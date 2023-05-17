package com.example.employeesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class view extends AppCompatActivity {
    ListView listView;
    List<jamualem> jamualemList;
    ArrayList<String> arrayList;
    mydatabasehelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        listView = findViewById(R.id.listview1);
        Button viewButton = findViewById(R.id.viewbutton);
        databaseHelper = new mydatabasehelper(this);


        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jamualemList = databaseHelper.view();
                arrayList = new ArrayList<String>();
                Iterator<jamualem> it = jamualemList.iterator();
                while (it.hasNext()) {
                    jamualem jam = it.next();
                    arrayList.add("id: " + jam.getId() + " ,firstname: " + jam.getFirstname() + " ,middlename: " + jam.getMiddlename() +
                         ",gender:" +jam.getGender() +  " ,salary: " + jam.getSalary() + ",department: " + jam.getDepartment());
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                        getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        arrayList);
                listView.setAdapter(arrayAdapter);
            }
        });
    }
}
