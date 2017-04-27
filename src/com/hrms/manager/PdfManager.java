/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.manager;

import com.hrms.dto.Pdfdto;
import com.hrms.model.DeductionMaster;
import com.hrms.model.EmployeeProfile;
import com.hrms.model.IncentiveRules;
import com.hrms.model.Incentives;
import com.hrms.model.Wages;
import com.hrms.util.HibernateUtil;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Swathi
 */
public class PdfManager {
    
    public List<Integer> searchEmployee(Pdfdto p) {
        int empid=p.getEmp_id();
        int wdays=p.getWorkingdays();
        List<Integer> l=new ArrayList<>();
        int netsal=0;
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try {
            Wages w=new Wages();
             Criteria c=s.createCriteria(Wages.class);
           w=(Wages) c.add(Restrictions.eq("employeeProfile.empId",empid)).uniqueResult();
            System.out.println("basic rate is--------------->>>>>>"+w.getBasicRate());
            netsal=wdays*w.getBasicRate();
             System.out.println("Net salary is--------------->>>>>>"+netsal);
            l.add(netsal);
            System.out.println("List in manager is --------------<<<<<<<<<<<<"+l);
        }
        catch(Exception e) {
            
        }
        System.out.println("List in manager is --------------<<<<<<<<<<<<"+l);
        return l;
    }
    
    public List<EmployeeProfile> empList(Pdfdto p) {
        List l=null;
        int empid=p.getEmp_id();
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try {
              EmployeeProfile e=new EmployeeProfile();
              Criteria c=s.createCriteria(EmployeeProfile.class);
              e=(EmployeeProfile) c.add(Restrictions.eq("empId",empid)).uniqueResult();
              l=c.list();
        }
        catch(Exception ex) {
          
            
        }
        System.out.println("list in Employee Profile is--------"+l);
        return l;
    }
    
   
 public List<Incentives> incentiveList(Pdfdto p) {
        List l=new ArrayList();
        List l1=new ArrayList();
        int empid=p.getEmp_id();
        String date=p.getDate();
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        Incentives i=new Incentives();
        Date realdate=new Date();
        try {  
              SimpleDateFormat s1=new SimpleDateFormat("dd-MM-yy");
              Date d1=s1.parse(date);
              System.out.println("Date is [[[[[[[[[[[[[[["+d1);
               Calendar cal = Calendar.getInstance();
                cal.setTime(d1);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH)+1;            
               
                
                System.out.println("Incentives year year isssssssss"+year);
                System.out.println("Incentives month isssssssss"+month);
              Criteria c=s.createCriteria(Incentives.class);
              c.add(Restrictions.eq("employeeProfileByEmpiId.empId",empid)).setProjection(Projections.property("date"));
              l=c.list();
              
               //   .add(Restrictions.eq("year(ddate)",year));
              System.out.println("list in Incentives is';;';';;';'';;'--------"+l);
              for(int i1=0; i1<l.size(); i1++) {
                  Date ddd=(Date) l.get(i1);
                  System.out.println("Incentives iterator is---------"+ddd);
                   cal.setTime(ddd);
                 int year8 = cal.get(Calendar.YEAR);
                int month8 = cal.get(Calendar.MONTH)+1;
                if(year==year8 &&month==month8) {
                    realdate=ddd;
                }
              }
              System.out.println("real date is..............."+realdate);
              Criteria c1=s.createCriteria(Incentives.class);
              i=(Incentives) c1.add(Restrictions.eq("date",realdate)).add(Restrictions.eq("employeeProfileByEmpiId.empId", empid)).uniqueResult();                
             l1=c1.list();
        }
        catch(Exception ex) {
          
            
        }
        System.out.println("list is';;';';;';'';;'--------"+l1);
        return l1;   
        }
     
     public List<DeductionMaster> deductionList(Pdfdto p) {
        List l=new ArrayList();
        List l1=new ArrayList();
        int empid=p.getEmp_id();
        String date=p.getDate();
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        DeductionMaster i=new DeductionMaster();
        Date realdate=new Date();
        try {  
              SimpleDateFormat s1=new SimpleDateFormat("dd-MM-yy");
              Date d1=s1.parse(date);
              System.out.println("Date is [[[[[[[[[[[[[[["+d1);
               Calendar cal = Calendar.getInstance();
                cal.setTime(d1);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH)+1;            
               
                
                System.out.println("year isssssssss"+year);
                System.out.println("month isssssssss"+month);
              Criteria c=s.createCriteria(DeductionMaster.class);
              c.add(Restrictions.eq("employeeProfileByEmpdId.empId",empid)).setProjection(Projections.property("ddate"));
              l=c.list();
              
               //   .add(Restrictions.eq("year(ddate)",year));
              System.out.println("list in Deductions is';;';';;';'';;'--------");
              for(int i1=0; i1<l.size(); i1++) {
                  Date ddd=(Date) l.get(i1);
                  System.out.println("iterator is---------"+ddd);
                   cal.setTime(ddd);
                 int year8 = cal.get(Calendar.YEAR);
                int month8 = cal.get(Calendar.MONTH)+1;
                if(year==year8 &&month==month8) {
                    realdate=ddd;
                }
              }
              System.out.println("real date is..............."+realdate);
              Criteria c1=s.createCriteria(DeductionMaster.class);
              i=(DeductionMaster) c1.add(Restrictions.eq("ddate",realdate)).add(Restrictions.eq("employeeProfileByEmpdId.empId", empid)).uniqueResult();                
             l1=c1.list();
        }
        catch(Exception ex) {
          
            
        }
        System.out.println("list is';;';';;';'';;'--------"+l1);
        return l1;
    }
     
     
     public List<Integer> deductionListtotal(Pdfdto p) {
        List<Integer> l=new ArrayList();
        List l1=new ArrayList();
        int empid=p.getEmp_id();
        String date=p.getDate();
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        DeductionMaster i=new DeductionMaster();
        Date realdate=new Date();
        try {  
              SimpleDateFormat s1=new SimpleDateFormat("dd-MM-yy");
              Date d1=s1.parse(date);
              System.out.println("Date is [[[[[[[[[[[[[[["+d1);
               Calendar cal = Calendar.getInstance();
                cal.setTime(d1);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH)+1;            
               
                
                System.out.println("year isssssssss"+year);
                System.out.println("month isssssssss"+month);
              Criteria c=s.createCriteria(DeductionMaster.class);
              c.add(Restrictions.eq("employeeProfileByEmpdId.empId",empid)).setProjection(Projections.property("ddate"));
              l1=c.list();
              
               //   .add(Restrictions.eq("year(ddate)",year));
              System.out.println("list in Deductions is';;';';;';'';;'--------");
              for(int i1=0; i1<l1.size(); i1++) {
                  Date ddd=(Date) l1.get(i1);
                  System.out.println("iterator is---------"+ddd);
                   cal.setTime(ddd);
                 int year8 = cal.get(Calendar.YEAR);
                int month8 = cal.get(Calendar.MONTH)+1;
                if(year==year8 &&month==month8) {
                    realdate=ddd;
                }
              }
              System.out.println("real date is..............."+realdate);
              Criteria c1=s.createCriteria(DeductionMaster.class);
              i=(DeductionMaster) c1.add(Restrictions.eq("ddate",realdate)).add(Restrictions.eq("employeeProfileByEmpdId.empId", empid)).uniqueResult();                
          
             int ppp=i.getPpp(); int sal_adv=i.getSalaryAdvance(); int total_amt=i.getTotalSanctionedAmount();
             int power=i.getPower(); int meals=i.getMeals(); int tiffin=i.getTiffin();
             int tea=i.getTea(); int store=i.getStore(); int medicines=i.getMedicines();
             int cable=i.getCable(); int gas=i.getGas(); int adv2=i.getAdv2();
             int eggs=i.getEggs(); int uniform=i.getUniform();
             int total_misc=ppp+sal_adv+total_amt+power+meals+tiffin+tea+store+medicines+cable+gas+adv2+eggs+uniform;
             System.out.println("total misc is ==========="+total_misc);
             l.add(total_misc);
        }
        catch(Exception ex) {
          
            
        }
        System.out.println("list is';;';';;';'';;'--------"+l1);
        return l;
    }
      
    
     public boolean validateUser(Pdfdto p) {
         System.out.println("---------home----??????????------------"); 
        
            System.out.println("-------------------ssssssssssss");
       Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction t=session.beginTransaction();
        try {
            int empid = p.getEmp_id();
           
//            String sql = "select * from User l where l.username=:name and l.password=:pwd";
//            Query query = session.createSQLQuery(sql);
//            query.setParameter("name", name);
//            query.setParameter("pwd", pwd);
        //    List<User> list = query.list();
            
            Criteria c=session.createCriteria(Wages.class);
            c.add(Restrictions.eq("employeeProfile.empId", empid));
            List<Wages> list = c.list();
            
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
     
     
      public boolean validateUserIncentives(Pdfdto p) {
         System.out.println("---------home----??????????------------"); 
        
        System.out.println("-------------------ssssssssssss");
       Session s = HibernateUtil.getSessionFactory().openSession();
       Transaction t=s.beginTransaction();
       List l=new ArrayList();
        List l1=new ArrayList();
        try {
            int empid = p.getEmp_id();
            String date=p.getDate();
         Incentives i=new Incentives();
        Date realdate=new Date();
           SimpleDateFormat s1=new SimpleDateFormat("dd-MM-yy");
              Date d1=s1.parse(date);
              System.out.println("Swaaaaaaaaaaaaaathiiiiiiiiiii"+d1);
               Calendar cal = Calendar.getInstance();
                cal.setTime(d1);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH)+1;            
               
                
                System.out.println("Incentives year year isssssssss"+year);
                System.out.println("Incentives month isssssssss"+month);
              Criteria c=s.createCriteria(Incentives.class);
              c.add(Restrictions.eq("employeeProfileByEmpiId.empId",empid)).setProjection(Projections.property("date"));
              l=c.list();
              
               //   .add(Restrictions.eq("year(ddate)",year));
              System.out.println("list in Incentives is';;';';;';'';;'--------"+l);
              for(int i1=0; i1<l.size(); i1++) {
                  Date ddd=(Date) l.get(i1);
                  System.out.println("Incentives iterator is---------"+ddd);
                   cal.setTime(ddd);
                 int year8 = cal.get(Calendar.YEAR);
                int month8 = cal.get(Calendar.MONTH)+1;
                if(year==year8 &&month==month8) {
                    realdate=ddd;
                }
              }
              System.out.println("real date is..............."+realdate);
              Criteria c1=s.createCriteria(Incentives.class);
              i=(Incentives) c1.add(Restrictions.eq("date",realdate)).add(Restrictions.eq("employeeProfileByEmpiId.empId", empid)).uniqueResult();                
             l1=c1.list();
            
            if (l1.size() > 0) {
                //session.close();
                return false;
            }
            t.commit();
            s.close();
        } catch (Exception e) {
            //session.getTransaction().rollback();
        } finally {
            if (s != null) {
               // session.close();
            }
        }

        return true;

    }
      
      public boolean validateDeductionlist(Pdfdto p) {
           Session s = HibernateUtil.getSessionFactory().openSession();
       Transaction t=s.beginTransaction();
       List l=new ArrayList();
        List l1=new ArrayList();
        try {
            int empid = p.getEmp_id();
            String date=p.getDate();
         DeductionMaster i=new DeductionMaster();
        Date realdate=new Date();
           SimpleDateFormat s1=new SimpleDateFormat("dd-MM-yy");
              Date d1=s1.parse(date);
              System.out.println("Date is [[[[[[[[[[[[[[["+d1);
               Calendar cal = Calendar.getInstance();
                cal.setTime(d1);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH)+1;            
               
                
                System.out.println("Incentives year year isssssssss"+year);
                System.out.println("Incentives month isssssssss"+month);
              Criteria c=s.createCriteria(DeductionMaster.class);
              c.add(Restrictions.eq("employeeProfileByEmpdId.empId",empid)).setProjection(Projections.property("ddate"));
              l=c.list();
              
               //   .add(Restrictions.eq("year(ddate)",year));
              System.out.println("list in Incentives is';;';';;';'';;'--------"+l);
              for(int i1=0; i1<l.size(); i1++) {
                  Date ddd=(Date) l.get(i1);
                  System.out.println("Incentives iterator is---------"+ddd);
                   cal.setTime(ddd);
                 int year8 = cal.get(Calendar.YEAR);
                int month8 = cal.get(Calendar.MONTH)+1;
                if(year==year8 &&month==month8) {
                    realdate=ddd;
                }
              }
              System.out.println("real date is..............."+realdate);
              Criteria c1=s.createCriteria(DeductionMaster.class);
              i=(DeductionMaster) c1.add(Restrictions.eq("ddate",realdate)).add(Restrictions.eq("employeeProfileByEmpdId.empId", empid)).uniqueResult();                
             l1=c1.list();
            
            if (l1.size() > 0) {
                //session.close();
                return false;
            }
            t.commit();
            s.close();
        } catch (Exception e) {
            //session.getTransaction().rollback();
        } finally {
            if (s != null) {
               // session.close();
            }
        }

        return true;
      }
      
      
       public boolean trivs(Pdfdto p) {
           Session s = HibernateUtil.getSessionFactory().openSession();
       Transaction t=s.beginTransaction();
       List l=new ArrayList();
        List l1=new ArrayList();
           System.out.println("hhhhhhhhhhhhhhhhhhhh");
        
        try {
          //  int empid = p.getEmp_id();
          
            String date=p.getEmpdate();
         DeductionMaster i;
         System.out.println("duuuuuuuuuuuuuuuuuude"+date);
        Date realdate=new Date();
           SimpleDateFormat s1=new SimpleDateFormat("dd-MM-yy");          
              Date d1=s1.parse(date);
             
                System.out.println("fgggggggggggggggggdfgdgdfg");
              System.out.println("Date is [[[[[[[[[[[[[[["+d1);
               Calendar cal = Calendar.getInstance();
                cal.setTime(d1);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH)+1;            
               
                
                System.out.println("Incentives year year isssssssss"+year);
                System.out.println("Incentives month isssssssss"+month);
              Criteria c=s.createCriteria(DeductionMaster.class);
              c.setProjection(Projections.property("ddate"));
              l=c.list();
              
               //   .add(Restrictions.eq("year(ddate)",year));
              System.out.println("list in Incentives is';;';';;';'';;'--------"+l);
              for(int i1=0; i1<l.size(); i1++) {
                  Date ddd=(Date) l.get(i1);
                  System.out.println("Incentives iterator is---------"+ddd);
                   cal.setTime(ddd);
                 int year8 = cal.get(Calendar.YEAR);
                int month8 = cal.get(Calendar.MONTH)+1;
                if(year==year8 &&month==month8) {
                    realdate=ddd;
                    
                     System.out.println("real date is..............."+realdate);
              Criteria c1=s.createCriteria(DeductionMaster.class);
             c1.add(Restrictions.eq("ddate",realdate));                
             l1=c1.list();
                }
                if (l1.size() > 0) {
                //session.close();
                return false;
            }
              }
             
             System.out.println("--------------------dgdfg--------------list------------>"+l1);
            
            
            t.commit();
            s.close();
        } catch (Exception e) {
            //session.getTransaction().rollback();
        } finally {
            if (s != null) {
               // session.close();
            }
        }

        return true;
      }
     
      public List<Integer> getYear(Pdfdto p) {
          System.out.println("HELLLLLLLLLLLLLLLLLLLLO SWATHI");
          Session s = HibernateUtil.getSessionFactory().openSession();
       Transaction t=s.beginTransaction();
       List<Integer> l=new ArrayList();
        try {
            int empid = p.getEmp_id();
            String date=p.getDate();
         Incentives i=new Incentives();
        Date realdate=new Date();
           SimpleDateFormat s1=new SimpleDateFormat("dd-MM-yy");
              Date d1=s1.parse(date);
              System.out.println("Date is [[[[[[[[[[[[[[["+d1);
               Calendar cal = Calendar.getInstance();
                cal.setTime(d1);
                int year = cal.get(Calendar.YEAR);
                  l.add(year);
                  
        }
        catch(Exception e) {
            
        }
        return l;
      }
      
        public List<String> getMonth(Pdfdto p) {
          System.out.println("HELLLLLLLLLLLLLLLLLLLLO SWATHI");
          Session s = HibernateUtil.getSessionFactory().openSession();
       Transaction t=s.beginTransaction();
       List<String> l=new ArrayList();
        try {
            int empid = p.getEmp_id();
            String date=p.getDate();
         Incentives i=new Incentives();
        Date realdate=new Date();
           SimpleDateFormat s1=new SimpleDateFormat("dd-MM-yy");
              Date d1=s1.parse(date);
              System.out.println("Date is [[[[[[[[[[[[[[["+d1);
               Calendar cal = Calendar.getInstance();
                cal.setTime(d1);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH)+1;   
                  String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            String newmonth=monthNames[month-1];          
          System.out.println("Month name is"+newmonth);
                  l.add(newmonth);
                  
        }
        catch(Exception e) {
            
        }
        return l;
      }
        
        
        
 
   
     
}
