 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.dto;

import com.hrms.model.GasConnectionMaster;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author NSG
 */
public class GasConnectionMasterForm 
{
     private Integer connectionId;
     private String gasCompanyName;
     private Integer gasStoveId;
     private Integer gasConnectionAmount;
     private String gasCylinderCount;
     private String consumerNumber;
     private String gasConnectionHolderName;
     private String gasConnectionValidateDate;
     private Set gasAllotments = new HashSet(0);
     
     private List<GasConnectionMaster> masterList=new ArrayList<>();

    public List<GasConnectionMaster> getMasterList() {
        return masterList;
    }

    public void setMasterList(List<GasConnectionMaster> masterList) {
        this.masterList = masterList;
    }

    public Integer getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(Integer connectionId) {
        this.connectionId = connectionId;
    }

    public String getConsumerNumber() {
        return consumerNumber;
    }

    public void setConsumerNumber(String consumerNumber) {
        this.consumerNumber = consumerNumber;
    }

    
     

    public String getGasCompanyName() {
        return gasCompanyName;
    }

    public void setGasCompanyName(String gasCompanyName) {
        this.gasCompanyName = gasCompanyName;
    }

    public Integer getGasStoveId() {
        return gasStoveId;
    }

    public void setGasStoveId(Integer gasStoveId) {
        this.gasStoveId = gasStoveId;
    }

    public Integer getGasConnectionAmount() {
        return gasConnectionAmount;
    }

    public void setGasConnectionAmount(Integer gasConnectionAmount) {
        this.gasConnectionAmount = gasConnectionAmount;
    }

    public String getGasCylinderCount() {
        return gasCylinderCount;
    }

    public void setGasCylinderCount(String gasCylinderCount) {
        this.gasCylinderCount = gasCylinderCount;
    }

    

    public String getGasConnectionHolderName() {
        return gasConnectionHolderName;
    }

    public void setGasConnectionHolderName(String gasConnectionHolderName) {
        this.gasConnectionHolderName = gasConnectionHolderName;
    }

    public String getGasConnectionValidateDate() {
        return gasConnectionValidateDate;
    }

    public void setGasConnectionValidateDate(String gasConnectionValidateDate) {
        this.gasConnectionValidateDate = gasConnectionValidateDate;
    }

   

    public Set getGasAllotments() {
        return gasAllotments;
    }

    public void setGasAllotments(Set gasAllotments) {
        this.gasAllotments = gasAllotments;
    }
     
     
}
