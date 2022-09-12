package com.example.stud.Model;

public class TaskModel {
    String id;
    String TaskName;
    String TaskCategory;
    String Deadline;
    int status;

    public TaskModel(String id, String taskName, String taskCategory, String deadline, int status) {
        this.id = id;
        TaskName = taskName;
        TaskCategory = taskCategory;
        Deadline = deadline;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getTaskName() {
        return TaskName;
    }

    public String getTaskCategory() {
        return TaskCategory;
    }

    public String getDeadline() {
        return Deadline;
    }

    public int getStatus() {
        return status;
    }
}
