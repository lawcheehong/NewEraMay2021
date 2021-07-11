package com.example.neweramay2021.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.neweramay2021.R;

public class SharedPreferencesDisplayActivity extends AppCompatActivity {
    private TextView displayname, displaycourse, displayage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_display);
        findViews();
        initData();
    }

    private void findViews(){
        displayname = findViewById(R.id.displayname);
        displaycourse = findViewById(R.id.displaycourse);
        displayage = findViewById(R.id.displayage);
    }

    private void initData(){
        SharedPreferences pref = getSharedPreferences(SharedPreferencesDemoActivity.MY_PREF_NAME, Context.MODE_PRIVATE);
        String name = pref.getString("name","");
        String course = pref.getString("course", "");
        int age = pref.getInt("age",0);

        displayname.setText(name);
        displaycourse.setText(course);
        displayage.setText(Integer.toString(age));
    }
}