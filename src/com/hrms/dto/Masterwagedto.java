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
public class Masterwagedto {
    private Integer wageid;
    private String emptype;
    private String wagetype;

    public Integer getWageid() {
        return wageid;
    }

    public void setWageid(Integer wageid) {
        this.wageid = wageid;
    }

   

    public String getEmptype() {
        return emptype;
    }

    public void setEmptype(String emptype) {
        this.emptype = emptype;
    }

    public String getWagetype() {
        return wagetype;
    }

    public void setWagetype(String wagetype) {
        this.wagetype = wagetype;
    }
}
