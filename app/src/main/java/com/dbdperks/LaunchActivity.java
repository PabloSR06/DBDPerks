package com.dbdperks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;

import com.dbdperks.api.threads.Thread;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isConnected() == true){
                    Thread.getInstance();
                    startActivity(new Intent(LaunchActivity.this, MainActivity.class));
                }else{
                    startActivity(new Intent(LaunchActivity.this, ErrorActivity.class));
                }
                finish();
            }
        }, 2000);
    }

    private boolean isConnected(){
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        boolean activo = false;

        if (networkInfo != null && networkInfo.isConnected()) {
            activo = true;
        }
        return activo;
    }
}