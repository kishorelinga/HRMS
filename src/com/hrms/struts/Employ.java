/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.struts;

import com.hrms.dto.EmployeeForm;
import com.hrms.manager.EmployMananger;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nsg
 */
public class Employ  extends ActionSupport{
    private EmployeeForm empf;
    private EmployMananger em=new EmployMananger();
    private static List<EmployeeForm> emp=new ArrayList<>();
     private int id;
     private  static int c,d,e;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public List<EmployeeForm> getEmp() {
        return emp;
    }

    public void setEmp(List<EmployeeForm> emp) {
        this.emp = emp;
    }
    
    
    public EmployeeForm getEmpf() {
        return empf;
    }

    public void setEmpf(EmployeeForm empf) {
        this.empf = empf;
    }
     public String insert1(){
        System.out.println("========+++++++++++++========");
        em.insertemp(getEmpf());
        emp=em.EmployeeTypeDisplay();
        return SUCCESS;
    }
     public String displayEmpType(){
        emp=em.EmployeeTypeDisplay();
        return "success";
     }
      public String editemp(){
        emp=em.editEmployee(getId());
        return "success";
   }
   public String updateemp(){
        em.updateemployee(getEmpf());
        emp=em.EmployeeTypeDisplay();
        return "success";
   }
   
    public String deleteemp(){
         em.deleteEmployee(getId());
         emp=em.EmployeeTypeDisplay();
         return "success";
    }
    
    public String Reset1(){
        super.clearErrorsAndMessages();
        return "success";
    }
    
    public void validate()
    {
         
        try
        {
            if(empf.getEmpTypeId()==0)
            {
                
                 c++;
                    if (c % 2 != 0) {
                         addFieldError("empf.empTypeId", "Please provide Employee Type Id");
                         
                    } else {
                        addFieldError("empf.empTypeId", "");
                       c = 0;
                    }
                
            }
            
          else  if(empf.getDescription().length()==0)
            {
               
                d++;
                    if (d % 2 != 0) {
                         addFieldError("empf.description", "Please provide Description");
                         
                    } else {
                        addFieldError("empf.description", "");
                       d = 0;
                    }
                
                
            }
            
            
            
             else if(!(empf.getDescription().matches("^[a-zA-Z ]*$")))
            {
               
                e++;
                    if (e % 2 != 0) {
                         addFieldError("empf.description", "Only alphabets are allowed");
                         
                    } else {
                        addFieldError("empf.description", "");
                       e = 0;
                    }
                
                
            }
            
            
          
        }
        catch(Exception e)
        {
            System.out.println("\n Exception during validation"+e);
        }
    }
}

