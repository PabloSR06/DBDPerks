package com.dbdperks;

import com.dbdperks.api.data.Build;

import java.util.ArrayList;

public class SurvivorBuild {

    private static SurvivorBuild instance;

    private final int maxPerks = 4;
    private int perkSize = 0;


    private Build build = new Build();

    public ArrayList<String> perks = new ArrayList<String>();

    public void addPerk(String perk){

        if(perkSize < maxPerks){
            perkSize++;
            perks.add(perk);
        }
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
