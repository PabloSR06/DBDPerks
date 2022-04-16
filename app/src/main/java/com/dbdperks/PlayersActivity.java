package com.dbdperks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PlayersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        findViewById(R.id.button_killers).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(PlayersActivity.this, KillersActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button_survivors).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(PlayersActivity.this, SurvivorActivity.class);
                startActivity(intent);
            }
        });


    }
}