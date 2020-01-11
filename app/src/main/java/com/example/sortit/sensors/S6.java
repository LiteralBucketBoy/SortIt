package com.example.sortit.sensors;

public class S6 extends Sensor{
    //Sensor that reads if the third arm is in contracted or extended
    public void extendArm(){
        super.setActive();
    }

    public void contractArm(){
        super.setInactive();
    }

    public Boolean isArmExtended(){
        return super.isActive();
    }
}
