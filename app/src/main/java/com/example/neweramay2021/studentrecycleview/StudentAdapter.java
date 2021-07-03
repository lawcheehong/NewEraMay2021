package com.example.neweramay2021.studentrecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.neweramay2021.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private ArrayList<Student> studentList;
    private Context context;

    public StudentAdapter(Context context, ArrayList<Student> list){
        this.studentList = list;
        this.context = context;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_row_student, parent, false);
        return new StudentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull StudentAdapter.ViewHolder holder, int position) {
        Student Student = studentList.get(position);

        holder.tvmatricnumber.setText(Student.getMatric());
        holder.tvstudentname.setText(Student.getName());
        holder.tvcoursename.setText(Student.getCourseName());

        Glide.with(context)
                .load(Student.getPhoto())
                .into(holder.imgStudent);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvmatricnumber, tvstudentname, tvcoursename;
        public ImageView imgStudent;

        public ViewHolder(View itemView){
            super(itemView);

            tvmatricnumber = itemView.findViewById(R.id.tvmatricnumber);
            tvstudentname = itemView.findViewById(R.id.tvstudentname);
            tvcoursename = itemView.findViewById(R.id.tvcoursename);
            imgStudent = itemView.findViewById(R.id.imgStudent);
        }
    }
}