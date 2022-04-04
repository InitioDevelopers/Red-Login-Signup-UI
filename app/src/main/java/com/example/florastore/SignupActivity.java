package com.example.florastore;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class SignupActivity extends AppCompatActivity {
    private int mYear, mMonth, mDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
       TextView textviewBirthDate=findViewById(R.id.textViewBirthDate);
        textviewBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(SignupActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                textviewBirthDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        mYear,
                        mMonth,
                        mDay);
                datePickerDialog.show();
            }


        });
        Button buttonCreateAccount=findViewById(R.id.buttonCreateAccount);
        CheckBox checkboxTermCondition=findViewById(R.id.checkBoxTermCondition);
        checkboxTermCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                // Check which checkbox was clicked
                if (checked){
                    // Do your coding
                    buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent i = new Intent(SignupActivity.this, PhoneActivity.class);
                            startActivity(i);
                        }
                    });
                }
                else{
                    buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(SignupActivity.this, "PLEASE ACCEPT TERM AND CONDITION", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        ImageView imageviewBackSignup=findViewById(R.id.imageViewBackSignup);
        imageviewBackSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
        TextView textviewMamberSignin = findViewById(R.id.textviewMamberSignin);
        String str = "Alredy a member? Sign in";
        SpannableString S = new SpannableString(str);
        ForegroundColorSpan red = new ForegroundColorSpan(Color.BLACK);
        S.setSpan(red, 17, 24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textviewMamberSignin.setText(S);
        textviewMamberSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
    }