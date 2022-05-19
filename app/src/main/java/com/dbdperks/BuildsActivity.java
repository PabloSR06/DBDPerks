package com.dbdperks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.dbdperks.api.data.Build;
import com.dbdperks.api.data.Killer;
import com.dbdperks.api.data.Perks;
import com.dbdperks.api.threads.Thread;
import com.dbdperks.listAdapter.BuildViewAdapter;
import com.dbdperks.listAdapter.KillersViewAdapter;
import com.dbdperks.listAdapter.PerksKillerViewAdapter;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        Build build = new Build();
        build = Thread.getInstance().getSurvivorBuild().get(0);



    }

    private void killer(){
        ArrayList<Build> buildKillerList = Thread.getInstance().getKillerBuild();

        BuildViewAdapter perksAdapter = new BuildViewAdapter(this, buildKillerList);

        ListView buildList = findViewById(R.id.list);

        buildList.setAdapter(perksAdapter);

        buildList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(PerksActivity.this, PerksInfoActivity.class);
//                intent.putExtra("option_code", 1);
//                intent.putExtra("player_pos", position);
//                startActivity(intent);

            }
        });
    }
}