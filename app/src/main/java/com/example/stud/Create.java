package com.example.stud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stud.Model.SubjectModel;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Create extends AppCompatActivity {


    String [] type = {"Online","Face to Face"};
    String [] day = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    String [] time = {"00:00","01:00","02:00","03:00","04:00","05:00","06:00","07:00","08:00","09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00"};
    TextView add;
    EditText subjectEditText , codeEditText, teacherEditText;

    AutoCompleteTextView autoCompleteText,autoCompleteText1,autoCompleteText2;
    ArrayAdapter<String> scheduleAdapter,dayAdapter,timeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        subjectEditText = findViewById(R.id.subject);
        codeEditText = findViewById(R.id.code);
        teacherEditText = findViewById(R.id.teacher);

        autoCompleteText = findViewById(R.id.auto_complete_txt);
        autoCompleteText1 = findViewById(R.id.auto_complete_txt1);
        autoCompleteText2 = findViewById(R.id.auto_complete_txt2);
        add = findViewById(R.id.add);




        //Schedule Dropdown
        scheduleAdapter = new ArrayAdapter<String>(this, R.layout.schedule_item, type);
        autoCompleteText.setAdapter(scheduleAdapter);
        autoCompleteText.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String type = parent.getItemAtPosition(position).toString();
//                Toast.makeText(getApplicationContext(),"Type:" + type,Toast.LENGTH_SHORT).show();
            }
        });

        //Day Dropdown
        dayAdapter = new ArrayAdapter<String>(this, R.layout.day_item, day);
        autoCompleteText1.setAdapter(dayAdapter);
        autoCompleteText1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String day = parent.getItemAtPosition(position).toString();
//                Toast.makeText(getApplicationContext(),"Day:" + day,Toast.LENGTH_SHORT).show();
            }
        });

        //time dropdown
        timeAdapter = new ArrayAdapter<String>(this, R.layout.hours_item, time);
        autoCompleteText2.setAdapter(timeAdapter);
        autoCompleteText2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String time = parent.getItemAtPosition(position).toString();
//                Toast.makeText(getApplicationContext(),"Hours:" + time,Toast.LENGTH_SHORT).show();
            }
        });

        add.setOnClickListener(view -> {
            if(subjectEditText.getText().toString().isEmpty() || codeEditText.getText().toString().isEmpty() || (teacherEditText.getText().toString().isEmpty())){
                Toast.makeText(this, "Please fillup all the data above", Toast.LENGTH_SHORT).show();

                }else {
                add.setTextColor(Color.BLUE);
                SubjectModel subjectModel;
                    try {

                        subjectModel = new SubjectModel(-1, subjectEditText.getText().toString(), codeEditText.getText().toString(), autoCompleteText1.getText().toString(), teacherEditText.getText().toString(), autoCompleteText1.getText().toString(), autoCompleteText2.getText().toString());

                        DatabaseHelper databaseHelper = new DatabaseHelper(this);
                        boolean success = databaseHelper.addSubject(subjectModel);
                        Snackbar.make(view, " Added Successfully ", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                        //                    Toast.makeText(getActivity(), productModel.toString(), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(this, "Please Insert All Data", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

    }
