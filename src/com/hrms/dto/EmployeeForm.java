/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.dto;


import com.hrms.model.EmployeeProfile;
import com.hrms.model.EmployeeType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author nsg
 */
public class EmployeeForm {
    private int empTypeId;
    private EmployeeProfile employeeProfile;

    public EmployeeProfile getEmployeeProfile() {
        return employeeProfile;
    }

    public void setEmployeeProfile(EmployeeProfile employeeProfile) {
        this.employeeProfile = employeeProfile;
    }
    
    
     private String description;
     
     public EmployeeForm() {
    }
     private List<EmployeeType> emp=new ArrayList();

    public List<EmployeeType> getEmp() {
        return emp;
    }

    public void setEmp(List<EmployeeType> emp) {
        this.emp = emp;
    }
     
    public EmployeeForm(int empTypeId) {
        this.empTypeId = empTypeId;
    }
    public EmployeeForm(int empTypeId, String description) {
       this.empTypeId = empTypeId;
       this.description = description;
       
    }
   
    public int getEmpTypeId() {
        return this.empTypeId;
    }
    
    public void setEmpTypeId(int empTypeId) {
        this.empTypeId = empTypeId;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
   

}




