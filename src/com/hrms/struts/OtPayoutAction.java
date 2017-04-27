/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.struts;

import com.hrms.dto.OtPayoutForm;
import com.hrms.manager.OtPayoutManager;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NSG
 */
public class OtPayoutAction extends ActionSupport 
{
    OtPayoutManager ot=new OtPayoutManager();
    private OtPayoutManager ot1;
    private OtPayoutForm form;
    private int id1;
    private static int id2,a,b;

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }
    
    
    public OtPayoutManager getOt1() {
        return ot1;
    }
    public void setOt1(OtPayoutManager ot1) {
        this.ot1 = ot1;
    }

    public OtPayoutForm getForm() {
        return form;
    }

    public void setForm(OtPayoutForm form) {
        this.form = form;
    }
    
    
    private List otList=new ArrayList();
    private static List<OtPayoutForm> otPayoutList=new ArrayList();

    public List<OtPayoutForm> getOtPayoutList() {
        return otPayoutList;
    }

    public void setOtPayoutList(List<OtPayoutForm> otPayoutList) {
        this.otPayoutList = otPayoutList;
    }


    public List getOtList() {
        return otList;
    }

    public void setOtList(List otList) {
        this.otList = otList;
    }
    
    
    public OtPayoutAction() 
    {
        ot1=new OtPayoutManager();
    }
    public String otPayoutEnroll()
    {
        otList=ot1.getOtPayout();
        return "success";
    }
    public String otPayoutInsert()
    {
        ot1.insertOtPayout(getForm());
        otPayoutList=ot1.displayOtPayout();
        return "success";
    }
    public String otPayoutDisplay()
    {
        otPayoutList=ot1.displayOtPayout();
        return "success";
    }
    public String otPayoutDelete()
    {
        ot1.deleteOtPayout(getId1());
        otPayoutList=ot1.displayOtPayout();
        return "success";
    }
    public String otPayoutEdit()
    {
        otList=ot1.getOtPayout();
        otPayoutList=ot1.editOtPayout(getId1());
        id2=getId1();
        System.out.println("----------"+id2);
        return "success";
    }
    public String otPayoutUpdate()
    {
        ot1.updateOtPayout(getForm(),id2);
        otPayoutList=ot1.displayOtPayout();
        return "success";
    }
    @Override
    public void validate()
    {
        otList=ot1.getOtPayout(); 
        try
        {
            if(form.getWageId().equals("-1"))
            {
                a++;
                if(a%2 !=0)
                {
                   addFieldError("form.wageId", "Please select Wage Id");
                }
                else
                {
                    addFieldError("form.wageId", "");
                }
            }
            if(form.getPayoutDays()==null)
            {
                b++;
                if(b%2 !=0)
                {
                    addFieldError("form.payoutDays", "Please provide payout days");
                }
                else
                {
                    addFieldError("form.payoutDays", "");
                }
            }
        }
        catch(Exception e)
        {
           // System.out.println("\n Exception during validation"+e);
        }
    }
}
