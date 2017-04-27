/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.manager;

import com.hrms.dto.Users;
import com.hrms.model.EmployeeProfile;
import com.hrms.model.FamilyIdentity;
import com.hrms.model.GasAllotment;
import com.hrms.model.GasConnectionMaster;
import com.hrms.model.ResidentialQuarters;
import com.hrms.model.User;
import com.hrms.util.HibernateUtil;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Masrat
 */
public class UserManager {

    
    private Session session;
    List ulist = null;
    boolean status = false;

    public UserManager() {
        System.out.println("---------home----------------");        
        // this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }


    public boolean validateUser(Users l) {
         System.out.println("---------home----??????????------------"); 
        if (session != null) {
              session.close();
           }
        session = HibernateUtil.getSessionFactory().openSession();
       Transaction t=session.beginTransaction();
        try {
            String name = l.getUsername();
            String pwd = l.getPassword();
            String sql = "select * from user l where l.username=:name and l.password=:pwd";
            Query query = session.createSQLQuery(sql);
            query.setParameter("name", name);
            query.setParameter("pwd", pwd);
            List<User> list = query.list();
            if (list.size() > 0) {
                //session.close();
                return false;
            }
            t.commit();
            session.close();
        } catch (Exception e) {
            //session.getTransaction().rollback();
        } finally {
            if (session != null) {
               // session.close();
            }
        }

        return true;

    }

    public Long[] getEmps() {

        Long ary[] = new Long[3];
         
          if (session != null) {
               session.close();
            }
         session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction t=session.beginTransaction();
        try {
           
            System.out.println("count--------++++--------->");
            Long x = (Long) session.createCriteria(EmployeeProfile.class).setProjection(Projections.rowCount()).uniqueResult();
            System.out.println("count--------++++--------->" + x);
            Criteria cr = session.createCriteria(EmployeeProfile.class);
            cr.add(Restrictions.eq("gender", "M"));
            cr.setProjection(Projections.rowCount());
            List rowCount = cr.list();
            System.out.println("Total Coint: " + rowCount.get(0));
            Criteria cr1 = session.createCriteria(EmployeeProfile.class);
            cr1.add(Restrictions.eq("gender", "F"));
            cr1.setProjection(Projections.rowCount());
            List rowCount1 = cr1.list();
            System.out.println("Total Coint: " + rowCount1.get(0));
            ary[0] = x;
            ary[1] = (Long) rowCount.get(0);
            ary[2] = (Long) rowCount1.get(0);
            System.out.println("Total aaaaarrrrrrCoint: " + ary[2]);
             t.commit();
            session.close();
            
        } catch (Exception e) {
            //session.getTransaction().rollback();
        } finally {
            if (session != null) {
                //session.close();
            }
        }
        return ary;

    }

    public Long getQuarts() {
         session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction t=session.beginTransaction();
         Long x = (Long) session.createCriteria(ResidentialQuarters.class).setProjection(Projections.rowCount()).uniqueResult();
            System.out.println("count--------++++--------->" + x);
            t.commit();
            //session.close();
            return x;
    }

    public Long[] getConn() {
        Long ary[] = new Long[3];
         session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction t=session.beginTransaction();
         Long x = (Long) session.createCriteria(GasConnectionMaster.class).setProjection(Projections.rowCount()).uniqueResult();
            System.out.println("count--------++++--------->" + x);
            Long y = (Long) session.createCriteria(GasAllotment.class).setProjection(Projections.rowCount()).uniqueResult();
            System.out.println("count--------++++--------->" + y);
            Long z=x-y;
            System.out.println("count--------++++--------->" + z);
            ary[0]=x;
            ary[1]=y;
            ary[2]=z;
           t.commit();
           // session.close();
            return ary;
    }

    public Long getfamilies() {
         session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction t=session.beginTransaction();
            Long x = null;
            try{
        x = (Long) session.createCriteria(FamilyIdentity.class).setProjection(Projections.rowCount()).uniqueResult();
            System.out.println("count--------++++--------->" + x);
            }catch(Exception e){
                System.out.println("------->"+e);
            }
           t.commit();
           // session.close();
            return x;
    }

    public String getStatus(Users user) {
       String pz = null;
       List<String> p=null;
       ArrayList<String> spl;
         session = HibernateUtil.getSessionFactory().openSession();
       Transaction t=session.beginTransaction();
          try {
            String name = user.getUsername();
            String pwd = user.getPassword();
            String sql = "select * from User l where l.password=:pwd";
            Query query = session.createSQLQuery(sql);
           // query.setParameter("name", name);
            query.setParameter("pwd", pwd);
           p=query.list();
          // spl=p.toString().split(", ");
           List<String> list = new ArrayList<String>(Arrays.asList(p.toString().split(", ")));
           for(int i=0;i<list.size();i++){
                 System.out.println("----------------------------p------------------------->"+list.get(i));
                  // System.out.println("----------------------------");
           }
          
            for(String px:p){
            px=(String)p.get(0);
            pz=px;
           }
            t.commit();
            session.close();
        } 
        catch (Exception e) {
            //session.getTransaction().rollback();
    } 
          return pz; 
    }
} 
         
     
    
    
    
    
