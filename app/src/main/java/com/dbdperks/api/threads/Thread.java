package com.dbdperks.api.threads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.dbdperks.api.data.Build;
import com.dbdperks.api.data.Killer;
import com.dbdperks.api.data.Perks;
import com.dbdperks.api.data.Survivor;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Thread {

    private static Thread instance;

    //retrieve
    private static LoadPlayerSurvivors survivorsPlayer = new LoadPlayerSurvivors();
    private static LoadPlayerKillers killersPlayer = new LoadPlayerKillers();
    private static LoadPerksSurvivors survivorsPerks = new LoadPerksSurvivors();
    private static LoadPerksKillers killersPerks = new LoadPerksKillers();
    private static LoadBuilds builds = new LoadBuilds();

    //create
    private static AddBuild add_build;

    //Build
    public ArrayList<Build> getSurvivorBuild(){
        return builds.getSurvivorBuildList();
    }
    public ArrayList<ArrayList<Bitmap>> getSurvivorBuildIcons(){
        return builds.getSurvivorBuildIcons();
    }
    public ArrayList<ArrayList<Bitmap>> getKillerBuildIcons(){
        return builds.getKillerBuildIcons();
    }
    public ArrayList<Build> getKillerBuild(){
        return builds.getKillerBuildList();
    }

    //PERK
    public ArrayList<Perks> getSurvivorPerks(){
        return survivorsPerks.getSurvivorPerksList();
    }
    public ArrayList<Bitmap> getSurvivorPerksIcons(){
        return survivorsPerks.getSurvivorPerksIcons();
    }

    public ArrayList<Bitmap> getSurvivorIcons(){
        return survivorsPlayer.getSurvivorsIcons();
    }
    public ArrayList<Survivor> getSurvivor(){
        return survivorsPlayer.getSurvivorsList();
    }

    //KILLER
    public ArrayList<Bitmap> getKillerPerksIcons(){
        return killersPerks.getKillerPerksIcons();
    }
    public ArrayList<Perks> getKillerPerks(){
        return killersPerks.getKillerPerksList();
    }

    public ArrayList<Bitmap> getKillersIcons(){
        return killersPlayer.getKillersIcons();
    }
    public ArrayList<Killer> getKillers(){
        return killersPlayer.getKillersList();
    }


    //Create Build
    public void create_build(Build build){
        add_build = new AddBuild(build);
        add_build.start();
    }


    public static Thread getInstance() {
        if (instance == null) {
            try {
                instance = new Thread();
                survivorsPerks.start();
                survivorsPlayer.start();
                killersPerks.start();
                killersPlayer.start();
                builds.start();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return instance;
    }

    public Boolean isBuildsComplete(){
        return builds.isComplete();
    }

    public Boolean isPerkSurvivorComplete(){
        return survivorsPerks.isComplete();
    }
    public Boolean isPerkKillerComplete(){
        return killersPerks.isComplete();
    }

    public Boolean isPlayerSurvivorComplete(){
        return survivorsPlayer.isComplete();
    }
    public Boolean isPlayerKillerComplete(){
        return killersPlayer.isComplete();
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
