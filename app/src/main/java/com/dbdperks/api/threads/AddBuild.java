package com.dbdperks.api.threads;

import static com.dbdperks.api.threads.Thread.getBitmapFromURL;

import android.graphics.Bitmap;

import com.dbdperks.api.DBDService;
import com.dbdperks.api.DBD_BUILDS_Service;
import com.dbdperks.api.data.Build;
import com.dbdperks.api.data.Survivor;
import com.google.gson.Gson;

import java.util.ArrayList;

public class AddBuild extends java.lang.Thread {

    private DBD_BUILDS_Service dbdService = DBD_BUILDS_Service.getInstance();

    private Boolean complete = false;
    private Boolean started = false;

    Build build = new Build();

    public AddBuild(Build build){
        this.build = build;
    }


    public void run() {
        try {
            started = true;
            String json = new Gson().toJson(build);
            System.out.println(json);
            dbdService.createBuild(build);

            complete = true;
            System.out.println("AddBuild: " + complete);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public Boolean isComplete(){
        return complete;
    }
    public Boolean isStarted(){
        return started;
    }

}
