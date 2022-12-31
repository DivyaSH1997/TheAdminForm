package com.example.adminformhandson;


import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class SubmitDialog extends Dialog {

    Button btnOkay,btnCancel;
    TextView txtMessage;

    public interface OnLogoutListener{
        void onOkay();
        void onCancel();
    }
    private OnLogoutListener onLogoutListener;

    public void setOnLogoutListener(OnLogoutListener onLogoutListener){
        this.onLogoutListener = onLogoutListener;
    }

    public SubmitDialog(@NonNull Context context) {

        super(context);
        setContentView(R.layout.submit_dialog);

        initViews();
        initListeners();
    }
    public void initViews()
    {
        txtMessage=findViewById(R.id.txtMessage);
        btnOkay=findViewById(R.id.btnOkay);
        btnCancel=findViewById(R.id.btnCancel);
    }
    public void initListeners()
    {
        btnOkay.setOnClickListener(new BtnOkayClass());
        btnCancel.setOnClickListener(new BtnCancelClass());
    }

    class BtnOkayClass implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            onLogoutListener.onOkay();
        }
    }
    class BtnCancelClass implements View.OnClickListener
    {
        @Override
        public void onClick(View view) {
          onLogoutListener.onCancel();

        }
    }

}
