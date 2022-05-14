package com.dbdperks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.dbdperks.api.threads.Thread;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navBar();
    }

    public void navBar(){
        findViewById(R.id.button_survivors).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
                    intent.putExtra("option_code", 0);
                    startActivity(intent);
            }
        });
        findViewById(R.id.button_killers).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
                    intent.putExtra("option_code", 1);
                    startActivity(intent);
            }
        });
    }
}