package com.example.anam.shahzad.portal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anam.shahzad.portal.studentsdirectory.MainActivity;
import com.example.anam.shahzad.portal.studentsdirectory.SignupScreen;
import com.example.anam.shahzad.portal.teachersdirectory.Constants;
import com.example.anam.shahzad.portal.teachersdirectory.MainActivity2;

public class LoginScreen extends AppCompatActivity {
    EditText email,password;
    Button sign_in;
    TextView sign_up;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public static String storedname,storedemail,storedpassword,storedphone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        sign_in=findViewById(R.id.buttonsignin);
        sign_up=findViewById(R.id.signup);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginScreen.this, SignupScreen.class);
                startActivity(intent);
            }
        });


        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String InputEmail=email.getText().toString();
                String InputPassword = password.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String getName = sharedPreferences.getString("student_name", "");
                String getPassword = sharedPreferences.getString("student_password", "");
                String getEmail = sharedPreferences.getString("student_email", "");
                String getPhone = sharedPreferences.getString("student_phone", "");
                storedemail=getEmail;
                storedpassword=getPassword;
                storedname=getName;
                storedphone=getPhone;


                if (!InputEmail.equals("")) {
                    if (!InputPassword.equals("")) {
                        if (InputEmail.equals(Constants.firstTeacheremail)) {
                            if (InputPassword.equals(Constants.firstTeacherpassword)) {
                                Intent intent=new Intent(LoginScreen.this, MainActivity2.class);
                                startActivity(intent);


                            } else {
                                Toast.makeText(LoginScreen.this, "Please enter correct Password", Toast.LENGTH_SHORT).show();
                            }


                        } else if (InputEmail.equals(Constants.secondTeacheremail)) {
                            if (InputPassword.equals(Constants.secondTeacherpassword)) {
                                Intent intent=new Intent(LoginScreen.this, MainActivity2.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(LoginScreen.this, "Enter correct password", Toast.LENGTH_SHORT).show();
                            }
                        } else if (InputEmail.equals(storedemail)) {
                                if (InputPassword.equals(storedpassword)) {
                                    Intent intent = new Intent(LoginScreen.this, MainActivity.class);
                                    startActivity(intent);

                                } else {
                                    Toast.makeText(LoginScreen.this, "Enter correct password", Toast.LENGTH_SHORT).show();
                                }
                        } else {
                            Toast.makeText(LoginScreen.this, "Please sign up ", Toast.LENGTH_SHORT).show();

                        }


                    } else {
                        Toast.makeText(LoginScreen.this, "Please enter Password", Toast.LENGTH_SHORT).show();}

                } else {
                    Toast.makeText(LoginScreen.this, "Please enter email", Toast.LENGTH_SHORT).show();
            }

            }
        });



    }







}