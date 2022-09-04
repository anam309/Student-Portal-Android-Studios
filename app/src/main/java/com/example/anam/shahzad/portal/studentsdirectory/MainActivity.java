package com.example.anam.shahzad.portal.studentsdirectory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.anam.shahzad.portal.R;
import com.example.anam.shahzad.portal.studentsdirectory.InsertCoursesFragment;
import com.example.anam.shahzad.portal.studentsdirectory.StudentViewPagerAdapter;
import com.example.anam.shahzad.portal.studentsdirectory.ViewCoursesFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager viewpager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviewpager();


    }

    private void initviewpager() {
        viewpager=findViewById(R.id.studentviewpager);
        tabLayout=findViewById(R.id.studenttablayout);
        StudentViewPagerAdapter studentViewPagerAdapter= new StudentViewPagerAdapter(getSupportFragmentManager());
        studentViewPagerAdapter.AddFragment(new InsertCoursesFragment(),"Insert New Courses");
        studentViewPagerAdapter.AddFragment(new ViewCoursesFragment(),"View All Courses");
        viewpager.setOffscreenPageLimit(studentViewPagerAdapter.getCount());

        viewpager.setAdapter(studentViewPagerAdapter);
        tabLayout.setupWithViewPager(viewpager);

    }
}