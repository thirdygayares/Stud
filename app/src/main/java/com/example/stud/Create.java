package com.example.stud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class Create extends AppCompatActivity {
    String [] type = {"Online","Face to Face"};
    String [] day = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    String [] time = {"12:00","01:00","02:00","03:00","04:00","05:00","06:00","07:00","08:00","09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00","24:00"};


    AutoCompleteTextView autoCompleteText,autoCompleteText1,autoCompleteText2;
    ArrayAdapter<String> scheduleAdapter,dayAdapter,timeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        autoCompleteText = findViewById(R.id.auto_complete_txt);
        autoCompleteText1 = findViewById(R.id.auto_complete_txt1);
        autoCompleteText2 = findViewById(R.id.auto_complete_txt2);

        //Schedule Dropdown
        scheduleAdapter = new ArrayAdapter<String>(this,R.layout.schedule_item,type);
        autoCompleteText.setAdapter(scheduleAdapter);
        autoCompleteText.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String type = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Type:" + type,Toast.LENGTH_SHORT).show();
            }
        });

        //Day Dropdown
        dayAdapter = new ArrayAdapter<String>(this,R.layout.day_item,day);
        autoCompleteText1.setAdapter(dayAdapter);
        autoCompleteText1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String day = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Day:" + day,Toast.LENGTH_SHORT).show();
            }
        });

        //time dropdown
        timeAdapter = new ArrayAdapter<String>(this,R.layout.hours_item,time);
        autoCompleteText2.setAdapter(timeAdapter);
        autoCompleteText2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String time = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Hours:" + time,Toast.LENGTH_SHORT).show();
            }
        });
    }
}