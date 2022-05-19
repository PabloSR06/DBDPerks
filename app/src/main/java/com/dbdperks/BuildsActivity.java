package com.dbdperks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.dbdperks.api.data.Build;
import com.dbdperks.api.threads.Thread;
import com.dbdperks.listAdapter.BuildKillerViewAdapter;
import com.dbdperks.listAdapter.BuildSurvivorViewAdapter;

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
        ArrayList<Build> buildSurvivorList = Thread.getInstance().getSurvivorBuild();

        BuildSurvivorViewAdapter buildAdapter = new BuildSurvivorViewAdapter(this, buildSurvivorList);

        ListView buildList = findViewById(R.id.list);

        buildList.setAdapter(buildAdapter);

        buildList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BuildsActivity.this, BuildInfoActivity.class);
                intent.putExtra("option_code", 0);
                intent.putExtra("player_pos", position);
                startActivity(intent);

            }
        });

    }

    private void killer(){
        ArrayList<Build> buildKillerList = Thread.getInstance().getKillerBuild();

        BuildKillerViewAdapter buildAdapter = new BuildKillerViewAdapter(this, buildKillerList);

        ListView buildList = findViewById(R.id.list);

        buildList.setAdapter(buildAdapter);

        buildList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BuildsActivity.this, BuildInfoActivity.class);
                intent.putExtra("option_code", 1);
                intent.putExtra("player_pos", position);
                startActivity(intent);

            }
        });
    }
}