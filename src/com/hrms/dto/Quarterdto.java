/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.dto;

/**
 *
 * @author Swathi
 */
public class Quarterdto {
    private int empId;
    private String empName;
    private String aadharNumber;
    private String quartercode;
    private String doissued;
    private int id;
    private int quarterId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuarterId() {
        return quarterId;
    }

    public void setQuarterId(int quarterId) {
        this.quarterId = quarterId;
    }

    public String getQuartercode() {
        return quartercode;
    }

    public void setQuartercode(String quartercode) {
        this.quartercode = quartercode;
    }

    public String getDoissued() {
        return doissued;
    }

    public void setDoissued(String doissued) {
        this.doissued = doissued;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }
    

   
    
    
}
