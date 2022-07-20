package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.et1);
        e2 = findViewById(R.id.et2);
        tv1 = findViewById(R.id.textView);
    }
    public void add(View v){
        int a1= Integer.parseInt(e1.getText().toString());
        int a2= Integer.parseInt(e2.getText().toString());
        int result = a1+a2;
        tv1.setText(""+result);
    }
    public void sub(View v){
        int a1= Integer.parseInt(e1.getText().toString());
        int a2= Integer.parseInt(e2.getText().toString());
        int result = a1-a2;
        tv1.setText(""+result);
    }
    public void mul(View v){
        int a1= Integer.parseInt(e1.getText().toString());
        int a2= Integer.parseInt(e2.getText().toString());
        int result = a1*a2;
        tv1.setText(""+result);
    }
    public void div(View v){
        float a1= Integer.parseInt(e1.getText().toString());
        float a2= Integer.parseInt(e2.getText().toString());
        float result = a1/a2;
        tv1.setText(""+result);
    }
}