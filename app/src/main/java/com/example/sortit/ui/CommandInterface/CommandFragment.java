package com.example.sortit.ui.CommandInterface;

import android.os.Bundle;
import android.util.Log;
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

import com.example.sortit.R;
import com.example.sortit.TestDataReader;

import java.util.ArrayList;
import java.util.List;

public class CommandFragment extends Fragment {

    private CommandViewModel commandViewModel;
    private TestDataReader reader = new TestDataReader();

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
        reader.runEventLine(true,false,true,false,false,false,false,true,false,false,false,true,false);

        return root;
    }
}