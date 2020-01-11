package com.example.sortit.commands;
import android.widget.Switch;

public class C6 extends Command {
    private Switch switchy;
    public void setSwitch (Switch switchy){
        this.switchy = switchy;
    }


    public void setCurrentSwitchOn (){
        super.setActive();
        switchy.setChecked(true);
    }
    public void setCurrentSwitchOff (){
        super.setInactive();
        switchy.setChecked(false);
    }
}
