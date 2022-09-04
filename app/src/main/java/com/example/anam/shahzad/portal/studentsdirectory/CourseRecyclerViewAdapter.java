package com.example.anam.shahzad.portal.studentsdirectory;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anam.shahzad.portal.R;

import java.util.ArrayList;
import java.util.List;

public class CourseRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Course> courseArrayList = new ArrayList<>();
    StudentInterface studentInterface;

    public void setStudentInterface(StudentInterface studentInterface) {
        //to attach adapter with interface

        this.studentInterface = studentInterface;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.courseslist, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Course course = courseArrayList.get(position);
        String name = course.getCoursename().toString();
        String dep = course.getCoursedep().toString();
        int id = course.getId();

        CourseViewHolder courseViewHolder = (CourseViewHolder) holder;
        courseViewHolder.course_name.setText(name);
        courseViewHolder.course_dep.setText(dep);
        courseViewHolder.course_id.setText("Course ID: " + id);
        courseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentInterface.onItemClick(course);
            }
        });


    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return courseArrayList.size();
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView course_name, course_dep, course_id;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            course_name = itemView.findViewById(R.id.coursename);
            course_dep = itemView.findViewById(R.id.coursedep);
            course_id = itemView.findViewById(R.id.courseid);

        }
    }

    public void setData(List<Course> courseArrayList) {
        this.courseArrayList = courseArrayList;


        notifyDataSetChanged();
    }
}
