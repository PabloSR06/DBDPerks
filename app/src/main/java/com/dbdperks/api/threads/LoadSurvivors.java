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

public class LoadSurvivors extends java.lang.Thread {

    DBDService dbdService = new DBDService();

    private Boolean complete = false;

    //DATA

    private ArrayList<Perks> perkSurvivorList;

    private ArrayList<Survivor> survivorsList;

    //ICONS
    private ArrayList<Bitmap> perkSurvivorIcons;

    private ArrayList<Bitmap> survivorsIcons;

    //Builds
    public static DBD_BUILDS_Service apiManager = DBD_BUILDS_Service.getInstance();

    private ArrayList<Build> buildList;

    public void run() {
        try {
            perkSurvivorList = dbdService.survivorPerks();
            survivorsList = dbdService.survivors();

            perkSurvivorIcons = new ArrayList<Bitmap>();
            survivorsIcons = new ArrayList<Bitmap>();

            //BUILDS
            //buildList = apiManager.getBuilds();


            for(int pos = 0; pos < perkSurvivorList.size(); pos++ ) {
                perkSurvivorIcons.add(getBitmapFromURL(perkSurvivorList.get(pos).getIcon()));
            }
            for(int pos = 0; pos < survivorsList.size(); pos++ ) {
                survivorsIcons.add(getBitmapFromURL(survivorsList.get(pos).getIcon().getPortrait()));
            }

            complete = true;
            System.out.println("Survivor: " + complete);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Bitmap> getSurvivorPerksIcons(){
        return perkSurvivorIcons;
    }

    public ArrayList<Bitmap> getSurvivorsIcons(){
        return survivorsIcons;
    }

    public ArrayList<Perks> getSurvivorPerksList(){
        return perkSurvivorList;
    }

    public ArrayList<Survivor> getSurvivorsList(){
        return survivorsList;
    }


    public Boolean getStatus(){
        return complete;
    }

}
