package com.example.stud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.stud.Model.SubjectModel;

public class DatabaseHelper extends SQLiteOpenHelper {

    //product table
    public static final String SUBJECTS_TABLE = "SUBJECTS_TABLE";
    public static final String ID = "ID";
    public static final String SUBJECTNAME = "SUBJECTNAME";
    public static final String SUBJECTCODE = "SUBJECTCODE";
    public static final String TEACHER = "TEACHER";
    public static final String TYPE = "TYPE";
    public static final String DAY = "DAY";
    public static final String TIME = "TIME";
    public static final String DATETIMESTAMP = "DATETIMESTAMP";


    public DatabaseHelper(@Nullable Context context) { super(context, "subjects.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSubject = "CREATE TABLE " + SUBJECTS_TABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SUBJECTNAME + " STRING,  " + SUBJECTCODE + " STRING, " + TEACHER + " STRING, " + TYPE + " STRING ," + DAY + " STRING, " + TIME + " STRING,  "  + DATETIMESTAMP + " DEFAULT (STRFTIME('%Y-%m-%d %H:%M:%f', 'NOW')) )";
        db.execSQL(createTableSubject);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SUBJECTS_TABLE);

        onCreate(db);
    }

    //add product
    public boolean addSubject(SubjectModel subjectModel){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(SUBJECTNAME, subjectModel.getSubjectName());
        cv.put(SUBJECTCODE, subjectModel.getSubjectCode());
        cv.put(TYPE, subjectModel.getType());
        cv.put(TEACHER, subjectModel.getTeacher());
        cv.put(DAY, subjectModel.getDay());
        cv.put(TIME, subjectModel.getTime());

        long insert = db.insert(SUBJECTS_TABLE, null, cv);
        if (insert == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getSubjectsList(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor SubjectData = db.rawQuery("SELECT * FROM " + SUBJECTS_TABLE + " ORDER BY " + TIME + " DESC", null);
        return SubjectData;
    }

}