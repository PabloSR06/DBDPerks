package com.dbdperks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.dbdperks.api.data.Perks;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class LoadIconThread extends Thread{

    String url;
    public LoadIconThread(String url){
        this.url = url;
    }

    private Bitmap bit;

    public Bitmap getBit() {
        return bit;
    }

    private ArrayList<Bitmap> perksIcons;

    public void run() {
        bit = getBitmapFromURL(url);
    }




    public static Bitmap getBitmapFromURL(String src) {
        try {
            Log.e("src",src);
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
