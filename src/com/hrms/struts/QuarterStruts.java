/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.struts;

import com.hrms.dto.Quarterdto;
import com.hrms.manager.QuarterManager;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Swathi
 */
public class QuarterStruts extends ActionSupport{
    private QuarterManager qmanager;
    private List qlist;
    private int quarterId;
    private Quarterdto object;
    private static List qlist1;
    private int count;   
    private int count1;
    private List quarterslist;
    private int id;
    private static List qlist2;
    private List qlist3;
    private int empId;
    private static int a,b,c;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public List getQlist3() {
        return qlist3;
    }

    public void setQlist3(List qlist3) {
        this.qlist3 = qlist3;
    }
   

    public List getQlist2() {
        return qlist2;
    }

    public void setQlist2(List qlist2) {
        this.qlist2 = qlist2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuarterId() {
        return quarterId;
    }

    public void setQuarterId(int quarterId) {
        this.quarterId = quarterId;
    }

    public List getQuarterslist() {
        return quarterslist;
    }

    public void setQuarterslist(List quarterslist) {
        this.quarterslist = quarterslist;
    }

    public int getCount1() {
        return count1;
    }

    public void setCount1(int count1) {
        this.count1 = count1;
    }

    

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List getQlist1() {
        return qlist1;
    }

    public void setQlist1(List qlist1) {
        this.qlist1 = qlist1;
    }

    public Quarterdto getObject() {
        return object;
    }

    public void setObject(Quarterdto object) {
        this.object = object;
    }

    public List getQlist() {
        return qlist;
    }

    public void setQlist(List qlist) {
        this.qlist = qlist;
    }

    public QuarterManager getQmanager() {
        return qmanager;
    }

    public void setQmanager(QuarterManager qmanager) {
        this.qmanager = qmanager;
    }

    public QuarterStruts() {
       qmanager=new QuarterManager();
       quarterslist=new ArrayList();
    }
    public  String list() {
        qlist=qmanager.list();
        return "success";
    }
     public String delete()
    {
       // System.out.println(getEmpId());
        qmanager.delete(getQuarterId());
        return "success";
    }
     private Quarterdto employeeProfile;

    public Quarterdto getEmployeeProfile() {
        return employeeProfile;
    }

    public void setEmployeeProfile(Quarterdto employeeProfile) {
        this.employeeProfile = employeeProfile;
    }
     public  String edit() {
         this.qlist1=qmanager.edit(getEmpId());  
        
         this.qlist3=qmanager.listEdit();
         System.out.println(qlist3);
         return "success";
     }
     public String update() throws ParseException {
        // if(qmanager.searchQuarterEdit(getObject())) { 
          //    this.qlist2=qmanager.edit(getId()); 
          //    addFieldError("object.quarterId","select a valid emp id");   
      //   return "fail";   }
       //  else
            qmanager.update(getObject());
         return "success";
        
     }
     public String search() throws SQLException 
     {
         if(!qmanager.searchQuarter(getObject())) {
        if(qmanager.searchEmployeee(getObject())) { 
           this.qlist1=qmanager.searchEmployee(getObject());
            this.count=qmanager.count(getObject());
            this.count1=qmanager.count1(getObject());
          quarterslist=new ArrayList();     
    this.quarterslist=qmanager.quarterCode(getObject());
        return "success";} 
         else
             addFieldError("object.empId","Select a valid Employee Id"); }
        else 
             addFieldError("object.empId","Quarter is already Alloted");      
            return "fail";      
       
     }
     public  String insertQuarter() throws ParseException {
         
         qmanager.insertQuarters(getObject());
         return "success";
     }
     
      private int id1;

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }
     public String quarterView() {
         this.quarterslist=qmanager.viewEmployee(getId1());
         return "success";
     }
     

    @Override
    public void validate() {
        
      try {   
          this.qlist1=qmanager.edit(getEmpId());  
          
           if(!qmanager.searchQuarter(getObject())) {
          if(qmanager.searchEmployeee(getObject())) { 
           this.qlist1=qmanager.searchEmployee(getObject());
            this.count=qmanager.count(getObject());
            this.count1=qmanager.count1(getObject());
          quarterslist=new ArrayList();     
    this.quarterslist=qmanager.quarterCode(getObject());
        }}
           if(getObject()!=null) {
               if(object.getDoissued().length()==0) { 
                   a++;
                   if(a%2!=0) {
                        addFieldError("object.doissued", "Date of issuing  is required");  
                   }
                   else {
                       addActionError("");
                       a=0;
                   }
               }
                if (object.getQuartercode().equals("-1"))  { 
                   b++;
                   if(b%2!=0) {
                        addFieldError("object.quartercode", "Please select quarter code");  
                   }
                   else {
                       addFieldError("object.quartercode", "");   
                       b=0;
                   }
               }
               
           }
      }
     
        catch(Exception ex) {
                
                }
        
      
    }
     
     
    
}
