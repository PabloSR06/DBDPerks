package com.dbdperks.api.threads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
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

    private static LoadPlayerSurvivors survivorsPlayer = new LoadPlayerSurvivors();
    private static LoadPlayerKillers killersPlayer = new LoadPlayerKillers();
    private static LoadPerksSurvivors survivorsPerks = new LoadPerksSurvivors();
    private static LoadPerksKillers killersPerks = new LoadPerksKillers();

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


    public ArrayList<String> prueba = new ArrayList<String>();

    public void addString(String entrada){
        prueba.add(entrada);
    }
    public void getprueba(){
        System.out.println(prueba.toString());
    }

    public void build(){
        //System.out.println(survivors.getBuildList().toString());
    }


    public static Thread getInstance() {
        if (instance == null) {
            try {
                instance = new Thread();
                survivorsPerks.start();
                survivorsPlayer.start();
                killersPerks.start();
                killersPlayer.start();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return instance;
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
