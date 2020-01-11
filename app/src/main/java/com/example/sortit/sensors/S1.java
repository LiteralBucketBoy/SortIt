package com.example.sortit.sensors;

public class S1 extends Sensor{
    //Sensor that reads if something is in the initial position of belt
    public void setPieceInBelt(){
        super.setActive();
    }
    public void movePieceInBelt(){ super.setInactive();
    }
    public Boolean isPieceInBelt(){
       return super.isActive();
    }
}
