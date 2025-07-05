package com.yxb.teaching_assessment.biz.entity;

import java.io.Serializable;
import java.util.List;

public class Globls implements Serializable {
    List<Clazz> clazzes;

    public List<Clazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(List<Clazz> clazzes) {
        this.clazzes = clazzes;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    List<Course> courses;

}
