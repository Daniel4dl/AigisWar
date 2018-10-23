package com.example.csipro.aigiswar;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quocnguyen on 03/08/2016.
 */
public class AdapterCaracter extends ArrayAdapter<Unidades> {

    List<Unidades>Unidades;
    Context context;
    int resource;

    public AdapterCaracter(Context context, int resource,List<Unidades> unidades) {
        super(context, resource, unidades);
        Unidades = unidades;
        this.context = context;
        this.resource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item_caracteristica, null, true);

        }
        Unidades product = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewProduct);
        Picasso.with(context).load(product.getImage()).into(imageView);

        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        txtName.setText(product.getName());

        TextView txtPrice = (TextView) convertView.findViewById(R.id.txtPrice);
        txtPrice.setText(product.getPrice());

        return convertView;
    }
}