package com.example.employeesystem;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.window.SplashScreen;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        Thread welcometh = new Thread() {
            @Override
            public void run() {
                try {
                    super.run();
                    sleep(5000);

                } catch (Exception e) {

                } finally {
                    Intent intent=new Intent(splashscreen.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        welcometh.start();
    }

}