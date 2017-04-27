/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.manager;

import com.hrms.dto.DepartmentForm;
import com.hrms.model.Departments;
import com.hrms.util.HibernateUtil;
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
public class DepartmentManager {

    public DepartmentForm insertDepartment(DepartmentForm df) {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        Departments d=new Departments();
        try
        {
            d.setDeptId(df.getDeptId());
            d.setDeptName(df.getDeptName());
            d.setDeptScope(df.getDeptScope());
            s.save(d);
            t.commit();
        }
        catch(HibernateException he)
        {
            System.out.println("Exception during Departments Insertion " +he);
        }
        finally{
            s.close();
        }
        return df;
    }

    public List<DepartmentForm> displayDepartment() {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List l = null;
        try
        {
            Criteria cr=s.createCriteria(Departments.class);
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

    public void deleteDepartment(int id1) {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try
        {
            Departments d=new Departments();
            Criteria cr=s.createCriteria(Departments.class);
            d=(Departments) cr.add(Restrictions.eq("deptId", id1)).uniqueResult();
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

    public List<DepartmentForm> editDepartment(int id1) {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List l = null;
        try
        {
             
            Criteria cr=s.createCriteria(Departments.class);
            cr.add(Restrictions.eq("deptId",id1)).uniqueResult();
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

    public DepartmentForm updateDepartment(DepartmentForm df) {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        Departments d=new Departments();
        try
        {
            d.setDeptId(df.getDeptId());
            d.setDeptName(df.getDeptName());
            d.setDeptScope(df.getDeptScope());
            s.update(d);
            t.commit();
        }
        catch(HibernateException he){
                 System.out.println("Exception during Departments Updation " +he);
        }
        finally{
            s.close();
        }
        return df;
    }
}

