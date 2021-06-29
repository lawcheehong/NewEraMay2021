package com.example.neweramay2021.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.neweramay2021.R;

import java.util.ArrayList;

public class Contact extends AppCompatActivity {
    private ArrayList<String> arrayData = new ArrayList<>();
    private ListView contactlistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list_item);
        findViews();
        popularArraylist();
        initListview();
    }

    private void findViews(){
        contactlistView = findViewById(R.id.contactlistView);
    }

    private void popularArraylist(){
        for(int i=0; i < 50; i++){
            arrayData.add("John");
        }
    }

    private void initListview(){
        ContactAdapter adapter = new ContactAdapter(Contact.this, arrayData);
        contactlistView.setAdapter(adapter);
        contactlistView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String userClick = arrayData.get(i);
                Toast.makeText(Contact.this, "You Clicked On: " + userClick, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
