package com.example.anam.shahzad.portal.studentsdirectory;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.anam.shahzad.portal.AppDatabase;
import com.example.anam.shahzad.portal.R;
import com.example.anam.shahzad.portal.teachersdirectory.Students;

import java.util.List;

public class ViewCoursesFragment extends Fragment {
    Button refresh;
    RecyclerView recyclerView;
    List<Course> courseList;

    public ViewCoursesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_courses, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);

        refresh = view.findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initRecyclerView();
            }
        });

        return view;

    }

    private void initRecyclerView() {
        CourseRecyclerViewAdapter courseRecyclerViewAdapter = new CourseRecyclerViewAdapter();
        //we can also implement interface on top (then declare methods) and declare interface after that and pass context "this" when setting interface with adapter
        courseRecyclerViewAdapter.setStudentInterface(new StudentInterface() {
            @Override
            public void onItemClick(Course course) {
                int id = course.getId();
                Intent intent = new Intent(getActivity(), CourseDetailsActivity.class);
                intent.putExtra("courseID", id);
                startActivity(intent);
                Toast.makeText(getContext(), "Showing Course Details", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStudentClick(Students students) {
                //
            }
        });
        recyclerView.setAdapter(courseRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        AppDatabase db = AppDatabase.getInstance(getContext());
        List<Course> allCourses = db.courseDAO().getAllCourses();
        courseRecyclerViewAdapter.setData(allCourses);
    }

}