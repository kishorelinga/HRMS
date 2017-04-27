/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.struts;

import com.hrms.dto.DeductionForm;
import com.hrms.manager.DeductionRuleManager;
import com.hrms.model.DeductionRules;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NSG
 */
public class DeductionRuleAction extends ActionSupport {
    
    DeductionRuleManager d=new DeductionRuleManager();
    private DeductionRuleManager dm;
    
    public DeductionRuleAction() {
        dm=new DeductionRuleManager();
    }

    public DeductionRuleManager getD() {
        return d;
    }

    public void setD(DeductionRuleManager d) {
        this.d = d;
    }

    public DeductionRuleManager getDm() {
        return dm;
    }

    public void setDm(DeductionRuleManager dm) {
        this.dm = dm;
    }

    private DeductionForm dform;
    private static List<DeductionForm> dlist=new ArrayList<>();
    private List<String> gradeList=new ArrayList<>();
    private int id1;
    private static int z=0;
    private static int check,a,b,c,e;

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public DeductionForm getDform() {
        return dform;
    }

    public void setDform(DeductionForm dform) {
        this.dform = dform;
    }
    
    public List<DeductionForm> getDlist() {
        return dlist;
    }

    public void setDlist(List<DeductionForm> dlist) {
        this.dlist = dlist;
    }

    
    public List<String> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<String> gradeList) {
        this.gradeList = gradeList;
    }

    public String exhibit()
    {
        z=0;
        gradeList=d.getGradeList();
        return "success";
    } 
    public String execute() {
      
       return "success";
    }
    
    public String insertDeduction()
    {
        dm.deductionInsert(getDform());
        dlist=d.deductionDisplay();
        return "success";
    }
    public String displayDeduction(){
        dlist=d.deductionDisplay();
        return "success";
    }
    public String deleteDeduction(){
        d.deductionDelete(getId1());
        dlist=d.deductionDisplay();
        return "success";
    }
    public String editDeduction(){
        z++;
        gradeList=d.getGradeList();
        dlist=dm.deductionEdit(getId1());
        return "success";
    }
    public String updateDeduction(){
        dm.deductionUpdate(getDform());
        dlist=d.deductionDisplay();
        return "success";
    }
    public void validate(){
        try{
            gradeList=d.getGradeList();
            System.out.println("============..----------------"+dform.getDeductionRuleId());
            if(!( dform.getEmpGrade().equals("-1") && dform.getFlatDeductionAmount()==null && dform.getBasicRate()==null&& dform.getDeductionRuleId()==null))
            {
                if(dform.getDeductionRuleId()==null)
                {         
                    a++;
                    System.out.println("--------------aa-----------------"+a);
                    if (a % 2 != 0) {
                        addFieldError("dform.deductionRuleId", "Deduction Rule Id is required");
                        
                    } else {
                        addFieldError("dform.deductionRuleId", "");
                       a = 0;
                }
                }
                if(dform.getEmpGrade().equals("-1"))
                {
                    b++;
                    System.out.println("--------------aa-----------------"+a);
                    if (b % 2 != 0) {
                         addFieldError("dform.empGrade", "Emplyee Grade is required");
                        
                    } else {
                        addFieldError("dform.empGrade", "");
                       b = 0;
                }
                }  
                if(dform.getFlatDeductionAmount()==null)
                {
                    c++;
                    System.out.println("--------------aa-----------------"+c);
                    if (c % 2 != 0) {
                         addFieldError("dform.flatDeductionAmount", "Flat Deduction Amount is required");
                        
                    } else {
                       addFieldError("dform.flatDeductionAmount", "");
                       c= 0;
                }
                    
                }
                if(dform.getBasicRate()==null) 
                {
                   
                     e++;
                    System.out.println("--------------aa-----------------"+e);
                    if (e % 2 != 0) {
                         addFieldError("dform.basicRate", "Basic Rate is required");
                        
                    } else {
                        addFieldError("dform.basicRate", "");
                       e= 0;
                }
                    
                }
            } 
            else
            {
                
                check++;
                if (check % 2 != 0) {
                    addFieldError("dform.deductionRuleId", "Please Fill All Fields");

                    System.out.println("-----------------...>" + check);
                } else {
                    addFieldError("dform.deductionRuleId", "");
                    check = 0;
                    System.out.println("---------++++++++++--------...>" + check);
                    // addActionError("hello");
                }
            }
            if(z==0){
            for(Object ob: dlist)
            {
                DeductionRules dr=(DeductionRules) ob;
                if(getDform().getDeductionRuleId()==dr.getDeductionRuleId())
                {
                    addFieldError("dform.deductionRuleId", "Deduction Rule Id already exists");
                }
            }
        }
        }
        catch(Exception e){
            
        }
    }
}
