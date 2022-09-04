package com.example.anam.shahzad.portal.teachersdirectory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class TeacherViewPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> FragmentArrayList;
    ArrayList<String>TabTitle;

    public TeacherViewPagerAdapter(@NonNull FragmentManager fm) {

        super(fm);
        FragmentArrayList=new ArrayList<>();
        TabTitle= new ArrayList<>();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return FragmentArrayList.get(position);
    }

    public void AddFragment(Fragment fragment, String title){
        FragmentArrayList.add(fragment);
        TabTitle.add(title);
    }

    @Override
    public int getCount() {
        return FragmentArrayList.size();
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return TabTitle.get(position);
    }

}
