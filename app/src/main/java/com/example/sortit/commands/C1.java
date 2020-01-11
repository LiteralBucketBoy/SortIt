package com.example.sortit.commands;
import android.widget.ImageView;
import com.example.sortit.R;

public class C1 extends Command {
    private ImageView light;
    public void setLight (ImageView view){
        this.light = view;
    }
    public void setLightOn (){
        super.setActive();
        light.setBackgroundResource(R.color.HL1_on);
    }
    public void setLightOff (){
        super.setInactive();
        light.setBackgroundResource(R.color.HL1_off);
    }


}
