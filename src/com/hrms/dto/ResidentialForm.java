/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.dto;

import com.hrms.model.ResidentialQuarters;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NSG
 */
public class ResidentialForm {
     private Integer quarterId;
     private String quarterType;
     private String quarterCode;
     private List<ResidentialQuarters> qlist=new ArrayList();

    public List<ResidentialQuarters> getQlist() {
        return qlist;
    }

    public void setQlist(List<ResidentialQuarters> qlist) {
        this.qlist = qlist;
    }

    public Integer getQuarterId() {
        return quarterId;
    }

    public void setQuarterId(Integer quarterId) {
        this.quarterId = quarterId;
    }
     


    public String getQuarterType() {
        return quarterType;
    }

    public void setQuarterType(String quarterType) {
        this.quarterType = quarterType;
    }

    public String getQuarterCode() {
        return quarterCode;
    }

    public void setQuarterCode(String quarterCode) {
        this.quarterCode = quarterCode;
    }
     
     
     
}
