package com.example.anam.shahzad.portal.teachersdirectory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.anam.shahzad.portal.AppDatabase;
import com.example.anam.shahzad.portal.R;
import com.example.anam.shahzad.portal.studentsdirectory.Course;

import java.util.List;

public class StudentsDetailsActivity extends AppCompatActivity {
    TextView id,name,email,teacher,year,phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_details);
        id=findViewById(R.id.studentid);
        name=findViewById(R.id.studentname);
        email=findViewById(R.id.studentemail);
        teacher=findViewById(R.id.studentteacher);
        year=findViewById(R.id.studentyear);
        phone=findViewById(R.id.studentphone);
        int studentID=getIntent().getIntExtra("studentID",0);
        AppDatabase db = AppDatabase.getInstance(getApplicationContext());
        List<Students> allStudents= db.courseDAO().getAllStudents();
        Students students = allStudents.get((studentID-1));
        id.setText("Student ID: "+students.getId());
        name.setText("Student Name: "+students.getStudentname());
        email.setText("Student Email: "+students.getStudentemail());
        teacher.setText("Student Teacher: "+students.getStudentteacher());
        year.setText("Registered Year: "+students.getRegyear());
        phone.setText("Student Phone: "+students.getStudentphone());
    }
}