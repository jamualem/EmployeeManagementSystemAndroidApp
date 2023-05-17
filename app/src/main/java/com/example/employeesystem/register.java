package com.example.employeesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class register extends AppCompatActivity {
    mydatabasehelper ds;
    EditText editing1, editing2, editing3, editing4;
    String gender = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

      ds=new mydatabasehelper(this);
       editing1=findViewById(R.id.edit1);
        editing2=findViewById(R.id.edit2);
       editing3=findViewById(R.id.edit3);
       editing4=findViewById(R.id.edit4);

        RadioGroup rbt=findViewById(R.id.radiog);
        RadioButton rgk=findViewById(R.id.radio_female);
        RadioButton rgl=findViewById(R.id.radio_male);

      rbt.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(RadioGroup group, int checkedId) {

              // Check which RadioButton was clicked
              if (checkedId == R.id.radio_male) {
                  gender = "male";
                  rgl.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_baseline_radio_button_checked_24, 0, 0);
                  rgk.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_baseline_radio_button_unchecked_24, 0, 0);
              } else if (checkedId == R.id.radio_female) {
                  gender = "female";
                  rgk.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_baseline_radio_button_checked_24, 0, 0);
                  rgl.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_baseline_radio_button_unchecked_24, 0, 0);
              }
          }
      });




        Button button=findViewById(R.id.addvalue);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addindata();
            }
        });


    }
    public void addindata() {
        boolean add = ds.adddata(new jamualem(editing1.getText().toString(), editing2.getText().toString(),gender,
                editing3.getText().toString(), editing4.getText().toString()));
        if (add == true) {
            Toast.makeText(getApplicationContext(), "Insert successful", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Please fill all fields correctly!", Toast.LENGTH_LONG).show();
        }
    }



}