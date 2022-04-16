package com.dbdperks.api;

import com.dbdperks.api.data.Killer;
import com.dbdperks.api.data.Perks;
import com.dbdperks.api.data.Survivor;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface    DBDInterface {

    @GET("perks?lang=en")
    public Call<ArrayList<Perks>> perkList();

    @GET("perks?lang=en&role=Survivor")
    public Call<ArrayList<Perks>> perkSurvivorList();

    @GET("perks?lang=en&role=Killer")
    public Call<ArrayList<Perks>> perkKillerList();

    @GET("killers?lang=en")
    public Call<ArrayList<Killer>> killerList();

    @GET("survivors?lang=en")
    public Call<ArrayList<Survivor>> survivorList();
}
