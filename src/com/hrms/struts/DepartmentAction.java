/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.struts;

import com.hrms.dto.DepartmentForm;
import com.hrms.manager.DepartmentManager;
import com.hrms.model.Departments;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NSG
 */
public class DepartmentAction extends ActionSupport {
    private DepartmentManager dm;
    DepartmentManager dmr=new DepartmentManager();
    private static int check, a, b, c, d;

    public DepartmentManager getDmr() {
        return dmr;
    }

    public void setDmr(DepartmentManager dmr) {
        this.dmr = dmr;
    }
    
    
    public DepartmentAction() {
        dm=new DepartmentManager();
    }
    private DepartmentForm df;
    private static List<DepartmentForm> dept=new ArrayList<>();
    private int id1;
    private static int z=0;

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }
    

    public List<DepartmentForm> getDept() {
        return dept;
    }

    public void setDept(List<DepartmentForm> dept) {
        this.dept = dept;
    }

    public DepartmentForm getDf() {
        return df;
    }

    public void setDf(DepartmentForm df) {
        this.df = df;
    }

    public DepartmentManager getDm() {
        return dm;
    }

    public void setDm(DepartmentManager dm) {
        this.dm = dm;
    }
    
    
    public String execute()  {
       return "success";
    }
    public String insertDept(){
        dm.insertDepartment(getDf());
        dept=dmr.displayDepartment();
        return "success";
    }
    public String displayDept(){
        dept=dmr.displayDepartment();
        return "success";
    }
    public String deleteDept(){
        dm.deleteDepartment(getId1());
        dept=dmr.displayDepartment();
        return "success";
    }
   public String editDept(){
       z++;
       dept=dmr.editDepartment(getId1());
       return "success";
   }
   public String updateDept(){
       dm.updateDepartment(getDf());
       dept=dmr.displayDepartment();
       return "success";
   }
   public void validate(){
     {
        
        try{
          
          if(!(df.getDeptId()== null && df.getDeptName().length()==0 && df.getDeptScope().length()==0))
          {
              if(df.getDeptId()==null)
              {
                  a++;
                  if(a%2!=0)
                  {
                      addFieldError("df.deptId", "Department Id is required");
                  }
                  else
                  {
                      addFieldError("df.deptId", "");
                      a=0;
                  }
                  
              }
              if(df.getDeptName().length()==0)
              {
                  b++;
                  if(b%2!=0)
                  {
                      addFieldError("df.deptName", "Department Name is required");
                  }
                  else
                  {
                      addFieldError("df.deptName", "");
                      b=0;
                  }
              }
              else if(!(df.getDeptName().matches("^[a-zA-Z ]*$")))
              {
                  d++;
                  if(d%2 !=0)
                  {
                      addFieldError("df.deptName","Only alphabets are allowed");
                  }
                  else
                  {
                      addFieldError("df.deptName","");
                      d=0;
                  }
              }
              if(df.getDeptScope().length()==0)
              {
                  c++;
                  if(c%2!=0)
                  {
                      addFieldError("df.deptScope", "Department Scope is required");
                  }
                  else
                  {
                      addFieldError("df.deptScope", "");
                      c=0;
                  }
              }
          }
          else
          {
              check++;
              if(check%2 !=0)
              {
              addFieldError("df.deptId", "please fill all fields");
              }
              else
              {
                  addFieldError("form.deptId", "");
                  check=0;
              }
          }
            if(z==0){
                for (Object sub : dept) 
                {
                    Departments dr=(Departments) sub;
                    if(df.getDeptId()==dr.getDeptId()){
                        addFieldError("df.deptId", "Department Id already exists");
                    }
                    if(df.getDeptName().equals(dr.getDeptName())){
                        addFieldError("dr.deptName", "Department Name already exists");
                    }
                }
            }
        }
        
     catch(Exception e){
             
             }
   }
}
}

