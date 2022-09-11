package com.example.stud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Homepage extends AppCompatActivity {
    Button getStarted;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        getStarted = findViewById(R.id.getStartedBtn);
    }
}