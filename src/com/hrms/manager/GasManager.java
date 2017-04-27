/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.manager;

import com.hrms.dto.Gasdto;
import com.hrms.dto.Quarterdto;
import com.hrms.model.EmployeeProfile;
import com.hrms.model.GasAllotment;
import com.hrms.model.GasConnectionMaster;
import com.hrms.model.QuarterAllotment;
import com.hrms.model.ResidentialQuarters;
import com.hrms.util.HibernateUtil;
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
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Swathi
 */
public class GasManager {
    public boolean searchEmployeee(Gasdto emp)
    {
       Session  s=HibernateUtil.getSessionFactory().openSession();
         Transaction t=s.beginTransaction();
         int empId=emp.getEmpId();
     //    String empName=emp.getEmpName();
        // Criteria cr=null;
   //     String aadharNumber=emp.getAadharNumber();
       
         try
         {
             String sql="select quarter_id,emp_id from quarter_allotment where emp_id=:empId"; 
               SQLQuery query = s.createSQLQuery(sql);
               query.setParameter("empId",empId);
           
          List<QuarterAllotment> list = query.list();
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
    
    
    
    public List<Quarterdto> searchEmployee(Gasdto emp) {
        Session s = HibernateUtil.getSessionFactory().openSession();
         Transaction t=s.beginTransaction();
          List l=new ArrayList();
          int empId=emp.getEmpId();
          System.out.println("-----------..///->"+empId);
          try
         {             
             EmployeeProfile e1=new EmployeeProfile();
               Criteria c=s.createCriteria(EmployeeProfile.class);
           e1=(EmployeeProfile) c.add(Restrictions.eq("empId",empId)).uniqueResult();
             
//             Criteria c=s.createCriteria(QuarterAllotment.class,"q");
//      
//             c.add(Restrictions.eq("q.empId",id)).uniqueResult();
             Criteria  criteria  =s.createCriteria(QuarterAllotment.class);
             criteria.add(Restrictions.eq("employeeProfile.empId",empId)).uniqueResult();
                     l=criteria.list();  
             
             System.out.println("---------------.............---------->"+l);
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
       return l;
    }
    public List consumerno(Gasdto q) {
         Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx=session.beginTransaction();
       List<GasConnectionMaster> list1=null;
        int empId=q.getEmpId();
       String quartertype=null;
       String sql=null;
         List quartercode;
      // List l=null;
       List<GasAllotment> list= (List<GasAllotment>)session.createCriteria(GasAllotment.class).list();
      if(list.isEmpty()) {
         Criteria cr = session.createCriteria(GasConnectionMaster.class)
    .setProjection(Projections.projectionList()
      .add(Projections.property("consumerNumber"), "consumerNumber"));
    

   list1= cr.list();
          System.out.println(list1);
          return list1;
      }        
        else    
      
       sql="select r.consumer_number from gas_connection_master r where  r.connection_id not in (select connection_id from gas_allotment) ";
        SQLQuery query = session.createSQLQuery(sql);
      //  query.setParameter("quartertype",quartertype);
        quartercode=query.list();
        
   //     System.out.println(quartercode);
        return quartercode; 
    }
//    public List ConsumerNumber(Quarterdto emp) {
//      Session session = HibernateUtil.getSessionFactory().openSession();
//       Transaction tx=session.beginTransaction();
//       List quartercode;
//       int empId=emp.getEmpId();
//       String quartertype=null;
//       String sql="select r.consumer_number from gas_connection_master r where  r.connection_id not in (select connection_id from gas_allotment) ";
//        SQLQuery query = session.createSQLQuery(sql);
//      //  query.setParameter("quartertype",quartertype);
//        quartercode=query.list();
//        
//   //     System.out.println(quartercode);
//        return quartercode; 
//    }
    
    public Gasdto insert(Gasdto g) {
       Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx=session.beginTransaction();    
        int eid=g.getEmpId();
        String consumerno=g.getConsumerno();
        String alloteddate=g.getAlloteddate();
        String closeddate=g.getCloseddate();
        int connectionid=0;
        try {
         HashMap<Integer,String> dept=new HashMap<>();
             List<GasConnectionMaster> departments = (List<GasConnectionMaster>)session.createCriteria(GasConnectionMaster.class).list();
             for(GasConnectionMaster d: departments) {
                  dept.put( d.getConnectionId(),d.getConsumerNumber());           
                 System.out.println(dept);                               }
          Iterator it = dept.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer,String> pair=(Map.Entry)it.next();
         //    System.out.println(pair.getKey()+ pair.getValue());
           if(consumerno.equals(pair.getValue())) {
               connectionid=pair.getKey();
              // System.out.println(quarterid);
           }
           
              it.remove();
        }   
         SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy");
                 Date doj1=sf.parse(alloteddate);
                 Date doj2=sf.parse(closeddate);
                 GasAllotment ga=new GasAllotment();
                 GasConnectionMaster m=new GasConnectionMaster();
                  Criteria c1=session.createCriteria(GasConnectionMaster.class);
           m=(GasConnectionMaster) c1.add(Restrictions.eq("connectionId",connectionid)).uniqueResult();
                 
               EmployeeProfile e1=new EmployeeProfile();
                 Criteria c=session.createCriteria(EmployeeProfile.class);
           e1=(EmployeeProfile) c.add(Restrictions.eq("empId",eid)).uniqueResult();
                 ga.setEmployeeProfile(e1);
                 ga.setGasConnectionMaster(m);
                 ga.setAllotedDate(doj1);
                 ga.setClosedDate(doj2);
                 session.save(ga);
                 tx.commit();
              session.close();
        }
        catch(Exception e) {
            
        }
        return g;
    }
    
     public boolean searchEmp(Gasdto emp) {
        Session s = HibernateUtil.getSessionFactory().openSession();
         Transaction t=s.beginTransaction();
          List l=new ArrayList();
          int empId=emp.getEmpId();
          try
         {             
         //    EmployeeProfile e1=new EmployeeProfile(empId);
//             Criteria c=s.createCriteria(QuarterAllotment.class,"q");
//      
//             c.add(Restrictions.eq("q.empId",id)).uniqueResult();
             Criteria  criteria  =s.createCriteria(GasAllotment.class);
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
     
     public List list1()
   {
       Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List<GasAllotment> glist=new ArrayList<GasAllotment>();
        try
        {
           Criteria c=s.createCriteria(GasAllotment.class);
           glist=c.list();
           t.commit();
        }
        catch(Exception e)
        {
             System.out.println(e); 
        }
        System.out.println(glist);
        return glist;
   }
     
      public List<Gasdto> edit1(int empId)
   {
        Session s=HibernateUtil.getSessionFactory().openSession();
          Transaction t=s.beginTransaction();
          GasAllotment g=null;
             Gasdto d=new Gasdto();
             List list=null;
          try
          {
             
              Criteria c=s.createCriteria(GasAllotment.class);
              c.add(Restrictions.eq("employeeProfile.empId",empId)).uniqueResult();
             list=c.list();
              t.commit();
          }
          catch(Exception e)
          {
              System.out.println(e);
             // s.close();
          }
          return list;
   }
      
     
   public Gasdto update1(Gasdto p) throws ParseException
   {
       Session s=HibernateUtil.getSessionFactory().openSession();
          Transaction t=s.beginTransaction();
          try
          {
             // GasAllotment g=(GasAllotment)s.get(GasAllotment.class,p.getEmpId());
             GasAllotment g=new GasAllotment();
                 int id=p.getId();
              int empId=p.getEmpId();
              int connectionId=0;
              String allotedate=p.getAlloteddate();
              String closeddate=p.getCloseddate();
              String consumerno=p.getConsumerno();
              System.out.println(empId);
                HashMap<Integer,String> dept=new HashMap<>();
             List<GasConnectionMaster> departments = (List<GasConnectionMaster>)s.createCriteria(GasConnectionMaster.class).list();
             for(GasConnectionMaster d1: departments) {
                  dept.put( d1.getConnectionId(),d1.getConsumerNumber());           
                 System.out.println(dept);                               }
          Iterator it = dept.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer,String> pair=(Map.Entry)it.next();
         //    System.out.println(pair.getKey()+ pair.getValue());
           if(consumerno.equals(pair.getValue())) {
               connectionId=pair.getKey();
              System.out.println(connectionId);
           }
           
              it.remove();
        }   
              
          //     Criteria c=s.createCriteria(GasAllotment.class);
         //     c.add(Restrictions.eq("employeeProfile.empId", empId));
              g.setId(id);
             // QuarterAllotment q=new QuarterAllotment(empId);
              EmployeeProfile e=new EmployeeProfile();
              Criteria c=s.createCriteria(EmployeeProfile.class);
           e=(EmployeeProfile) c.add(Restrictions.eq("empId",empId)).uniqueResult();
              
              
              
                g.setEmployeeProfile(e);
              GasConnectionMaster m=new GasConnectionMaster();
               Criteria c1=s.createCriteria(GasConnectionMaster.class);
           m=(GasConnectionMaster) c1.add(Restrictions.eq("connectionId",connectionId)).uniqueResult();
              
              
              g.setGasConnectionMaster(m);
              SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy");
                 Date doj1=sf.parse(allotedate);
                 Date doj2=sf.parse(closeddate);
              g.setAllotedDate(doj1);
              g.setClosedDate(doj2);
              s.update(g);
              t.commit();
              
          }
          catch(Exception e)
          {
              System.out.println(e);
              s.close();
          }
          return p;
   }
   
   public List<ResidentialQuarters> listEdit() {
       Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List l=null;
        String sql=null;
          sql="select r.consumer_number from gas_connection_master r where r.connection_id not in (select connection_id from gas_allotment)";
         SQLQuery query = s.createSQLQuery(sql);
      //  query.setParameter("quartertype",quartertype);
        l=query.list();
        System.out.println(l);
         return l;
    }
 
   public int delete1(int empId)
   {
       Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try
        {
            
           /*GasAllotment g=(GasAllotment)s.get(GasAllotment.class, empId);
           s.delete(g);*/
            String sql="delete from gas_allotment  where emp_id=:empId";
            SQLQuery query = s.createSQLQuery(sql);
         query.setParameter("empId",empId);
        query.executeUpdate();
           t.commit();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return empId;
   }
   
    public List gasView(int id1) {
       Session s=HibernateUtil.getSessionFactory().openSession();
          Transaction t=s.beginTransaction();
          GasAllotment g=null;
             Gasdto d=new Gasdto();
             List list=null;
          try
          {
             
              Criteria c=s.createCriteria(GasAllotment.class);
              c.add(Restrictions.eq("employeeProfile.empId",id1)).uniqueResult();
             list=c.list();
              t.commit();
          }
          catch(Exception e)
          {
              System.out.println(e);
             // s.close();
          }
          return list;
    }
  
    
}
