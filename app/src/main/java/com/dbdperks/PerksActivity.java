package com.dbdperks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.dbdperks.api.data.Perks;
import com.dbdperks.api.threads.Thread;
import com.dbdperks.listAdapter.PerksKillerViewAdapter;

import java.util.ArrayList;

public class PerksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perks);

        findViewById(R.id.button_killers).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(PerksActivity.this, PerksKillerActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button_survivors).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(PerksActivity.this, PerksSurvivorActivity.class);
                startActivity(intent);
            }
        });
    }
}