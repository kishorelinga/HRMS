/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.dto;

import com.hrms.model.OtPayoutSchedule;
import com.hrms.model.WageDefinitions;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NSG
 */
public class OtPayoutForm 
{
     private Integer id;
     private WageDefinitions wageDefinitions;
     private Integer payoutDays;
     private String wageId;

    public String getWageId() {
        return wageId;
    }

    public void setWageId(String wageId) {
        this.wageId = wageId;
    }

    
 
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public WageDefinitions getWageDefinitions() {
        return wageDefinitions;
    }

    public void setWageDefinitions(WageDefinitions wageDefinitions) {
        this.wageDefinitions = wageDefinitions;
    }

    public Integer getPayoutDays() {
        return payoutDays;
    }

    public void setPayoutDays(Integer payoutDays) {
        this.payoutDays = payoutDays;
    }
     
     
}
