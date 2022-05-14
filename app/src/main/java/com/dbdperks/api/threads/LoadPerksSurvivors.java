package com.dbdperks.api.threads;

import static com.dbdperks.api.threads.Thread.getBitmapFromURL;

import android.graphics.Bitmap;

import com.dbdperks.api.DBDService;
import com.dbdperks.api.DBD_BUILDS_Service;
import com.dbdperks.api.data.Build;
import com.dbdperks.api.data.Perks;
import com.dbdperks.api.data.Survivor;

import java.util.ArrayList;

public class LoadPerksSurvivors extends java.lang.Thread {

    private DBDService dbdService = DBDService.getInstance();

    private Boolean complete = false;
    private Boolean started = false;

    //DATA

    private ArrayList<Perks> perkSurvivorList;
    //ICONS
    private ArrayList<Bitmap> perkSurvivorIcons;


    public void run() {
        try {
            started = true;

            perkSurvivorList = dbdService.survivorPerks();

            perkSurvivorIcons = new ArrayList<Bitmap>();


            for(int pos = 0; pos < perkSurvivorList.size(); pos++ ) {
                perkSurvivorIcons.add(getBitmapFromURL(perkSurvivorList.get(pos).getIcon()));
            }

            complete = true;
            System.out.println("SurvivorPerks: " + complete);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Bitmap> getSurvivorPerksIcons(){
        return perkSurvivorIcons;
    }

    public ArrayList<Perks> getSurvivorPerksList(){
        return perkSurvivorList;
    }

    public Boolean isComplete(){
        return complete;
    }
    public Boolean isStarted(){
        return started;
    }

}
