package com.dbdperks;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dbdperks.api.data.Perks;
import com.dbdperks.api.threads.Thread;
import com.google.gson.Gson;

import java.util.ArrayList;

public class PerksInfoActivity extends AppCompatActivity {

    int option_code = 0;
    int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        setContentView(R.layout.activity_perk_info);

        Perks perks = new Perks();
        perks = Thread.getInstance().getSurvivorPerks().get(pos);


        TextView players_nameText = findViewById(R.id.perk_nameText);
        players_nameText.setText(perks.getPerkName());

        ImageView playerImage = findViewById(R.id.perk1);
        playerImage.setImageBitmap(Thread.getInstance().getSurvivorPerksIcons().get(pos));

        findViewById(R.id.button_addToBuild).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                if(SurvivorBuild.getInstance().addPerk(Thread.getInstance().getSurvivorPerksIcons().get(pos), Thread.getInstance().getSurvivorPerks().get(pos)) == true){
                    Toast.makeText(PerksInfoActivity.this, getResources().getString(R.string.perkadded), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(PerksInfoActivity.this, getResources().getString(R.string.buildfull), Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView description = findViewById(R.id.descriptionperkText);
        description.setText(perks.getDescription());



    }
    private void killer(){
        setContentView(R.layout.activity_perk_info);

        Perks perks = new Perks();
        perks = Thread.getInstance().getKillerPerks().get(pos);


        TextView players_nameText = findViewById(R.id.perk_nameText);
        players_nameText.setText(perks.getPerkName());

        ImageView playerImage = findViewById(R.id.perk1);
        playerImage.setImageBitmap(Thread.getInstance().getKillerPerksIcons().get(pos));

        findViewById(R.id.button_addToBuild).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //SurvivorBuild.getInstance().addPerk(Thread.getInstance().getSurvivorPerks().get(pos).getIcon());
            }
        });

        TextView description = findViewById(R.id.descriptionperkText);
        description.setText(perks.getDescription());
    }
}