/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.manager;

import com.hrms.dto.EmployeeProfileForm;
import com.hrms.dto.WagesForm;
import com.hrms.model.EmployeeProfile;
import com.hrms.model.WageDefinitions;
import com.hrms.model.Wages;
import com.hrms.util.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author NSG
 */
public class WagesManager 
{
    Session s=null;
    public void insertWage(WagesForm form) 
    {
        s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try
        {
             Wages gm=new Wages();
             String date=form.getEffectiveDate();
             SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy");
             Date d=sf.parse(date);
             String de=form.getWageId();
             int n=Integer.parseInt(de);
             WageDefinitions w=new WageDefinitions(n);             
             EmployeeProfile e=new EmployeeProfile(form.getEmpId());
             gm.setBasicRate(form.getBasicRate());
             gm.setEffectiveDate(d);
             gm.setWageDefinitions(w);
             gm.setEmployeeProfile(e);
             
             s.save(gm);
             t.commit();
             System.out.println("\n Wages inserted successfully");
        }
        catch(HibernateException h)
        {
            System.out.println("Hibernate Exception during insertion"+h);
            h.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println("Exception during insertion"+e);
            e.printStackTrace();
        }
        finally
        {
            s.close();
        }    
    }
    public List getWageId()
    {
        s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        List<Integer> wage=new ArrayList<>();
        List<WageDefinitions> l=(List<WageDefinitions>)s.createCriteria(WageDefinitions.class).list();
        for(WageDefinitions w : l)
       {
            wage.add(w.getWageId());
        }
        return wage;
    }
    public boolean validEmp(WagesForm l)
    {
        s = HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        int empId=l.getEmpId();
        try 
        {
            String sql = "from EmployeeProfile l where l.empId=:empId ";
            Query query = s.createQuery(sql);
            query.setParameter("empId",empId);
            List<EmployeeProfile> list = query.list();
            if (list.size() > 0) 
            {
                  s.close();
                  return true;
            }   
        } 
        catch(HibernateException h)
         {
             System.out.println("HibernateException during Searching:"+h);
             h.printStackTrace();
         }
         catch(Exception ex)
         {
            System.out.println("Exception during Searching:"+ex);
         }
         finally
         {
            s.close();
         }

        return false;

    }
    
    public List<WagesForm> displayWage()
    {
        s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        List l=null;
        try
        {
            Criteria cr=s.createCriteria(Wages.class);
            l=cr.list();
            t.commit();
            System.out.println("\n displayed successfully");
        }
        catch(HibernateException h)
        {
            System.out.println("\n Hibernate Exception during display"+h);
        }
        catch(Exception e)
        {
            System.out.println("\n Exception during display"+e);
        }
        finally
        {
            s.close();
        }
        return l;
    }
    
    public void deleteWage(int id)
    {
        s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try
        {
            Wages g=new Wages();
            Criteria cr=s.createCriteria(Wages.class);
            g=(Wages) cr.add(Restrictions.eq("id", id)).uniqueResult();
            s.delete(g);
            t.commit();
            System.out.println("\n deleted successfully");
        }
         catch(HibernateException h)
        {
            System.out.println("Hibernate Exception during deletion"+h);
        }
        catch(Exception e)
        {
            System.out.println("Exception during deletion"+e);
        }
        finally
         {
            s.close();
         }    
    }
    
     public List<WagesForm> editWage(int id1) 
    {
        s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List<WagesForm> l=null;
        try
        {
            Wages gm=new Wages();
            Criteria cr=s.createCriteria(Wages.class);
            cr.add(Restrictions.eq("id", id1)).uniqueResult();
            l=cr.list();
        }
        catch(HibernateException h)
        {
            System.out.println("Hibernate Exception during edit"+h);
        }
        catch(Exception e)
        {
            System.out.println("Exception during edit"+e);
            
        }
        finally
        {
            s.close();
        }
        return l;
    }

    public void updateWage(WagesForm form,int id) 
    {
        s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try
        {
             Wages gm=new Wages();
             gm=(Wages) s.get(Wages.class, id);
             System.out.println("\n wwwwwwwwwwwwww"+id);
             String date=form.getEffectiveDate();
             SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy");
             Date d=sf.parse(date);
             String de=form.getWageId();
             int n=Integer.parseInt(de);
             WageDefinitions w=new WageDefinitions(n);             
             EmployeeProfile e=new EmployeeProfile(form.getEmpId());
             gm.setBasicRate(form.getBasicRate());
             gm.setEffectiveDate(d);
             gm.setWageDefinitions(w);
             gm.setEmployeeProfile(e);
             
             s.update(gm);
             t.commit();
             System.out.println("\n Wages updated successfully");
        }
        catch(HibernateException h)
        {
            System.out.println("Hibernate Exception during Update"+h);
            h.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println("Exception during Update"+e);
            e.printStackTrace();
        }
        finally
        {
            s.close();
        } 
        
    }
     
    
    
}
