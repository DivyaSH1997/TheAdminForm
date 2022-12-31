package com.example.adminformhandson;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    TextView txtTitle,txtDate;
    ImageView image;
    EditText txtFirstName,txtLastName,txtCity,txtPincode;
    Button btnDatePicker,btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        intiListeners();
    }
    public void initViews()
    {
        txtTitle=findViewById(R.id.txtTitle);
        txtDate=findViewById(R.id.txtDate);
        image=findViewById(R.id.image);
        txtFirstName=findViewById(R.id.txtFirstName);
        txtLastName=findViewById(R.id.txtLastName);
        txtCity=findViewById(R.id.txtCity);
        txtPincode=findViewById(R.id.txtPincode);
        btnDatePicker=findViewById(R.id.btnDatePicker);
        btnSubmit=findViewById(R.id.btnSubmit);
    }
    public void intiListeners()
    {
        btnDatePicker.setOnClickListener(new BtnDatePickerDialogClass());
        btnSubmit.setOnClickListener(new BtnSubmitClass());
    }
    class BtnSubmitClass implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String fname=txtFirstName.getText().toString();
            String lname=txtLastName.getText().toString();
            String city=txtCity.getText().toString();
            String pincode=txtPincode.getText().toString();
            String date=txtDate.getText().toString();
            if(TextUtils.isEmpty(fname)) {
                txtFirstName.setError("First Name");
            }
            if(TextUtils.isEmpty(lname)) {
                txtLastName.setError("Last Name");
            }
            if(TextUtils.isEmpty(city)) {
                txtCity.setError("City");
            }
            if(TextUtils.isEmpty(pincode)) {
                txtPincode.setError("Pincode");
            }
            if(TextUtils.isEmpty(date))
            {
               txtDate.setError("Date");
            }

            else
            {
                makeToast("Form Completed");
                SubmitDialog submitDialog = new SubmitDialog(MainActivity.this);
                submitDialog.setOnLogoutListener(new MyOnLogoutListener());
                submitDialog.show();
            }
        }
    }

    class BtnDatePickerDialogClass implements View.OnClickListener{


        @Override
        public void onClick(View view) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    MainActivity.this,
                    new MyOnDateSetListener(),
                    2022,
                    12,
                    31
            );
            datePickerDialog.show();

        }
    }

    class MyOnLogoutListener implements SubmitDialog.OnLogoutListener{

        @Override
        public void onOkay() {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("firstname", txtFirstName.getText().toString());
            intent.putExtra("lastname", txtLastName.getText().toString());
            intent.putExtra("city", txtCity.getText().toString());
            intent.putExtra("pincode", txtPincode.getText().toString());
            intent.putExtra("date", txtDate.getText().toString());

            startActivity(intent);
        }
        @Override
        public void onCancel()
        {
            finish();
        }
    }
    class MyOnDateSetListener implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePicker datePicker, int year, int m, int dayOfMonth) {
            int month=m+1;
            txtDate.setText(dayOfMonth + " / " + month+ " / " + year);

        }
    }
    private void makeToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
