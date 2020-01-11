package com.example.sortit.commands;
import android.widget.ImageView;

public class C5 extends Command {
    private ImageView light;
    public void setLight (ImageView view){
        this.light = view;
    }
    public void setLightOn (){
        //light.setBackgroundColor(R.color.SB2_on);
    }
    public void setLightOff (){
        //light.setBackgroundColor(R.color.SB2_off);
    }
    public void setCurrentActivityLight (){
        if(super.isActive()) {
            //light.setBackgroundColor(R.color.SB2_on);
        } else {
            //light.setBackgroundColor(R.color.SB2_off);
        }
    }
    public void pressButton (){
        super.switchActivity();
        setCurrentActivityLight();
    }
}
