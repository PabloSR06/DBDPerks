package com.dbdperks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dbdperks.api.data.Perks;
import com.dbdperks.api.threads.LoadThread;

import java.util.ArrayList;

public class    MainActivity extends AppCompatActivity {

    private ArrayList<Perks> listas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt = (TextView) findViewById(R.id.textView);


        LoadThread loadThread = new LoadThread();
        loadThread.start();


        Button button = (Button) findViewById(R.id.testButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ArrayList<Perks> perks = loadThread.getPerksList();

                if (perks == null){
                    System.out.println("aA");

                }else{
                    Intent i = new Intent(MainActivity.this, PerksActivity.class);
                    i.putParcelableArrayListExtra("perks",  perks);
                    startActivity(i);

                }

            }
        });






    }
}