package com.example.employeesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button reg=findViewById(R.id.registor);
        Button update=findViewById(R.id.update);
        Button view=findViewById(R.id.view);
        Button del=findViewById(R.id.delete);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                act1();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                act2();
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                act4();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                act3();
            }
        });





    }
    public void act1(){
        Intent intent=new Intent(this,register.class);
        startActivity(intent);
    }
    public void act2(){
        Intent intent1=new Intent(this,updating.class);
        startActivity(intent1);
    }
    public void act3(){
        Intent intent2=new Intent(this,view.class);
        startActivity(intent2);
    }
    public void act4(){
        Intent intent3=new Intent(this,delete.class);
        startActivity(intent3);
    }



}