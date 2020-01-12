package com.example.sortit.ui.CommandInterface;

import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.sortit.communication.Requests;
import com.example.sortit.communication.StateBuilder;
import com.example.sortit.MainActivity;
import com.example.sortit.R;
import com.example.sortit.TestDataReader;

import java.util.ArrayList;
import java.util.List;

public class CommandFragment extends Fragment {

    private CommandViewModel commandViewModel;
    private TestDataReader reader = new TestDataReader();
    private Button btnStart;
    private Thread thread;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        commandViewModel =
                ViewModelProviders.of(this).get(CommandViewModel.class);
        View root = inflater.inflate(R.layout.fragment_command, container, false);
        final TextView textView = root.findViewById(R.id.text_command);
        commandViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        //data stuff
        List<ImageView> images = new ArrayList<>();
        List<Button> buttons = new ArrayList<>();
        ImageView hl1 = root.findViewById(R.id.view_c1_light);
        ImageView hl2 = root.findViewById(R.id.view_c2_light);
        ImageView hl3 = root.findViewById(R.id.view_c3_light);
        images.add(hl1);
        Switch sa = root.findViewById(R.id.c6_button);
        reader.initialize(hl1,hl2,hl3,buttons,sa);

        //button to start reading
        btnStart = root.findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startReading();
            }
        });

        //ask tuple
        MainActivity.askTuple();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //get statebuilder and represent
        StateBuilder sb = MainActivity.sb;
        if (sb != null) {
            ArrayList<Boolean> listState = sb.getList();
            reader.runEventLine(listState.get(0), listState.get(1), listState.get(2), listState.get(3),
                    listState.get(4), listState.get(5), listState.get(6), listState.get(9),
                    listState.get(10), listState.get(11), listState.get(12), listState.get(13),
                    listState.get(14));
            System.out.println(sb);
        }

        return root;
    }

    @Override
    public void onStop() {
        try {
            thread.interrupt();
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            super.onStop();
        }


    }

    private void startReading() {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                while (true) {
                    //ask tuple
                    Requests req = new Requests();
                    MainActivity.sb = new StateBuilder(req.getTuple());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                    //get statebuilder and represent
                    StateBuilder sb = MainActivity.sb;
                    if (sb != null) {
                        ArrayList<Boolean> listState = sb.getList();
                        reader.runEventLine(listState.get(0), listState.get(1), listState.get(2), listState.get(3),
                                listState.get(4), listState.get(5), listState.get(6), listState.get(9),
                                listState.get(10), listState.get(11), listState.get(12), listState.get(13),
                                listState.get(14));
                        System.out.println(sb);
                    }
                }
            }
        });
        thread.start();
    }
}