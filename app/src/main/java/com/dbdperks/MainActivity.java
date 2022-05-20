package com.dbdperks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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
        ImageView survivor = findViewById(R.id.button_survivors);
        survivor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
                    intent.putExtra("option_code", 0);
                    startActivity(intent);
            }
        });

        ImageView killer = findViewById(R.id.button_killers);
        killer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
                intent.putExtra("option_code", 1);
                startActivity(intent);
            }
        });
    }
}