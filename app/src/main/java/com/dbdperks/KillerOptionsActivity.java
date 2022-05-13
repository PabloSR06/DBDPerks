package com.dbdperks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class KillerOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_killer_options);

        findViewById(R.id.button_perks).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(KillerOptionsActivity.this, PerksKillerActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button_player).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(KillerOptionsActivity.this, KillersActivity.class);
                startActivity(intent);
            }
        });
    }
}