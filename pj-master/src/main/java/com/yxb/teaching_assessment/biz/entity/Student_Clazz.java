package com.yxb.teaching_assessment.biz.entity;

import java.io.Serializable;
import java.util.List;

public class Student_Clazz implements Serializable {
    private List<Student> students;
    private  List<Clazz> clazzes;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Clazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(List<Clazz> clazzes) {
        this.clazzes = clazzes;
    }
}
