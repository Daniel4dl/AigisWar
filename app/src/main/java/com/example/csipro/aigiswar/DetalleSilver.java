package com.example.csipro.aigiswar;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class DetalleSilver extends AppCompatActivity {
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
    Button add;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pesonaje);
        Perfil = findViewById(R.id.foto);
Favorito=findViewById(R.id.Favorito);
        inicial = findViewById(R.id.lv1);
        atkb = findViewById(R.id.atkb);
        defb = findViewById(R.id.defb);
        blockB = findViewById(R.id.block);
        range = findViewById(R.id.range);
        hpb = findViewById(R.id.hpb);
        max = findViewById(R.id.max);
        minb = findViewById(R.id.min);
        Banusmax = findViewById(R.id.banusmax);
        inicialm = findViewById(R.id.lv55);
        hpm = findViewById(R.id.hpmax);
        atkm = findViewById(R.id.actkm);
        defm = findViewById(R.id.defm);
        class1=findViewById(R.id.class1);
        add=findViewById(R.id.Add);


        Unidades obj = (Unidades) getIntent().getExtras().getSerializable("objecto");
        i = obj.getId();

        class1.setText(obj.getClas());

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute("https://inby-subordinates.000webhostapp.com/silver.js");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add.setText("Favorito");
                  
            }
        });



    }


    class ReadJSON extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            return readURL(params[0]);
        }

        @Override
        protected void onPostExecute(String content) {

            try {
                JSONObject jsonObject = new JSONObject(content);
                JSONArray jsonArray = jsonObject.getJSONArray("caracerisicas");

                JSONObject productObject = jsonArray.getJSONObject(i).getJSONArray("class1").getJSONObject(0);

                inicial.setText(productObject.getString("inicial"));
                hpb.setText(productObject.getString("Hp"));
                atkb.setText(productObject.getString("Atk"));
                defb.setText(productObject.getString("Def"));
                blockB.setText(productObject.getString("Block"));
                range.setText(productObject.getString("Range"));
                max.setText(productObject.getString("Max"));
                minb.setText(productObject.getString("Min"));
                Banusmax.setText(productObject.getString("Banus"));
                Picasso.with(null).load(productObject.getString("img")).into(Perfil);
                productObject = jsonArray.getJSONObject(i).getJSONArray("class1").getJSONObject(1);
                inicialm.setText(productObject.getString("LvMax"));
                hpm.setText(productObject.getString("Hp"));
                atkm.setText(productObject.getString("Atk"));
                defm.setText(productObject.getString("Def"));


            } catch (JSONException e) {
                e.printStackTrace();
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



