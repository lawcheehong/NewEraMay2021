package com.example.neweramay2021.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.neweramay2021.R;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SimpleListviewActivity extends AppCompatActivity {
    private OkHttpClient client = new OkHttpClient();
    private ArrayList<String> arrayData = new ArrayList<>();
    private ListView listView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_listview);
        findViews();
        popularArraylist();
        initListview();
    }

    private void findViews(){
        listView = findViewById(R.id.listView);
        progressBar = findViewById(R.id.progressbar);
    }

    private void popularArraylist(){
        progressBar.setVisibility(View.VISIBLE);
        Request request = new Request.Builder()
                .url("https://api.jsonbin.io/v3/b/60d14dca8ea8ec25bd12b9b4")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                runOnUiThread( ()->{
                    progressBar.setVisibility(View.GONE);
                    e.printStackTrace();
                });
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.body() !=null){
                    try {
                        JSONObject resObject = new JSONObject(response.body().string());
                        JSONArray userArray = resObject.getJSONObject("record").getJSONArray("users");

                        for (int i=0; i<userArray.length(); i++){
                            arrayData.add(userArray.getString(i));
                        }
                        runOnUiThread( () -> {
                            initListview();
                            progressBar.setVisibility(View.GONE);
                        });
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void initListview(){
        SimpleAdapter adapter = new SimpleAdapter(SimpleListviewActivity.this, arrayData);
        listView.setAdapter(adapter);
    }
}
