package com.yxb.teaching_assessment.biz.entity;

import java.io.Serializable;
import java.util.List;

public class Teacher_Clazz_Course  implements  Serializable {


    List<Teacher> teachers;
    List<Course> courses;
    List<Clazz> clazzes;

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Clazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(List<Clazz> clazzes) {
        this.clazzes = clazzes;
    }
}
