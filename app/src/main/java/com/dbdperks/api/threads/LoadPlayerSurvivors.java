package com.dbdperks.api.threads;

import static com.dbdperks.api.threads.Thread.getBitmapFromURL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.dbdperks.api.DBDService;
import com.dbdperks.api.DBD_BUILDS_Service;
import com.dbdperks.api.data.Build;
import com.dbdperks.api.data.Killer;
import com.dbdperks.api.data.Perks;
import com.dbdperks.api.data.Survivor;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class LoadPlayerSurvivors extends java.lang.Thread {

    private DBDService dbdService = DBDService.getInstance();

    private Boolean complete = false;
    private Boolean started = false;

    //DATA
    private ArrayList<Survivor> survivorsList;

    //ICONS

    private ArrayList<Bitmap> survivorsIcons;

    public void run() {
        try {
            started = true;

            survivorsList = dbdService.survivors();

            survivorsIcons = new ArrayList<Bitmap>();

            for(int pos = 0; pos < survivorsList.size(); pos++ ) {
                survivorsIcons.add(getBitmapFromURL(survivorsList.get(pos).getIcon().getPortrait()));
            }

            complete = true;
            System.out.println("SurvivorPlayer: " + complete);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Bitmap> getSurvivorsIcons(){
        return survivorsIcons;
    }

    public ArrayList<Survivor> getSurvivorsList(){
        return survivorsList;
    }

    public Boolean isComplete(){
        return complete;
    }
    public Boolean isStarted(){
        return started;
    }

}
