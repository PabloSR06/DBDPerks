package com.dbdperks;

import android.graphics.Bitmap;
import android.os.Bundle;
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

        ArrayList<Survivor> perksList = Thread.getInstance().getSurvivor();

        SurvivorViewAdapter perksAdapter = new SurvivorViewAdapter(this, perksList);

        ListView perklist = findViewById(R.id.list);

        perklist.setAdapter(perksAdapter);

    }
}