package com.dbdperks;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ListView;

import com.dbdperks.api.data.Perks;
import com.dbdperks.api.threads.Thread;
import com.dbdperks.listAdapter.PerksViewAdapter;

import java.util.ArrayList;

public class PerksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perks);

        ArrayList<Perks> perksList = Thread.getInstance().getPerks();
        //ArrayList<Bitmap> perksIcons = getIntent().getParcelableArrayListExtra("icons");
        ArrayList<Bitmap> perksIcons = null;

        PerksViewAdapter perksAdapter = new PerksViewAdapter(this, perksList, perksIcons);

        ListView perklist = findViewById(R.id.list);

        perklist.setAdapter(perksAdapter);
    }
}