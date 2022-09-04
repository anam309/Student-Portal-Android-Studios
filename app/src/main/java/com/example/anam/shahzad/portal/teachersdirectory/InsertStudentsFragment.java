package com.example.anam.shahzad.portal.teachersdirectory;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anam.shahzad.portal.R;
import com.example.anam.shahzad.portal.AppDatabase;
import com.example.anam.shahzad.portal.studentsdirectory.Course;


public class InsertStudentsFragment extends Fragment {
    EditText student_name,student_email,student_teacher,student_year,student_phone;
    Button save;

    public InsertStudentsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_insert_students, container, false);
        student_name=view.findViewById(R.id.studentname);
        student_email=view.findViewById(R.id.studentemail);
        student_teacher=view.findViewById(R.id.studentteacher);
        student_phone=view.findViewById(R.id.studentphone);
        student_year =view.findViewById(R.id.studentyear);

        save=view.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stdName=student_name.getText().toString();
                String stdEmail=student_email.getText().toString();
                String stdTeacher=student_teacher.getText().toString();
                String stdYear=student_year.getText().toString();
                String stdPhone=student_phone.getText().toString();
                if (!stdName.equals("")){
                    if (!stdEmail.equals("")){
                        if (!stdPhone.equals("")){
                            if (!stdTeacher.equals("")){
                                if (!stdYear.equals("")){
                                    Students students= new Students();
                                    students.setStudentname(stdName);
                                    students.setStudentemail(stdEmail);
                                    students.setStudentphone(stdPhone);
                                    students.setStudentteacher(stdTeacher);
                                    students.setRegyear(stdYear);

                                    AppDatabase db = AppDatabase.getInstance(getContext());
                                    db.courseDAO().insertStudent(students);
                                    Toast.makeText(getContext(), "New Student "+stdName+ " Added", Toast.LENGTH_SHORT).show();

                                }else{
                                    Toast.makeText(getContext(), "Enter Student Year", Toast.LENGTH_SHORT).show();
                                }

                            }else{
                                Toast.makeText(getContext(), "Enter Student Teacher", Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            Toast.makeText(getContext(), "Enter Student Phone", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(getContext(), "Enter Student Email", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(getContext(), "Enter Student Name", Toast.LENGTH_SHORT).show();
                }


            }
        });


        // Inflate the layout for this fragment
        return view;
    }
}