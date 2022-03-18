package com.dbdperks.api.threads;

import com.dbdperks.api.DBDService;
import com.dbdperks.api.data.Killer;
import com.dbdperks.api.data.Perks;
import com.dbdperks.api.data.Survivor;

import java.util.ArrayList;

public class LoadThread extends Thread{

    DBDService dbdService = new DBDService();


    private ArrayList<Perks> perksList;

    private ArrayList<Killer> killersList;

    private ArrayList<Survivor> survivorsList;


    public void run() {
        try {
            perksList = dbdService.perks();
            killersList = dbdService.killers();
            survivorsList = dbdService.survivors();

            System.out.println(perksList.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
