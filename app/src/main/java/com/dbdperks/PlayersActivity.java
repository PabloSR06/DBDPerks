package com.dbdperks;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.dbdperks.api.data.Perks;
import com.dbdperks.api.data.Survivor;
import com.dbdperks.api.threads.Thread;
import com.dbdperks.listAdapter.PerksViewAdapter;
import com.dbdperks.listAdapter.SurvivorViewAdapter;

import java.util.ArrayList;

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