package com.example.sortit.commands;
import android.widget.ImageView;

public class C4 extends Command {
    private ImageView light;
    public void setLight (ImageView view){
        this.light = view;
    }
    public void setLightOn (){
        //light.setBackgroundColor(R.color.SB1_on);
    }
    public void setLightOff (){
        //light.setBackgroundColor(R.color.SB1_off);
    }
    public void setCurrentActivityLight (){
        if(super.isActive()) {
            //light.setBackgroundColor(R.color.SB1_on);
        } else {
            //light.setBackgroundColor(R.color.SB1_off);
        }
    }
    public void pressButton (){
        super.switchActivity();
        setCurrentActivityLight();
    }
}
