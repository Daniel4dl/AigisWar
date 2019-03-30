package com.example.csipro.aigiswar;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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


public class StoryMission extends AppCompatActivity {
    TextView title1;
    TextView parrafo1;
    TextView title2;
    TextView parrafo2;
    TextView title3;
    TextView parrafo3;
    ImageView img;

    ImageView img1;
    TextView arco1;
    ImageView img2;
    TextView arco2;
    ImageView img3;
    TextView arco3;
    ImageView img4;
    TextView arco4;
    ImageView img5;
    TextView arco5;
    ImageView img6;
    TextView arco6;
    ImageView img7;
    TextView arco7;
    ImageView img8;
    TextView arco8;
    ImageView img9;
    TextView arco9;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mission);
        title1 = findViewById(R.id.title1);
        parrafo1 = findViewById(R.id.parrafo1);
        title2 = findViewById(R.id.title2);
        parrafo2 = findViewById(R.id.parrafo2);
        img = findViewById(R.id.img);
        title3 = findViewById(R.id.title3);
        parrafo3 = findViewById(R.id.parrafo3);
        arco1 = findViewById(R.id.arco1);
        img1 = findViewById(R.id.img1);
        arco2 = findViewById(R.id.arco2);
        img2 = findViewById(R.id.img2);
        arco3 = findViewById(R.id.arco3);
        img3 = findViewById(R.id.img3);
        arco4 = findViewById(R.id.arco4);
        img4 = findViewById(R.id.img4);
        arco5 = findViewById(R.id.arco5);
        img5 = findViewById(R.id.img5);
        arco6 = findViewById(R.id.arco6);
        img6 = findViewById(R.id.img6);
        arco7 = findViewById(R.id.arco7);
        img7 = findViewById(R.id.img7);
        arco8 = findViewById(R.id.arco8);
        img8 = findViewById(R.id.img8);
        arco9 = findViewById(R.id.arco9);
        img9 = findViewById(R.id.img9);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute("https://inby-subordinates.000webhostapp.com/misiones.js");
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
                JSONArray jsonArray = jsonObject.getJSONArray("misiones").getJSONObject(0).getJSONArray("Story Missions");
                title1.setText(jsonArray.getJSONObject(0).getString("title"));
                parrafo1.setText(jsonArray.getJSONObject(0).getString("parrafo"));
                title2.setText(jsonArray.getJSONObject(1).getString("title"));
                parrafo2.setText(jsonArray.getJSONObject(1).getString("parrafo"));
                Picasso.with(null).load(jsonArray.getJSONObject(1).getString("img")).into(img);
                title3.setText(jsonArray.getJSONObject(2).getString("tile"));
                parrafo3.setText(jsonArray.getJSONObject(2).getString("parrafo"));
                arco1.setText(jsonArray.getJSONObject(2).getJSONArray("Arcos").getJSONObject(0).getString("nombre de arco"));
                Picasso.with(null).load(jsonArray.getJSONObject(2).getJSONArray("Arcos").getJSONObject(0).getString("img")).into(img1);
                arco2.setText(jsonArray.getJSONObject(2).getJSONArray("Arcos").getJSONObject(1).getString("nombre de arco"));
                Picasso.with(null).load(jsonArray.getJSONObject(2).getJSONArray("Arcos").getJSONObject(1).getString("img")).into(img2);
                arco3.setText(jsonArray.getJSONObject(2).getJSONArray("Arcos").getJSONObject(2).getString("nombre de arco"));
                Picasso.with(null).load(jsonArray.getJSONObject(2).getJSONArray("Arcos").getJSONObject(2).getString("img")).into(img3);
                arco4.setText(jsonArray.getJSONObject(2).getJSONArray("Arcos").getJSONObject(3).getString("nombre de arco"));
                Picasso.with(null).load(jsonArray.getJSONObject(2).getJSONArray("Arcos").getJSONObject(3).getString("img")).into(img4);
                arco5.setText(jsonArray.getJSONObject(2).getJSONArray("Arcos").getJSONObject(4).getString("nombre de arco"));
                Picasso.with(null).load(jsonArray.getJSONObject(2).getJSONArray("Arcos").getJSONObject(4).getString("img")).into(img5);
                arco6.setText(jsonArray.getJSONObject(2).getJSONArray("Arcos").getJSONObject(5).getString("nombre de arco"));
                Picasso.with(null).load(jsonArray.getJSONObject(2).getJSONArray("Arcos").getJSONObject(5).getString("img")).into(img6);
                arco7.setText(jsonArray.getJSONObject(2).getJSONArray("Arcos").getJSONObject(6).getString("nombre de arco"));
                Picasso.with(null).load(jsonArray.getJSONObject(2).getJSONArray("Arcos").getJSONObject(6).getString("img")).into(img7);
                arco8.setText(jsonArray.getJSONObject(2).getJSONArray("Arcos").getJSONObject(7).getString("nombre de arco"));
                Picasso.with(null).load(jsonArray.getJSONObject(2).getJSONArray("Arcos").getJSONObject(7).getString("img")).into(img8);
                arco9.setText(jsonArray.getJSONObject(2).getJSONArray("Arcos").getJSONObject(8).getString("nombre de arco"));
                Picasso.with(null).load(jsonArray.getJSONObject(2).getJSONArray("Arcos").getJSONObject(8).getString("img")).into(img9);

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
