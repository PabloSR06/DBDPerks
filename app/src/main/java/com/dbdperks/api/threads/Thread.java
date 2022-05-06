package com.dbdperks.api.threads;

import android.graphics.Bitmap;

import com.dbdperks.api.DBD_BUILDS_Service;
import com.dbdperks.api.data.Killer;
import com.dbdperks.api.data.Perks;
import com.dbdperks.api.data.Survivor;
import com.dbdperks.conection.ConectionController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Thread {

    private static Thread instance;
    private static LoadThread load = new LoadThread();


    public ArrayList<Bitmap> getSurvivorPerksIcons(){
        return load.getSurvivorPerksIcons();
    }
    public ArrayList<Bitmap> getKillerPerksIcons(){
        return load.getKillerPerksIcons();
    }
    public ArrayList<Perks> getSurvivorPerks(){
        return load.getSurvivorPerksList();
    }
    public ArrayList<Perks> getKillerPerks(){
        return load.getKillerPerksList();
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

    public Boolean getStatus(){
        return load.getStatus();
    }
}
