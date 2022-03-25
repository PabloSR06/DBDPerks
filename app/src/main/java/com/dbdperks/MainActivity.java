package com.dbdperks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dbdperks.api.data.Perks;
import com.dbdperks.api.threads.LoadThread;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private LoadThread loadThread = new LoadThread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // loadThread.start();
        Thread.getInstance();

        TextView txt = (TextView) findViewById(R.id.textView);

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
                intent.putParcelableArrayListExtra("perks",  Thread.getInstance().getPerks());

                startActivity(intent);

            }
        });
        findViewById(R.id.button_player).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("33333");
//                Intent i = new Intent(MainActivity.this, PerksActivity.class);
//                startActivity(i);
            }
        });
    }
}