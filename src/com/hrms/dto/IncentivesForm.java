/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.dto;

import com.hrms.model.EmployeeProfile;
import com.hrms.model.IncentiveRules;
import java.util.Date;

/**
 *
 * @author NSG
 */
public class IncentivesForm 
{
    private Integer id;
     private EmployeeProfile employeeProfile;
     private IncentiveRules incentiveRules;
     private int incentiveId;
     private String incentiveName;
     private String incentiveCode;
     private Integer empId;
     private int inc;
     private int days;
     private String date;
     private int incAmount;

    public int getIncAmount() {
        return incAmount;
    }

    public void setIncAmount(int incAmount) {
        this.incAmount = incAmount;
    }

    public int getInc() {
        return inc;
    }

    public void setInc(int inc) {
        this.inc = inc;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public IncentiveRules getIncentiveRules() {
        return incentiveRules;
    }

    public void setIncentiveRules(IncentiveRules incentiveRules) {
        this.incentiveRules = incentiveRules;
    }

    public int getIncentiveId() {
        return incentiveId;
    }

    public void setIncentiveId(int incentiveId) {
        this.incentiveId = incentiveId;
    }

    

    public String getIncentiveName() {
        return incentiveName;
    }

    public void setIncentiveName(String incentiveName) {
        this.incentiveName = incentiveName;
    }

    public String getIncentiveCode() {
        return incentiveCode;
    }

    public void setIncentiveCode(String incentiveCode) {
        this.incentiveCode = incentiveCode;
    }
     
     
     
    
}
