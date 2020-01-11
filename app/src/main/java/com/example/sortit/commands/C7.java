package com.example.sortit.commands;
import android.widget.Button;

public class C7 extends Command {
    private Button stopButton;
    public void setButton (Button stopButton){
        this.stopButton = stopButton;
    }
    public void pressButton (){
        super.switchActivity();
    }
}
