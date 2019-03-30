package com.example.csipro.aigiswar;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MenuBlack extends AppCompatActivity {
    ListView lv;
    ArrayList<CaracteristicaDeUnidades> arrayList;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menublack);
        lv = (ListView) findViewById(R.id.clases);
        arrayList = new ArrayList<>();

        Unidades unidades=(Unidades) getIntent().getSerializableExtra("objecto");

        id=unidades.getId();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute("https://inby-subordinates.000webhostapp.com/black.js");
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
                JSONObject jsonArray = jsonObject.getJSONArray("caracerisicas").getJSONObject(id);

                for (int i = 1; i < 6; i++) {

                    arrayList.add(new CaracteristicaDeUnidades(jsonArray.getJSONArray("class" + i).getJSONObject(0).getString("inicial"),
                            jsonArray.getJSONArray("class" + i).getJSONObject(0).getString("Hp"),
                            jsonArray.getJSONArray("class" + i).getJSONObject(0).getString("Atk"),
                            jsonArray.getJSONArray("class" + i).getJSONObject(0).getString("Def"),
                            jsonArray.getJSONArray("class" + i).getJSONObject(0).getString("MR"),
                            jsonArray.getJSONArray("class" + i).getJSONObject(0).getString("Block"),
                            jsonArray.getJSONArray("class" + i).getJSONObject(0).getString("Max"),
                            jsonArray.getJSONArray("class" + i).getJSONObject(0).getString("Min"),
                            jsonArray.getJSONArray("class" + i).getJSONObject(0).getString("Banus"),
                            jsonArray.getJSONArray("class" + i).getJSONObject(0).getString("BanusEx"),
                            jsonArray.getJSONArray("class" + i).getJSONObject(1).getString("LvMax"),
                            jsonArray.getJSONArray("class" + i).getJSONObject(1).getString("Hp"),
                            jsonArray.getJSONArray("class" + i).getJSONObject(1).getString("Atk"),
                            jsonArray.getJSONArray("class" + i).getJSONObject(1).getString("Def"),
                            jsonArray.getJSONArray("class" + i).getJSONObject(1).getString("Range")
                            ));

                }
            } catch (JSONException e) {
                e.printStackTrace();

            }
            AdaptadorPersonajes adaptadorPersonajes=new AdaptadorPersonajes(getApplicationContext(),R.layout.class1,arrayList);
            lv.setAdapter(adaptadorPersonajes);
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
