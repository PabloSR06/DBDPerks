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

    private ArrayList<Perks> perksList;

    private ArrayList<Killer> killersList;

    private ArrayList<Survivor> survivorsList;

    private ArrayList<Bitmap> perksIcons;

    public void run() {
        try {
            perksList = dbdService.perks();
            killersList = dbdService.killers();
            survivorsList = dbdService.survivors();

            perksIcons = new ArrayList<Bitmap>();

            for(int pos = 0; pos < perksList.size(); pos++ ) {
                perksIcons.add(getBitmapFromURL(perksList.get(pos).getIcon()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Bitmap> getPerksIcons(){
        return perksIcons;
    }
    public ArrayList<Perks> getPerksList(){
        return perksList;
    }
    public ArrayList<Survivor> getSurvivorsList(){
        return survivorsList;
    }
    public ArrayList<Killer> getKillersList(){
        return killersList;
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
