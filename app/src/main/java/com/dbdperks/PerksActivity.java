package com.dbdperks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.dbdperks.api.data.Perks;

import java.util.ArrayList;

public class PerksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perks);

        ArrayList<Perks> perksList = getIntent().getParcelableArrayListExtra("perks");
        System.out.println(perksList.get(0).getName());


        PerksViewAdapter perksAdapter = new PerksViewAdapter(this, perksList);

        ListView perklist = findViewById(R.id.list);

        perklist.setAdapter(perksAdapter);
    }
}