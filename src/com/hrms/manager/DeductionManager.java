/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.manager;

import com.hrms.dto.Deductions;
import com.hrms.dto.Pdfdto;
import com.hrms.model.DeductionMaster;
import com.hrms.model.DeductionRules;
import com.hrms.model.EmployeeProfile;
import com.hrms.model.LoanAllotment;
import com.hrms.util.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Masrat
 */
public class DeductionManager {
    Session s=null;
     List<DeductionMaster> deds = null;

    public List getDedId() {
         List list=new ArrayList<>();
         s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try{
        List<DeductionRules> l=(List<DeductionRules>)s.createCriteria(DeductionRules.class).list();
       for(DeductionRules d : l)
       {
            list.add(d.getDeductionRuleId());
       }
        }catch(Exception e){
            System.out.println("Error due to retrieving rule id-------->"+e);
        }
        t.commit();
        s.close();
        return list;
    }

    public void addDeductions(Deductions deduc) {
         s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        int xz=0,totalded=0;
        try{
        DeductionMaster ded=new DeductionMaster();
      //  DeductionRules dr=new DeductionRules();
        EmployeeProfile ep=new EmployeeProfile();
        ded.setDeductionId(deduc.getDeductionId());
        ded.setDeductionName(deduc.getDeductionName());
        ded.setDeductionCode(deduc.getDeductionCode());
        ded.setAdv2(deduc.getAdv2());
        ded.setCable(deduc.getCable());
        ded.setEggs(deduc.getEggs());
        ded.setGas(deduc.getGas());
        ded.setMeals(deduc.getMeals());
        ded.setMedicines(deduc.getMedicines());
        ded.setPf(deduc.getPf());
        ded.setPfNo(deduc.getPfNum());
        ded.setPower(deduc.getPower());
        ded.setPpp(deduc.getPpp());
        String p=deduc.getRecordCreationDate();
        SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy");
        Date doj1=sf.parse(p);
        ded.setDdate(doj1);
           
        //ded.setLoanAmount(deduc.getLoanAmount());
        ded.setUniform(deduc.getUniform());
        ded.setSalaryAdvance(deduc.getSalaryAdvance());
        ded.setTiffin(deduc.getTiffin());
        ded.setTea(deduc.getTea());
        ded.setStore(deduc.getStore());
        Criteria c2 = s.createCriteria(LoanAllotment.class);
        try{
       List<LoanAllotment> la=c2.add(Restrictions.eq("employeeProfile.empId", deduc.getEmpId())).list();
       System.out.println("--------------------jghh");
       if(la!=null){
        for(Object o:la){
            LoanAllotment l=(LoanAllotment)o;
            System.out.println("---------------sanc------------->"+l.getSanctionedAmt());
            if(l.getStatus().equals("Approved"))
            xz+=l.getSanctionedAmt();
        }
        ded.setTotalSanctionedAmount(xz);
       }
        }catch(Exception o){
             System.out.println("--------------------jghh"+o);
        }
        
         totalded=deduc.getUniform()+deduc.getPf()+deduc.getPpp()+deduc.getSalaryAdvance()+deduc.getPower()+deduc.getMeals()+deduc.getTiffin()+deduc.getTea()+deduc.getStore()+deduc.getMedicines()+deduc.getCable()+deduc.getGas()+deduc.getAdv2()+deduc.getEggs();
       ded.setTotalDeductions(totalded+xz);
        
        Criteria c = s.createCriteria(DeductionRules.class);
//        dr= (DeductionRules) c.add(Restrictions.eq("deductionRuleId", deduc.getDeductionRuleId())).uniqueResult();
//        ded.setDeductionRules(dr);
        Criteria c1 = s.createCriteria(EmployeeProfile.class);
        ep= (EmployeeProfile) c1.add(Restrictions.eq("empId", deduc.getEmpId())).uniqueResult();
        ded.setEmployeeProfile(ep);
        ded.setDeptdId(ep.getDepartments());
        s.save(ded);
        } catch(Exception e){
            System.out.println("Error due to adding deductions-------->"+e);
        }
         t.commit();
        s.close();
        System.out.println("--------- added deduction------------");
    }

    public List getDeduList() {
        s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try{
        Criteria crit = s.createCriteria(DeductionMaster.class);
            deds = crit.list();
        } catch(Exception e){
            System.out.println("Error due to displaying deductions-------->"+e);
        }
       t.commit();
        s.close();
        return deds;
    }

    public void deleteDeductions(int deductionId) {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try{
        DeductionMaster la=new DeductionMaster();
        Criteria c = s.createCriteria(DeductionMaster.class);
         la=(DeductionMaster) c.add(Restrictions.eq("id", deductionId)).uniqueResult();
            s.delete(la);
        } catch(Exception e){
            System.out.println("Error due to deleting deductions-------->"+e);
        }
            t.commit();
            s.close();
        System.out.println("------------ deleted successfully-------------");
    }

    public List<Deductions> editDeductions(int id) {
        System.out.println("------edit-------->");
        
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List<Deductions> l=null;
      
        try{
            DeductionMaster la=new DeductionMaster();
        Criteria c = s.createCriteria(DeductionMaster.class);
            c.add(Restrictions.eq("id", id)).uniqueResult();
             l= c.list();
            t.commit();
            s.close();
        } catch(Exception e){
            System.out.println("Error due to eediting deductions-------->"+e);
        }
        finally{
           // s.close();
        }
         return l;
    }

    public void updateDeductions(Deductions deduc, int id) {
          s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        int xz=0,totalded=0;
        try{
             
             DeductionMaster ded=new DeductionMaster();
             ded=(DeductionMaster) s.get(DeductionMaster.class, id);
              System.out.println("dgfdjg----------------"+"]]]]]"+ded);
       // DeductionRules dr=new DeductionRules();
        EmployeeProfile ep=new EmployeeProfile();
       // ded.setDeductionId(deduc.getDeductionId());
       
        ded.setDeductionName(deduc.getDeductionName());
        ded.setDeductionCode(deduc.getDeductionCode());
        ded.setAdv2(deduc.getAdv2());
        ded.setCable(deduc.getCable());
        ded.setEggs(deduc.getEggs());
        ded.setGas(deduc.getGas());
        ded.setMeals(deduc.getMeals());
        ded.setMedicines(deduc.getMedicines());
        ded.setPf(deduc.getPf());
        ded.setPfNo(deduc.getPfNum());
        ded.setPower(deduc.getPower());
        ded.setPpp(deduc.getPpp());
        String p=deduc.getRecordCreationDate();
        SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy");
        Date doj1=sf.parse(p);
        ded.setDdate(doj1);
      
       // ded.setLoanAmount(deduc.getLoanAmount());
        ded.setUniform(deduc.getUniform());
        ded.setSalaryAdvance(deduc.getSalaryAdvance());
        ded.setTiffin(deduc.getTiffin());
        ded.setTea(deduc.getTea());
        ded.setStore(deduc.getStore());
        Criteria c2 = s.createCriteria(LoanAllotment.class);
       try{
       List<LoanAllotment> la=c2.add(Restrictions.eq("employeeProfile.empId", deduc.getEmpId())).list();
       if(la!=null){
        for(Object o:la){
            LoanAllotment l=(LoanAllotment)o;
            System.out.println("---------------sanc------------->"+l.getSanctionedAmt());
            if(l.getStatus().equals("Approved"))
            xz+=l.getSanctionedAmt();
        }
           System.out.println("dgfdjg----------------"+xz);
        ded.setTotalSanctionedAmount(xz);
       }
        }catch(Exception o){
             System.out.println("--------------------jghh"+o);
        }
         totalded=deduc.getUniform()+deduc.getPf()+deduc.getPpp()+deduc.getSalaryAdvance()+deduc.getPower()+deduc.getMeals()+deduc.getTiffin()+deduc.getTea()+deduc.getStore()+deduc.getMedicines()+deduc.getCable()+deduc.getGas()+deduc.getAdv2()+deduc.getEggs();
       ded.setTotalDeductions(totalded+xz);
        
        Criteria c = s.createCriteria(DeductionRules.class);
//        dr= (DeductionRules) c.add(Restrictions.eq("deductionRuleId", deduc.getDeductionRuleId())).uniqueResult();
//        ded.setDeductionRules(dr);
        Criteria c1 = s.createCriteria(EmployeeProfile.class);
        ep= (EmployeeProfile) c1.add(Restrictions.eq("empId", deduc.getEmpId())).uniqueResult();
        ded.setEmployeeProfile(ep);
         ded.setDeptdId(ep.getDepartments());
        s.update(ded);
           } catch(Exception e){
            System.out.println("Error due to updating deductions-------->"+e);
        }    
         t.commit();
        s.close();
        System.out.println("--------- updated deduction------------");
    }
public boolean checkId(int empId) 
{
         s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List l = null;
        boolean f=true;
        try{
         Criteria c1 = s.createCriteria(EmployeeProfile.class);
       l= c1.add(Restrictions.eq("empId", empId)).list();
        if(l.size()>0)
           f=false;
       else
           f=true;
        }catch(Exception ep){
            System.out.println("------------");
        }
        t.commit();
        s.close();
      return f;
       
}
public boolean checkdd(int deductionId) 
{
         s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List l = null;
        boolean f = false;
        try{
         Criteria c1 = s.createCriteria(DeductionMaster.class);
       l= c1.add(Restrictions.eq("deductionId", deductionId)).list();
        if(l.size()>0)
           f=true;
       else
           f=false;
        }catch(Exception ep){
            System.out.println("-----------------shfdkh");
        }
        t.commit();
        s.close();
        return f;
       
}

    public boolean checkdem(int empId) {
          s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List l = null;
        boolean f = false;
        try{
         Criteria c1 = s.createCriteria(DeductionMaster.class);
       l= c1.add(Restrictions.eq("employeeProfile.empId", empId)).list();
        if(l.size()>0)
           f=true;
       else
           f=false;
        }catch(Exception ep){
            System.out.println("-----------------shfdkh");
        }
        t.commit();
        s.close();
        return f;
    }
     public boolean validateDeductionlist(Deductions p) {
           Session s = HibernateUtil.getSessionFactory().openSession();
       Transaction t=s.beginTransaction();
       List l=new ArrayList();
        List l1=new ArrayList();
        try {
            int empid = p.getEmpId();
            String date=p.getRecordCreationDate();
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
