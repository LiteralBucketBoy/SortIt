package com.example.sortit.ui.Statistics;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.sortit.Piece;
import com.example.sortit.R;
import com.example.sortit.stats.Statistics;

import java.util.ArrayList;

public class StatsFragment extends Fragment {

    private StatsViewModel statsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        statsViewModel =
                ViewModelProviders.of(this).get(StatsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_stats, container, false);
        final TextView textView = root.findViewById(R.id.text_stats);
        statsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        //get stats
        Statistics stats = Statistics.getInstance();
        ArrayList<Piece> pieces = stats.getPieces();
        int counter = 0;
        for (Piece p : pieces) {
            System.out.println(counter++ + " " + p.isMetallic() + " " + p.isBlack());
        }

        return root;
    }
}