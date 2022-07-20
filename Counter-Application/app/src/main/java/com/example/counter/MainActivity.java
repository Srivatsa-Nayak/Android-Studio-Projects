package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnstart,btnstop;
    TextView tv1;
    int i=0;
    Handler customhandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnstart = findViewById(R.id.start);
        btnstop = findViewById(R.id.stop);
        tv1 = findViewById(R.id.textView);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customhandler.postDelayed(updateTimerThread,0);
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customhandler.removeCallbacks(updateTimerThread);
            }
        });
    }
    private final Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            customhandler.postDelayed(this,1000);
            tv1.setText(""+i);
            i++;
        }
    };
}