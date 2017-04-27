/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.manager;

import com.hrms.dto.Masterwagedto;
import com.hrms.model.QuarterAllotment;
import com.hrms.model.WageDefinitions;
import com.hrms.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Swathi
 */
public class MasterManager {
    public List<String> employee_type() {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List<String> employee_type=new ArrayList();
        employee_type.add("daily wage");
        employee_type.add("contract");
        employee_type.add("temporary");
        System.out.println(employee_type);
        return employee_type;
    }
    
     public List<String> wageCal() {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List<String> employee_type=new ArrayList();
        employee_type.add("daily");
        employee_type.add("weekly");
        employee_type.add("monthly");
        System.out.println(employee_type);
        return employee_type;
    }
     
    public Masterwagedto insertWagemaster(Masterwagedto mw) {
        Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx=session.beginTransaction();
       Integer wageid=mw.getWageid();
       String emptype=mw.getEmptype();
       String wagetype=mw.getWagetype();
       try {
           WageDefinitions w=new WageDefinitions();
           w.setWageId(wageid);
           w.setEmpType(emptype);
           w.setWageCalculation(wagetype);
           session.save(w);
           tx.commit();
           session.close();
       }
       catch(Exception e) {
           e.getMessage();
       }
        return mw;
    }
    
    public List<WageDefinitions> listwagedef() {
         Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx=session.beginTransaction();
           List<WageDefinitions> list= (List<WageDefinitions>)session.createCriteria(WageDefinitions.class).list();
           return list;
    }
    public void delete(int wageid) {
         Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx=session.beginTransaction();
     
      WageDefinitions employee = (WageDefinitions) session.get(WageDefinitions.class, wageid);
            session.delete(employee);
            session.getTransaction().commit();
    }
    public List<Masterwagedto> editWage(int wageid) {
         Session s=HibernateUtil.getSessionFactory().openSession();
          Transaction t=s.beginTransaction();
          List list = null;
          try
          {
              Criteria c=s.createCriteria(WageDefinitions.class);
              c.add(Restrictions.eq("wageId",wageid)).uniqueResult();
             list=c.list();
              System.out.println(list);
              t.commit();
          }
          catch(Exception e)
          {
              System.out.println(e); 
              s.close();
             
          }
         
          return list;
    }
    public Masterwagedto updateWage(Masterwagedto mw) {
        Session s=HibernateUtil.getSessionFactory().openSession();
          Transaction tx=s.beginTransaction();
          Integer wage_id=mw.getWageid();
          String emp_type=mw.getEmptype();
          String wage_calculation=mw.getWagetype();
       
          try {


          WageDefinitions  d1=(WageDefinitions) s.get(WageDefinitions.class,wage_id);
          d1.setWageCalculation(wage_calculation);
          d1.setEmpType(emp_type);
            tx.commit();
            s.update(d1);
          }
          catch(Exception e) {
               System.out.println("Hibernate Exception caught:" +e.getMessage());
             
          }
          finally {
              s.close();
          }
        return mw;
    }
}   
