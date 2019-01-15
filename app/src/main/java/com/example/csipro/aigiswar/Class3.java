package com.example.csipro.aigiswar;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


/**
 * A simple {@link Fragment} subclass.
 */
public class Class3 extends Fragment {
    ImageView Perfil;
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
    TextView class1;
    TextView Favorito;
<<<<<<< HEAD
    TextView MR;
=======
    TextView Rm;
>>>>>>> 48359499da3de8f5138d320ca40b44c167d6ed06
    Button add;
    TextView Banus;
    boolean favorito;
    int i = 0;
    String clase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root=inflater.inflate(R.layout.class1,container,false);
        Perfil =root. findViewById(R.id.foto);
        Favorito=root.findViewById(R.id.Favorito);
        inicial = root.findViewById(R.id.lv1);
        atkb = root.findViewById(R.id.atkb);
        defb = root.findViewById(R.id.defb);
        blockB = root.findViewById(R.id.block);
        range = root.findViewById(R.id.range);
        hpb = root.findViewById(R.id.hpb);
        max = root.findViewById(R.id.max);
        minb = root.findViewById(R.id.min);
        Banusmax = root.findViewById(R.id.banusmax);
        inicialm = root.findViewById(R.id.lv55);
        hpm = root.findViewById(R.id.hpmax);
        atkm = root.findViewById(R.id.actkm);
        defm = root.findViewById(R.id.defm);
<<<<<<< HEAD
        Banus=root.findViewById(R.id.banus);
        class1=root.findViewById(R.id.class1);
=======
        Rm=root.findViewById(R.id.Mr);

>>>>>>> 48359499da3de8f5138d320ca40b44c167d6ed06
        add=root.findViewById(R.id.Add);
        MR=root.findViewById(R.id.Mr);
        Unidades obj = (Unidades) getActivity().getIntent().getExtras().getSerializable("objecto");
        clase=obj.getRare();
        i=obj.getId();

<<<<<<< HEAD
        switch (clase){
=======
        switch (obj.getRare()){
>>>>>>> 48359499da3de8f5138d320ca40b44c167d6ed06
            case "Gold":
                new ReadJSON().execute("https://inby-subordinates.000webhostapp.com/gold.js");
                break;

            case "Platinum":
                new ReadJSON().execute("https://inby-subordinates.000webhostapp.com/platino.js");
                break;
            case "Black":
                new ReadJSON().execute("https://inby-subordinates.000webhostapp.com/black.js");
                break;
        }


        setHasOptionsMenu(true);
        return root;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return true;
    }
    class ReadJSON extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            return readURL(params[0]);
        }

        @Override
        protected void onPostExecute(String content) {
            if (clase.equals("Gold")) {
                try {
                    JSONObject jsonObject = new JSONObject(content);
                    JSONArray jsonArray = jsonObject.getJSONArray("caracerisicas");

                    JSONObject productObject = jsonArray.getJSONObject(i).getJSONArray("class3").getJSONObject(0);

                    inicial.setText(productObject.getString("inicial"));
                    hpb.setText(productObject.getString("Hp"));
                    atkb.setText(productObject.getString("Atk"));
                    defb.setText(productObject.getString("Def"));
                    blockB.setText(productObject.getString("Block"));
                    MR.setText(productObject.getString("MR"));
                    max.setText(productObject.getString("Max"));
                    minb.setText(productObject.getString("Min"));
                    Banus.setText(productObject.getString("Banus"));
                    Picasso.with(null).load(productObject.getString("img")).into(Perfil);
                    productObject = jsonArray.getJSONObject(i).getJSONArray("class3").getJSONObject(1);
                    inicialm.setText(productObject.getString("LvMax"));
                    hpm.setText(productObject.getString("Hp"));
                    atkm.setText(productObject.getString("Atk"));
                    defm.setText(productObject.getString("Def"));
                    range.setText(productObject.getString("Range"));


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    JSONObject jsonObject = new JSONObject(content);
                    JSONArray jsonArray = jsonObject.getJSONArray("caracerisicas");

                    JSONObject productObject = jsonArray.getJSONObject(i).getJSONArray("class3").getJSONObject(0);

                    inicial.setText(productObject.getString("inicial"));
                    hpb.setText(productObject.getString("Hp"));
                    atkb.setText(productObject.getString("Atk"));
                    defb.setText(productObject.getString("Def"));
                    blockB.setText(productObject.getString("Block"));
                    max.setText(productObject.getString("Max"));
                    minb.setText(productObject.getString("Min"));
                    Banusmax.setText(productObject.getString("BanusEx"));
                    MR.setText(productObject.getString("MR"));

                    Banus.setText(productObject.getString("Banus"));
                    Picasso.with(null).load(productObject.getString("img")).into(Perfil);
                    productObject = jsonArray.getJSONObject(i).getJSONArray("class3").getJSONObject(1);
                    inicialm.setText(productObject.getString("LvMax"));
                    hpm.setText(productObject.getString("Hp"));
                    atkm.setText(productObject.getString("Atk"));
                    defm.setText(productObject.getString("Def"));
                    range.setText(productObject.getString("Range"));



                } catch (JSONException e) {
                    e.printStackTrace();
                }

<<<<<<< HEAD
=======
            try {
                JSONObject jsonObject = new JSONObject(content);
                JSONArray jsonArray = jsonObject.getJSONArray("caracerisicas");

                JSONObject productObject = jsonArray.getJSONObject(i).getJSONArray("class3").getJSONObject(0);

                inicial.setText(productObject.getString("inicial"));
                hpb.setText(productObject.getString("Hp"));
                atkb.setText(productObject.getString("Atk"));
                defb.setText(productObject.getString("Def"));
                blockB.setText(productObject.getString("Block"));
                max.setText(productObject.getString("Max"));
                Rm.setText(productObject.getString("MR"));

                minb.setText(productObject.getString("Min"));
                Picasso.with(null).load(productObject.getString("img")).into(Perfil);
                productObject = jsonArray.getJSONObject(i).getJSONArray("class3").getJSONObject(1);
                inicialm.setText(productObject.getString("LvMax"));
                hpm.setText(productObject.getString("Hp"));
                atkm.setText(productObject.getString("Atk"));
                defm.setText(productObject.getString("Def"));
                range.setText(productObject.getString("Range"));


            } catch (JSONException e) {
                e.printStackTrace();
>>>>>>> 48359499da3de8f5138d320ca40b44c167d6ed06
            }
        }
    }


    private static String readURL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            // create a url object
            URL url = new URL(theUrl);
            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();
            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}

