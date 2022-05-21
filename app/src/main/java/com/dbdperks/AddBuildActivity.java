package com.dbdperks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dbdperks.api.data.Build;
import com.dbdperks.api.data.Perks;

import java.util.ArrayList;

public class AddBuildActivity extends AppCompatActivity {

    int option_code = 0;
    int pos = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_build);

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

        ImageView perk1 = findViewById(R.id.perk1);
        ImageView perk2 = findViewById(R.id.perk2);
        ImageView perk3 = findViewById(R.id.perk3);
        ImageView perk4 = findViewById(R.id.perk4);

        ArrayList<Perks> perks = SurvivorBuild.getInstance().getPerks();
        ArrayList<Bitmap> icons = SurvivorBuild.getInstance().getIcons();

        if (perks != null) {
            int len = icons.size();
            for (int j = 0; j < len; j++) {
                Bitmap icon = icons.get(j);
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
        findViewById(R.id.button_sendBuild).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SurvivorBuild.getInstance().endInstance();

                Intent intent = new Intent(AddBuildActivity.this, OptionsActivity.class);
                intent.putExtra("option_code", 0);
                startActivity(intent);
            }
        });


    }
    private void killer(){


    }
}