package com.example.sortit;

public class Piece {
    private boolean isBlack;
    private boolean isMetallic;
    private int position = 0;//(0,300) 0 = initial value, in case we want to use positioning
    private boolean checkedMetallic;
    private boolean checkedColor;

    public Piece () {
        isBlack = true; //default value
        isMetallic = false;
        checkedMetallic = false;
        checkedColor = false;
    }

    public void setCheckedMetallic(boolean checkedMetallic) {
        this.checkedMetallic = checkedMetallic;
    }

    public void setCheckedColor(boolean checkedColor) {
        this.checkedColor = checkedColor;
    }

    public boolean isCheckedMetallic() {
        return checkedMetallic;
    }

    public boolean isCheckedColor() {
        return checkedColor;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public boolean isWhite() {
        return !isBlack();
    }

    public boolean isMetallic() {
        return isMetallic;
    }

    public void setBlack(boolean black) {
        isBlack = black;
    }

    public void setMetallic(boolean metallic) {
        isMetallic = metallic;
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
