package com.dbdperks;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.dbdperks.api.data.Perks;
import com.dbdperks.api.threads.Thread;
import com.dbdperks.listAdapter.PerksKillerViewAdapter;

import java.util.ArrayList;

public class PerksKillerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listperks);

        ArrayList<Perks> perksKillerList = Thread.getInstance().getKillerPerks();

        PerksKillerViewAdapter perksAdapter = new PerksKillerViewAdapter(this, perksKillerList);

        ListView perklist = findViewById(R.id.list);

        perklist.setAdapter(perksAdapter);
    }
}