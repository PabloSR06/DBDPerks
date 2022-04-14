package com.dbdperks;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.dbdperks.api.data.Killer;
import com.dbdperks.api.data.Survivor;
import com.dbdperks.api.threads.Thread;
import com.dbdperks.listAdapter.KillersViewAdapter;
import com.dbdperks.listAdapter.SurvivorViewAdapter;

import java.util.ArrayList;

public class SurvivorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listplayers);

        ArrayList<Survivor> survivors = Thread.getInstance().getSurvivor();

        SurvivorViewAdapter survivorAdapter = new SurvivorViewAdapter(this, survivors);

        ListView survivorList = findViewById(R.id.list);

        survivorList.setAdapter(survivorAdapter);

    }
}