package com.dbdperks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.dbdperks.api.data.Killer;
import com.dbdperks.api.data.Survivor;
import com.dbdperks.api.threads.Thread;
import com.dbdperks.listAdapter.KillersViewAdapter;
import com.dbdperks.listAdapter.SurvivorViewAdapter;

import java.util.ArrayList;

public class PlayersActivity extends AppCompatActivity {

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
        ArrayList<Survivor> survivors = Thread.getInstance().getSurvivor();

        SurvivorViewAdapter survivorAdapter = new SurvivorViewAdapter(this, survivors);

        ListView survivorList = findViewById(R.id.list);

        survivorList.setAdapter(survivorAdapter);

        survivorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PlayersActivity.this, PlayerInfoActivity.class);
                intent.putExtra("option_code", 0);
                intent.putExtra("player_pos", position);
                startActivity(intent);
            }
        });
    }

    private void killer(){
        ArrayList<Killer> killers = Thread.getInstance().getKillers();

        KillersViewAdapter killerAdapter = new KillersViewAdapter(this, killers);

        ListView killerList = findViewById(R.id.list);

        killerList.setAdapter(killerAdapter);

        killerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PlayersActivity.this, PlayerInfoActivity.class);
                intent.putExtra("option_code", 1);
                intent.putExtra("player_pos", position);
                startActivity(intent);
            }
        });
    }
}