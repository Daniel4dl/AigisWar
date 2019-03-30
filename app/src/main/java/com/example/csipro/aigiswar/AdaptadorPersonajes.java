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
import java.util.List;

public class AdaptadorPersonajes extends ArrayAdapter<CaracteristicaDeUnidades> {
    List<CaracteristicaDeUnidades> caracteristicaDeUnidades;
    Context context;
    int resource;
    TextView inicial;
    TextView inicialm;
    TextView hpb;
    TextView atkb;
    TextView defb;
    TextView hpm;
    TextView atkm;
    TextView defm;
    TextView blockB;
    TextView range;
    TextView max;
    TextView minb;
    TextView Banusmax;
    TextView nombre;
    TextView Mr;
    TextView class1;
    TextView Favorito;
    TextView Banus;

    public AdaptadorPersonajes(Context context, int resource, List<CaracteristicaDeUnidades> caracteristicaDeUnidade) {
        super(context, resource, caracteristicaDeUnidade);
        caracteristicaDeUnidades = caracteristicaDeUnidade;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.class1, null, true);

        }
        CaracteristicaDeUnidades caracteristicaDeUnidades = getItem(position);

        inicial = convertView.findViewById(R.id.lv1);
        atkb = convertView.findViewById(R.id.atkb);
        defb = convertView.findViewById(R.id.defb);
        blockB = convertView.findViewById(R.id.block);
        range = convertView.findViewById(R.id.range);
        hpb = convertView.findViewById(R.id.hpb);
        max = convertView.findViewById(R.id.max);
        minb = convertView.findViewById(R.id.min);
        Banusmax = convertView.findViewById(R.id.banusmax);
        inicialm = convertView.findViewById(R.id.lv55);
        hpm = convertView.findViewById(R.id.hpmax);
        atkm = convertView.findViewById(R.id.actkm);
        defm = convertView.findViewById(R.id.defm);
        Mr = convertView.findViewById(R.id.Mr);
        Banus = convertView.findViewById(R.id.banus);

        inicial.setText(caracteristicaDeUnidades.getInicial());
        atkb.setText(caracteristicaDeUnidades.getAtk());
        defb.setText(caracteristicaDeUnidades.getDef());
        blockB.setText(caracteristicaDeUnidades.getBloc());
        range.setText(caracteristicaDeUnidades.getRanfe());
        hpb.setText(caracteristicaDeUnidades.getHp());
        max.setText(caracteristicaDeUnidades.getMax());
        minb.setText(caracteristicaDeUnidades.getMin());
        Banusmax.setText(caracteristicaDeUnidades.getBanusmax());
        inicialm.setText(caracteristicaDeUnidades.getLvmax());
        hpm.setText(caracteristicaDeUnidades.getHpm());
        atkm.setText(caracteristicaDeUnidades.getArkmax());
        defm.setText(caracteristicaDeUnidades.getDefmax());
        Mr.setText(caracteristicaDeUnidades.getMr());
        Banus.setText(caracteristicaDeUnidades.getBanus());


        return convertView;
    }
}
