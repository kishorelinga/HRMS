/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.struts;

import com.hrms.dto.Deductions;
import com.hrms.manager.DeductionManager;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Masrat
 */
public class DeductionAction extends ActionSupport{
    private Deductions deduc;
    private DeductionManager dm=new DeductionManager();
    private List<String> dedlist=new ArrayList<>();
    private static List<Deductions> listofdeducs=new ArrayList<>();
    private static int id;
    private String m="dfgdgdg";
    private static int a,b,c,d,e,f,g,h,z,i;
    

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }
   
    public Deductions getDeduc() {
        return deduc;
    }

    public void setDeduc(Deductions deduc) {
        this.deduc = deduc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Deductions> getListofdeducs() {
        return listofdeducs;
    }

    public void setListofdeducs(List<Deductions> listofdeducs) {
        this.listofdeducs = listofdeducs;
    }

    public List<String> getDedlist() {
        return dedlist;
    }

    public void setDedlist(List<String> dedlist) {
        this.dedlist = dedlist;
    }
    public String getDudid(){
        dedlist=dm.getDedId();
        return SUCCESS;
    }
    public String getDedList(){
        listofdeducs=dm.getDeduList();
        return SUCCESS;
    }
    public String addDeduction(){
        z=0;
        dm.addDeductions(getDeduc());
        return SUCCESS;
    }
    public String deleteDeduction(){
        dm.deleteDeductions(getId());
        return SUCCESS;
    }
    public String editDeduction(){
        z++;
        System.out.println("----"+getId());
        listofdeducs=dm.editDeductions(getId());
        
        // dedlist=dm.getDedId();
        return SUCCESS;
    }
    public String updateDeduction(){
        dm.updateDeductions(getDeduc(),getId());
        return SUCCESS;
      
    }
   
    
    
    @Override
    public void validate(){
       // dedlist=dm.getDedId();
      
        if(getDeduc()!=null)
        {
            if(!(deduc.getDeductionId()==0&&deduc.getGas()==0&&deduc.getTea()==0&&deduc.getTiffin()==0&&
           deduc.getSalaryAdvance()==0&&deduc.getStore()==0&&deduc.getMeals()==0&&deduc.getMedicines()==0
   &&deduc.getPf()==0&&deduc.getPfNum()==0&&deduc.getPower()==0&&deduc.getPpp()==0&&deduc.getAdv2()==0&&
   deduc.getCable()==0&&deduc.getEggs()==0&&deduc.getDeductionName().length()==0&&deduc.getUniform()==0&&
             deduc.getEmpId()==0&&deduc.getDeductionCode().length()==0&&deduc.getDeductionRuleId()==-1))
            {
            if(deduc.getDeductionId()==0){
              
                    a++;
                    if (a % 2 != 0) {
                          addFieldError("deduc.deductionId", "Enter Deduction Id");
                         
                    } else {
                        addFieldError("deduc.deductionId", "");
                       a = 0;
                    }
            }
            
            else if(deduc.getDeductionId()!=0){
              if(z==0){
                    h++;
                    if (h % 2 != 0) {
                        if(dm.checkdd(deduc.getDeductionId()))
                          addFieldError("deduc.deductionId", "Deduction Id already exists. Give another Id");
                         
                    } else {
                        addFieldError("deduc.deductionId", "");
                       h = 0;
                    }
            }
            }
            
            if(deduc.getDeductionName().length()==0){
               
                     b++;
                    if (b % 2 != 0) {
                        addFieldError("deduc.deductionName", "Deduction name is Required");
                         
                    } else {
                        addFieldError("deduc.deductionName", "");
                       b = 0;
                    }
	
            }
            if(deduc.getDeductionCode().length()==0){
               
                    c++;
                    if (c % 2 != 0) {
                         addFieldError("deduc.deductionCode", "Deduction Code is Required");
                         
                    } else {
                        addFieldError("deduc.deductionCode", "");
                       c = 0;
                    }
            }
            if(deduc.getDeductionRuleId()==-1){
              
                    d++;
                    if (d % 2 != 0) {
                          addFieldError("deduc.deductionRuleId", "Select Deduction Rule Id");
                         
                    } else {
                        addFieldError("deduc.deductionRuleId", "");
                       d = 0;
                    }
            }
             if(deduc.getEmpId()==0){
              
                    f++;
                    if (f % 2 != 0) {
                          addFieldError("deduc.empId", "Employee Id is required");
                         
                    } else {
                        addFieldError("deduc.empId", "");
                       f = 0;
                    }
            }
              if (dm.validateDeductionlist(getDeduc())) {
               System.out.println("sssssssssssssssssss");
                 i++;
                    if (i % 2 != 0) {
                         addFieldError("deduc.empId", "Already Employee added in this month");
                         
                    } else {
                        addFieldError("deduc.empId", "");
                       i = 0;
                    }
            }
            else if(deduc.getEmpId()!=0){
                 System.out.println("=----------------------------=+++=---------------");
                    g++;
                    if (g % 2 != 0) {
                        if(dm.checkId(deduc.getEmpId()))
                          addFieldError("deduc.empId", "No Employee with Id "+deduc.getEmpId()+". Enter valid Id");
                        else{
                            if(z==0){
                                 System.out.println("=----------------0000------------=+++=---------------");
                           }
                        }
                    } else {
                        addFieldError("deduc.empId", "");
                       g = 0;
                    }
            }
             
        }
            else{
                e++;
                    if (e % 2 != 0) {
                          addFieldError("deduc.empId", "Please fill the form");
                         
                    } else {
                        addFieldError("deduc.empId", "");
                       e = 0;
                    }
            }
            
        }
    }
}
