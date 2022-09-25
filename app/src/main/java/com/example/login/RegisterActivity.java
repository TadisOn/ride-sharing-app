package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class RegisterActivity extends AppCompatActivity {

    TextView email1,username1,password1,repeat_pass1;
    ProgressBar progressBar1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email1 = (TextView) findViewById(R.id.email);
        username1 = (TextView) findViewById(R.id.username);
        password1 = (TextView) findViewById(R.id.password);
        repeat_pass1 = (TextView) findViewById(R.id.repeat_password);
        progressBar1 = (ProgressBar) findViewById(R.id.progress);


MaterialButton registerbtn = (MaterialButton) findViewById(R.id.registerbtn1);




        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email, username, password;

                email = String.valueOf(email1.getText());
                username = String.valueOf(username1.getText());
                password = String.valueOf(password1.getText());

                if(!email.equals("") && !username.equals("") && !password.equals("")) {

                    //-------------------------------------------------------------------
                    progressBar1.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[3];
                            field[0] = "email";
                            field[1] = "username";
                            field[2] = "password";
                            //Creating array for data
                            String[] data = new String[3];
                            data[0] = email;
                            data[1] = username;
                            data[2] = password;
                            PutData putData = new PutData("http://192.168.1.219/app_database/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar1.setVisibility(View.VISIBLE);
                                    String result = putData.getResult();
                                    if (result.equals("Sign Up Success")) {

                                        Toast.makeText(getApplicationContext(),"You have successfully registered", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }else {
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();

                                }
                            }
                            }
                            //End Write and Read data with URL
                        }
                    });
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "All fields are required",Toast.LENGTH_SHORT);
                }

                //-------------------------------------------------------------------

                startActivity(new Intent(RegisterActivity.this, MainActivity.class));


            }
        });
    }
}