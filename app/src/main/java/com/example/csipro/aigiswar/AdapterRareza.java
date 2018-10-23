package com.example.csipro.aigiswar;

import android.app.Activity;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class AdapterRareza extends ArrayAdapter<Rareza> {
    ArrayList<Rareza> rareza;
    Context context;
    int res;

    public AdapterRareza(Context context, int resource, ArrayList<Rareza> Rareza) {
        super(context, resource, Rareza);
        this.rareza =Rareza;
        this.context = context;
        this.res = resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.rareza, null, true);

        }
        Rareza rareza = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.Menu);
        Picasso.with(context).load(rareza.getUrl()).into(imageView);


        return convertView;
    }
}
