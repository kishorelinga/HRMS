/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.manager;

import com.hrms.dto.LoanAppForm;
import com.hrms.model.EmployeeProfile;
import com.hrms.model.LoanEligibility;
import com.hrms.model.LoansMaster;
import com.hrms.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author NSG
 */
public class LoanAppManager {

       public LoanAppForm insertLoan(LoanAppForm lf) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        LoansMaster loans=new LoansMaster();
        try
        {
            loans.setLoanId(lf.getLoanId());
            loans.setLoanTypeName(lf.getLoanTypeName()); 
            //String erule=lf.getEligibilityRuleId();
            //int eruleId=Integer.parseInt(erule);
            //LoanEligibility le=new LoanEligibility(eruleId);
           // loans.setLoanEligibility(le);
            loans.setEmpGrade(lf.getEmpGrade());
            session.save(loans);
            t.commit();
            System.out.println("\n inserted successfully");
        }
        catch(HibernateException he){
            System.out.println("Exception during insertion" +he);
        }
        finally{
           // session.close();
        }
        return lf;
    }

    public List<String> getLoanEligibilityList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List<String> le=new ArrayList<>();
        Criteria c = session.createCriteria(LoanEligibility.class);
        c.setProjection(Projections.property("eligibilityRuleId"));
        List departments = c.list();
        return departments;
    }

    public List<String> getEmpGradeList() {
      
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List<String> le=new ArrayList<>();
        Criteria c = session.createCriteria(EmployeeProfile.class);
        c.setProjection(Projections.distinct(Projections.property("empGrade")));
       
        List emp = c.list();
         System.out.println("---------------->"+emp);
        return emp;
    }

    public List<LoanAppForm> displayLoan() 
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List l = null;
        try
        {
            Criteria cr=s.createCriteria(LoansMaster.class);
            l=cr.list();
            t.commit();
        }
        catch(Exception ex)
        {
            System.out.println("Exception during display"+ex);
              
        }
        finally
        {
           // s.close();
        }
       return l;  
    }

    public void deleteLoan(int id1) 
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try
        {
            LoansMaster l=new LoansMaster();
            Criteria cr=s.createCriteria(LoansMaster.class);
            l=(LoansMaster) cr.add(Restrictions.eq("loanId", id1)).uniqueResult();
            s.delete(l);
            t.commit();
            System.out.println("\n deleted successfully");
        }
        catch(Exception ex)
        {
            System.out.println("Exception during delete"+ex);
             
        }
        finally
        {
           // s.close();
        }
    }

    public List<LoanAppForm> editLoan(int id1) 
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List l = null;
        try
        {
             
            Criteria cr=s.createCriteria(LoansMaster.class);
            cr.add(Restrictions.eq("loanId",id1)).uniqueResult();
            l=cr.list();
            t.commit();
        }
        catch(Exception ex)
        {
            System.out.println("Exception during display"+ex);
        }
        finally
        {
           // s.close();
        }
        return l;  
    }

    public LoanAppForm updateLoan(LoanAppForm lform) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        LoansMaster loans=new LoansMaster();
        try
        {
            loans.setLoanId(lform.getLoanId());
            loans.setLoanTypeName(lform.getLoanTypeName()); 
            //String erule=lform.getEligibilityRuleId();
           // int eruleId=Integer.parseInt(erule);
            //LoanEligibility le=new LoanEligibility(eruleId);
            //loans.setLoanEligibility(le);
            loans.setEmpGrade(lform.getEmpGrade());
            session.update(loans);
            t.commit();
            System.out.println("updated successfully");
        }
        catch(HibernateException he){
            System.out.println("Exception during updation" +he);
        }
        finally{
           // session.close();
        }
        return lform;
    }
}
    

