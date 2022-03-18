package com.dbdperks;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dbdperks.api.data.Icon;
import com.dbdperks.api.data.Perks;

import java.net.URI;
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


        TextView textView1 = currentItemView.findViewById(R.id.textView1);
        textView1.setText(currentNumberPosition.getPerkName());

        TextView textView2 = currentItemView.findViewById(R.id.textView2);
        textView2.setText(currentNumberPosition.getDescription());

        return currentItemView;
    }
}
