package com.example.adminformhandson;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView fname,lname,city,pincode,date;
    String strfname,strlname,strcity,strpincode,strdate;
    Button btnBack;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        initViews();
        getDetails();
        initListeners();

    }
    public void initViews()
    {
        fname=findViewById(R.id.fname);
        lname=findViewById(R.id.lname);
        city=findViewById(R.id.city);
        pincode=findViewById(R.id.pincode);
        date=findViewById(R.id.date);
        btnBack=findViewById(R.id.btnBack);
    }
    public void getDetails()
    {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        strfname = bundle.getString("firstname");
        fname.setText(strfname);

        strlname = bundle.getString("lastname");
        lname.setText(strlname);

        strcity = bundle.getString("city");
        city.setText(strcity);

        strpincode = bundle.getString("pincode");
        pincode.setText(strpincode);

        strdate = bundle.getString("date");
        date.setText(strdate);
    }

    public void initListeners()
    {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}

