package com.dbdperks;

import android.graphics.Bitmap;
import android.widget.Toast;

import com.dbdperks.api.data.Build;
import com.dbdperks.api.data.Perks;

import java.util.ArrayList;

public class SurvivorBuild {

    private static SurvivorBuild instance;

    private final int maxPerks = 4;
    private int perkSize = 0;


    private Build build = new Build();

    public ArrayList<Bitmap> icon_perk = new ArrayList<Bitmap>();
    public ArrayList<Perks> perk_list = new ArrayList<Perks>();

    public Boolean addPerk(Bitmap icon, Perks perk){
        if(perkSize < maxPerks){
            perkSize++;
            icon_perk.add(icon);
            perk_list.add(perk);
            return true;
        }

        return false;
    }

    public ArrayList<Perks> getPerks(){
        return perk_list;
    }
    public ArrayList<Bitmap> getIcons(){
        return icon_perk;
    }

    public void endInstance(){
        instance = null;
    }

    public static SurvivorBuild getInstance(){
        if (instance == null) {
            try {
                instance = new SurvivorBuild();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return instance;
    }
}
