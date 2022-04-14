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

public class KillersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listplayers);

        ArrayList<Killer> killers = Thread.getInstance().getKillers();

        KillersViewAdapter killerAdapter = new KillersViewAdapter(this, killers);

        ListView killerList = findViewById(R.id.list);

        killerList.setAdapter(killerAdapter);

    }
}