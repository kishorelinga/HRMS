/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.struts;

import com.hrms.dto.IncentivesForm;
import com.hrms.manager.IncentivesManager;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NSG
 */
public class IncentivesAction extends ActionSupport
{
     IncentivesManager im=new IncentivesManager();
    private  IncentivesForm form;
    private static int a,b,c,d,e,f;

    public IncentivesForm getForm() {
        return form;
    }

    public void setForm(IncentivesForm form) {
        this.form = form;
    }
    
    
    
    private static List<IncentivesForm> incentiveList=new ArrayList<>();
    private List<String> ruleIdList=new ArrayList<>();
    private static int id1;

    public List<IncentivesForm> getIncentiveList() {
        return incentiveList;
    }

    public void setIncentiveList(List<IncentivesForm> incentiveList) {
        this.incentiveList = incentiveList;
    }

   

    public List<String> getRuleIdList() {
        return ruleIdList;
    }

    public void setRuleIdList(List<String> ruleIdList) {
        this.ruleIdList = ruleIdList;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    
    
    
    public IncentivesAction() {
    }
    public String incentiveEnroll()
    {
        ruleIdList=im.getruleid();
        return "success";
    }
    public String incentiveInsert()
    {
        im.insertIncentive(getForm());
        incentiveList=im.displayIncentive();
        return "success";
    }
    public String incentiveDisplay()
    {
        System.out.println("--------------incent--dgfdgd8528528\\\\\\\\g-----654646------------");
        incentiveList=im.displayIncentive();
        return "success";
    }
    public String incentiveDelete()
    {
        im.deleteIncentive(getId1());
        incentiveList=im.displayIncentive();
        return "success";
    }
    public String incentiveEdit()
    {
         System.out.println("--------------trivsssss--dgfdgdg-----654646------------");
        incentiveList=im.editIncentive(getId1());
        return "success";
    }
//    public String updateIncent()
//    {
//        System.out.println("--------------incent-------654646------------");
//        im.updateIncentive(getForm(),getId1());
//        incentiveList=im.displayIncentive();
//        return "success";
//    }
    public String updateIncentives(){
        System.out.println("--------------swaaaaa-------654646-----------");
        
        im.updateIncentive(getForm(),getId1());
        incentiveList=im.displayIncentive();
        return "success";
    }
    public String dgfhgfdsg(){
          System.out.println("--------------saranya-------654646-----------");
            System.out.println("--------------incent-------654646-----------");
          return "success";
    }
     @Override
    public String execute(){
          System.out.println("--------------masrath-------654646-----------");
            System.out.println("--------------incent-------654646-----------");
          return "success";
    }
    
     @Override
    public void validate()
    {
        try
        {
          
           incentiveList=im.editIncentive(getId1());  
            System.out.println("validaaaaaaaaaaaateeeee//////////////////");
          
            
            
           if (im.validateUserIncentives(getForm())) {
               System.out.println("validdddddddddddddddddate");
                 f++;
                    if (f % 2 != 0) {
                         addFieldError("form.empId", "Already Employee added in this month");
                         
                    } else {
                        addFieldError("form.empId", "");
                       f = 0;
                    }
            }
            if(form.getIncentiveCode().length()== 0)
            {
               
                addFieldError("form.incentiveCode", "Incentive Code is required");
            }
              System.out.println("--------------masrath-------654646-----------");
              if( !im.validEmpwage(getForm())){
                     System.out.println("dkjg---------fhgfh//////////----------ksjf=============5464");
                      addFieldError("form.empId", "please fill in wages");
                 }
            if(form.getIncentiveId() == 0)
            {
                addFieldError("form.incentiveId", "Incentive id is required");
            }
            if(form.getIncentiveName().length() == 0)
            {
                addFieldError("form.incentiveName", "Incentive Name is required");
            }
              System.out.println("dkh--------------dk=====----------");
                 if(!im.validEmpded(getForm()))
                 {
                      System.out.println("dkjg-------------------ksjf=============5464");
                     addFieldError("form.empId", "please fill in deduction master");
                      
                 }
                 
            if(form.getInc() == 0)
            {
                addFieldError("form.inc", "Incentive  is required");
            }
            if(form.getDays() == 0)
            {
                addFieldError("form.days", "No. of days worked  is required");
            }
            
            
            if(form.getEmpId() == null)
            {
                addFieldError("form.empId", "Employee Id is required");
            }
             if (!im.validEmp(getForm())) 
            {
                System.out.println("dkh--------------dk=====----------");
               addFieldError("form.empId", "Select valid Employee Id");
                   
            }
            
             
            
          
        }
        catch(Exception e)
        {
            
        }
    }
    
}
