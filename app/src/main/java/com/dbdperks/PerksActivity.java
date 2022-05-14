package com.dbdperks;

import android.content.Intent;
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

public class PerksActivity extends AppCompatActivity {

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
                optionSurvivor();
                break;
            case 1:
                optionKiller();
                break;
        }

    }

    private void optionSurvivor(){
        ArrayList<Perks> perksSurvivorList = Thread.getInstance().getSurvivorPerks();

        PerksSurvivorViewAdapter perksAdapter = new PerksSurvivorViewAdapter(this, perksSurvivorList);

        ListView perklist = findViewById(R.id.list);

        perklist.setAdapter(perksAdapter);

        perklist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(PerksActivity.this, PlayerInfoActivity.class);
//                intent.putExtra("option_code", 1);
//                intent.putExtra("player_pos", position);
//                startActivity(intent);
                SurvivorBuild.getInstance().addPerk(Thread.getInstance().getSurvivorPerks().get(position).getIcon());

            }
        });
    }

    private void optionKiller(){
        ArrayList<Perks> perksKillerList = Thread.getInstance().getKillerPerks();

        PerksKillerViewAdapter perksAdapter = new PerksKillerViewAdapter(this, perksKillerList);

        ListView perklist = findViewById(R.id.list);

        perklist.setAdapter(perksAdapter);
    }
}