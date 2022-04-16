package com.dbdperks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dbdperks.api.threads.LoadThread;
import com.dbdperks.api.threads.Thread;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//       while (Thread.getInstance().getStatus() == false){
//           System.out.println("1");
//       }




        navBar();
    }

    public void navBar(){

        findViewById(R.id.button_builds).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PerksActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button_perks).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, PerksActivity.class);
                startActivity(intent);

            }
        });
        findViewById(R.id.button_player).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PlayersActivity.class);
                startActivity(i);
            }
        });
    }
}