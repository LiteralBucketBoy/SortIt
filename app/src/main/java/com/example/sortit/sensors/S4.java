package com.example.sortit.sensors;

public class S4 extends Sensor{
    //Sensor that reads if the first arm is in contracted or extended
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
