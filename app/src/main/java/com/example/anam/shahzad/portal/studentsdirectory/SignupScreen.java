package com.example.anam.shahzad.portal.studentsdirectory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anam.shahzad.portal.R;

public class SignupScreen extends AppCompatActivity {
    EditText name, email, phone, password1, password2;
    Button sign_up;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);
        name = findViewById(R.id.nameedittext);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        password1 = findViewById(R.id.password1);
        password2 = findViewById(R.id.password2);
        sign_up = findViewById(R.id.signup);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Input_Name = name.getText().toString();
                String Input_Password1 = password1.getText().toString();
                String Input_Password2 = password2.getText().toString();
                String Input_Email = email.getText().toString();
                String Input_Phone = phone.getText().toString();
                if (!Input_Name.equals("")) {
                    if (!Input_Email.equals("")) {
                        if (!Input_Phone.equals("")) {
                            if (!Input_Password1.equals("")) {
                                if (!Input_Password2.equals("")) {
                                    if (Input_Password1.equals(Input_Password2)) {
                                        Toast.makeText(SignupScreen.this, "Sign up complete", Toast.LENGTH_SHORT).show();
                                        SharedPreferences sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putString("student_name", Input_Name);
                                        editor.putString("student_email", Input_Email);
                                        editor.putString("student_password", Input_Password1);
                                        editor.putString("student_phone", Input_Phone);
                                        editor.apply();
                                        finish();

                                    } else {
                                        Toast.makeText(SignupScreen.this, "Password does not match", Toast.LENGTH_SHORT).show();
                                    }

                                } else {
                                    Toast.makeText(SignupScreen.this, "Please Re-Enter password", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(SignupScreen.this, "Please Enter password", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(SignupScreen.this, "Enter phone", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(SignupScreen.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(SignupScreen.this, "Enter Name", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

}