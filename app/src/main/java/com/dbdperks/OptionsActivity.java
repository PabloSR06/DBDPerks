package com.dbdperks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dbdperks.api.data.Survivor;
import com.dbdperks.api.threads.Thread;

public class OptionsActivity extends AppCompatActivity {

    int option_code = 0;
    static int patience = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        Bundle parametros = this.getIntent().getExtras();

        if (parametros != null) {
            option_code = parametros.getInt("option_code");
        }


        switch (option_code){
            case 0:
                survivor();
                break;
            case 1:
                killer();
                break;
        }

    }


    private void survivor() {
        findViewById(R.id.button_player).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Thread.getInstance().isPlayerSurvivorComplete() != false) {
                    intentPlayer();
                }else{
                    loading_alert();
                }
            }
        });

        findViewById(R.id.button_perks).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Thread.getInstance().isPerkSurvivorComplete() != false) {
                    intentPerk();
                } else {
                    loading_alert();
                }
            }
        });

        findViewById(R.id.button_build).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intentBuild();
            }
        });
    }

    private void killer() {
        findViewById(R.id.button_player).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Thread.getInstance().isPlayerKillerComplete() != false) {
                    intentPlayer();
                }else{
                    loading_alert();
                }
            }
        });

        findViewById(R.id.button_perks).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Thread.getInstance().isPerkKillerComplete() != false) {
                    intentPerk();
                }else{
                    loading_alert();
                }
            }
        });

        findViewById(R.id.button_build).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intentBuild();
            }
        });
    }


    private void loading_alert(){
        if (patience == 5) {
            patience = 0;
            Toast.makeText(OptionsActivity.this, getResources().getString(R.string.loading_break), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(OptionsActivity.this, getResources().getString(R.string.loading), Toast.LENGTH_SHORT).show();
            patience++;
        }
    }

    private void intentPerk(){
        Intent intent = new Intent(OptionsActivity.this, PerksActivity.class);
        intent.putExtra("option_code", option_code);
        startActivity(intent);
    }
    private void intentPlayer(){
        Intent intent = new Intent(OptionsActivity.this, PlayersActivity.class);
        intent.putExtra("option_code", option_code);
        startActivity(intent);
    }
    private void intentBuild(){
//        Intent intent = new Intent(OptionsActivity.this, PerksSurvivorActivity.class);
//        intent.putExtra("option_code", option_code);
//        startActivity(intent);
        System.out.println(option_code);
    }
}