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
    private static LoadSurvivors survivors = new LoadSurvivors();
    private static LoadKillers killers = new LoadKillers();

    public ArrayList<Perks> getSurvivorPerks(){
        return survivors.getSurvivorPerksList();
    }
    public ArrayList<Bitmap> getSurvivorPerksIcons(){
        return survivors.getSurvivorPerksIcons();
    }
    public ArrayList<Bitmap> getSurvivorIcons(){
        return survivors.getSurvivorsIcons();
    }
    public ArrayList<Survivor> getSurvivor(){
        return survivors.getSurvivorsList();
    }


    public ArrayList<Bitmap> getKillerPerksIcons(){
        return killers.getKillerPerksIcons();
    }
    public ArrayList<Perks> getKillerPerks(){
        return killers.getKillerPerksList();
    }
    public ArrayList<Bitmap> getKillersIcons(){
        return killers.getKillersIcons();
    }
    public ArrayList<Killer> getKillers(){
        return killers.getKillersList();
    }




    public static Thread getInstance() {
        if (instance == null) {
            try {
                instance = new Thread();
                killers.start();
                survivors.start();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return instance;
    }

    public Boolean getSurvivorStatus(){
        return survivors.getStatus();
    }
    public Boolean getKillerStatus(){
        return killers.getStatus();
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
