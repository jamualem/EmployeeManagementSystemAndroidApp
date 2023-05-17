package com.example.employeesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class delete extends AppCompatActivity{

    EditText edt;
    mydatabasehelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        db=new mydatabasehelper(this);
        edt=findViewById(R.id.edit1);
        Button btn=findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if(edt.getText().toString().trim().length() > 0)
                    {
                        db.deleteing(new jamualem(Integer.parseInt(edt.getText().toString())));
                        Toast.makeText(getApplicationContext(),"Delete successful",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Please fill ID field!",Toast.LENGTH_LONG).show();
                    }

            }
        });
    }

}