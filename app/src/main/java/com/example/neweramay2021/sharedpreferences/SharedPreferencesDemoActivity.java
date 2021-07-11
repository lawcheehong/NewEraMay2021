package com.example.neweramay2021.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.neweramay2021.R;

public class SharedPreferencesDemoActivity extends AppCompatActivity {
    public static final String MY_PREF_NAME = "MyPrefName";
    private EditText edtsharedname, edtsharedcourse, edtsharedage;
    private Button btnshowdata, btnsavedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_demo);
        findViews();
        setListeners();
    }

    private void findViews(){
        edtsharedname = findViewById(R.id.edtsharedname);
        edtsharedcourse = findViewById(R.id.edtsharedcourse);
        edtsharedage = findViewById(R.id.edtsharedage);
        btnshowdata = findViewById(R.id.btnshowdata);
        btnsavedata = findViewById(R.id.btnsavedata);
    }

    private void setListeners(){
        btnsavedata.setOnClickListener(view->{
            String name = edtsharedname.getText().toString();
            String course = edtsharedcourse.getText().toString();
            String age = edtsharedage.getText().toString();

            SharedPreferences pref = SharedPreferencesDemoActivity.this.getSharedPreferences(MY_PREF_NAME, Context.MODE_PRIVATE);
            pref.edit()
                    .putString("name",name)
                    .putString("course",course)
                    .putInt("age",Integer.parseInt(age))
                    .apply();

            Toast.makeText(this,"Data saved into Shared Preference",Toast.LENGTH_SHORT).show();
        });

        btnshowdata.setOnClickListener(view->{
            Intent i = new Intent(this,SharedPreferencesDisplayActivity.class);
            startActivity(i);
        });
    }
}