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

    public ArrayList<Piece> getBlackPieces() {
        ArrayList<Piece> blacks = new ArrayList<>();
        for (Piece p : pieces) {
            if(p.isBlack()) {
                blacks.add(p);
            }
        }
        return blacks;
    }

    public ArrayList<Piece> getWhitePieces() {
        ArrayList<Piece> whites = new ArrayList<>();
        for (Piece p : pieces) {
            if(!p.isBlack()) {
                whites.add(p);
            }
        }
        return whites;
    }

    public ArrayList<Piece> getMetalPieces() {
        ArrayList<Piece> metal = new ArrayList<>();
        for (Piece p : pieces) {
            if(p.isMetallic()) {
                metal.add(p);
            }
        }
        return metal;
    }

    @Override
    public void update(Observable observable, Object o) {
        TestDataReader obj = (TestDataReader) observable;
        pieces = obj.getRecordedPieces();
    }
}
