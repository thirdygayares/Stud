package com.example.stud.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.stud.Model.TaskModel;
import com.example.stud.R;

import java.util.ArrayList;

class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

//    private final historyInterface historyInterfaces;

    static  int x;
    Context context;
    ArrayList<TaskModel> taskModels;

    public TaskAdapter(Context context, ArrayList<TaskModel> taskModels){
        this.context = context;
        this.taskModels = taskModels;

    }

    @NonNull
    @Override
    public TaskAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType  ) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.task_details_recyclerview, parent, false);

        return new TaskAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.MyViewHolder holder, int position) {
        holder.taskName.setText(taskModels.get(position).getTaskName());
        holder.Category.setText(taskModels.get(position).getTaskCategory());
        holder.deadline.setText(taskModels.get(position).getDeadline());

    }

    @Override
    public int getItemCount() {
        return taskModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView taskName, Category, deadline;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            taskName = itemView.findViewById(R.id.nameAct);
            Category = itemView.findViewById(R.id.categoryAct);
            deadline = itemView.findViewById(R.id.Deadline);
        }
    }






}
