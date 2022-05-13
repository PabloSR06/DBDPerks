package com.dbdperks;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.dbdperks.api.data.Perks;
import com.dbdperks.api.threads.Thread;
import com.dbdperks.listAdapter.PerksKillerViewAdapter;
import com.dbdperks.listAdapter.PerksSurvivorViewAdapter;

import java.util.ArrayList;

public class PerksSurvivorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listperks);

        ArrayList<Perks> perksSurvivorList = Thread.getInstance().getSurvivorPerks();

        PerksSurvivorViewAdapter perksAdapter = new PerksSurvivorViewAdapter(this, perksSurvivorList);

        ListView perklist = findViewById(R.id.list);

        perklist.setAdapter(perksAdapter);


    }
}