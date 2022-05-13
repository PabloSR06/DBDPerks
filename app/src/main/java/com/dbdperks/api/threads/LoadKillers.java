package com.dbdperks.api.threads;

import static com.dbdperks.api.threads.Thread.getBitmapFromURL;

import android.graphics.Bitmap;
import com.dbdperks.api.DBDService;
import com.dbdperks.api.DBD_BUILDS_Service;
import com.dbdperks.api.data.Build;
import com.dbdperks.api.data.Killer;
import com.dbdperks.api.data.Perks;
import java.util.ArrayList;

public class LoadKillers extends java.lang.Thread {

    DBDService dbdService = new DBDService();

    private Boolean complete = false;

    //DATA
    private ArrayList<Perks> perkKillerList;

    private ArrayList<Killer> killersList;

    //ICONS
    private ArrayList<Bitmap> perkKillerIcons;

    private ArrayList<Bitmap> killersIcons;

    //Builds
    public static DBD_BUILDS_Service apiManager = DBD_BUILDS_Service.getInstance();

    private ArrayList<Build> buildList;

    public void run() {
        try {

            perkKillerList = dbdService.killerPerks();
            killersList = dbdService.killers();

            perkKillerIcons = new ArrayList<Bitmap>();
            killersIcons = new ArrayList<Bitmap>();

            //BUILDS
            //buildList = apiManager.getBuilds();

            for(int pos = 0; pos < perkKillerList.size(); pos++ ) {
                perkKillerIcons.add(getBitmapFromURL(perkKillerList.get(pos).getIcon()));
            }
            for(int pos = 0; pos < killersList.size(); pos++ ) {
                killersIcons.add(getBitmapFromURL(killersList.get(pos).getIcon().getPortrait()));
            }
            complete = true;
            System.out.println("Killers: " + complete);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Bitmap> getKillerPerksIcons(){
        return perkKillerIcons;
    }
    public ArrayList<Bitmap> getKillersIcons(){
        return killersIcons;
    }

    public ArrayList<Perks> getKillerPerksList(){
        return perkKillerList;
    }
    public ArrayList<Killer> getKillersList(){
        return killersList;
    }

    public Boolean getStatus(){
        return complete;
    }

}
