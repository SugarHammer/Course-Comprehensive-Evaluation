package com.yxb.teaching_assessment.biz.entity;

import java.io.Serializable;
import java.util.List;

public class DepartmentClass  implements Serializable {
    private List<Department> departments;
    private List<Clazz> clazzes;

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Clazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(List<Clazz> clazzes) {
        this.clazzes = clazzes;
    }
}
