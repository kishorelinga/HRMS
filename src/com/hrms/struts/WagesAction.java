/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.struts;

import com.hrms.dto.WagesForm;
import com.hrms.manager.WagesManager;
import com.hrms.model.Wages;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NSG
 */
public class WagesAction extends ActionSupport 
{
    WagesManager wg=new WagesManager();
    private  WagesForm form;
    public WagesForm getForm() {
        return form;
    }
    public void setForm(WagesForm form) {
        this.form = form;
    }
    
    private static List<WagesForm> wageList=new ArrayList<>();
    private List<String> wageIdList=new ArrayList<>();
    private List<String> empIdList=new ArrayList<>();
    private static int id1;

    public int getId1() {
        return id1;
    }
    public void setId1(int id1) {
        this.id1 = id1;
    } 
    
    public List<WagesForm> getWageList() {
        return wageList;
    }
    public void setWageList(List<WagesForm> wageList) {
        this.wageList = wageList;
    }
    
    public List<String> getWageIdList() {
        return wageIdList;
    }
    public void setWageIdList(List<String> wageIdList) {
        this.wageIdList = wageIdList;
    }

    public List<String> getEmpIdList() {
        return empIdList;
    }
    public void setEmpIdList(List<String> empIdList) {
        this.empIdList = empIdList;
    }
    
    
    public WagesAction() {
    }
    public String wageEnroll()
    {
        wageIdList=wg.getWageId();
        return "success";
    }
    public String wageInsert()
    {
        wg.insertWage(getForm());
        wageList=wg.displayWage();
        return "success";
    }
    public String wageDisplay()
    {
        wageList=wg.displayWage();
        return "success";
    }
    public String wageDelete()
    {
        wg.deleteWage(getId1());
        wageList=wg.displayWage();
        return "success";
    }
    public String wageEdit()
    {
        wageList=wg.editWage(getId1());
        return "success";
    }
    public String wageUpdate()
    {
        wg.updateWage(getForm(),getId1());
        wageList=wg.displayWage();
        return "success";
    }
    
    public void validate()
    {
        wageIdList=wg.getWageId();
        try
        {
            if(form.getWageId().equals("-1"))
            {
                addFieldError("form.wageId", "Please select Wage Id");
            }
            if(form.getBasicRate() == null)
            {
                addFieldError("form.basicRate", "Basic Rate is required");
            }
            if(form.getEffectiveDate().length()== 0)
            {
                addFieldError("form.effectiveDate", "Effective Date is required");
            }
            if(form.getEmpId() == null)
            {
                addFieldError("form.empId", "Employee Id is required");
            }
            else if (!wg.validEmp(getForm())) 
            {
               addFieldError("form.empId", "Select valid Employee Id");
            }
            
          }
        catch(Exception e)
        {
            //System.out.println("\n exception");
        }
        
    }
}
