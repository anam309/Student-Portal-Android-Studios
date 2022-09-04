package com.example.anam.shahzad.portal.teachersdirectory;

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

import com.example.anam.shahzad.portal.R;
import com.example.anam.shahzad.portal.AppDatabase;
import com.example.anam.shahzad.portal.studentsdirectory.Course;
import com.example.anam.shahzad.portal.studentsdirectory.StudentInterface;

import java.util.List;

public class ViewStudentsFragment extends Fragment {
    Button refresh;
    RecyclerView recyclerView;
    List<Students> studentsList;


    public ViewStudentsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_view_students, container, false);
        recyclerView=view.findViewById(R.id.recyclerview);
        refresh=view.findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initRecyclerView();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void initRecyclerView() {
        StudentRecyclerViewAdapter studentRecyclerViewAdapter= new StudentRecyclerViewAdapter();
        studentRecyclerViewAdapter.setStudentInterface(new StudentInterface() {
            @Override
            public void onItemClick(Course course) {
                //
            }

            @Override
            public void onStudentClick(Students students) {
                int id = students.getId();
                Intent intent = new Intent(getContext(), StudentsDetailsActivity.class);
                intent.putExtra("studentID",id);
                startActivity(intent);
                Toast.makeText(getContext(), "Showing Student Details", Toast.LENGTH_SHORT).show();

            }
        });
        recyclerView.setAdapter(studentRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        AppDatabase db = AppDatabase.getInstance(getContext());
        List<Students> allStudents=db.courseDAO().getAllStudents();
        studentRecyclerViewAdapter.setData(allStudents);

    }
}