package com.example.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText email1,password1;
    Button signupbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email1 = findViewById(R.id.email1);
        password1 = findViewById(R.id.pass1);
        signupbtn = findViewById(R.id.signup);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email1.getText().toString();
                String password = password1.getText().toString();
                if(!isValidPassword(password)){
                    Toast.makeText(MainActivity.this, "Password Does not match the requirements", Toast.LENGTH_LONG).show();
                    return;
                }
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    intent.putExtra("email", email);
                    intent.putExtra("password", password);
                    startActivity(intent);
            }
        });
    }
    Pattern uppercase = Pattern.compile("^.*[A-Z].*$");
    Pattern lowercase = Pattern.compile("^.*[a-z].*$");
    Pattern number = Pattern.compile("^.*[0-9].*$");
    Pattern specialCharacter = Pattern.compile("^.*[^a-zA-Z0-9].*$");
    private Boolean isValidPassword(String password){
        if(password.length()<8){
            return false;
        }
        if(!uppercase.matcher(password).matches()){
            return false;
        }
        if(!lowercase.matcher(password).matches()){
            return false;
        }
        if(!number.matcher(password).matches()){
            return false;
        }
        if(!specialCharacter.matcher(password).matches()){
            return false;
        }
        return true;
    }
}