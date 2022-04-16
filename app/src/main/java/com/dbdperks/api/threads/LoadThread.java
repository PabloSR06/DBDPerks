package com.dbdperks.api.threads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;

import com.dbdperks.api.DBDService;
import com.dbdperks.api.data.Killer;
import com.dbdperks.api.data.Perks;
import com.dbdperks.api.data.Survivor;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class LoadThread extends java.lang.Thread {

    DBDService dbdService = new DBDService();

    private Boolean completo = false;

    //DATA
    private ArrayList<Perks> perkKillerList;

    private ArrayList<Perks> perkSurvivorList;

    private ArrayList<Killer> killersList;

    private ArrayList<Survivor> survivorsList;

    //ICONS
    private ArrayList<Bitmap> perkKillerIcons;

    private ArrayList<Bitmap> perkSurvivorIcons;

    private ArrayList<Bitmap> survivorsIcons;

    private ArrayList<Bitmap> killersIcons;

    public void run() {
        try {

            perkKillerList = dbdService.killerPerks();
            perkSurvivorList = dbdService.survivorPerks();
            killersList = dbdService.killers();
            survivorsList = dbdService.survivors();

            perkKillerIcons = new ArrayList<Bitmap>();
            perkSurvivorIcons = new ArrayList<Bitmap>();
            survivorsIcons = new ArrayList<Bitmap>();
            killersIcons = new ArrayList<Bitmap>();

            for(int pos = 0; pos < perkSurvivorList.size(); pos++ ) {
                perkSurvivorIcons.add(getBitmapFromURL(perkSurvivorList.get(pos).getIcon()));
            }
            for(int pos = 0; pos < perkKillerList.size(); pos++ ) {
                perkKillerIcons.add(getBitmapFromURL(perkKillerList.get(pos).getIcon()));
            }
            for(int pos = 0; pos < survivorsList.size(); pos++ ) {
                survivorsIcons.add(getBitmapFromURL(survivorsList.get(pos).getIcon().getPortrait()));
            }
            for(int pos = 0; pos < killersList.size(); pos++ ) {
                killersIcons.add(getBitmapFromURL(killersList.get(pos).getIcon().getPortrait()));
            }
            completo = true;
            System.out.println(completo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Bitmap> getSurvivorPerksIcons(){
        return perkSurvivorIcons;
    }
    public ArrayList<Bitmap> getKillerPerksIcons(){
        return perkKillerIcons;
    }
    public ArrayList<Bitmap> getSurvivorsIcons(){
        return survivorsIcons;
    }
    public ArrayList<Bitmap> getKillersIcons(){
        return killersIcons;
    }

    public ArrayList<Perks> getSurvivorPerksList(){
        return perkSurvivorList;
    }
    public ArrayList<Perks> getKillerPerksList(){
        return perkKillerList;
    }
    public ArrayList<Survivor> getSurvivorsList(){
        return survivorsList;
    }
    public ArrayList<Killer> getKillersList(){
        return killersList;
    }

    public Boolean getStatus(){
        return completo;
    }


    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Exception",e.getMessage());
            return null;
        }
    }
}
