/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.manager;

import com.hrms.dto.OtPayoutForm;
import com.hrms.model.OtPayoutSchedule;
import com.hrms.model.WageDefinitions;
import com.hrms.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author NSG
 */
public class OtPayoutManager 
{
    Session s=null;
    public void insertOtPayout(OtPayoutForm f)
    {
        s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        try
        {
            OtPayoutSchedule ot=new OtPayoutSchedule();
            String de=f.getWageId();
            int n=Integer.parseInt(de);
            WageDefinitions w=new WageDefinitions(n);
            ot.setWageDefinitions(w);
            ot.setPayoutDays(f.getPayoutDays());
            s.save(ot);
            t.commit();
            System.out.println("\n inserted successfully");
        }
        catch(HibernateException h)
        {
            System.out.println("\n Hibernate Exception during insertion:"+h);
        }
        catch(Exception e)
        {
            System.out.println("\n Exception during insertion:"+e);
        }
        finally
        {
            s.close();
        }
    }
    public List getOtPayout()
    {
        s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        List<Integer> wage=new ArrayList<>();
        List<WageDefinitions> l=(List<WageDefinitions>)s.createCriteria(WageDefinitions.class).list();
        l.stream().forEach((w) -> {
            wage.add(w.getWageId());
        });
        return wage;
    }
    public List<OtPayoutForm> displayOtPayout()
    {
        s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        List l=null;
        try
        {
            Criteria cr=s.createCriteria(OtPayoutSchedule.class);
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
        return l;
    }
    public void deleteOtPayout(int id1)
    {
        s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        try
        {
            System.out.println("\n fffffff"+id1);
            Criteria cr=s.createCriteria(OtPayoutSchedule.class);
            OtPayoutSchedule ot=(OtPayoutSchedule) cr.add(Restrictions.eq("id", id1)).uniqueResult();
            s.delete(ot);
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

    public List<OtPayoutForm> editOtPayout(int id1) 
    {
        s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List<OtPayoutForm> l=null;
        try
        {
            OtPayoutSchedule ot=new OtPayoutSchedule();
            Criteria cr=s.createCriteria(OtPayoutSchedule.class);
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

    public void updateOtPayout(OtPayoutForm f, int id2) 
    {
        s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        try
        {
            OtPayoutSchedule ot=new OtPayoutSchedule();
            ot=(OtPayoutSchedule) s.get(OtPayoutSchedule.class, id2);
            String de=f.getWageId();
            int n=Integer.parseInt(de);            
            WageDefinitions w=new WageDefinitions(n);
            ot.setWageDefinitions(w);
            ot.setPayoutDays(f.getPayoutDays());
            s.update(ot);
            t.commit();
            System.out.println("\n Updated successfully");
        }
        catch(HibernateException h)
        {
            System.out.println("\n Hibernate Exception during updation:"+h);
        }
        catch(Exception e)
        {
            System.out.println("\n Exception during updation:"+e);
        }
        finally
        {
            s.close();
        }
    }

  
}
