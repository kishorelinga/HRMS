/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.struts;

import com.hrms.dto.Masterwagedto;
import com.hrms.manager.MasterManager;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Swathi
 */
public class masterstrutswage  extends ActionSupport{
    
     private  List emplist;
    private List wagecallist;
    private MasterManager mmanger;
    private Masterwagedto master;
    private int wageId;
    private List editList;
    private static int a,b,c;

    public List getEmplist() {
        return emplist;
    }

    public void setEmplist(List emplist) {
        this.emplist = emplist;
    }

    public List getWagecallist() {
        return wagecallist;
    }

    public void setWagecallist(List wagecallist) {
        this.wagecallist = wagecallist;
    }

    public MasterManager getMmanger() {
        return mmanger;
    }

    public void setMmanger(MasterManager mmanger) {
        this.mmanger = mmanger;
    }

    public Masterwagedto getMaster() {
        return master;
    }

    public void setMaster(Masterwagedto master) {
        this.master = master;
    }

    public int getWageId() {
        return wageId;
    }

    public void setWageId(int wageId) {
        this.wageId = wageId;
    }

    public List getEditList() {
        return editList;
    }

    public void setEditList(List editList) {
        this.editList = editList;
    }

    public masterstrutswage() {
        mmanger=new MasterManager();
         emplist=new ArrayList();
        wagecallist=new ArrayList();
        master=new Masterwagedto();
    }
    
    
    
    
    
    
    
    
    
     public  String refreshpage() {
           emplist=mmanger.listwagedef();
        System.out.println("jsdhfsjdfdsf");
        return "success";
    }
     
     
     
     
      public String emptype() {
       
        return "success";
    }
    public String wagedefpage() {
     //   z=0;
        emplist=mmanger.employee_type();
        wagecallist=mmanger.wageCal();
        return "success";
    }
    public String insertWagedef() {
       mmanger.insertWagemaster(getMaster());
       emplist=mmanger.listwagedef();
        return "success";
    }
    
     public String deleteWage() {
       mmanger.delete(getWageId());
       emplist=mmanger.listwagedef();
        return "success";
    }
    public String editWage() {
    //    z++;
        emplist=mmanger.employee_type();
        wagecallist=mmanger.wageCal();
        this.editList=mmanger.editWage(getWageId());
        return "success";
    }
    public String updateWage() {
        mmanger.updateWage(getMaster());
        emplist=mmanger.listwagedef();
        return "success";
    }

    @Override
    public void validate() {
        
        try {
             emplist=mmanger.employee_type();
            wagecallist=mmanger.wageCal();
            if(getMaster()!=null) {
                if (master.getEmptype().equals("-1")) { 
                    a++;
                    if(a%2!=0) {
                          addFieldError("master.emptype", "Please select status");
                    }
                    else {
                        addFieldError("master.emptype", ""); 
                        a=0;
                    }
                }
       if(master.getWageid()==null || master.getWageid()==0 || master.getWageid().equals("")) {
                       b++;
                        if(b%2!=0) {
                        addFieldError("master.wageid", "Wage Id  is required"); 
                        }
                        else {
                              addFieldError("master.wageid", ""); 
                              b=0;
                        }
                    }
      if (master.getWagetype().equals("-1")) {
                         c++;
                         if(c%2!=0) {
                               addFieldError("master.wagetype", "Please select wage calculation type");
                         }
                         else {
                               addFieldError("master.wagetype", "");
                               c=0;
                         }
                     }
                    
                }
            
            
            
       
        }
        catch(Exception e) {
            
        }
    }
    
}
