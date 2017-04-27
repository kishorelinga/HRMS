/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.struts;

import com.hrms.dto.DependentsInfodto;
import com.hrms.manager.DependentsInfoManager;
import com.opensymphony.xwork2.ActionSupport;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author Swathi
 */
public class MasterDependentsInfostruts extends ActionSupport {
   private DependentsInfoManager dmanager;
   private DependentsInfodto depnt;
   private static List dlist;
   private List flist;
  private static int id1=0;

    public static int getId1() {
        return id1;
    }

    public static void setId1(int id1) {
        MasterDependentsInfostruts.id1 = id1;
    }
   
//    public int getId1() {
//        return id1;
//    }
//
//    public void setId1(int id1) {
//        this.id1 = id1;
//    }

    public List getFlist() {
        return flist;
    }

    public void setFlist(List flist) {
        this.flist = flist;
    }
   private int id;
   private DependentsInfodto form;

    public DependentsInfodto getForm() {
        return form;
    }

    public void setForm(DependentsInfodto form) {
        this.form = form;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List getDlist() {
        return dlist;
    }

    public void setDlist(List dlist) {
        this.dlist = dlist;
    }
    public DependentsInfodto getDepnt() {
        return depnt;
    }

    public void setDepnt(DependentsInfodto depnt) {
        this.depnt = depnt;
    }
    public DependentsInfoManager getDmanager() {
        return dmanager;
    }

    public void setDmanager(DependentsInfoManager dmanager) {
        this.dmanager = dmanager;
    }
    public String dependentsinfolist() {
       this.dlist=dmanager.list();
        return "success";
    }
    public String SearchEmployee() {
        return "success";
    }

    public MasterDependentsInfostruts() {
        dmanager=new DependentsInfoManager();
    }
    
    public String dependentsearch() {
        if(dmanager.searchDependent(getDepnt())) {
             return "success";
        }
        else 
            addFieldError("depnt.empId","Select a valid Employee Id"); 
            return "fail";
    }
    public String insertdependentsinfo() {
        dmanager.addDependent(getDepnt());
        return "success";
    }
    public String deleteDepinfo() {
        dmanager.delete(getId());
        this.dlist=dmanager.list();
        return  "success";
    }
    public String editdepinfo() {
      
        this.dlist=dmanager.edit(getId());
        return "success";
    }
     public String updatedep() throws ParseException { 
           this.dlist=dmanager.edit(getId());
         dmanager.updateDependent(getDepnt());
          this.dlist=dmanager.list();
         return "success";
     }
    
    private static int a,b,c,d;
    @Override
    public void validate() {
      
      try {      
          if(depnt!=null) {
              if(depnt.getName().length()==0 || depnt.getName()==null ||  depnt.getName().trim().equals("")) {
                  a++;
                  if(a%2!=0) {
                      addFieldError("depnt.name", "Name is required"); 
                  }
                  else {
                      addFieldError("depnt.name", ""); 
                      a=0;
                  }
              }
              else if(!depnt.getName().matches("^[a-zA-Z ]*$"))
              {
                  d++;
                  if(d%2 !=0)
                  {
                   addFieldError("depnt.name", "Only Alphabets are alloewd"); 
                  }
                  else
                  {
                      addFieldError("depnt.name", ""); 
                  }
              }
               if (depnt.getStatus().equals("-1")) {
                   b++;
                   if(b%2!=0) {
                        addFieldError("depnt.status", "Please select status");
                   }
                   else {
                        addFieldError("depnt.status", "");
                        b=0;
                   }
               }
               if(depnt.getAge()==null || depnt.getAge()==0) {
                   c++;
                   if(c%2!=0) {
                       addFieldError("depnt.age", "Age  is required");  
                   }
                   else {
                       addFieldError("depnt.age", "");  
                   }
               }
          }
          
           
           
      }
      catch(Exception e) {
          
      }
    } 
     
    
    
   }
