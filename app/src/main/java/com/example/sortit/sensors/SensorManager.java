package com.example.sortit.sensors;
import java.util.*;

public class SensorManager {
    //
    private List<Sensor> sensores = new ArrayList<>();

    public void setupSensores(){
        sensores.add(new S1());//checks for stuff in belt
        sensores.add(new S2());//checks if stuff in belt is metallic
        sensores.add(new S3());//checks if stuff in belt is white
        sensores.add(new S4());//checks if first arm is extended
        sensores.add(new S5());//checks if second arm is extended
        sensores.add(new S6());//checks if third arm is extended
    }

    public List<Sensor> getSensores(){
        return sensores;
    }



}
