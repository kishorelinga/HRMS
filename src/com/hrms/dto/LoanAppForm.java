/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.dto;

import com.hrms.model.LoanEligibility;
import com.hrms.model.LoansMaster;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NSG
 */
public class LoanAppForm {
    
    private int loanId;
    private String loanTypeName;
    private String empGrade;
    private LoanEligibility loanEligibility;
    private List<LoansMaster> loan=new ArrayList();
    private String eligibilityRuleId;

    public String getEligibilityRuleId() {
        return eligibilityRuleId;
    }

    public void setEligibilityRuleId(String eligibilityRuleId) {
        this.eligibilityRuleId = eligibilityRuleId;
    }
   
    public List<LoansMaster> getLoan() {
        return loan;
    }

    public void setLoan(List<LoansMaster> loan) {
        this.loan = loan;
    }

    public LoanEligibility getLoanEligibility() {
        return loanEligibility;
    }

    public void setLoanEligibility(LoanEligibility loanEligibility) {
        this.loanEligibility = loanEligibility;
    }
     
    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public String getLoanTypeName() {
        return loanTypeName;
    }

    public void setLoanTypeName(String loanTypeName) {
        this.loanTypeName = loanTypeName;
    }

    public String getEmpGrade() {
        return empGrade;
    }

    public void setEmpGrade(String empGrade) {
        this.empGrade = empGrade;
    }
    
}
