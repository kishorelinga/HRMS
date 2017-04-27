/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.dto;

import com.hrms.model.Departments;
import com.hrms.model.EmployeeProfile;
import com.hrms.model.EmployeeType;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author NSG
 */
public class EmployeeProfileForm 
{
    
     private Integer empId;
     private Departments departments;
     private EmployeeType employeeType;
     private String doj;
     private String status;
     
     private String dept;
     private String quarter;
     private String etype;
     private String imageFileName;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getEtype() {
        return etype;
    }

    public void setEtype(String etype) {
        this.etype = etype;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }
     

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }
     
     
     
     private String empName;
     private String gender;
     private String dob;
     private String aadharNumber;
     private String maritialStatus;
     private String address;
     private String quarterType;
     private String perminentAddress;
     private String selfContactNumber;
     private String emergencyContactNumber;
     private String otEligibility;
     private String proofType;
     private String proofNumber;
     private byte[] proofScannedCopy;
     private File image;

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }
     
     
     
     private String empGrade;
     private String recordCreationDate;
     private Set leaveMasters = new HashSet(0);
     private Set overtimes = new HashSet(0);
     private Set gasAllotments = new HashSet(0);
     private Set loanAllotments = new HashSet(0);
     private Set incentiveses = new HashSet(0);
     private Set wageses = new HashSet(0);
     private Set deductionMasters = new HashSet(0);
     private Set familyIdentities = new HashSet(0);
     private Set quarterAllotments = new HashSet(0);
     
     private List<EmployeeProfile> list=new ArrayList();

    public List<EmployeeProfile> getList() {
        return list;
    }

    public void setList(List<EmployeeProfile> list) {
        this.list = list;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
     
     
     

    

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getMaritialStatus() {
        return maritialStatus;
    }

    public void setMaritialStatus(String maritialStatus) {
        this.maritialStatus = maritialStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQuarterType() {
        return quarterType;
    }

    public void setQuarterType(String quarterType) {
        this.quarterType = quarterType;
    }

    public String getPerminentAddress() {
        return perminentAddress;
    }

    public void setPerminentAddress(String perminentAddress) {
        this.perminentAddress = perminentAddress;
    }

    public String getSelfContactNumber() {
        return selfContactNumber;
    }

    public void setSelfContactNumber(String selfContactNumber) {
        this.selfContactNumber = selfContactNumber;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getOtEligibility() {
        return otEligibility;
    }

    public void setOtEligibility(String otEligibility) {
        this.otEligibility = otEligibility;
    }

    public String getProofType() {
        return proofType;
    }

    public void setProofType(String proofType) {
        this.proofType = proofType;
    }

    public String getProofNumber() {
        return proofNumber;
    }

    public void setProofNumber(String proofNumber) {
        this.proofNumber = proofNumber;
    }

    public byte[] getProofScannedCopy() {
        return proofScannedCopy;
    }

    public void setProofScannedCopy(byte[] proofScannedCopy) {
        this.proofScannedCopy = proofScannedCopy;
    }

    public String getEmpGrade() {
        return empGrade;
    }

    public void setEmpGrade(String empGrade) {
        this.empGrade = empGrade;
    }

    public String getRecordCreationDate() {
        return recordCreationDate;
    }

    public void setRecordCreationDate(String recordCreationDate) {
        this.recordCreationDate = recordCreationDate;
    }

    

    public Set getLeaveMasters() {
        return leaveMasters;
    }

    public void setLeaveMasters(Set leaveMasters) {
        this.leaveMasters = leaveMasters;
    }

    public Set getOvertimes() {
        return overtimes;
    }

    public void setOvertimes(Set overtimes) {
        this.overtimes = overtimes;
    }

    public Set getGasAllotments() {
        return gasAllotments;
    }

    public void setGasAllotments(Set gasAllotments) {
        this.gasAllotments = gasAllotments;
    }

    public Set getLoanAllotments() {
        return loanAllotments;
    }

    public void setLoanAllotments(Set loanAllotments) {
        this.loanAllotments = loanAllotments;
    }

    public Set getIncentiveses() {
        return incentiveses;
    }

    public void setIncentiveses(Set incentiveses) {
        this.incentiveses = incentiveses;
    }

    public Set getWageses() {
        return wageses;
    }

    public void setWageses(Set wageses) {
        this.wageses = wageses;
    }

    public Set getDeductionMasters() {
        return deductionMasters;
    }

    public void setDeductionMasters(Set deductionMasters) {
        this.deductionMasters = deductionMasters;
    }

    public Set getFamilyIdentities() {
        return familyIdentities;
    }

    public void setFamilyIdentities(Set familyIdentities) {
        this.familyIdentities = familyIdentities;
    }

    public Set getQuarterAllotments() {
        return quarterAllotments;
    }

    public void setQuarterAllotments(Set quarterAllotments) {
        this.quarterAllotments = quarterAllotments;
    }

    
}
