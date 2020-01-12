package com.example.sortit.communication;

import java.util.ArrayList;

public class StateBuilder {
    private ArrayList<Boolean> listSensorsCommands;

    public StateBuilder(String tuple) {
        listSensorsCommands = new ArrayList<>();
        buildState(tuple);
    }

    private void buildState(String tuple) {
        String separator = ",";
        String[] separated_tuple = tuple.split(separator);

        for (int i = 0; i < 16; i++) {
            boolean state = false;
            if (separated_tuple[i].equals("1")) {
                state = true;
            }
            listSensorsCommands.add(state);
        }
    }

    public ArrayList<Boolean> getList() {
        return listSensorsCommands;
    }

    @Override
    public String toString() {
        return listSensorsCommands.toString();
    }
}
