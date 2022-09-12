package com.example.stud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stud.Model.SubjectModel;

public class Subject_singlepage extends AppCompatActivity {

    TextView subjectCodeName, subjectName, schedule, teacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_singlepage);

        subjectCodeName = findViewById(R.id.subjectCodeName);
        subjectName = findViewById(R.id.subjectName);
        schedule = findViewById(R.id.schedule);
        teacher = findViewById(R.id.teacher);

        String subjectid = getIntent().getStringExtra("subjectId");


        DatabaseHelper myDB = new DatabaseHelper(this);

        Cursor data = myDB.getSubjectsList();

        if(data.getCount() == 0 ){

            Toast.makeText(this,"The database was empty", Toast.LENGTH_LONG).show();
        }else {
            while (data.moveToNext()) {
                subjectCodeName.setText(data.getString(2));
                subjectName.setText(data.getString(1));
                schedule.setText(data.getString(5) + " " + data.getString(6));
                teacher.setText(data.getString(3));
            }
        }





    }
}