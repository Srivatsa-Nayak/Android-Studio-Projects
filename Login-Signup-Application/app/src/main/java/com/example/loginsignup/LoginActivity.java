package com.example.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText email1,password1;
    Button loginbtn;
    int counter=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email1 = findViewById(R.id.email);
        password1 = findViewById(R.id.password);
        loginbtn = findViewById(R.id.loginbtn);
        String registeredEmail = getIntent().getStringExtra("email");
        String registeredPassword = getIntent().getStringExtra("password");
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email1.getText().toString();
                String password = password1.getText().toString();
                if(registeredEmail.equals(email)&& registeredPassword.equals(password)){
                    Intent intent = new Intent(LoginActivity.this, LoginSuccess.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Invalid Email or Password", Toast.LENGTH_LONG).show();
                }
                counter--;
                if(counter==0){
                    Toast.makeText(getBaseContext(), "Login Failed", Toast.LENGTH_LONG).show();
                    loginbtn.setEnabled(true);
                }
            }
        });
    }
}