package com.example.stud.Adapter;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.stud.MainActivity;
import com.example.stud.Model.SubjectModel;
import com.example.stud.R;

import java.util.ArrayList;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.MyViewHolder> {

    private final SubjectInete subjectInetes;


    Context context;
    ArrayList<SubjectModel> subjectModels;

    public SubjectAdapter(Context context, ArrayList<SubjectModel> subjectModels, SubjectInete subjectInetes){
        this.context = context;
        this.subjectModels = subjectModels;
        this.subjectInetes = subjectInetes;
    }


    @NonNull
    @Override
    public SubjectAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType  ) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.subject_details_recyclerview, parent, false);

        return new SubjectAdapter.MyViewHolder(view, subjectInetes);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectAdapter.MyViewHolder holder, int position) {
        holder.subjectCode.setText(subjectModels.get(position).getSubjectCode());
        holder.countTask.setText(subjectModels.get(position).getTeacher());
        holder.schedule.setText(subjectModels.get(position).getSchedule());
    }

    @Override
    public int getItemCount() {

        return subjectModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView subjectCode, countTask, schedule;


        public MyViewHolder(@NonNull View itemView, SubjectInete subjectInetes) {
            super(itemView);
            subjectCode = itemView.findViewById(R.id.subjectName);
            countTask = itemView.findViewById(R.id.countTask);
            schedule = itemView.findViewById(R.id.Schedule);

            itemView.setOnClickListener(view -> {
                if(subjectInetes != null ){
                    int sub = getAdapterPosition();
                    if(sub!= RecyclerView.NO_POSITION){
                        subjectInetes.onItemClick(sub);
                    }
                }
            });
        }
    }


}
