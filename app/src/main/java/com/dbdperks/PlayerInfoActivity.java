package com.dbdperks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.dbdperks.api.data.Killer;
import com.dbdperks.api.data.Survivor;
import com.dbdperks.api.threads.Thread;

public class PlayerInfoActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_player_info);

        Survivor surv = new Survivor();
        surv = Thread.getInstance().getSurvivor().get(pos);


        TextView players_nameText = findViewById(R.id.perk_nameText);
        players_nameText.setText(surv.getName());

        ImageView playerImage = findViewById(R.id.perkImage);
        playerImage.setImageBitmap(Thread.getInstance().getSurvivorIcons().get(pos));

        TextView difficultyText = findViewById(R.id.difficultyText);
        difficultyText.setText(surv.getDifficulty());

        TextView overviewText = findViewById(R.id.descriptionText);
        overviewText.setText(surv.getOverview());

        TextView loreText = findViewById(R.id.loreText);
        loreText.setText(surv.getLore());
    }
    private void killer(){
        setContentView(R.layout.activity_player_info);

        Killer killer = new Killer();
        killer = Thread.getInstance().getKillers().get(pos);


        TextView players_nameText = findViewById(R.id.perk_nameText);
        players_nameText.setText(killer.getName());

        ImageView playerImage = findViewById(R.id.perkImage);
        playerImage.setImageBitmap(Thread.getInstance().getKillersIcons().get(pos));

        TextView difficultyText = findViewById(R.id.difficultyText);
        difficultyText.setText(killer.getDifficulty());

        TextView overviewText = findViewById(R.id.descriptionText);
        overviewText.setText(killer.getOverview());

        TextView loreText = findViewById(R.id.loreText);
        loreText.setText(killer.getLore());
    }
}