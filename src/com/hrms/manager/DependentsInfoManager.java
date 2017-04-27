/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.manager;

import com.hrms.dto.DependentsInfodto;
import com.hrms.model.DependentsInformation;
import com.hrms.model.EmployeeProfile;
import com.hrms.model.FamilyIdentity;
import com.hrms.util.HibernateUtil;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Swathi
 */
public class DependentsInfoManager {
    Session s=null;
     public boolean searchDependent(DependentsInfodto emp) {
         System.out.println("-------------...........----------------->");
        s = HibernateUtil.getSessionFactory().getCurrentSession();
         Transaction t=s.beginTransaction();
          List l=new ArrayList();
          int empId=emp.getEmpId();
          
          try
         {  
              System.out.println("-------------.../?/........----------------->"+empId);
            // EmployeeProfile e1=new EmployeeProfile(empId);
//             Criteria c=s.createCriteria(QuarterAllotment.class,"q");
     
//             c.add(Restrictions.eq("q.empId",id)).uniqueResult();
             Criteria cr=s.createCriteria(EmployeeProfile.class);
             cr.add(Restrictions.eq("empId",empId)).uniqueResult();
                     l=cr.list();  
              System.out.println("------------------------------>"+l);
            if (l.size() > 0) {
          //  s.close();
            return true;
             }
            
           // l.add(count);
           //  System.out.println(count);
             t.commit();
         }
         catch(HibernateException h)
         {
             System.out.println("HibernateException during Edit:"+h);
         }
         catch(Exception ex)
         {
             System.out.println("Exception during Edit:"+ex);
             s.getTransaction().rollback();
         }
         finally
         {
            // s.close();
         }
        //  System.out.println("list is"+l);
      return false;
          }
     public List<String> checkboxList() {
         List<String> l=new ArrayList();
         l.add("yes");
         l.add("no");
         return l;
     }
     
      public  List<DependentsInformation> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx=session.beginTransaction();
       List<DependentsInformation> dlist=new ArrayList<DependentsInformation>();
       //ResidentialQuarters r=new ResidentialQuarters();
       try {
                    // employees=(List<EmployeeProfile>)session.createQuery(" from EmployeeProfile").list(); 
                    
                   Criteria c=session.createCriteria(DependentsInformation.class);
                     dlist=c.list();
                      //employees=query.list();              
                   //  System.out.println(emp1);
                  //   employees=criteria.list();
                   for(Object o:dlist){
                   DependentsInformation ac=(DependentsInformation)o;
                   //FamilyIdentity f=new FamilyIdentity(ac.getFamilyIdentity());
                   //ac.setFamilyIdentity(f);
                   //ac.getFamilyIdentity();
                       System.out.println(ac.getFamilyIdentity());
                       
               }
                    tx.commit();
                    session.close();
          //session.getTransaction().commit();
                       } catch (HibernateException ex) {
   ex.printStackTrace();
   session.getTransaction().rollback();
  }
               System.out.println("list is"+dlist);
              
              
                return dlist;
    }
      
      
      
       public int delete(int id)
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
       // System.out.println(quarterId);
        try
        {
        //QuarterAllotment q=(QuarterAllotment)s.get(QuarterAllotment.class,quarterId);
       //     ResidentialQuarters q=(ResidentialQuarters)s.get(ResidentialQuarters.class, quarterId);
            String sql="delete from  dependents_information  where id=:id";
            SQLQuery query = s.createSQLQuery(sql);
            query.setParameter("id",id);
            query.executeUpdate();
     
        t.commit();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return id;
    }
       
       public List<DependentsInfodto> edit(int id)
   {
        Session s=HibernateUtil.getSessionFactory().openSession();
          Transaction t=s.beginTransaction();
          DependentsInformation d=null;
          DependentsInfodto r=new DependentsInfodto();
          List list=null;
         try
         {
             Criteria c=s.createCriteria(DependentsInformation.class);
             c.add(Restrictions.eq("id",id));
             list=c.list();
             t.commit();
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
         return list;
   }
   
  
    public void addDependent(DependentsInfodto depnt) {
        System.out.println("------------>"+depnt.getName());
         Session s=HibernateUtil.getSessionFactory().openSession();
          Transaction tx=s.beginTransaction();
          DependentsInformation dm=new DependentsInformation();
          dm.setDepAge(depnt.getAge());
          dm.setDepId(depnt.getDepid());
          dm.setDepStatus(depnt.getStatus());
          dm.setDepName(depnt.getName());
          FamilyIdentity f=new FamilyIdentity();
           Criteria c=s.createCriteria(FamilyIdentity.class);
           f=(FamilyIdentity) c.add(Restrictions.eq("employeeProfile.empId",depnt.getEmpId())).uniqueResult();
            dm.setFamilyIdentity(f);
          s.save(dm);
        tx.commit();
        s.close();
    }

    public void updateDependent(DependentsInfodto depnt) {
         System.out.println("------------>"+depnt.getName());
         Session s=HibernateUtil.getSessionFactory().openSession();
          Transaction tx=s.beginTransaction();
        //  DependentsInformation dm=new DependentsInformation();
           DependentsInformation dm=(DependentsInformation) s.get(DependentsInformation.class,depnt.getId());
            FamilyIdentity f=new FamilyIdentity();
           Criteria c=s.createCriteria(FamilyIdentity.class);
           f=(FamilyIdentity) c.add(Restrictions.eq("employeeProfile.empId",depnt.getEmpId())).uniqueResult();
           
          dm.setId(depnt.getId());
          dm.setDepAge(depnt.getAge());
          
          dm.setDepStatus(depnt.getStatus());
          if(depnt.getStatus().equals("yes")){
              dm.setDepId(depnt.getDepid());
          }
          else{
               dm.setDepId(null);
          }
          
          
          dm.setDepName(depnt.getName());
         
            dm.setFamilyIdentity(f);
          s.update(dm);
        tx.commit();
        s.close();
    }
  
  }
