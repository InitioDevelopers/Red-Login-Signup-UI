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

public class PhoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        ImageView imageviewBackPhone=findViewById(R.id.imageViewBackPhone);
        imageviewBackPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(PhoneActivity.this,SignupActivity.class);
                startActivity(i);
                finish();
            }
        });
        Button submitButton=findViewById(R.id.submitButton);
        EditText edittextMobileNum=findViewById(R.id.editTextMobileNum);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(edittextMobileNum.getText().toString())){
                    Toast.makeText(PhoneActivity.this, "PLEASE FILL NUMBER", Toast.LENGTH_SHORT).show();
                }else{
                    Intent i=new Intent(PhoneActivity.this,Mobile_Otp_Activity.class);
                    startActivity(i);
                }
            }
        });
    }
}