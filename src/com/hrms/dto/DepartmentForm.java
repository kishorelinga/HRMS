/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.dto;

import com.hrms.model.Departments;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NSG
 */
public class DepartmentForm {
     private Integer deptId;
     private String deptName;
     private String deptScope;
     private List<Departments> dept=new ArrayList();

    public List<Departments> getDept() {
        return dept;
    }

    public void setDept(List<Departments> dept) {
        this.dept = dept;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptScope() {
        return deptScope;
    }

    public void setDeptScope(String deptScope) {
        this.deptScope = deptScope;
    }
     
    
}
