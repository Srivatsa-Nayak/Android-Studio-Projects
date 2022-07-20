package com.example.phonenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText phone;
    Button Clearbtn,Savebtn,Callbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone = findViewById(R.id.e1);
        Clearbtn = findViewById(R.id.btn4);
        Savebtn = findViewById(R.id.btn2);
        Callbtn = findViewById(R.id.btn3);
        Clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone.setText("");
            }
        });
        Callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phonenumber = phone.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phonenumber));
                startActivity(intent);
            }
        });
        Savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phonenumber = phone.getText().toString();
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                intent.putExtra(ContactsContract.Intents.Insert.PHONE, phonenumber);
                startActivity(intent);
            }
        });
    }
    public void inputnumber(View v){
        Button btn = (Button)v;
        String digit = btn.getText().toString();
        String phonenumber = phone.getText().toString();
        phone.setText(phonenumber +digit);
    }
}