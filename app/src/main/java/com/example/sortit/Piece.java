package com.example.sortit;

public class Piece {
    private boolean isBlack;
    private boolean isWhite;
    private boolean isMetallic;
    private String colour;
    private int position = 0;//(0,300) 0 = valor inicial, incase we want to use positioning


    public boolean isBlack() {
        return isBlack;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public boolean isMetallic() {
        return isMetallic;
    }

    public void setBlack(boolean black) {
        isBlack = black;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public void setMetallic(boolean metallic) {
        isMetallic = metallic;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
        if(colour.equals("White")){
            setWhite(true);
        }
        if(colour.equals("Black")){
            setBlack(true);
        }
        if(colour.equals("Metallic")){
            setMetallic(true);
        }
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        if(position<=300 && position>=0) {
            this.position = position;
        }
        else {throw new IllegalArgumentException("Position must be between 0 and 300! /n Position given: " + position);}
    }
}
