package com.example.neweramay2021.recycleview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neweramay2021.R;

import java.util.ArrayList;

public class RecycleViewActivity extends AppCompatActivity {
    private RecyclerView recycleView;
    private ArrayList<Contactrv> contactrvArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        findViews();
        setListeners();
        initRecycleView();
    }

    private void findViews(){
        recycleView = findViewById(R.id.recycleview);
    }

    private void setListeners(){

    }

    private void initRecycleView(){
        contactrvArrayList.add(new Contactrv("AH", "012-2334451"));
        contactrvArrayList.add(new Contactrv("BH", "012-2334452"));
        contactrvArrayList.add(new Contactrv("CH", "012-2334453"));
        contactrvArrayList.add(new Contactrv("DH", "012-2334454"));
        contactrvArrayList.add(new Contactrv("EH", "012-2334455"));

        ContactrvAdapter adapter = new ContactrvAdapter(RecycleViewActivity.this, contactrvArrayList);
        recycleView.setAdapter(adapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
    }
}