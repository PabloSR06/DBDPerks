package com.dbdperks.api.threads;

import android.graphics.Bitmap;
import com.dbdperks.api.DBD_BUILDS_Service;
import com.dbdperks.api.data.Build;
import com.dbdperks.api.data.Perks;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class LoadBuilds extends java.lang.Thread {

    private DBD_BUILDS_Service dbdService = DBD_BUILDS_Service.getInstance();

    private Boolean complete = false;
    private Boolean started = false;

    //DATA
    private ArrayList<Build> survivorBuildList;
    private ArrayList<Build> killerBuildList;

    //ICONS
    private ArrayList<ArrayList<Bitmap>> buildKillerIcons;
    private ArrayList<ArrayList<Bitmap>> buildSurvivorIcons;

    public void run() {
        try {
            started = true;

            survivorBuildList = dbdService.getBuildSurvivors();
            killerBuildList = dbdService.getBuildKillers();

            buildSurvivorIcons = new ArrayList<>();
            buildKillerIcons = new ArrayList<>();

            for(int pos = 0; pos < survivorBuildList.size(); pos++ ) {
                ArrayList<Perks> perksList = new ArrayList<>();
                perksList = getPerks(survivorBuildList.get(pos).getPerks());

                if (perksList != null) {
                    int len = perksList.size();
                    ArrayList<Bitmap> icons = new ArrayList<>();
                    for (int j = 0; j < len; j++) {
                        icons.add(Thread.getBitmapFromURL(perksList.get(j).getIcon()));
                    }
                    buildSurvivorIcons.add(icons);
                }
            }
            for(int pos = 0; pos < killerBuildList.size(); pos++ ) {
                ArrayList<Perks> perksList = new ArrayList<>();
                perksList = getPerks(killerBuildList.get(pos).getPerks());

                if (perksList != null) {
                    int len = perksList.size();
                    ArrayList<Bitmap> icons = new ArrayList<>();
                    for (int j = 0; j < len; j++) {
                        icons.add(Thread.getBitmapFromURL(perksList.get(j).getIcon()));
                    }
                    buildKillerIcons.add(icons);
                }
            }

            complete = true;
            System.out.println("Builds: " + complete);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Build> getSurvivorBuildList(){
        return survivorBuildList;
    }
    public ArrayList<ArrayList<Bitmap>> getSurvivorBuildIcons(){
        return buildKillerIcons;
    }

    public ArrayList<Build> getKillerBuildList(){
        return killerBuildList;
    }
    public ArrayList<ArrayList<Bitmap>> getKillerBuildIcons(){
        return buildKillerIcons;
    }

    public Boolean isComplete(){
        return complete;
    }
    public Boolean isStarted(){
        return started;
    }

    public ArrayList<Perks> getPerks(String perks) {
        try {
            JSONArray jsonArray = new JSONArray(perks);
            ArrayList<Perks> perksList = new ArrayList<>();
            if (jsonArray != null) {
                int len = jsonArray.length();
                for (int j = 0; j < len; j++) {
                    perksList.add(new Gson().fromJson(jsonArray.get(0).toString(), Perks.class));
                }
            }
            return perksList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
