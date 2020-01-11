package com.example.sortit.sensors;

public class S3 extends Sensor{
    //Sensor that reads if something is in the initial position of belt is white or black
    public void setWhitePieceInBelt(){
        super.setActive();
    }
    public void setBlackPieceInBelt(){
        super.setInactive();
    }

    public void moveWhitePieceInBelt(){
        super.setInactive();
    }
    public void moveBlackPieceInBelt(){
        super.setInactive();
    }

    public Boolean isPieceInBeltWhite(){
        return super.isActive();
    }
}
