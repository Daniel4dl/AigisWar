package com.example.csipro.aigiswar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdaptadorDeUnidadBlack extends RecyclerView.Adapter<AdaptadorDeUnidadBlack.MyViewHolder>{
    private LayoutInflater mInflater;

    private ArrayList<Unidades> unidades;

    public static class MyViewHolder extends RecyclerView.ViewHolder  {
        ImageView perfil;
        CardView cv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
                  perfil=itemView.findViewById(R.id.perfil);
        }

    }


    AdaptadorDeUnidadBlack(Context context, ArrayList<Unidades> unidades) {
        this.mInflater = LayoutInflater.from(context);
        this.unidades = unidades;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.item_caracteristica, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Picasso.with(myViewHolder.itemView.getContext()).load(unidades.get(i).getImage()).into(myViewHolder.perfil);

    }


    @Override
    public int getItemCount() {
        return unidades.size();
    }
}
