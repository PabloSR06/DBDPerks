package com.dbdperks.api.threads;

import android.graphics.Bitmap;

import com.dbdperks.api.data.Killer;
import com.dbdperks.api.data.Perks;
import com.dbdperks.api.data.Survivor;

import java.util.ArrayList;

public class Thread {

    private static Thread instance;
    private static LoadThread load = new LoadThread();

    public ArrayList<Bitmap> getPerksIcons(){
        return load.getPerksIcons();
    }
    public ArrayList<Perks> getPerks(){
        return load.getPerksList();
    }

    public ArrayList<Bitmap> getSurvivorIcons(){
        return load.getSurvivorsIcons();
    }
    public ArrayList<Survivor> getSurvivor(){
        return load.getSurvivorsList();
    }

    public ArrayList<Bitmap> getKillersIcons(){
        return load.getKillersIcons();
    }
    public ArrayList<Killer> getKillers(){
        return load.getKillersList();
    }

    public static Thread getInstance() {
        if (instance == null) {
            try {
                instance = new Thread();
                load.start();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return instance;
    }
}
