package com.example.sortit.commands;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import com.example.sortit.R;

import java.util.*;

public class CommandManager {
    private List<Command> commands = new ArrayList<>();
    private C1 c1 = new C1();
    private C2 c2 = new C2();
    private C3 c3 = new C3();
    private C4 c4 = new C4();
    private C5 c5 = new C5();
    private C6 c6 = new C6();
    private C7 c7 = new C7();
    public void setupCommands(ImageView ci1,ImageView ci2,ImageView ci3, List<Button> btn, Switch sa){
        c1.setLight(ci1);
        c2.setLight(ci2);
        c3.setLight(ci3);
        c6.setSwitch(sa);
        commands.add(c1);//hl1 light
        commands.add(c2);//hl2 light
        commands.add(c3);//hl3 light
        commands.add(c4);//sb1 lighted button
        commands.add(c5);//sb2 lighted button
        commands.add(c6);//switch mode
        commands.add(c7);//emergency button
    }
    public List<Command> getCommands(){
        return commands;
    }
    public C1 getC1(){return (C1)commands.get(0);}
    public C2 getC2(){return (C2)commands.get(1);}
    public C3 getC3(){return (C3)commands.get(2);}
    public C4 getC4(){return (C4)commands.get(3);}
    public C5 getC5(){return (C5)commands.get(4);}
    public C6 getC6(){return (C6)commands.get(5);}
}
