/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.manager;

import com.hrms.dto.IncentivesForm;
import com.hrms.model.DeductionMaster;
import com.hrms.model.EmployeeProfile;
import com.hrms.model.IncentiveRules;
import com.hrms.model.Incentives;
import com.hrms.model.Wages;
import com.hrms.util.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author NSG
 */
public class IncentivesManager 
{
    Session s=null;
    public void insertIncentive(IncentivesForm form) 
    {
          Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try
        {
            String dod=form.getDate();
            int days=form.getDays();
            int inc=form.getInc();
            int id=form.getEmpId();
            SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy");
              Date doj1=sf.parse(dod);
             
             Incentives i=new Incentives();
             i.setInc(inc);
             i.setIncentiveCode(form.getIncentiveCode());
             i.setIncentiveId(form.getIncentiveId());
             i.setIncentiveName(form.getIncentiveName());
             i.setDays(days);
             i.setDate(doj1);
             Calendar cal = Calendar.getInstance();
                cal.setTime(doj1);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH)+1; 
             EmployeeProfile e=new EmployeeProfile();
              Criteria c2=s.createCriteria(EmployeeProfile.class);
              e=(EmployeeProfile) c2.add(Restrictions.eq("empId",id)).uniqueResult();
             i.setEmployeeProfile(e);  
             
             Wages w=new Wages();
             Criteria c=s.createCriteria(Wages.class);
             
            w=(Wages) c.add(Restrictions.eq("employeeProfile.empId", id)).uniqueResult();
            System.out.println("\n mmmmmmmmmmmmmmm"+c);
            int wage=w.getBasicRate(); System.out.println("wage is''''''''''''''"+w.getBasicRate());
            
            int earn=days*wage; System.out.println("earn is''''''''''''''"+earn);
            int incamt=inc*days; System.out.println("incamt is''''''''''''''"+incamt);
            int gross_sal=incamt+wage;
            List l=null;
            Date realdate = null;
            DeductionMaster d=new DeductionMaster();
            Criteria c3=s.createCriteria(DeductionMaster.class);
              c3.add(Restrictions.eq("employeeProfileByEmpdId.empId",id)).setProjection(Projections.property("ddate"));
              l=c3.list();
              
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
            d=(DeductionMaster) c1.add(Restrictions.eq("ddate",realdate)).add(Restrictions.eq("employeeProfileByEmpdId.empId", id)).uniqueResult();
          
             int total_ded=d.getTotalDeductions();  System.out.println("total deductions is''''''''''''''"+d.getTotalDeductions());
              System.out.println("\n bbbbbbbbbbbbbbbbb"+total_ded);
             int net_sal=gross_sal-total_ded; System.out.println("wage is''''''''''''''"+net_sal);
             
             i.setWage(wage);
             i.setEarn(earn);
             i.setIncAmount(incamt);
             i.setGrossSalary(gross_sal);
             i.setNetSalary(net_sal);
             i.setDeptiId(e.getDepartments());
             s.save(i);
             t.commit();
             System.out.println("\n Incentives inserted successfully");
        }
        catch(HibernateException h )
        {
            System.out.println("Hibernate Exception during insertion"+h);
            h.printStackTrace();
        }
       
        catch(Exception e)
        {
            System.out.println("Exception during insertion"+e);
            e.printStackTrace();
        }
        finally
        {
            s.close();
        }    
    }
    public List getruleid()
    {
        s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        List<Integer> in=new ArrayList<>();
        List<IncentiveRules> l=(List<IncentiveRules>)s.createCriteria(IncentiveRules.class).list();
        for(IncentiveRules w : l)
       {
            in.add(w.getIncentiveRuleId());
        }
        return in;
    }
    public boolean validEmp(IncentivesForm l)
    {
        s = HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        int empId=l.getEmpId();
        try 
        {
            System.out.println("ksjhk\\\\\\\\------------------------"+empId);
            String sql = "from EmployeeProfile l where l.empId=:empId ";
            Query query = s.createQuery(sql);
            query.setParameter("empId",empId);
            List<EmployeeProfile> list = query.list();
            if (list.size() > 0) 
            {
                  s.close();
                  return true;
            }   
        } 
        catch(HibernateException h)
         {
             System.out.println("HibernateException during Searching:"+h);
             h.printStackTrace();
         }
         catch(Exception ex)
         {
            System.out.println("Exception during Searching:"+ex);
         }
         finally
         {
            s.close();
         }

        return false;

    }
    
     public boolean validEmpded(IncentivesForm l)
    {
        s = HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        int empId=l.getEmpId();
        try 
        {
             System.out.println("ksjhk[[[[[[[[[[[[[[[[[[------------------------"+empId);
            Criteria c1=s.createCriteria(DeductionMaster.class);
            c1.add(Restrictions.eq("employeeProfileByEmpdId.empId", empId)).uniqueResult();
          
            List<DeductionMaster> list = c1.list();
            if (list.size() > 0) 
            {
                  s.close();
                  return true;
            }   
        } 
        catch(HibernateException h)
         {
             System.out.println("HibernateException during Searching:"+h);
             h.printStackTrace();
         }
         catch(Exception ex)
         {
            System.out.println("Exception during Searching:"+ex);
         }
         finally
         {
            s.close();
         }

        return false;

    }
     
      public boolean validEmpwage(IncentivesForm l)
    {
        s = HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        int empId=l.getEmpId();
        try 
        {
             System.out.println("ksjh-------======================------------------------"+empId);
            Criteria c1=s.createCriteria(Wages.class);
            c1.add(Restrictions.eq("employeeProfile.empId", empId)).uniqueResult();
          
            List<Wages> list = c1.list();
            if (list.size() > 0) 
            {
                  s.close();
                  return true;
            }   
        } 
        catch(HibernateException h)
         {
             System.out.println("HibernateException during Searching:"+h);
             h.printStackTrace();
         }
         catch(Exception ex)
         {
            System.out.println("Exception during Searching:"+ex);
         }
         finally
         {
            s.close();
         }

        return false;

    }
    
    public List<IncentivesForm> displayIncentive()
    {
        s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        List l=null;
        try
        {
            Criteria cr=s.createCriteria(Incentives.class);
            l=cr.list();
            t.commit();
            System.out.println("\n displayed successfully");
        }
        catch(HibernateException h)
        {
            System.out.println("\n Hibernate Exception during display"+h);
            h.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println("\n Exception during display"+e);
            e.printStackTrace();
        }
        finally
        {
            s.close();
        }
        return l;
    }
    
    public void deleteIncentive(int id)
    {
        s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try
        {
            Incentives g=new Incentives();
            Criteria cr=s.createCriteria(Incentives.class);
            g=(Incentives) cr.add(Restrictions.eq("id", id)).uniqueResult();
            s.delete(g);
            t.commit();
            System.out.println("\n deleted successfully");
        }
         catch(HibernateException h)
        {
            System.out.println("Hibernate Exception during deletion"+h);
            h.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println("Exception during deletion"+e);
            e.printStackTrace();
        }
        finally
         {
            s.close();
         }    
    }

    public List<IncentivesForm> editIncentive(int id1) 
    {
        s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List<IncentivesForm> l=null;
        try
        {
            Incentives gm=new Incentives();
            Criteria cr=s.createCriteria(Incentives.class);
            cr.add(Restrictions.eq("id", id1)).uniqueResult();
            l=cr.list();
        }
        catch(HibernateException h)
        {
            System.out.println("Hibernate Exception during edit"+h);
        }
        catch(Exception e)
        {
            System.out.println("Exception during edit"+e);
            
        }
        finally
        {
            s.close();
        }
        return l;
        
    }

    public void updateIncentive(IncentivesForm form, int id1) 
    {
       s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try
        {
             int days=form.getDays();
             int inc=form.getInc();
             int id=form.getEmpId();
             int incid=form.getIncentiveId();
            System.out.println("----------------->incen update");
             Incentives i=new Incentives();
             i=(Incentives) s.get(Incentives.class, id1);
             i.setInc(inc);
             i.setIncentiveCode(form.getIncentiveCode());
             i.setIncentiveId(form.getIncentiveId());
             i.setIncentiveName(form.getIncentiveName());
             i.setDays(days); 
              EmployeeProfile e=new EmployeeProfile();
              Criteria c4=s.createCriteria(EmployeeProfile.class);
              e=(EmployeeProfile) c4.add(Restrictions.eq("empId",form.getEmpId())).uniqueResult();
             
             
             i.setEmployeeProfile(e);
                          Wages w=new Wages();
             Criteria c=s.createCriteria(Wages.class);
             
            w=(Wages) c.add(Restrictions.eq("employeeProfile.empId", id)).uniqueResult();
            System.out.println("\n mmmmmmmmmmmmmmm"+c);
            int wage=w.getBasicRate(); System.out.println("wage is''''''''''''''"+w.getBasicRate());
            
            int earn=days*wage; System.out.println("earn is''''''''''''''"+earn);
            int incamt=inc*days; System.out.println("incamt is''''''''''''''"+incamt);
            int gross_sal=incamt+wage;

             Criteria c1=s.createCriteria(Incentives.class);
              i=(Incentives) c1.add(Restrictions.eq("incentiveId", incid)).uniqueResult();
             Date ddd=i.getDate();
              Calendar cal = Calendar.getInstance();
                cal.setTime(ddd);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH)+1; 
             
                List l=null;
            Date realdate = null;
            DeductionMaster d=new DeductionMaster();
            Criteria c3=s.createCriteria(DeductionMaster.class);
              c3.add(Restrictions.eq("employeeProfileByEmpdId.empId",id)).setProjection(Projections.property("ddate"));
              l=c3.list();
             
              for(int i1=0; i1<l.size(); i1++) {
                  Date dd=(Date) l.get(i1);
                  System.out.println("iterator is---------"+dd);
                   cal.setTime(dd);
                 int year8 = cal.get(Calendar.YEAR);
                int month8 = cal.get(Calendar.MONTH)+1;
                if(year==year8 &&month==month8) {
                    realdate=dd;
                }
              }
              System.out.println("real date is..............."+realdate);
              
              Criteria c2=s.createCriteria(DeductionMaster.class);
            d=(DeductionMaster) c2.add(Restrictions.eq("ddate",realdate)).add(Restrictions.eq("employeeProfileByEmpdId.empId", id)).uniqueResult();
          
             int total_ded=d.getTotalDeductions();  System.out.println("total deductions is''''''''''''''"+d.getTotalDeductions());
              System.out.println("\n bbbbbbbbbbbbbbbbb"+total_ded);
             int net_sal=gross_sal-total_ded; System.out.println("wage is''''''''''''''"+net_sal);
             i.setWage(wage);
             i.setEarn(earn);
             i.setIncAmount(incamt);
             i.setGrossSalary(gross_sal);
             i.setNetSalary(net_sal);
             i.setDeptiId(e.getDepartments());
             s.update(i);
             t.commit();
             System.out.println("\n Incentives updated successfully");
        }
        catch(HibernateException h)
        {
            System.out.println("Hibernate Exception during update"+h);
            h.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println("Exception during update"+e);
            e.printStackTrace();
        }
        finally
        {
            s.close();
        }    
    }
    
     public boolean validateUserIncentives(IncentivesForm p) {
         System.out.println("---------home----??????????------------"); 
        
        System.out.println("-------------------ssssssssssss");
       Session s = HibernateUtil.getSessionFactory().openSession();
       Transaction t=s.beginTransaction();
       List l=new ArrayList();
        List l1=new ArrayList();
        try {
            int empid = p.getEmpId();
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
                return true;
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

        return false;

    }
    
    
}

//String dod=form.getDate();
//            int days=form.getDays();
//            int inc=form.getInc();
//            int id=form.getEmpId();
//            SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy");
//              Date doj1=sf.parse(dod);
//             
//             Incentives i=new Incentives();
//             i.setInc(inc);
//             i.setIncentiveCode(form.getIncentiveCode());
//             i.setIncentiveId(form.getIncentiveId());
//             i.setIncentiveName(form.getIncentiveName());
//             i.setDays(days);
//             i.setDate(doj1);
//             Calendar cal = Calendar.getInstance();
//                cal.setTime(doj1);
//                int year = cal.get(Calendar.YEAR);
//                int month = cal.get(Calendar.MONTH)+1; 
//             EmployeeProfile e=new EmployeeProfile();
//              Criteria c2=s.createCriteria(EmployeeProfile.class);
//              e=(EmployeeProfile) c2.add(Restrictions.eq("empId",id)).uniqueResult();
//             i.setEmployeeProfile(e);  
//             
//             Wages w=new Wages();
//             Criteria c=s.createCriteria(Wages.class);
//             
//            w=(Wages) c.add(Restrictions.eq("employeeProfile.empId", id)).uniqueResult();
//            System.out.println("\n mmmmmmmmmmmmmmm"+c);
//            int wage=w.getBasicRate(); System.out.println("wage is''''''''''''''"+w.getBasicRate());
//            
//            int earn=days*wage; System.out.println("earn is''''''''''''''"+earn);
//            int incamt=inc*days; System.out.println("incamt is''''''''''''''"+incamt);
//            int gross_sal=incamt+wage;
//            List l=null;
//            Date realdate = null;
//            DeductionMaster d=new DeductionMaster();
//            Criteria c3=s.createCriteria(DeductionMaster.class);
//              c3.add(Restrictions.eq("employeeProfileByEmpdId.empId",id)).setProjection(Projections.property("ddate"));
//              l=c3.list();
//              
//               //   .add(Restrictions.eq("year(ddate)",year));
//              System.out.println("list in Deductions is';;';';;';'';;'--------");
//              for(int i1=0; i1<l.size(); i1++) {
//                  Date ddd=(Date) l.get(i1);
//                  System.out.println("iterator is---------"+ddd);
//                   cal.setTime(ddd);
//                 int year8 = cal.get(Calendar.YEAR);
//                int month8 = cal.get(Calendar.MONTH)+1;
//                if(year==year8 &&month==month8) {
//                    realdate=ddd;
//                }
//              }
//              System.out.println("real date is..............."+realdate);
//            
//            
//            
//            Criteria c1=s.createCriteria(DeductionMaster.class);
//            d=(DeductionMaster) c1.add(Restrictions.eq("ddate",realdate)).add(Restrictions.eq("employeeProfileByEmpdId.empId", id)).uniqueResult();
//          
//             int total_ded=d.getTotalDeductions();  System.out.println("total deductions is''''''''''''''"+d.getTotalDeductions());
//              System.out.println("\n bbbbbbbbbbbbbbbbb"+total_ded);
//             int net_sal=gross_sal-total_ded; System.out.println("wage is''''''''''''''"+net_sal);
//             
//             i.setWage(wage);
//             i.setEarn(earn);
//             i.setIncAmount(incamt);
//             i.setGrossSalary(gross_sal);
//             i.setNetSalary(net_sal);
//             
//             s.save(i);
//             t.commit();
//             System.out.prin