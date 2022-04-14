package com.dbdperks.listAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dbdperks.R;
import com.dbdperks.api.data.Killer;
import com.dbdperks.api.data.Survivor;
import com.dbdperks.api.threads.Thread;

import java.util.ArrayList;

public class KillersViewAdapter extends ArrayAdapter<Killer> {


    public KillersViewAdapter(@NonNull Context context, ArrayList<Killer> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View currentItemView = convertView;

        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.playerlist_view, parent, false);
        }

        Killer currentNumberPosition = getItem(position);
        System.out.println(position);


        ImageView imageView = currentItemView.findViewById(R.id.perk_1);
        String icon = currentNumberPosition.getIcon().getPortrait();
        imageView.setImageBitmap(Thread.getInstance().getKillersIcons().get(position));


        TextView survivor_name = currentItemView.findViewById(R.id.players_name);
        survivor_name.setText(currentNumberPosition.getName());



        return currentItemView;
    }




}
