/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.dto;

import com.hrms.model.FamilyIdentity;

/**
 *
 * @author Swathi
 */
public class DependentsInfodto {
    private int empId;
    private String name;
   //  private FamilyIdentity familyIdentity;
    private Integer age;
    private Integer id;
    private Integer fid;

    public Integer getFid() {
        return fid;
    }

//    public FamilyIdentity getFamilyIdentity() {
//        return familyIdentity;
//    }
//
//    public void setFamilyIdentity(FamilyIdentity familyIdentity) {
//        this.familyIdentity = familyIdentity;
//    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    private String status;
    private Integer depid;

    public Integer getDepid() {
        return depid;
    }

    public void setDepid(Integer depid) {
        this.depid = depid;
    }
    private Integer fheadId;

    public int getFheadId() {
        return fheadId;
    }

    public void setFheadId(int fheadId) {
        this.fheadId = fheadId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
}
