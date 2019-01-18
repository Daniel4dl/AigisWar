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
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mission);
     title1=findViewById(R.id.title1);
     parrafo1=findViewById(R.id.parrafo1);
        title2=findViewById(R.id.title2);
        parrafo2=findViewById(R.id.parrafo2);
        img=findViewById(R.id.img);
        title3=findViewById(R.id.title3);
        parrafo3=findViewById(R.id.parrafo3);
        arco1=findViewById(R.id.arco1);
        img1=findViewById(R.id.img1);
        arco2=findViewById(R.id.arco2);
        img2=findViewById(R.id.img2);
        arco3=findViewById(R.id.arco3);
        img3=findViewById(R.id.img3);


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
