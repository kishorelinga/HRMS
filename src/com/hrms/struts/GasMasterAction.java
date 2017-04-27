/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.struts;

import com.hrms.dto.GasConnectionMasterForm;
import com.hrms.manager.GasMasterManager;
import com.hrms.model.GasConnectionMaster;
import com.opensymphony.xwork2.ActionSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author NSG
 */
public class GasMasterAction extends ActionSupport 
{
    GasMasterManager g=new GasMasterManager();
    private GasMasterManager gm;
    private int id1;
    private static int z=0,check,a,b,b1,c,d,e,f,g1,h,h1;

    public GasMasterManager getGm() {
        return gm;
    }
    public void setGm(GasMasterManager gm) {
        this.gm = gm;
    }

    public int getId1() {
        return id1;
    }
    public void setId1(int id1) {
        this.id1 = id1;
    }
    
    
    public GasMasterAction() 
    {
        gm = new GasMasterManager();
    }
    
    private GasConnectionMasterForm form;
    public GasConnectionMasterForm getForm() {
        return form;
    }
    public void setForm(GasConnectionMasterForm form) {
        this.form = form;
    }
    
    private static List<GasConnectionMasterForm> masterList=new ArrayList<>();
    private List<String> gasCompanyList=new ArrayList<>();
    private List<String> gasCylinderList=new ArrayList<>();
    

    public List<GasConnectionMasterForm> getMasterList() {
        return masterList;
    }
    public void setMasterList(List<GasConnectionMasterForm> masterList) {
        this.masterList = masterList;
    }
    
    public List<String> getGasCompanyList() {
        return gasCompanyList;
    }
    public void setGasCompanyList(List<String> gasCompanyList) {
        this.gasCompanyList = gasCompanyList;
    }

    public List<String> getGasCylinderList() {
        return gasCylinderList;
    }
    public void setGasCylinderList(List<String> gasCylinderList) {
        this.gasCylinderList = gasCylinderList;
    }
    
    
    
    public String gasEnroll()
    {
        z=0;
        gasCompanyList=gm.getCompanyName();
        gasCylinderList=gm.getCylinderCount();
        return "success";
        
    }
    public String gasMasterInsert() throws ParseException
    {
        gm.insertGasMaster(getForm()); 
        masterList=g.displayGasMaster();
        return "success";
    }
    public String gasMasterDisplay()
    {
        masterList=g.displayGasMaster();
        return "success";
    }
    public String gasMasterDelete()
    {
        g.deleteGasMaster(getId1());
        masterList=g.displayGasMaster();
        return "success";
    }
    public String gasMasterEdit()
    {
        z++;
        masterList=g.editGasMaster(getId1());
        return "success";
    }
    public String gasMasterUpdate()
    {
        g.updateGasMaster(getForm());
        masterList=g.displayGasMaster();
        return "success";
    }
    
    
    @Override
    public void validate()
    {
      try
      {
            gasCompanyList=gm.getCompanyName();
            gasCylinderList=gm.getCylinderCount();
        if(!( form.getGasCompanyName().equals("-1") && form.getGasConnectionAmount()==null
             && form.getGasConnectionHolderName().length()==0 && form.getGasConnectionValidateDate().length()==0
             && form.getGasCylinderCount().equals("-1") && form.getConnectionId()==null && form.getConsumerNumber().length()==0 ))
        {
            
            
           if(form.getConnectionId()== null)
           {
               a++;
               if(a%2 !=0)
               {
                   addFieldError("form.connectionId", "Connection id is required");
               }
               else
               {
                   addFieldError("form.connectionId", "");
                   a=0;
               }
           }
           if(form.getGasCompanyName().equals("-1"))
           {
               b++;
               if(b%2 !=0)
               {
                    addFieldError("form.gasCompanyName", "Please select gas company name");
               }
               else
               {
                   addFieldError("form.gasCompanyName", "");
                   b=0;
               }
           }
           
            if(form.getGasStoveId()==null)
           {
               c++;
               if(c%2 !=0)
               {
                    addFieldError("form.gasStoveId", "Gas stove id is required");
               }
               else
               {
                   addFieldError("form.gasStoveId", "");
                   c=0;
               }
           }
           if(form.getGasConnectionAmount()==null)
           {
               d++;
               if(d%2 !=0)
               {
                    addFieldError("form.gasConnectionAmount","please provide gas connection amount");
               }
               else
               {
                   addFieldError("form.gasConnectionAmount", "");
                   d=0;
               }
           }
           if(form.getGasConnectionHolderName().length()==0)
           {
               
               e++;
               if(e%2 !=0)
               {
                    addFieldError("form.gasConnectionHolderName", "Connection holder name is required");
               }
               else
               {
                   addFieldError("form.gasConnectionHolderName", "");
                   e=0;
               }
           }
           else if(!form.getGasConnectionHolderName().matches("^[a-zA-Z ]*$"))
           {
               b1++;
               if(b1%2 !=0)
               {
                   addFieldError("form.gasConnectionHolderName", "Only alphabets are allowed");
               }
               else
               {
                   addFieldError("form.gasConnectionHolderName","");
               }
           }
           if(form.getGasCylinderCount().equals("-1"))
           {
               
               f++;
               if(f%2 !=0)
               {
                    addFieldError("form.gasCylinderCount", "Pleas select Gas cylinder count");
               }
               else
               {
                   addFieldError("form.gasCylinderCount", "");
                   f=0;
               }
           }
           if(form.getGasConnectionValidateDate().length() == 0)
           {
               g1++;
               if(g1%2 !=0)
               {
                    addFieldError("form.gasConnectionValidateDate", "validity date is required");
               }
               else
               {
                   addActionError("");
                   g1=0;
               }
           }
           if(form.getConsumerNumber().length() == 0)
           {
               h++;
               if(h%2 !=0)
               {
                    addFieldError("form.consumerNumber", "Consumer Number is required");
               }
               else
               {
                   addFieldError("form.consumerNumber", "");
                   h=0;
               }
           }
           else if(!form.getConsumerNumber().matches("^[a-zA-Z0-9 ]*$"))
           {
               h1++;
               if(h1%2 !=0)
               {
                   addFieldError("form.consumerNumber", "Special symbols are not allowed");
               }
               else
               {
                   addFieldError("form.consumerNumber", "");
                   h1=0;
               }
           }
        }
        else
        {
           check++;
               if(check%2 !=0)
               {
                    addFieldError("form.connectionId", "Pleas fill all fields");
               }
               else
               {
                   addFieldError("form.connectionId", "");
                   check=0;
               }
                
        }
        
        Calendar cal1 = new GregorianCalendar();
            Calendar cal2 = new GregorianCalendar();
            String valid=form.getGasConnectionValidateDate();
            Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(valid);
            Date date2 = new Date();
            /*cal1.setTime(date1);
            cal2.setTime(date2);
            int c = cal1.get(Calendar.DATE) - cal2.get(Calendar.DATE);
            System.out.println("count is: "+c);*/
            if(!date1.after(date2))
            {
                  addFieldError("form.gasConnectionValidateDate","invalid validity date"); 
            }
            else if(valid.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}"))
            {
                   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                   Date date = sdf.parse(valid);
                   Calendar cal3 = Calendar.getInstance();
                   cal3.setTime(date);
                   String parts[] = valid.split("-");
                   boolean valid1 = true;
                   if (Integer.parseInt(parts[0]) != cal3.get(Calendar.DATE)) 
                   {
                       valid1 = false;
                       addFieldError("form.gasConnectionValidateDate", parts[0]+" is not a valid day of the month "+ parts[1]);
                       System.out.println(parts[0] + " is not a valid day of the month"+parts[1]);
                   } 
                   if (Integer.parseInt(parts[1]) != cal3.get(Calendar.MONTH)+1) 
                   {
                       valid1 = false;
                       addFieldError("form.gasConnectionValidateDate", parts[1]+" is not a valid month ");
                       System.out.println(parts[1] + " is not a valid month");
                   } 
            }
        
        
        
        if(z==0)
        {
                for (Object sub : masterList) 
                {
                    GasConnectionMaster ep = (GasConnectionMaster) sub;
                    if (getForm().getConnectionId()==(ep.getConnectionId())) 
                    {
                          addFieldError("form.connectionId", "Id already exists in database");
                    }
                    if (getForm().getGasConnectionHolderName().equals(ep.getGasConnectionHolderName())) 
                    {
                          addFieldError("form.gasConnectionHolderName", "Name already exists in database");
                    }
                    
                }
        }
            
        }
        catch(Exception e)
        {
//            System.out.println("\n exception during validation"+e);
        }
    }
}
