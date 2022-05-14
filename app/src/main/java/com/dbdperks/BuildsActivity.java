package com.dbdperks;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.dbdperks.api.data.Killer;
import com.dbdperks.api.threads.Thread;
import com.dbdperks.listAdapter.KillersViewAdapter;

import java.util.ArrayList;

public class BuildsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Bundle extras = this.getIntent().getExtras();
        int option_code = 0;
        if(extras !=null){
            option_code = extras.getInt("option_code");
        }

        switch (option_code){
            case 0:
                survivor();
                break;
            case 1:
                killer();
                break;
        }
    }

    private void survivor(){
        ArrayList<Killer> killers = Thread.getInstance().getKillers();

        KillersViewAdapter killerAdapter = new KillersViewAdapter(this, killers);

        ListView killerList = findViewById(R.id.list);

        killerList.setAdapter(killerAdapter);
    }

    private void killer(){
        ArrayList<Killer> killers = Thread.getInstance().getKillers();

        KillersViewAdapter killerAdapter = new KillersViewAdapter(this, killers);

        ListView killerList = findViewById(R.id.list);

        killerList.setAdapter(killerAdapter);
    }
}