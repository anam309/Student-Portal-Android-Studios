package com.example.anam.shahzad.portal;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.anam.shahzad.portal.studentsdirectory.Course;
import com.example.anam.shahzad.portal.teachersdirectory.Students;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Dao
public interface CourseDAO {

    @Insert
    void insertCourse(Course course);

    @Insert
    void insertStudent (Students students);

    @Query("SELECT * FROM Course")
    List<Course> getAllCourses();

    @Query("SELECT * FROM Students")
    List<Students> getAllStudents();






}
