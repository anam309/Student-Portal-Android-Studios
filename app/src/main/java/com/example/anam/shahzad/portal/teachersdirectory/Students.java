package com.example.anam.shahzad.portal.teachersdirectory;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Students {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "Student_name")
    public String studentname;

    @ColumnInfo(name = "Student_email")
    public String studentemail;

    @ColumnInfo(name = "Student_Teacher")
    public String studentteacher;

    @ColumnInfo(name = "Registered_Year")
    public String regyear;

    @ColumnInfo(name = "Student_Phone")
    public String studentphone;

    public Students() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentemail() {
        return studentemail;
    }

    public void setStudentemail(String studentemail) {
        this.studentemail = studentemail;
    }

    public String getStudentteacher() {
        return studentteacher;
    }

    public void setStudentteacher(String studentteacher) {
        this.studentteacher = studentteacher;
    }

    public String getRegyear() {
        return regyear;
    }

    public void setRegyear(String regyear) {
        this.regyear = regyear;
    }

    public String getStudentphone() {
        return studentphone;
    }

    public void setStudentphone(String studentphone) {
        this.studentphone = studentphone;
    }
}
