package com.example.android.myassistant;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder{
       TextView heading;
       TextView date;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            heading= itemView.findViewById(R.id.heading_listItem_TextView);
            date= itemView.findViewById(R.id.date_listItem_TextView);
        }
    }


}
