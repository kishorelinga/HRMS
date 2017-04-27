/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.dto;

import com.hrms.model.EmployeeProfile;
import com.hrms.model.WageDefinitions;
import java.util.Date;

/**
 *
 * @author NSG
 */
public class WagesForm 
{
     private Integer id;
     private EmployeeProfile employeeProfile;
     private WageDefinitions wageDefinitions;
     private Integer basicRate;
     private String effectiveDate;
     private String wageId;
     private Integer empId;

    public String getWageId() {
        return wageId;
    }

    public void setWageId(String wageId) {
        this.wageId = wageId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    

    
     

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeProfile getEmployeeProfile() {
        return employeeProfile;
    }

    public void setEmployeeProfile(EmployeeProfile employeeProfile) {
        this.employeeProfile = employeeProfile;
    }

    public WageDefinitions getWageDefinitions() {
        return wageDefinitions;
    }

    public void setWageDefinitions(WageDefinitions wageDefinitions) {
        this.wageDefinitions = wageDefinitions;
    }

    public Integer getBasicRate() {
        return basicRate;
    }

    public void setBasicRate(Integer basicRate) {
        this.basicRate = basicRate;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    
     
     

}
