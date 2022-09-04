package com.example.anam.shahzad.portal;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.anam.shahzad.portal.studentsdirectory.Course;
import com.example.anam.shahzad.portal.teachersdirectory.Students;

@Database(entities = {Course.class, Students.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    public abstract CourseDAO courseDAO();

    public static AppDatabase getInstance(Context context){
        if (instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,
                    "course_database")
                    .allowMainThreadQueries()
                    .build();

        }
        return instance;
    }
}

