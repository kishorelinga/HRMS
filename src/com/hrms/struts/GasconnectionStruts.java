/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.struts;

import com.hrms.dto.Gasdto;
import com.hrms.dto.Quarterdto;
import com.hrms.manager.GasManager;
import com.hrms.model.GasConnectionMaster;
import com.opensymphony.xwork2.ActionSupport;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Swathi
 */
public class GasconnectionStruts extends ActionSupport{
  //  private Quarterdto object;
    private Gasdto object;
   // private Gasdto residentialQuarters;
  
    private GasManager gmanager;
    private static List glist;
    private List qlist;
    private static int a,b,c;
  //  private int empId;

    public Gasdto getObject() {
        return object;
    }

    public void setObject(Gasdto object) {
        this.object = object;
    }
    
   
   
    public List getQlist() {
        return qlist;
    }

    public void setQlist(List qlist) {
        this.qlist = qlist;
    }

    public List getGlist() {
        return glist;
    }

    public void setGlist(List glist) {
        this.glist = glist;
    }

    public GasManager getGmanager() {
        return gmanager;
    }

    public void setGmanager(GasManager gmanager) {
        this.gmanager = gmanager;
    }
    
    
    public GasconnectionStruts() {
        gmanager=new GasManager();
        glist=new ArrayList();
    }
    public String search() {
       
 if(!gmanager.searchEmp(getObject())) {
        if(gmanager.searchEmployeee(getObject())) { 
                this.glist=gmanager.searchEmployee(getObject());
           qlist=new ArrayList();
          this.qlist=gmanager.consumerno(getObject());         
       //   this.qlist=gmanager.ConsumerNumber(getObject());
         return "success";}
         else 
             addFieldError("object.empId","Select a valid Employee Id");   }
        else
             addFieldError("object.empId","Connection is already given"); 
          
            return "fail"; 
    }
    public String insertgas() {
    
      
        gmanager.insert(getObject());
        return "success";
    }
    
    
    
   
   GasManager m=new GasManager();
   private Gasdto d;
   private int id;
   private int empId;
   private int connectionId;
    List<GasConnectionMaster> glist1;

    public List<GasConnectionMaster> getGlist1() {
        return glist1;
    }

    public void setGlist1(List<GasConnectionMaster> glist1) {
        this.glist1 = glist1;
    }
    private static List list=new ArrayList();

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(int connectionId) {
        this.connectionId = connectionId;
    }
    
   
    public String list1()
    {
        this.glist1=gmanager.list1();
        return "success";
    }
    
     public String edit1()
    {
        this.list=gmanager.edit1(getEmpId());
        this.glist=gmanager.listEdit();
        return "success";
    }
   
    public String update1() throws ParseException, java.text.ParseException
    {
       gmanager.update1(getObject());
       return "success";
    }
    
   public String delete1()
    {
        gmanager.delete1(empId);
        return "success";
    }
   
    private int id1;

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }
   public String gasConnectionView()  {
       this.list=gmanager.gasView(getId1());
       return "success";
   }

    @Override
    public void validate() 
    {
        
        
       try {   
                this.glist=gmanager.listEdit();
            if(!gmanager.searchEmp(getObject())) {
           if(gmanager.searchEmployeee(getObject())) {
                this.glist=gmanager.searchEmployee(getObject());
        //   qlist=new ArrayList();
          this.qlist=gmanager.consumerno(getObject()); }}
          
           if(getObject()!=null) {
               if(object.getAlloteddate().length()==0) { 
                   a++;
                   if(a%2!=0) {
                        addFieldError("object.alloteddate", "Alloted date is must"); 
                   }
                   else {
                       addActionError("");   
                       a=0;
                   }
               }
           if(object.getConsumerno().equals("-1")) { 
                   b++;
                   if(b%2!=0) {
                        addFieldError("object.consumerno", "Consumer Number is must");
                   }
                   else {
                       addFieldError("object.consumerno", "");   
                       b=0;
                   }
               }
         
          if(object.getCloseddate().length()==0) { 
                   c++;
                   if(c%2!=0) {
                        addFieldError("object.closeddate", "Closed date is must");  
                   }
                   else {
                      addActionError("");   
                       c=0;
                   }
               }
               
               
         
           }
       }
       catch(Exception e) {
       }
       
      }
    }
    
