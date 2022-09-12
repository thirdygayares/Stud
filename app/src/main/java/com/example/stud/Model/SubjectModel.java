package com.example.stud.Model;

public class SubjectModel {
    int id;
    String SubjectName;
    String CountTask;
    String Schedule;

    String SubjectCode;
    String Type;
    String Teacher;
    String Day;
    String Time;


    public SubjectModel(int id, String subjectName, String countTask, String schedule) {
        this.id = id;
        SubjectName = subjectName;
        CountTask = countTask;
        Schedule = schedule;
    }

    public SubjectModel(int id, String subjectName, String subjectCode, String type, String teacher, String day, String time) {
        this.id = id;
        SubjectName = subjectName;
        SubjectCode = subjectCode;
        Type = type;
        Teacher = teacher;
        Day = day;
        Time = time;
    }

    public SubjectModel( String subjectCode, String teacher, String schedule) {
        SubjectCode = subjectCode;
        Teacher = teacher;
        Schedule = schedule;

    }

    public SubjectModel(String subjectName, String subjectCode, String type, String teacher, String day, String time) {
        SubjectName = subjectName;
        SubjectCode = subjectCode;
        Type = type;
        Teacher = teacher;
        Day = day;
        Time = time;
    }

    public int getId() {
        return id;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public String getCountTask() {
        return CountTask;
    }

    public String getSchedule() {
        return Schedule;
    }

    public String getSubjectCode() {
        return SubjectCode;
    }

    public String getType() {
        return Type;
    }

    public String getTeacher() {
        return Teacher;
    }

    public String getDay() {
        return Day;
    }

    public String getTime() {
        return Time;
    }
}
