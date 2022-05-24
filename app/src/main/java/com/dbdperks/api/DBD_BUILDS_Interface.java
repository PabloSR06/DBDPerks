package com.dbdperks.api;

import com.dbdperks.api.data.Build;
import com.dbdperks.api.data.Perks;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface DBD_BUILDS_Interface {

    @POST("insert.php")
    @Headers({
            "Accept: application/json",
    })
    Call<Build> createBuild(@Body Build build);

    @GET("getbuilds.php")
    public Call<ArrayList<Build>> getBuilds();

    @GET("getbuildskillers.php")
    public Call<ArrayList<Build>> getBuildKillers();

    @GET("getbuildssurvivors.php")
    public Call<ArrayList<Build>> getBuildSurvivors();


}
