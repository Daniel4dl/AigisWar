package com.example.csipro.aigiswar;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainPlatino extends AppCompatActivity {
    ArrayList<Unidades> arrayList;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.listView);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute("https://inby-subordinates.000webhostapp.com/platino.js");
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Unidades obj = (Unidades) parent.getItemAtPosition(position);

                Intent paso = new Intent(getApplicationContext(), MenuPlatino.class);
                paso.putExtra("objecto", (Serializable) obj);
                startActivity(paso);

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

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject productObject = jsonArray.getJSONObject(i);
                    arrayList.add(new Unidades(
                            productObject.getString("foto"),
                            productObject.getString("nombre"),
                            productObject.getString("clase"),
                            productObject.getString("id"),
                            productObject.getString("rareza"),
                            productObject.getJSONArray("class2").getJSONObject(0).getString("clase"),
                            productObject.getJSONArray("class3").getJSONObject(0).getString("clase"),
                            productObject.getJSONArray("class4").getJSONObject(0).getString("clase")));


                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
            AdapterCaracter adapter = new AdapterCaracter(
                    getApplicationContext(), R.layout.item_caracteristica, arrayList
            );
            lv.setAdapter(adapter);
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
