/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.manager;

import com.hrms.dto.ResidentialForm;
import com.hrms.model.ResidentialQuarters;
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
public class ResidentialManager {

    public ResidentialForm quarterInsert(ResidentialForm rf) {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        ResidentialQuarters rq=new ResidentialQuarters();
        try{
            rq.setQuarterId(rf.getQuarterId());
            rq.setQuarterType(rf.getQuarterType());
            rq.setQuarterCode(rf.getQuarterCode());
            s.save(rq);
            t.commit();
        }
        catch(HibernateException he){
            System.out.println("Exception during insert" +he);
        }
        finally{
            s.close();
        }
        return rf;
          }

    public List<ResidentialForm> quarterDisplay() {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List l = null;
        try
        {
            Criteria cr=s.createCriteria(ResidentialQuarters.class);
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

    public List<String> getQuarterType() {
         List l=new ArrayList<>();
        l.add("Bachelor");
        l.add("Family");
        l.add("Hostel");
        return l;
    }

    public List<ResidentialForm> quarterEdit(int id1) {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List l = null;
        try
        {
             
            Criteria cr=s.createCriteria(ResidentialQuarters.class);
            cr.add(Restrictions.eq("quarterId",id1)).uniqueResult();
            l=cr.list();
            t.commit();
        }
        catch(Exception ex)
        {
            System.out.println("Exception during edit"+ex);
        }
        finally
        {
            s.close();
        }
        return l; 
    }

    public void quarterDelete(int id1) {
             Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try
        {
            ResidentialQuarters d=new ResidentialQuarters();
            Criteria cr=s.createCriteria(ResidentialQuarters.class);
            d=(ResidentialQuarters) cr.add(Restrictions.eq("quarterId", id1)).uniqueResult();
            s.delete(d);
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

    public ResidentialForm quarterUpdate(ResidentialForm rf) {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        ResidentialQuarters rq=new ResidentialQuarters();
        try{
            rq.setQuarterId(rf.getQuarterId());
            rq.setQuarterType(rf.getQuarterType());
            rq.setQuarterCode(rf.getQuarterCode());
            s.update(rq);
            t.commit();
        }
        catch(HibernateException he){
            System.out.println("Exception during insert" +he);
        }
        finally{
            s.close();
        }
        return rf;
          }
    }
    

