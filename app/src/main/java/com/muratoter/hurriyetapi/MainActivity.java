package com.muratoter.hurriyetapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Article> arrayList = new ArrayList<Article>();
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        loadArticle();
    }

    public class BackGroundTask extends AsyncTask<Void, Article, Void> {

        Context ctx;

        public BackGroundTask(Context ctx) {
            this.ctx = ctx;
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected Void doInBackground(Void... voids) {

            String json_string = Config.BaseUrl + "articles?apikey=" + Config.ApiKey + "&$top=10";//ilk 10 makale

            try {
                URL url = new URL(json_string);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream ınputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ınputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }

                httpURLConnection.disconnect();

                String json_str = stringBuilder.toString().trim();
                JSONArray jsonArray = new JSONArray(json_str);
                if (jsonArray != null) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jo = jsonArray.getJSONObject(i);
                        if (jo != null) {
                            JSONArray files = jo.getJSONArray("Files");
                            for (int j = 0; j < files.length(); j++) {
                                JSONObject joFiles = files.getJSONObject(j);
                                if (joFiles != null) {
                                    //Resimler network image view da gösterildiği için Files Array inde FileUrl si boş olmayanları çekmek gerekmektedir.
                                    Article article = new Article(jo.getString("Title"), jo.getString("Description"), jo.getString("Url"), joFiles.getString("FileUrl"));
                                    publishProgress(article);

                                }
                            }
                        }
                    }
                }
                Log.d("json", json_string);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onProgressUpdate(Article... values) {
            arrayList.add(values[0]);
            adapter.notifyDataSetChanged();
        }

        @Override
        protected void onPostExecute(Void aVoid) {

        }
    }

    public void loadArticle() {

        BackGroundTask backGroundTask = new BackGroundTask(getApplicationContext());
        backGroundTask.execute();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        adapter = new Adapter(this, arrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
