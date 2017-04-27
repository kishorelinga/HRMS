/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.manager;

import com.hrms.dto.DeductionForm;
import com.hrms.model.DeductionRules;
import com.hrms.model.EmployeeProfile;
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
public class DeductionRuleManager {

    public DeductionForm deductionInsert(DeductionForm dform) {
        
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        DeductionRules dr=new DeductionRules();
        try{
            System.out.println("-66666666666666666666666666666666666666666"+dform.getEmpGrade());
           dr.setDeductionRuleId(dform.getDeductionRuleId());
           dr.setEmpGrade(dform.getEmpGrade());
           dr.setFlatDeductionAmount(dform.getFlatDeductionAmount());
           dr.setBasicRate(dform.getBasicRate());
           s.save(dr);
           t.commit();
            
        }
        catch(HibernateException he){
            System.out.println("Exception during Deduction Rules Insertion" +he);
        }
        finally{
           // s.close();
        }
        
        return dform;
        
    }

    public List<DeductionForm> deductionDisplay() {
        Session s=HibernateUtil.getSessionFactory().openSession();
         Transaction t=s.beginTransaction();
         List l = null;
         try
         {
              Criteria cr=s.createCriteria(DeductionRules.class);
              l=cr.list();
              t.commit();
         }
         catch(Exception ex)
         {
              System.out.println("Exception during display"+ex);
             
         }
         finally
         {
              //s.close();
         }
         return l; 
    }

   
    public List<String> getGradeList() {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List<String> le=new ArrayList<>();
        Criteria c = session.createCriteria(EmployeeProfile.class);
        c.setProjection(Projections.distinct(Projections.property("empGrade")));
        List emp = c.list();
        System.out.println("--------------->"+emp);
        return emp;
    }

    public void deductionDelete(int id1) {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try
        {
            Criteria cr=s.createCriteria(DeductionRules.class);
            DeductionRules l=(DeductionRules) cr.add(Restrictions.eq("deductionRuleId", id1)).uniqueResult();
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

    public List<DeductionForm> deductionEdit(int id1) {
        
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List l = null;
        try
        {
             
            Criteria cr=s.createCriteria(DeductionRules.class);
            cr.add(Restrictions.eq("deductionRuleId",id1)).uniqueResult();
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

    public void deductionUpdate(DeductionForm dform) {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        DeductionRules dr=new DeductionRules();
        try{
           dr.setDeductionRuleId(dform.getDeductionRuleId());
           dr.setEmpGrade(dform.getEmpGrade());
           dr.setFlatDeductionAmount(dform.getFlatDeductionAmount());
           dr.setBasicRate(dform.getBasicRate());
           s.update(dr);
           t.commit();
           System.out.println("Updated successfully"); 
        }
        catch(HibernateException he){
            System.out.println("Exception during Deduction Rules Updation" +he);
        }
        finally{
           // s.close();
        }
       // return dform;
    }
    
}
