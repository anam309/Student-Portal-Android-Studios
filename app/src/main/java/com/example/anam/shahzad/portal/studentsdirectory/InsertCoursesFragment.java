package com.example.anam.shahzad.portal.studentsdirectory;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anam.shahzad.portal.AppDatabase;
import com.example.anam.shahzad.portal.R;


public class InsertCoursesFragment extends Fragment {
    EditText course_name,course_dep,course_teacher,course_year,course_code;
    Button save;


    public InsertCoursesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_insert_courses, container, false);
        course_name=view.findViewById(R.id.coursename);
        course_dep=view.findViewById(R.id.coursedep);
        course_teacher=view.findViewById(R.id.courseteacher);
        course_year=view.findViewById(R.id.courseyear);
        course_code=view.findViewById(R.id.coursecode);


        save=view.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String courseName=course_name.getText().toString();
                String courseDep=course_dep.getText().toString();
                String courseTeacher=course_teacher.getText().toString();
                String courseYear=course_year.getText().toString();
                String courseCode=course_code.getText().toString();
                if (!courseName.equals("")){
                    if (!courseDep.equals("")){
                        if (!courseTeacher.equals("")){
                            if (!courseYear.equals("")){
                                if (!courseCode.equals("")){

                                    Course course= new Course();
                                    course.setCoursename(courseName);
                                    course.setCourseteacher(courseTeacher);
                                    course.setCoursedep(courseDep);
                                    course.setCourseyear(courseYear);
                                    course.setCoursecode(courseCode);
                                    AppDatabase db = AppDatabase.getInstance(getContext());
                                    db.courseDAO().insertCourse(course);
                                    Toast.makeText(getContext(), "New Course "+courseName+ " Added", Toast.LENGTH_SHORT).show();


                                }else{
                                    Toast.makeText(getContext(), "Enter Course Code", Toast.LENGTH_SHORT).show();
                                }

                            }else{
                                Toast.makeText(getContext(), "Enter Course Year", Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            Toast.makeText(getContext(), "Enter Course Teacher", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(getContext(), "Enter Course Department", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(getContext(), "Enter Course Name", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }
}