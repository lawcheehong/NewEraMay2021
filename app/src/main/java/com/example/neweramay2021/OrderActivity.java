package com.example.neweramay2021;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {
    private Button btnminus, btnadd, btnmakeorder;
    private CheckBox cbcream, cbcookieflakes, cbchotolatechip;
    private TextView numberofcoffee, totalprice;

    private int amount = 1;
    private int BasePrice = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        findViews();
        setListeners();
    }

    private void findViews(){
        btnminus = findViewById(R.id.btnminus);
        btnadd = findViewById(R.id.btnadd);
        btnmakeorder = findViewById(R.id.btnmakeorder);
        cbcream = findViewById(R.id.cbcream);
        cbcookieflakes = findViewById(R.id.cbcookieflakes);
        cbchotolatechip = findViewById(R.id.cbchocolatechip);
        numberofcoffee = findViewById(R.id.numberofcoffee);
        totalprice = findViewById(R.id.totalprice);
    }

    private void setListeners(){
        btnadd.setOnClickListener(view ->{
            amount++;
            numberofcoffee.setText(Integer.toString(amount));
        });

        btnminus.setOnClickListener(view ->{
            if(amount!=1){
                amount--;
                numberofcoffee.setText(Integer.toString(amount));
            }
        });

        btnmakeorder.setOnClickListener(view ->{
            int price = BasePrice;
            if(cbcream.isChecked()){
                price +=1;
            }
            if(cbcookieflakes.isChecked()){
                price +=2;
            }
            if(cbchotolatechip.isChecked()){
                price +=3;
            }
            price = price * amount;
            totalprice.setText("The total price is: " + Integer.toString(price));
        });
    }
}

