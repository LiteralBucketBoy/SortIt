package com.example.sortit.sensors;

public class S2 extends Sensor{
    //Sensor that reads if something is in the initial position of belt is metallic
    public void setMetalPieceInBelt(){
            super.setActive();
    }
    public void moveMetalPieceInBelt(){
            super.setInactive();
    }
    public Boolean isPieceInBeltMetal(){
        return super.isActive();
    }
}
