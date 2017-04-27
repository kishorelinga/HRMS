/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.struts;

import com.hrms.dto.ResidentialForm;
import com.hrms.manager.ResidentialManager;
import com.hrms.model.ResidentialQuarters;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NSG
 */
public class ResidentialAction extends ActionSupport {
    private ResidentialManager rm;
    ResidentialManager r=new ResidentialManager();

    public ResidentialManager getR() {
        return r;
    }

    public void setR(ResidentialManager r) {
        this.r = r;
    }
    
    private ResidentialForm rf;
    private static List<ResidentialForm> qlist=new ArrayList<>();
    private List<String> quarterList = new ArrayList<>();
    private int id1;
    private static int check, a, b, c,z,d,g;

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }
    

    public List<String> getQuarterList() {
        return quarterList;
    }

    public void setQuarterList(List<String> quarterList) {
        this.quarterList = quarterList;
    }

    
    public ResidentialManager getRm() {
        return rm;
    }

    public void setRm(ResidentialManager rm) {
        this.rm = rm;
    }

    public ResidentialForm getRf() {
        return rf;
    }

    public void setRf(ResidentialForm rf) {
        this.rf = rf;
    }

    public List<ResidentialForm> getQlist() {
        return qlist;
    }

    public void setQlist(List<ResidentialForm> qlist) {
        this.qlist = qlist;
    }
    
    
    public ResidentialAction() {
        rm=new ResidentialManager();
    }
    
    @Override
    public String execute() {
        
        return "success";
    }
    public String express(){
        z=0;
        quarterList=rm.getQuarterType();
    return "success";
}
    public String insertQuarter(){
        rm.quarterInsert(getRf());
        qlist=r.quarterDisplay();
        return "success";
    }
    public String displayQuarter(){
        qlist=r.quarterDisplay();
        return "success";
    }
    public String deleteQuarter(){
        rm.quarterDelete(getId1());
         qlist=r.quarterDisplay();
        return "success";
    }
    public String editQuarter(){
        z++;
        qlist=r.quarterEdit(getId1());
        quarterList=r.getQuarterType();
        return "success";
    }
    public String updateQuarter(){
        rm.quarterUpdate(getRf());
        qlist=r.quarterDisplay();
        return "success";
    }
    
    public String Reset1(){
        
        super.clearErrorsAndMessages();
        return "success";
    }
    public void validate(){
        try{
            quarterList=r.getQuarterType();
            if(!(rf.getQuarterId()==null && rf.getQuarterType().equals("-1")&& rf.getQuarterCode().length()==0))
            {
                if(rf.getQuarterId()==null){
               
                a++;
                if(a%2!=0){
                     addFieldError("rf.quarterId", "Quarter Id is required");
                }
                else{
                     addFieldError("rf.quarterId", "");
                     a=0;
                }
            }
                else if(!(rf.getQuarterCode().matches("^[a-zA-Z0-9]*$")))
            {
              
                g++;
                if(g%2!=0){
                      addFieldError("rf.quarterCode", "It contains Alpha Numerics  only");
                }
                else{
                      addFieldError("rf.quarterCode", "");
                      g=0;
                }
            }
            if(rf.getQuarterType().equals("-1")){
               
                b++;
                if(b%2!=0){
                     addFieldError("rf.quarterType", "Quarter Type is required");
                }
                else{
                     addActionError("");
                     b=0;
                }
            }
            if(rf.getQuarterCode().length()==0){
              
                c++;
                if(c%2!=0){
                      addFieldError("rf.quarterCode", "Quarter Code is required");
                }
                else{
                      addFieldError("rf.quarterCode", "");
                      c=0;
                }
            }
        }
            else{
                check++;
                if(check%2!=0){
                    addFieldError("rf.quarterId", "Please Fill All Fields");
                }
                else{
                     addFieldError("rf.quarterId", "");
                     check=0;
                }
                }
            if(z==0){
                for(Object obj: qlist){
                    ResidentialQuarters rq=(ResidentialQuarters) obj;
                    if(rf.getQuarterId()==rq.getQuarterId()){
                        d++;
                        if(d%2!=0){
                        addFieldError("rf.quarterId", "Quarter Id already Exists");
                        }
                        else{
                             addFieldError("rf.quarterId", "");
                             d=0;
                        }
                    }
                }
                
            }
        }
    
        catch(Exception e){
            
        }
    }
}
