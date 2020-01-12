package com.example.sortit;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import com.example.sortit.commands.C1;
import com.example.sortit.commands.CommandManager;
import com.example.sortit.sensors.SensorManager;
import com.example.sortit.stats.Statistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class TestDataReader extends Observable {
    private CommandManager commandManager = new CommandManager();
    private SensorManager sensorManager = new SensorManager();
    private ArrayList<Piece> pieces;
    private int nPiecesOnTray;
    private ArrayList<Piece> recordedPieces;
    private Statistics stats;


    public void initialize(ImageView hl1,ImageView hl2,ImageView hl3, List<Button> buttons, Switch sa){
        commandManager.setupCommands(hl1,hl2,hl3,buttons,sa);
        sensorManager.setupSensores();
        pieces = new ArrayList<>();
        nPiecesOnTray = 0;
        recordedPieces = new ArrayList<>();
        stats = Statistics.getInstance();
        addObserver(stats);
    }

    public ArrayList<Piece> getRecordedPieces() {
        return recordedPieces;
    }

    public void runEventLine(Boolean s1,Boolean s2,Boolean s3,Boolean s4, Boolean s5, Boolean s6,
                             Boolean c1,Boolean c2,Boolean c3, Boolean c4,Boolean c5,Boolean c6,
                             Boolean c7){
        //setting sensors
        if(s1){
            //new piece is added to the piece construction list
            pieces.add(new Piece());
            nPiecesOnTray++;
            sensorManager.getSensores().get(0).setActive();
        }else {
            sensorManager.getSensores().get(0).setInactive();
        }
        if(s2){ //metallic sensor
            int index = 0;
            Piece p = pieces.get(index);
            while(p.isCheckedMetallic() && index < nPiecesOnTray) {
                p = pieces.get(index++);
            }
            p.setCheckedMetallic(true);
            p.setMetallic(true);
            sensorManager.getSensores().get(1).setActive();
        }else {
            sensorManager.getSensores().get(1).setInactive();
        }
        if(s3){
            int index = 0;
            Piece p = pieces.get(index);
            while(p.isCheckedColor() && index < nPiecesOnTray) {
                p = pieces.get(index++);
            }
            p.setCheckedColor(true);
            p.setBlack(false);
            sensorManager.getSensores().get(2).setActive();
        }else {
            sensorManager.getSensores().get(2).setInactive();
        }
        if(s4){
            if (nPiecesOnTray > 0) {
                Piece recordPiece = pieces.remove(--nPiecesOnTray);
                recordPiece.setPosition(100); //set traveled distance equals to the predetermined
                recordedPieces.add(recordPiece);
                setChanged();
                notifyObservers();
            }
            sensorManager.getSensores().get(3).setActive();
        }else {
            sensorManager.getSensores().get(3).setInactive();
        }
        if(s5){
            if (nPiecesOnTray > 0) {
                Piece recordPiece = pieces.remove(--nPiecesOnTray);
                recordPiece.setPosition(150); //set traveled distance equals to the predetermined
                recordedPieces.add(recordPiece);
                setChanged();
                notifyObservers();
            }
            sensorManager.getSensores().get(4).setActive();
        }else {
            sensorManager.getSensores().get(4).setInactive();
        }
        if(s6){
            if (nPiecesOnTray > 0) {
                Piece recordPiece = pieces.remove(--nPiecesOnTray);
                recordPiece.setPosition(200); //set traveled distance equals to the predetermined
                recordedPieces.add(recordPiece);
                setChanged();
                notifyObservers();
            }
            sensorManager.getSensores().get(5).setActive();
        }else {
            sensorManager.getSensores().get(5).setInactive();
        }

        //setting commands
        if(c1){
            commandManager.getC1().setLightOn();
            System.out.println("Hl1 On");
        }else {
            commandManager.getC1().setLightOff();
            System.out.println("Hl1 Off");
        }
        if(c2){
            commandManager.getC2().setLightOn();
        }else {
            commandManager.getC2().setLightOff();
        }
        if(c3){
            commandManager.getC3().setLightOn();
            System.out.println("Hl3 On");
        }else {
            commandManager.getC3().setLightOff();
            System.out.println("Hl3 Off");
        }
        if(c4){
            commandManager.getCommands().get(3).setActive();
        }else {
            commandManager.getCommands().get(3).setInactive();
        }
        if(c5){
            commandManager.getCommands().get(4).setActive();
        }else {
            commandManager.getCommands().get(4).setInactive();
        }
        if(c6){
            commandManager.getC6().setCurrentSwitchOn();
        }else {
            commandManager.getC6().setCurrentSwitchOff();
        }
        if(c7){
            commandManager.getCommands().get(6).setActive();
        }else {
            commandManager.getCommands().get(6).setInactive();
        }

    }
}
