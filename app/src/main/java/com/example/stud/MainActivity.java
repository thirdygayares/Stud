package com.example.stud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.stud.Adapter.SubjectAdapter;
import com.example.stud.Adapter.SubjectInete;
import com.example.stud.Model.SubjectModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SubjectInete {

    ArrayList<SubjectModel> subjectModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subjectDetails();
        setupsubjects();
        RecyclerView recyclerView = findViewById(R.id.SubjectRecylerView);
        SubjectAdapter adapter = new SubjectAdapter(this, subjectModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setupsubjects() {




        //from database data
        ArrayList<String> SubjectCode = new ArrayList<>();
        ArrayList<String> CountTask = new ArrayList<>();
        ArrayList<String> Schedule = new ArrayList<>();


        DatabaseHelper myDB = new DatabaseHelper(this);
        Cursor data = myDB.getSubjectsList();

        if(data.getCount() == 0 ){

         Toast.makeText(this,"The database was empty", Toast.LENGTH_LONG).show();
        }else {
            while (data.moveToNext()) {
                SubjectCode.add(data.getString(2));
                CountTask.add(data.getString(3));
                Schedule.add(data.getString(5) + " " + data.getString(6));
            }
        }

        for(int i=0; i<SubjectCode.size(); i++){
            subjectModels.add(new SubjectModel(SubjectCode.get(i),CountTask.get(i),
                    Schedule.get(i)
            ));
        }
    }

    private void subjectDetails() {
        ArrayList<String> qty = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> singleprice = new ArrayList<>();
        ArrayList<String> price = new ArrayList<>();
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, Subject_singlepage.class);
        intent.putExtra("subjectId", subjectModels.get(position).getId());
        startActivity(intent);
    }
}