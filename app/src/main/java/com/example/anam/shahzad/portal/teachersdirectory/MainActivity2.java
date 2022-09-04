package com.example.anam.shahzad.portal.teachersdirectory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.anam.shahzad.portal.R;
import com.example.anam.shahzad.portal.studentsdirectory.InsertCoursesFragment;
import com.example.anam.shahzad.portal.studentsdirectory.StudentViewPagerAdapter;
import com.example.anam.shahzad.portal.studentsdirectory.ViewCoursesFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity2 extends AppCompatActivity {
    ViewPager viewpager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initViewPager();
    }

    private void initViewPager() {
        viewpager=findViewById(R.id.teacherviewpager);
        tabLayout=findViewById(R.id.teachertablayout);
        TeacherViewPagerAdapter teacherViewPagerAdapter= new TeacherViewPagerAdapter(getSupportFragmentManager());
        teacherViewPagerAdapter.AddFragment(new InsertStudentsFragment(),"Insert New Students");
        teacherViewPagerAdapter.AddFragment(new ViewStudentsFragment(),"View All Students");
        viewpager.setOffscreenPageLimit(teacherViewPagerAdapter.getCount());

        viewpager.setAdapter(teacherViewPagerAdapter);
        tabLayout.setupWithViewPager(viewpager);

    }
}