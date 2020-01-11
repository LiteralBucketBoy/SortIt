package com.example.sortit.commands;
import android.widget.ImageView;

import com.example.sortit.R;

public class C2 extends Command {
    private ImageView light;
    public void setLight (ImageView view){
        this.light = view;
    }
    public void setLightOn (){
        light.setBackgroundResource(R.color.HL2_on);
    }
    public void setLightOff (){
        light.setBackgroundResource(R.color.HL2_off);
    }
    public void setCurrentActivityLight (){
        if(super.isActive()) {
            //light.setBackgroundColor(R.color.HL2_on);
        } else {
            //light.setBackgroundColor(R.color.HL2_off);
        }
    }
}
