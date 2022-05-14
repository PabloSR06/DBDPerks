package com.dbdperks;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dbdperks.api.data.Killer;
import com.dbdperks.api.data.Perks;
import com.dbdperks.api.data.Survivor;
import com.dbdperks.api.threads.Thread;

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

        ImageView playerImage = findViewById(R.id.perkImage);
        playerImage.setImageBitmap(Thread.getInstance().getSurvivorPerksIcons().get(pos));


    }
    private void killer(){
        setContentView(R.layout.activity_perk_info);

        Perks perks = new Perks();
        perks = Thread.getInstance().getKillerPerks().get(pos);


        TextView players_nameText = findViewById(R.id.perk_nameText);
        players_nameText.setText(perks.getPerkName());

        ImageView playerImage = findViewById(R.id.perkImage);
        playerImage.setImageBitmap(Thread.getInstance().getKillerPerksIcons().get(pos));
    }
}