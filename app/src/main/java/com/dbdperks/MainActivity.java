package com.dbdperks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;

import com.dbdperks.api.DBD_BUILDS_Service;
import com.dbdperks.api.data.Build;
import com.dbdperks.api.threads.Thread;
import com.dbdperks.conection.ConectionController;
import com.google.gson.Gson;
import com.google.gson.JsonSerializer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        navBar();



    }





    public void navBar(){

        findViewById(R.id.button_builds).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PerksActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button_perks).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, PerksActivity.class);
                startActivity(intent);

            }
        });
        findViewById(R.id.button_player).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PlayersActivity.class);
                startActivity(i);
            }
        });
    }
}