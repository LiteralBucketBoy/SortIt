package com.example.sortit.commands;

public class Command {
    private boolean isActive = false;
    public Boolean isActive(){
        return isActive;
    }
    public void setActive(){
        isActive=true;
    }
    public void setInactive(){
        isActive=false;
    }
    public void switchActivity(){
        isActive=!isActive;
    }
}
