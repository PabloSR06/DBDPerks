package com.dbdperks.api;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DBDService {

    private static final String BASE_URL = "https://dbd-api.herokuapp.com/";

    private DBDService service;
    private Gson gson = new Gson();

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

        service = retrofit.create(DBDService.class);
    }



    private void assertResponse(Response<?> response) throws Exception {
        if (!response.isSuccessful()) {
            ErrorMessage error = gson.fromJson(response.errorBody().string(), ErrorMessage.class);
            throw new Exception(error.getMessage());
        }
    }
}
