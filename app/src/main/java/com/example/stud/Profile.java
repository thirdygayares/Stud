package com.example.stud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    TextView editTxtView, nameTxtView, sectionTxtView,addCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        editTxtView = findViewById(R.id.editTxtView);
        nameTxtView = findViewById(R.id.nameTxtView);
        sectionTxtView = findViewById(R.id.sectionTxtView);
        addCourse = findViewById(R.id.addCourse);


        addCourse.setOnClickListener(view1 -> {
            Intent intent = new Intent(this, Create.class);
            startActivity(intent);
        });

    }
}