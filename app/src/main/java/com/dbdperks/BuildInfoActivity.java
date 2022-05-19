package com.dbdperks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.dbdperks.api.data.Build;
import com.dbdperks.api.data.Perks;
import com.dbdperks.api.threads.Thread;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.BitSet;

public class BuildInfoActivity extends AppCompatActivity {

    int option_code = 0;
    int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_info);

        Bundle extras = this.getIntent().getExtras();


        if (extras != null) {
            option_code = extras.getInt("option_code");
            pos = extras.getInt("player_pos");
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

        Build build = Thread.getInstance().getSurvivorBuild().get(pos);

        ArrayList<Bitmap> icons = Thread.getInstance().getSurvivorBuildIcons().get(pos);

        generateLayout(build, icons);


    }
    private void killer(){
        Build build = Thread.getInstance().getKillerBuild().get(pos);

        ArrayList<Bitmap> icons = Thread.getInstance().getKillerBuildIcons().get(pos);

        generateLayout(build, icons);

    }

    private void generateLayout(Build build, ArrayList<Bitmap> bitmaps){
        ImageView perk1 = findViewById(R.id.perk1);
        ImageView perk2 = findViewById(R.id.perk2);
        ImageView perk3 = findViewById(R.id.perk3);
        ImageView perk4 = findViewById(R.id.perk4);

        if (build.getPerks() != null) {
            int len = bitmaps.size();
            for (int j = 0; j < len; j++) {
                Bitmap icon = bitmaps.get(j);
                switch (j){
                    case 0:
                        perk1.setImageBitmap(icon);
                        break;
                    case 1:
                        perk2.setImageBitmap(icon);
                        break;
                    case 2:
                        perk3.setImageBitmap(icon);
                        break;
                    case 3:
                        perk4.setImageBitmap(icon);
                        break;
                }
            }

        }

        TextView nameBuild = findViewById(R.id.nameBuild);
        nameBuild.setText(build.getNameBuild());
    }

}