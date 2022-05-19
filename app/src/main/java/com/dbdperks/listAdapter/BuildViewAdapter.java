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
import com.dbdperks.api.data.Build;
import com.dbdperks.api.data.Perks;
import com.dbdperks.api.data.Survivor;
import com.dbdperks.api.threads.Thread;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class BuildViewAdapter extends ArrayAdapter<Build> {


    public BuildViewAdapter(@NonNull Context context, ArrayList<Build> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View currentItemView = convertView;

        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.buildlist_view, parent, false);
        }

        Build currentNumberPosition = getItem(position);

        //Thread.getBitmapFromURL()

        ImageView perk1 = currentItemView.findViewById(R.id.perk1);
        ImageView perk2 = currentItemView.findViewById(R.id.perk2);
        ImageView perk3 = currentItemView.findViewById(R.id.perk3);
        ImageView perk4 = currentItemView.findViewById(R.id.perk4);



        if (currentNumberPosition.getPerks() != null) {
            int len = Thread.getInstance().getKillerBuildIcons().get(position).size();
            for (int j = 0; j < len; j++) {
                perk1.setImageBitmap(Thread.getInstance().getKillerBuildIcons().get(position).get(j));
            }
        }
//
//
//        TextView survivor_name = currentItemView.findViewById(R.id.perk_nameText);
//        survivor_name.setText(currentNumberPosition.getName());


        return currentItemView;
    }



}
