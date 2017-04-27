/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.struts;

import com.hrms.dto.LoanAppForm;
import com.hrms.manager.LoanAppManager;
import com.hrms.manager.LoanManager;
import com.hrms.model.LoansMaster;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NSG
 */
public class LoanAppAction extends ActionSupport {
    
    LoanAppManager l=new LoanAppManager();
    private LoanAppManager lm;
    
    public LoanAppAction() {
        lm=new LoanAppManager();
    }

    public LoanAppManager getLm() {
        return lm;
    }

    public void setLm(LoanAppManager lm) {
        this.lm = lm;
    }
    private LoanAppForm lform;
    
    public String execute() throws Exception {
        return "success";
    }
    private static List<LoanAppForm> loan=new ArrayList<>();
    private List<LoanAppForm> loan1=new ArrayList<>();
    private List<String> loanTypeList=new ArrayList<>();
    private List<String> loanEligibilityList=new ArrayList<>();
    private List<String> empGradeList=new ArrayList<>();
    private int id1;
    private  static int a,b,c,d,e,f,g;

    public List<LoanAppForm> getLoan1() {
        return loan1;
    }

    public void setLoan1(List<LoanAppForm> loan1) {
        this.loan1 = loan1;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }
    

    public List<String> getEmpGradeList() {
        return empGradeList;
    }

    public void setEmpGradeList(List<String> empGradeList) {
        this.empGradeList = empGradeList;
    }
    
    public List<String> getLoanEligibilityList() {
        return loanEligibilityList;
    }

    public void setLoanEligibilityList(List<String> loanEligibilityList) {
        this.loanEligibilityList = loanEligibilityList;
    }

    public LoanAppForm getLform() {
        return lform;
    }

    public void setLform(LoanAppForm lform) {
        this.lform = lform;
    }
    
    

    public List<LoanAppForm> getLoan() {
        return loan;
    }

    public void setLoan(List<LoanAppForm> loan) {
        this.loan = loan;
    }

    public List<String> getLoanTypeList() {
        return loanTypeList;
    }

    public void setLoanTypeList(List<String> loanTypeList) {
        this.loanTypeList = loanTypeList;
    }
    private static int z=0;
    public String expand(){
        z=0;
        loanEligibilityList=lm.getLoanEligibilityList();
        empGradeList=lm.getEmpGradeList();
        return "success";
    }
    public String loanInsert(){
        lm.insertLoan(getLform());
        loan=l.displayLoan();
        return "success";
    }
    public String loanDisplay(){
        System.out.println("111112164654654444444444444464789" +loan);
        loan=l.displayLoan();
        return "success";
    }
    public String loanDelete()
    {
        l.deleteLoan(getId1());
        loan=l.displayLoan();
        return "success";
    }
    public String loanEdit()
    {
        z++;
        loanEligibilityList=lm.getLoanEligibilityList();
        empGradeList=lm.getEmpGradeList();
        loan1=l.editLoan(getId1());
        return "success";
    }
    public String loanUpdate(){
        lm.updateLoan(getLform());
        loan=l.displayLoan();
        return "success";
    }
    public void validate(){
        super.validate();
        try
        {
            loanEligibilityList=lm.getLoanEligibilityList();
            empGradeList=lm.getEmpGradeList();
        if(!(lform.getLoanId()==0 && lform.getLoanTypeName().length()==0 && lform.getEligibilityRuleId().equals("-1") &&
                lform.getEmpGrade().equals("-1")))
        {
            if(lform.getLoanId()==0){
                a++;
                    if (a % 2 != 0) {
                         addFieldError("lform.loanId", "Loan Id is required");
                         
                    } else {
                        addFieldError("lform.loanId", "");
                       a = 0;
                    }
              
                
            }
            if(lform.getLoanTypeName().length()==0){

                    b++;
                    if (b % 2 != 0) {
                         addFieldError("lform.loanTypeName", "Loan Type Name is required");
                         
                    } else {
                        addFieldError("lform.loanTypeName", "");
                       b = 0;
                    }
       
             
                            }
            else if (!(lform.getLoanTypeName().matches("^[a-zA-Z ]*$"))) 
                {

                      c++;
                    if (c % 2 != 0) {
                         addFieldError("lform.loanTypeName", "Only alphabets are allowed");
                         
                    } else {
                        addFieldError("lform.loanTypeName", "");
                       c = 0;
                    }
                    
                }
            if(lform.getEligibilityRuleId().equals("-1")){

                  d++;
                    if (d % 2 != 0) {
                         addFieldError("lform.eligibilityRuleId", "Please select one");
                         
                    } else {
                        addFieldError("lform.eligibilityRuleId", "");
                       d = 0;
                    } 
                
            }
            if(lform.getEmpGrade().equals("-1")){

                   
                  e++;
                    if (e % 2 != 0) {
                          addFieldError("lform.empGrade", "Please choose one");
                         
                    } else {
                        addFieldError("lform.empGrade", "");
                       e = 0;
                    } 
               
            }
        }
        else
        {
            f++;
                    if (f % 2 != 0) {
                          addFieldError("lform.loanId", "Please Fill All Fields");
                         
                    } else {
                        addFieldError("lform.loanId", "");
                       f = 0;
                    } 
              
            
        }
       if(z==0)
            {
                for (Object sub : loan) 
                {
                    LoansMaster lmr=(LoansMaster) sub;
                    if(lform.getLoanId()==lmr.getLoanId()){

                         g++;
                    if (g % 2 != 0) {
                           addFieldError("lform.loanId", "Loan Id already exists");
                         
                    } else {
                        addFieldError("lform.loanId", "");
                       g = 0;
                    } 

                        
                    }
                    
                }
            }
        }
        catch(Exception e){
            
        }
    }
}
