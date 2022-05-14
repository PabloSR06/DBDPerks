package com.dbdperks.api.threads;

import static com.dbdperks.api.threads.Thread.getBitmapFromURL;

import android.graphics.Bitmap;

import com.dbdperks.api.DBDService;
import com.dbdperks.api.DBD_BUILDS_Service;
import com.dbdperks.api.data.Build;
import com.dbdperks.api.data.Killer;
import com.dbdperks.api.data.Perks;

import java.util.ArrayList;

public class LoadPerksKillers extends java.lang.Thread {

    private DBDService dbdService = DBDService.getInstance();

    private Boolean complete = false;
    private Boolean started = false;

    //DATA
    private ArrayList<Perks> perkKillerList;

    //ICONS
    private ArrayList<Bitmap> perkKillerIcons;

    public void run() {
        try {
            started = true;

            perkKillerList = dbdService.killerPerks();

            perkKillerIcons = new ArrayList<Bitmap>();

            for(int pos = 0; pos < perkKillerList.size(); pos++ ) {
                perkKillerIcons.add(getBitmapFromURL(perkKillerList.get(pos).getIcon()));
            }
            complete = true;
            System.out.println("KillerPerks: " + complete);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Bitmap> getKillerPerksIcons(){
        return perkKillerIcons;
    }

    public ArrayList<Perks> getKillerPerksList(){
        return perkKillerList;
    }

    public Boolean isComplete(){
        return complete;
    }
    public Boolean isStarted(){
        return started;
    }

}
