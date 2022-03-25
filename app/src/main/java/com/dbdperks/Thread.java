package com.dbdperks;

import android.graphics.Bitmap;

import com.dbdperks.api.data.Perks;
import com.dbdperks.api.threads.LoadThread;

import java.util.ArrayList;

public class Thread {

    private static Thread instance;
    private static LoadThread load = new LoadThread();


    public static void main(String[] args) {


    }

    public ArrayList<Bitmap> getIcons(){
        return load.getPerksIcons();
    }
    public ArrayList<Perks> getPerks(){
        return load.getPerksList();
    }

    public static Thread getInstance() {
        if (instance == null) {
            try {
                instance = new Thread();
                System.out.println("222");
                load.start();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return instance;
    }
}
