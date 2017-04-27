/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.manager;

import com.hrms.dto.Quarterdto;
import com.hrms.model.Departments;
import com.hrms.model.DependentsInformation;
import com.hrms.model.EmployeeProfile;
import com.hrms.model.FamilyIdentity;
import com.hrms.model.GasAllotment;
import com.hrms.model.GasConnectionMaster;
import com.hrms.model.QuarterAllotment;
import com.hrms.model.ResidentialQuarters;
import com.hrms.util.HibernateUtil;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Swathi
 */
public class QuarterManager {
    public  List<QuarterAllotment> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx=session.beginTransaction();
       List<QuarterAllotment> employees=new ArrayList<QuarterAllotment>();
       EmployeeProfile e=new EmployeeProfile();
       QuarterAllotment q=new QuarterAllotment();
       try {
                    // employees=(List<EmployeeProfile>)session.createQuery(" from EmployeeProfile").list(); 
                    
                   String sql="from QuarterAllotment";
                     Query query=session.createQuery(sql);
                      employees=query.list();              
                   //  System.out.println(emp1);
                  //   employees=criteria.list();
                    tx.commit();
	         //session.getTransaction().commit();
                      	} catch (HibernateException ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
               System.out.println("list is"+employees);
              
               	return employees;
    }
    
    
    public boolean searchEmployeee(Quarterdto emp)
    {
       Session  s=HibernateUtil.getSessionFactory().openSession();
         Transaction t=s.beginTransaction();
         int empId=emp.getEmpId();
         String empName=emp.getEmpName();
        // Criteria cr=null;
        String aadharNumber=emp.getAadharNumber();
       
         try
         {
             String sql="from EmployeeProfile r where r.empId=:empId or r.empName=:empName or r.aadharNumber=:aadharNumber"; 
              Query query=s.createQuery(sql);
               query.setParameter("empId",empId);
               query.setParameter("empName",empName);
               query.setParameter("aadharNumber",aadharNumber);
          List<ResidentialQuarters> list = query.list();
             if (list.size() > 0) {
            s.close();
            return true;
                                  }          
         }
         catch(HibernateException h)
         {
             System.out.println("HibernateException during Searching:"+h);
         }
         catch(Exception ex)
         {
            System.out.println("Exception during Searching:"+ex);
         }
         finally
         {
           //  s.close();
         }
         return false; 
    }
    
     public boolean searchQuarter(Quarterdto emp) {
        Session s = HibernateUtil.getSessionFactory().openSession();
         Transaction t=s.beginTransaction();
          List l=new ArrayList();
          int empId=emp.getEmpId();
          try
         {             
           //  EmployeeProfile e1=new EmployeeProfile();
          // Criteria c=s.createCriteria(EmployeeProfile.class);
     
           //  c.add(Restrictions.eq("empId",empId)).uniqueResult();
             Criteria  criteria  =s.createCriteria(QuarterAllotment.class);
             criteria.add(Restrictions.eq("employeeProfile.empId",empId)).uniqueResult();
                     l=criteria.list();  
             
             if (l.size() > 0) {
            s.close();
            return true;
             }
             System.out.println(l);
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
     
     public boolean searchQuarterEdit(Quarterdto emp) {
        Session s = HibernateUtil.getSessionFactory().openSession();
         Transaction t=s.beginTransaction();
          List l=new ArrayList();
          int empId=emp.getQuarterId();
          System.out.println(empId);
          try
         {             
        //     EmployeeProfile e1=new EmployeeProfile(empId);
//             Criteria c=s.createCriteria(QuarterAllotment.class,"q");
//      
//             c.add(Restrictions.eq("q.empId",id)).uniqueResult();
             Criteria  criteria  =s.createCriteria(QuarterAllotment.class);
             criteria.add(Restrictions.eq("residentialQuarters.quarterId",empId)).uniqueResult();
                     l=criteria.list();  
              System.out.println(l);
             if (l.size() > 0) {
            s.close();
            return true;
             }
             System.out.println(l);
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
    
    
    
    public List<Quarterdto> searchEmployee(Quarterdto emp) {
        Session s = HibernateUtil.getSessionFactory().openSession();
         Transaction t=s.beginTransaction();
          List l=null;
          int id=emp.getEmpId();
          try
         {             
             EmployeeProfile e=new EmployeeProfile();
             Criteria c=s.createCriteria(EmployeeProfile.class);
             c.add(Restrictions.eq("empId",id)).uniqueResult();
             l=c.list();
                                  
            
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
         }
         finally
         {
            // s.close();
         }
        //  System.out.println("list is"+l);
     return l;
    }
    public int count(Quarterdto emp) throws SQLException {      
        int count=0;
        int empId=emp.getEmpId();
        List list=null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
          String sql="select count(d.dep_name) from dependents_information d where d.family_head_id=:empId";
      SQLQuery query = s.createSQLQuery(sql);
      query.setParameter("empId",empId);
            BigInteger count1= (BigInteger) query.uniqueResult();
     count=count1.intValue();
//            Criteria c=s.createCriteria(DependentsInformation.class);
//          
//            c.add(Restrictions.eq("familyIdentity.employeeProfile",empId)).uniqueResult();  
//             c.setProjection(Projections.rowCount());
//             BigInteger count1= (BigInteger)c.uniqueResult(); 
//             count=count1.intValue();
//             list=c.list();
//             System.out.println("list is"+list);
   //List l=query.list();
        }
        catch(HibernateException h)
         {
             System.out.println("HibernateException during Edit:"+h);
         }
     //   System.out.println(count);
          return count;
    }
   public int count1(Quarterdto emp) throws SQLException {      
        int count=0;
        int empId=emp.getEmpId();
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
          String sql="select count(d.dep_name) from dependents_information d where d.family_head_id=:empId and dep_status='yes'";
      SQLQuery query = s.createSQLQuery(sql);
      query.setParameter("empId",empId);
            BigInteger count1= (BigInteger) query.uniqueResult();
     count=count1.intValue();
   //List l=query.list();
        }
        catch(HibernateException h)
         {
             System.out.println("HibernateException during Edit:"+h);
         }
      //  System.out.println(count);
          return count;
    }
    public List quarterCode(Quarterdto emp) {
      Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx=session.beginTransaction();
       List quartercode;
       int empId=emp.getEmpId();
       String sql=null;
       String quarterType=null;
       HashMap<Integer,String> dept=new HashMap<>();
             List<EmployeeProfile> departments = (List<EmployeeProfile>)session.createCriteria(EmployeeProfile.class).list();
             for(EmployeeProfile d: departments) {
                  dept.put( d.getEmpId(),d.getQuarterType());           
                                             }
          Iterator it = dept.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer,String> pair=(Map.Entry)it.next();
           //  System.out.println(pair.getKey()+ pair.getValue());
           if(empId==pair.getKey()) {
               quarterType=pair.getValue();
               System.out.println(quarterType);
           }
              it.remove();
        }  
        List<QuarterAllotment> list1=null;
          List<QuarterAllotment> list= (List<QuarterAllotment>)session.createCriteria(QuarterAllotment.class).list();
        if(list.isEmpty()) {
//         Criteria cr = session.createCriteria(ResidentialQuarters.class)
//    .setProjection(Projections.projectionList()
//             .add(Projections.property("quarterCode"), "quarterCode")).add(Restrictions.eq("quarterType","quarterType"));
//      
   sql="select quarter_code from residential_quarters where quarter_type=:quarterType";
    SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("quarterType",quarterType);
        quartercode=query.list();
   list1= query.list();
          System.out.println(list1);
          return list1;
      }    
        else 
        sql="select distinct(r.quarter_code) from residential_quarters r,quarter_allotment q where r.quarter_type=:quarterType and r.quarter_id not in (select quarter_id from quarter_allotment)";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("quarterType",quarterType);
        quartercode=query.list();
        
   //     System.out.println(quartercode);
        return quartercode; 
    }
    
    
    
    
  public Quarterdto insertQuarters(Quarterdto q) throws ParseException {
       Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx=session.beginTransaction();
      
      int quarterid=0;
      try {
          int empid=q.getEmpId();
      String quartercode=q.getQuartercode();
  //   System.out.println(quartercode);
      String doissued=q.getDoissued();
      
      HashMap<Integer,String> dept=new HashMap<>();
             List<ResidentialQuarters> departments = (List<ResidentialQuarters>)session.createCriteria(ResidentialQuarters.class).list();
             for(ResidentialQuarters d: departments) {
                  dept.put( d.getQuarterId(),d.getQuarterCode());           
                 System.out.println(dept);                               }
          Iterator it = dept.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer,String> pair=(Map.Entry)it.next();
         //    System.out.println(pair.getKey()+ pair.getValue());
           if(quartercode.equals(pair.getValue())) {
               quarterid=pair.getKey();
              // System.out.println(quarterid);
           }
           
              it.remove();
        }   
        SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy");
                 Date doj1=sf.parse(doissued);
                 System.out.println("----------<<----........."+doj1);
              
                    System.out.println(quarterid);
                       EmployeeProfile e=new EmployeeProfile();
                       
                        Criteria c=session.createCriteria(EmployeeProfile.class);
           e=(EmployeeProfile) c.add(Restrictions.eq("empId",empid)).uniqueResult();
                       
                       
                 ResidentialQuarters r=new ResidentialQuarters(quarterid);
                 QuarterAllotment q1=new QuarterAllotment();
                 q1.setEmployeeProfile(e);
                 q1.setResidentialQuarters(r);
                 q1.setCheckInDate(doj1);
                  session.save(q1);                   
              tx.commit();
              session.close();
      }
      catch(Exception ex) {
          
      }
      return q;
  }
  
  public Quarterdto update(Quarterdto d) throws ParseException
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
          Transaction t=s.beginTransaction();
          int quarterid=0;
         try
         {
             QuarterAllotment q=(QuarterAllotment)s.get(QuarterAllotment.class,d.getId());
             String quartercode=d.getQuartercode();
         //    System.out.println(qid);
             int eid=d.getEmpId();
             int id=d.getId();
               HashMap<Integer,String> dept=new HashMap<>();
             List<ResidentialQuarters> departments = (List<ResidentialQuarters>)s.createCriteria(ResidentialQuarters.class).list();
             for(ResidentialQuarters d1: departments) {
                  dept.put( d1.getQuarterId(),d1.getQuarterCode());           
                 System.out.println(dept);                               }
          Iterator it = dept.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer,String> pair=(Map.Entry)it.next();
         //    System.out.println(pair.getKey()+ pair.getValue());
           if(quartercode.equals(pair.getValue())) {
               quarterid=pair.getKey();
              // System.out.println(quarterid);
           }
           
              it.remove();
        }   
             
            
             ResidentialQuarters r=new ResidentialQuarters();
             
             
               Criteria c1=s.createCriteria(ResidentialQuarters.class);
           r=(ResidentialQuarters) c1.add(Restrictions.eq("quarterId",quarterid)).uniqueResult();
             
             
             EmployeeProfile emp=new EmployeeProfile();
             
               Criteria c=s.createCriteria(EmployeeProfile.class);
           emp=(EmployeeProfile) c.add(Restrictions.eq("empId",eid)).uniqueResult();
             
              System.out.println("........................."+quarterid);
             q.setResidentialQuarters(r);
             q.setEmployeeProfile(emp);
             q.setId(id);
            s.update(q);
          //   s.save(q);
             t.commit();
           
         }
         catch(Exception e)
         {
              System.out.println("Hibernate Exception caught:" +e.getMessage());
              s.close();
         }
         return d;
    }
    public List<Quarterdto> edit(int empId)
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
          Transaction t=s.beginTransaction();
          QuarterAllotment q=null;
          Quarterdto d=new Quarterdto();
          List list = null;
          try
          {
              Criteria c=s.createCriteria(QuarterAllotment.class);
              c.add(Restrictions.eq("employeeProfile.empId",empId)).uniqueResult();
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
    
    public int delete(int quarterId)
    {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        System.out.println(quarterId);
        try
        {
        //QuarterAllotment q=(QuarterAllotment)s.get(QuarterAllotment.class,quarterId);
       //     ResidentialQuarters q=(ResidentialQuarters)s.get(ResidentialQuarters.class, quarterId);
            String sql="delete from  quarter_allotment  where quarter_id=:quarterId";
            SQLQuery query = s.createSQLQuery(sql);
            query.setParameter("quarterId",quarterId);
            query.executeUpdate();
     
        t.commit();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return quarterId;
    }
    
    public List<ResidentialQuarters> listEdit() {
       Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List l=null;
        String sql=null;
          sql="select r.quarter_code from residential_quarters r where r.quarter_id not in (select quarter_id from quarter_allotment)";
         SQLQuery query = s.createSQLQuery(sql);
      //  query.setParameter("quartertype",quartertype);
        l=query.list();
        System.out.println(l);
         return l;
    }
    
     public List<QuarterAllotment> viewEmployee(int id1) {
         Session s=HibernateUtil.getSessionFactory().openSession();
          Transaction t=s.beginTransaction();
          QuarterAllotment q=null;
          Quarterdto d=new Quarterdto();
          List list = null;
          try
          {
              Criteria c=s.createCriteria(QuarterAllotment.class);
              c.add(Restrictions.eq("employeeProfile.empId",id1)).uniqueResult();
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
    
}
