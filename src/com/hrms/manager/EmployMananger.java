/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.manager;

import com.hrms.dto.EmployeeForm;
import com.hrms.model.EmployeeProfile;
import com.hrms.model.EmployeeType;
import com.hrms.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author nsg
 */
public class EmployMananger {
    Session s=null;
    
     public EmployeeForm insertemp(EmployeeForm empf) {
         EmployeeType e=new EmployeeType();
         System.out.println("----------due to  insertion----->");
        s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try{
            int id=empf.getEmpTypeId();
            
            System.out.println("hfghhhhhhhhhhhhhhhhhhhhhhhd" +id);
             String des=empf.getDescription();
              e.setDescription(des);
              e.setEmpTypeId(id);
              
              s.save(e);
              System.out.println("------------- details inserted----->");
            t.commit();
           
        }
        
        catch(Exception ex){
            System.out.println("Error due to  insertion----->"+e);
            ex.printStackTrace();
            
        }
        finally{
             s.close();
        }
       return empf;
       
        
    }

    public List<EmployeeForm> EmployeeTypeDisplay() {
         s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List l=null;
        try{
            Criteria c=s.createCriteria(EmployeeType.class);
            l=c.list();
            t.commit();
            
        }
        catch(HibernateException he){
            System.out.println("Exception during display:" +he);
        }
        finally{
            s.close();
        }
        return l;
    }
    
    
    public List<EmployeeForm> editEmployee(int id) {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List l = null;
        try
        {
             
            Criteria cr=s.createCriteria(EmployeeType.class);
            cr.add(Restrictions.eq("empTypeId",id)).uniqueResult();
            l=cr.list();
            t.commit();
        }
        catch(Exception ex)
        {
            System.out.println("Exception during display"+ex);
        }
        finally
        {
            s.close();
        }
        return l; 
    }
     public EmployeeForm updateemployee(EmployeeForm empf) {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        EmployeeType e=new EmployeeType();
        try{
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +empf.getEmpTypeId());
        e.setEmpTypeId(empf.getEmpTypeId());
        e.setDescription(empf.getDescription());
        
        s.update(e);
        t.commit();
        }
        catch(HibernateException he){
                 System.out.println("Exception during Departments Updation " +he);
        }
        finally{
            s.close();
        }
        return empf;
    }
     public void deleteEmployee(int id) {
      Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try
        {
             EmployeeType e=new  EmployeeType();
            Criteria cr=s.createCriteria( EmployeeType.class);
            e=( EmployeeType) cr.add(Restrictions.eq("empTypeId", id)).uniqueResult();
            s.delete(e);
            t.commit();
            System.out.println("\n deleted successfully");
        }
        catch(Exception ex)
        {
            System.out.println("Exception during delete"+ex);
             
        }
        finally
        {
            s.close();
        }
    }
 
     }  

