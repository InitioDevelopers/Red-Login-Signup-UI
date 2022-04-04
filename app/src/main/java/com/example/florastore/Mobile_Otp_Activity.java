package com.example.florastore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Mobile_Otp_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_otp);
        EditText editTextOtp01=findViewById(R.id.editTextOtp01);
        Button buttonOtpSubmit=findViewById(R.id.buttonOtpSubmit);
        buttonOtpSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(editTextOtp01.getText().toString())) {
                    Toast.makeText(Mobile_Otp_Activity.this, "please enter otp".toUpperCase(), Toast.LENGTH_SHORT).show();
                }else {
                    Intent i=new Intent(Mobile_Otp_Activity.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
        ImageView imageviewBackOtp=findViewById(R.id.imageviewBackOtp);
        imageviewBackOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Mobile_Otp_Activity.this,PhoneActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}