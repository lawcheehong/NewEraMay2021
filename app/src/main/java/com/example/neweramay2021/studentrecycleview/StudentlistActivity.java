package com.example.neweramay2021.studentrecycleview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class StudentlistActivity extends AppCompatActivity {
    private OkHttpClient client = new OkHttpClient();
    private RecyclerView recyclerView;
    private ArrayList<Student> studentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlist);
        findViews();
        initAdapterViews();
    }

    private void findViews(){
        recyclerView = findViewById(R.id.studentrecycleview);
    }

    private void initAdapterViews(){
        Request request = new Request.Builder()
                .url("https://api.jsonbin.io/b/5f2773c81823333f8f1afec3/1")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String responseString = response.body().string();

                try{
                    JSONObject resObject = new JSONObject(responseString);
                    JSONArray resArray = resObject.getJSONArray("response");


                    for(int i=0; i < resArray.length(); i++) {
                        JSONObject singleObject = resArray.getJSONObject(i);
                        Student student = new Student();

                        student.setMatric(singleObject.getString("id"));
                        student.setName(singleObject.getString("name"));
                        student.setCourseName(singleObject.getString("course"));
                        student.setPhoto(singleObject.getString("photo"));

                        studentArrayList.add(student);
                    } runOnUiThread(() -> {
                        StudentAdapter adapter = new StudentAdapter(StudentlistActivity.this, studentArrayList);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(StudentlistActivity.this));

                        RecyclerView.ItemDecoration divider = new DividerItemDecoration(StudentlistActivity.this, DividerItemDecoration.VERTICAL);
                        recyclerView.addItemDecoration(divider);
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}