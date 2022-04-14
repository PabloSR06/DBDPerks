package com.dbdperks.listAdapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dbdperks.R;
import com.dbdperks.api.threads.Thread;
import com.dbdperks.api.data.Perks;

import java.util.ArrayList;

public class PerksViewAdapter extends ArrayAdapter<Perks> {


    public PerksViewAdapter(@NonNull Context context, ArrayList<Perks> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View currentItemView = convertView;

        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.perkslist_view, parent, false);
        }

        Perks currentNumberPosition = getItem(position);
        System.out.println(position);


        ImageView imageView = currentItemView.findViewById(R.id.perk_1);
        String icon = currentNumberPosition.getIcon();

        imageView.setImageBitmap(Thread.getInstance().getPerksIcons().get(position));

        TextView perk_name = currentItemView.findViewById(R.id.perk_name);
        perk_name.setText(currentNumberPosition.getPerkName());



        return currentItemView;
    }




}
