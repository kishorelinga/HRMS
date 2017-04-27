/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.dto;

import com.hrms.model.DeductionRules;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NSG
 */
public class DeductionForm {
        private Integer deductionRuleId;
        private String empGrade;
        private Integer flatDeductionAmount;
        private Float basicRate;
        private List<DeductionRules> dlist=new ArrayList();

    public List<DeductionRules> getDlist() {
        return dlist;
    }

    public void setDlist(List<DeductionRules> dlist) {
        this.dlist = dlist;
    }

    public Integer getDeductionRuleId() {
        return deductionRuleId;
    }

    public void setDeductionRuleId(Integer deductionRuleId) {
        this.deductionRuleId = deductionRuleId;
    }
     
 

    public String getEmpGrade() {
        return empGrade;
    }

    public void setEmpGrade(String empGrade) {
        this.empGrade = empGrade;
    }

    public Integer getFlatDeductionAmount() {
        return flatDeductionAmount;
    }

    public void setFlatDeductionAmount(Integer flatDeductionAmount) {
        this.flatDeductionAmount = flatDeductionAmount;
    }

    public Float getBasicRate() {
        return basicRate;
    }

    public void setBasicRate(Float basicRate) {
        this.basicRate = basicRate;
    }

  
     
}
