package com.example.csipro.aigiswar;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterInicio extends ArrayAdapter<inicio> {
    ArrayList<inicio> inicio;
    Context context;
    int resource;

    public AdapterInicio(Context context, int resource, ArrayList<inicio> inicio) {
        super(context, resource, inicio);
        this.inicio = inicio;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item, null, true);

        }
        inicio inicio = getItem(position);
        ImageView imageView = convertView.findViewById(R.id.Menu);
        Picasso.with(context).load(inicio.getUrl()).into(imageView);
        TextView textView = convertView.findViewById(R.id.nombretxt);
        textView.setText(inicio.getNombre());
        return convertView;
    }
}
