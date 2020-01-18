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
        //get stats
        Statistics stats = Statistics.getInstance();
        ArrayList<Piece> pieces = stats.getPieces();
        int counter = 0;
        for (Piece p : pieces) {
            System.out.println(counter++ + " " + p.isMetallic() + " " + p.isBlack());
        }

        TextView totalMetal = root.findViewById(R.id.totalMetal);
        TextView totalBlack = root.findViewById(R.id.totalBlack);
        TextView totalWhite = root.findViewById(R.id.totalWhite);
        TextView avgMetal = root.findViewById(R.id.avgMetallic);
        TextView avgBlack = root.findViewById(R.id.avgBlack);
        TextView avgWhite = root.findViewById(R.id.avgWhite);
        TextView totalDistance = root.findViewById(R.id.totalDistance);

        totalMetal.setText("" + stats.getMetalPieces().size());
        totalBlack.setText("" + stats.getBlackPieces().size());
        totalWhite.setText("" + stats.getWhitePieces().size());

        double avgMetalNumber = 0;
        if (stats.getPieces().size() > 0) {
            avgMetalNumber = (double) stats.getMetalPieces().size() / stats.getPieces().size();
        }
        avgMetal.setText("" + avgMetalNumber);

        double avgBlackNumber = 0;
        if (stats.getPieces().size() > 0) {
            avgBlackNumber = (double) stats.getBlackPieces().size() / stats.getPieces().size();
        }
        avgBlack.setText("" + avgBlackNumber);

        double avgWhiteNumber = 0;
        if (stats.getPieces().size() > 0) {
            avgWhiteNumber = (double) stats.getWhitePieces().size() / stats.getPieces().size();
        }
        avgWhite.setText("" + avgWhiteNumber);

        int distance = stats.getTotalDistance();
        totalDistance.setText(""+ distance);

        return root;
    }
}