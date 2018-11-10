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
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainRareza extends AppCompatActivity {
    ArrayList<Rareza> arrayList;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        arrayList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.listView);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute("https://inby-subordinates.000webhostapp.com/Rareza.js");
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = null;
                switch(position){

                    case 0:
                        intent = new Intent(MainRareza.this,MainSilver.class);
                        break;
                    case 3:
                        intent=new Intent(MainRareza.this,MainPlatino.class);
                        break;
                    case 4:
                        intent = new Intent(MainRareza.this,MainBlack.class);
                        break;
                }

                startActivity(intent);
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
                JSONArray jsonArray =  jsonObject.getJSONArray("url");

                for(int i =0;i<jsonArray.length(); i++){
                    JSONObject productObject = jsonArray.getJSONObject(i);
                    arrayList.add(new Rareza(productObject.getString("imag")));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            AdapterRareza adapter=new AdapterRareza(getApplicationContext(),R.layout.inicio,arrayList);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = null;
        switch(position){

            case 0:
                intent = new Intent(MainRareza.this,MainSilver.class);
                break;
            case 1:
                intent = new Intent(MainRareza.this,MainGold.class);
                break;
            case 2:
                intent = new Intent(MainRareza.this,MainPlatino.class);
                break;
            case 3:
                intent = new Intent(MainRareza.this,MainBlack.class);
                break;
        }
        startActivity(intent);
    }
});


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
