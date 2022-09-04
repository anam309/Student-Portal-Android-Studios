package com.example.anam.shahzad.portal.studentsdirectory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.anam.shahzad.portal.AppDatabase;
import com.example.anam.shahzad.portal.CourseDAO;
import com.example.anam.shahzad.portal.R;
import com.example.anam.shahzad.portal.teachersdirectory.Students;

import java.util.List;

public class CourseDetailsActivity extends AppCompatActivity {
    TextView id,name,dep,teacher,year,code;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
        id=findViewById(R.id.courseid);
        name=findViewById(R.id.coursename);
        dep=findViewById(R.id.coursedep);
        teacher=findViewById(R.id.courseteacher);
        year=findViewById(R.id.courseyear);
        code=findViewById(R.id.coursecode);
        int courseID=getIntent().getIntExtra("courseID",0);
        AppDatabase db = AppDatabase.getInstance(getApplicationContext());
        List<Course>allCourses = db.courseDAO().getAllCourses();
        Course course = allCourses.get((courseID-1));
        String text1="Course ID: "+course.getId();
        id.setText(text1);
        name.setText("Course Name: "+course.getCoursename());
        dep.setText("Course Department: "+course.getCoursedep());
        teacher.setText("Course Teacher: "+course.getCourseteacher());
        year.setText("Course Year: "+course.getCourseyear());
        code.setText("Course Code: "+course.getCoursecode());



    }
}