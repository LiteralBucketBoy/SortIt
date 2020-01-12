package com.example.sortit.stats;

import com.example.sortit.Piece;
import com.example.sortit.TestDataReader;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Statistics implements Observer {

    private static Statistics instance = null;
    private ArrayList<Piece> pieces;

    private Statistics() {
        pieces = new ArrayList<>();
    }

    public static Statistics getInstance() {
        if(instance == null) {
            instance = new Statistics();
        }
        return instance;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    @Override
    public void update(Observable observable, Object o) {
        TestDataReader obj = (TestDataReader) observable;
        pieces = obj.getRecordedPieces();
    }
}
