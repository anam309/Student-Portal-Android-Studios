package com.example.anam.shahzad.portal.teachersdirectory;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anam.shahzad.portal.R;
import com.example.anam.shahzad.portal.studentsdirectory.Course;
import com.example.anam.shahzad.portal.studentsdirectory.CourseDetailsActivity;
import com.example.anam.shahzad.portal.studentsdirectory.CourseRecyclerViewAdapter;
import com.example.anam.shahzad.portal.studentsdirectory.StudentInterface;

import java.util.ArrayList;
import java.util.List;

public class StudentRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<Students> studentsArrayList=new ArrayList<>();
    StudentInterface studentInterface;

    public void setStudentInterface(StudentInterface studentInterface) {
        //to attach adapter with interface

        this.studentInterface = studentInterface;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.studentslist,parent,false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Students students=studentsArrayList.get(position);
        String name = students.getStudentname().toString();
        String email = students.getStudentemail().toString();
        int id = students.getId();
        StudentViewHolder studentViewHolder=(StudentViewHolder) holder;
        studentViewHolder.student_name.setText(name);
        studentViewHolder.student_email.setText(email);
        studentViewHolder.student_id.setText("Student ID: "+id);
        studentViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentInterface.onStudentClick(students);
//                Intent intent = new Intent(view.getContext(), StudentsDetailsActivity.class);
//                intent.putExtra("studentID",id);
//                view.getContext().startActivity(intent);
//                Toast.makeText(view.getContext(), "Showing Student Details", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentsArrayList.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView student_name,student_email,student_id;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            student_name=itemView.findViewById(R.id.studentname);
            student_email=itemView.findViewById(R.id.studentemail);
            student_id=itemView.findViewById(R.id.studentid);

        }
    }

    public void setData(List<Students> studentsArrayList){
        this.studentsArrayList = studentsArrayList;
        notifyDataSetChanged();
    }
}
