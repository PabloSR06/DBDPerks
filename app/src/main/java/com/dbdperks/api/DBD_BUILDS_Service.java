package com.dbdperks.api;



import com.dbdperks.api.data.Build;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DBD_BUILDS_Service {

    private static final String BASE_URL = "https://dbdperks.000webhostapp.com/";

    private DBD_BUILDS_Interface service;
    private Gson gson = new Gson();

    private static DBD_BUILDS_Service apiManager;

    public DBD_BUILDS_Service() {

        ConnectionPool pool = new ConnectionPool(1, 5, TimeUnit.SECONDS);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectionPool(pool)
                .build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        service = retrofit.create(DBD_BUILDS_Interface.class);
    }

    public void createBuild(Build build) throws Exception {

//        Call<Build> userCall = service.createBuild(build);
//        userCall.enqueue(new Callback<Build>() {
//            @Override
//            public void onResponse(Call<Build> call, Response<Build> response) {
//                System.out.println("asa");
//            }
//
//            @Override
//            public void onFailure(Call<Build> call, Throwable t) {
//                System.out.println(t);
//            }
//        });

    }
    public ArrayList<Build> getBuilds() throws Exception {

        Call<ArrayList<Build>> call = service.getBuilds();

        Response<ArrayList<Build>> response = call.execute();

        ArrayList<Build> build = response.body();

        return build;
    }

    public ArrayList<Build> getBuildKillers() throws Exception {

        Call<ArrayList<Build>> call = service.getBuildKillers();

        Response<ArrayList<Build>> response = call.execute();

        ArrayList<Build> buildKiller = response.body();

        return buildKiller;
    }

    public ArrayList<Build> getBuildSurvivors() throws Exception {

        Call<ArrayList<Build>> call = service.getBuildSurvivors();

        Response<ArrayList<Build>> response = call.execute();

        ArrayList<Build> buildSurvivor = response.body();

        return buildSurvivor;
    }

    private void assertResponse(Response<?> response) throws Exception {
        if (!response.isSuccessful()) {
            ErrorMessage error = gson.fromJson(response.errorBody().string(), ErrorMessage.class);
            throw new Exception(error.getMessage());
        }
    }
    public static DBD_BUILDS_Service getInstance() {
        if (apiManager == null) {
            apiManager = new DBD_BUILDS_Service();
        }
        return apiManager;
    }
}
