package com.example.anam.shahzad.portal.studentsdirectory;

import android.widget.EditText;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Course {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name="Course_Name")
    public String coursename;

    @ColumnInfo(name="Course_Department")
    public String coursedep;

    @ColumnInfo(name="Course_Teacher")
    public String courseteacher;

    @ColumnInfo(name="Course_Year")
    public String courseyear;

    @ColumnInfo(name="Course_Code")
    public String coursecode;

    public Course(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursedep() {
        return coursedep;
    }

    public void setCoursedep(String coursedep) {
        this.coursedep = coursedep;
    }

    public String getCourseteacher() {
        return courseteacher;
    }

    public void setCourseteacher(String courseteacher) {
        this.courseteacher = courseteacher;
    }

    public String getCourseyear() {
        return courseyear;
    }

    public void setCourseyear(String courseyear) {
        this.courseyear = courseyear;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }
}
