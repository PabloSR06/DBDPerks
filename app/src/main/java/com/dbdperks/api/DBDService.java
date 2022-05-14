package com.dbdperks.api;

import com.dbdperks.api.data.Killer;
import com.dbdperks.api.data.Perks;
import com.dbdperks.api.data.Survivor;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DBDService {

    private static final String BASE_URL = "https://dbd-api.herokuapp.com/";

    private DBDInterface service;
    private Gson gson = new Gson();

    private static DBDService dbdAPI;


    public DBDService() {

        ConnectionPool pool = new ConnectionPool(1, 5, TimeUnit.SECONDS);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectionPool(pool)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        service = retrofit.create(DBDInterface.class);
    }

    public ArrayList<Perks> perks() throws Exception {

        Call<ArrayList<Perks>> call = service.perkList();

        Response<ArrayList<Perks>> response = call.execute();

        ArrayList<Perks> perksList = response.body();

        return perksList;
    }

    public ArrayList<Perks> survivorPerks() throws Exception {

        Call<ArrayList<Perks>> call = service.perkSurvivorList();

        Response<ArrayList<Perks>> response = call.execute();

        ArrayList<Perks> perkSurvivorList = response.body();

        return perkSurvivorList;
    }

    public ArrayList<Perks> killerPerks() throws Exception {

        Call<ArrayList<Perks>> call = service.perkKillerList();

        Response<ArrayList<Perks>> response = call.execute();

        ArrayList<Perks> perkKillerList = response.body();

        return perkKillerList;
    }

    public ArrayList<Survivor> survivors() throws Exception {

        Call<ArrayList<Survivor>> call = service.survivorList();

        Response<ArrayList<Survivor>> response = call.execute();

        ArrayList<Survivor> survivorsList = response.body();

        return survivorsList;
    }

    public ArrayList<Killer> killers() throws Exception {

        Call<ArrayList<Killer>> call = service.killerList();

        Response<ArrayList<Killer>> response = call.execute();

        ArrayList<Killer> killerList = response.body();

        return killerList;
    }

    private void assertResponse(Response<?> response) throws Exception {
        if (!response.isSuccessful()) {
            ErrorMessage error = gson.fromJson(response.errorBody().string(), ErrorMessage.class);
            throw new Exception(error.getMessage());
        }
    }

    public static DBDService getInstance() {
        if (dbdAPI == null) {
            dbdAPI = new DBDService();
        }
        return dbdAPI;
    }
}
