package com.dbdperks.api.threads;

import static com.dbdperks.api.threads.Thread.getBitmapFromURL;

import android.graphics.Bitmap;
import com.dbdperks.api.DBDService;
import com.dbdperks.api.DBD_BUILDS_Service;
import com.dbdperks.api.data.Build;
import com.dbdperks.api.data.Killer;
import com.dbdperks.api.data.Perks;
import java.util.ArrayList;

public class LoadPlayerKillers extends java.lang.Thread {

    private DBDService dbdService = DBDService.getInstance();

    private Boolean complete = false;
    private Boolean started = false;

    //DATA
    private ArrayList<Killer> killersList;

    //ICONS

    private ArrayList<Bitmap> killersIcons;


    public void run() {
        try {
            started = true;

            killersList = dbdService.killers();

            killersIcons = new ArrayList<Bitmap>();

            for(int pos = 0; pos < killersList.size(); pos++ ) {
                killersIcons.add(getBitmapFromURL(killersList.get(pos).getIcon().getPortrait()));
            }
            complete = true;
            System.out.println("KillersPlayer: " + complete);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Bitmap> getKillersIcons(){
        return killersIcons;
    }

    public ArrayList<Killer> getKillersList(){
        return killersList;
    }

    public Boolean isComplete(){
        return complete;
    }
    public Boolean isStarted(){
        return started;
    }

}
