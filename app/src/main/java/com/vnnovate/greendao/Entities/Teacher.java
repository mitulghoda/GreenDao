package com.vnnovate.greendao.Entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Vnnovate on 17-Jul-17.
 */
@Entity
public class Teacher {
    @org.greenrobot.greendao.annotation.Id(autoincrement = true)
    private Long Teacher_Id;

    private String TeacherName;
    private int Salary;
    private String City;
    @Generated(hash = 41004304)
    public Teacher(Long Teacher_Id, String TeacherName, int Salary, String City) {
        this.Teacher_Id = Teacher_Id;
        this.TeacherName = TeacherName;
        this.Salary = Salary;
        this.City = City;
    }
    @Generated(hash = 1630413260)
    public Teacher() {
    }
    public Long getTeacher_Id() {
        return this.Teacher_Id;
    }
    public void setTeacher_Id(Long Teacher_Id) {
        this.Teacher_Id = Teacher_Id;
    }
    public String getTeacherName() {
        return this.TeacherName;
    }
    public void setTeacherName(String TeacherName) {
        this.TeacherName = TeacherName;
    }
    public int getSalary() {
        return this.Salary;
    }
    public void setSalary(int Salary) {
        this.Salary = Salary;
    }
    public String getCity() {
        return this.City;
    }
    public void setCity(String City) {
        this.City = City;
    }
}
