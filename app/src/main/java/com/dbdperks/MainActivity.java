package com.dbdperks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.dbdperks.api.threads.Thread;


public class MainActivity extends AppCompatActivity {

    static int patience = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navBar();

    }

    public void navBar(){

//        findViewById(R.id.button_builds).setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, PerksActivity.class);
//                startActivity(intent);
//            }
//        });
        findViewById(R.id.button_survivors).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (Thread.getInstance().getSurvivorStatus() != false) {
                    Intent intent = new Intent(MainActivity.this, SurvivorOptionsActivity.class);
                    startActivity(intent);
                }else{
                    if (patience == 5){
                        patience = 0;
                        Toast.makeText(MainActivity.this, getResources().getString(R.string.loading_break), Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, getResources().getString(R.string.loading), Toast.LENGTH_SHORT).show();
                        patience++;
                    }
                }


            }
        });
        findViewById(R.id.button_killers).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Thread.getInstance().getKillerStatus() != false) {
                    Intent i = new Intent(MainActivity.this, KillerOptionsActivity.class);
                    startActivity(i);
                }else{
                    if (patience == 5){
                        patience = 0;
                        Toast.makeText(MainActivity.this, getResources().getString(R.string.loading_break), Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, getResources().getString(R.string.loading), Toast.LENGTH_SHORT).show();
                        patience++;
                    }
                }
            }
        });
    }
}