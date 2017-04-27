/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.manager;

import com.hrms.dto.Loan;
import com.hrms.model.DeductionMaster;
import com.hrms.model.Departments;
import com.hrms.model.EmployeeProfile;
import com.hrms.model.Incentives;
import com.hrms.model.LoanAllotment;
import com.hrms.model.LoansMaster;
import com.hrms.util.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Masrat
 */
public class LoanManager {
    
    Session s=null;
     List<LoanAllotment> loans = null;

    public void insertLoan(Loan loan) {
        s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        
        try{
            int lid = 0,eid;
            EmployeeProfile emp=new EmployeeProfile();
            HashMap<Integer,String> h=new HashMap<>();
            String re=loan.getLoanType();
            System.out.println("--------------?????"+re);
            LoanAllotment la=new LoanAllotment();
             eid=loan.getEmpId();
           
            List<LoansMaster> l=s.createCriteria(LoansMaster.class).list();
            for(LoansMaster l1:l)
             {
                 h.put(l1.getLoanId(), l1.getLoanTypeName());
             }
             Iterator it1=h.entrySet().iterator();
             while(it1.hasNext())
             {
                 Map.Entry<Integer,String> pair=(Map.Entry)it1.next();
                 if(re.equals(pair.getValue())) 
                 {
                    lid=pair.getKey();
                 }
                 it1.remove();
             }
             System.out.println(".............."+lid);
              Criteria c = s.createCriteria(EmployeeProfile.class);
             emp= (EmployeeProfile) c.add(Restrictions.eq("empId", eid)).uniqueResult();
             LoansMaster lom=new LoansMaster(lid);
              System.out.println(".............."+lid+"............----------"+lom);
             la.setEmployeeProfile(emp);
             la.setDeptlId(emp.getDepartments());
             la.setLoansMaster(lom);
             System.out.println("============8888888"+re);
             la.setLoanType(re);
             la.setRequestedAmt(loan.getRequestedAmt());
             la.setStatus("New");
             System.out.println("--------"+loan.getGasLoan()+"00000000000"+loan.getCashLoan()+"------------"+loan.getTraLoan());
             la.setGasLoan(loan.getGasLoan());
             la.setCashLoan(loan.getCashLoan());
             la.setTraLoan(loan.getTraLoan());
             
             la.setHouseholdThings(loan.getHouseholdThings());
              System.out.println("==================.............."+loan.getHouseholdThings());
             SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy");
             String dt=loan.getLoanCreationdate();
             Date j=sf.parse(dt);
             la.setLoanCreationDate(j);
            
             s.save(la);
            t.commit();
            s.close();
        }catch(Exception e){
            System.out.println("Error due to loan insertion----->"+e);
            e.printStackTrace();
            
        }
       
        
    }

    public List getId() {
        List<String> list=new ArrayList<>();
         s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List<LoansMaster> l=(List<LoansMaster>)s.createCriteria(LoansMaster.class).list();
       for(LoansMaster d : l)
       {
            list.add(d.getLoanTypeName());
       }
        t.commit();
        s.close();
        return list;
    }

    public List loansList() {
         s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try{
        Criteria crit = s.createCriteria(LoanAllotment.class);
            loans = crit.list();
        }catch(HibernateException e){
            System.out.println("-----loans--------->"+e);
        }catch(Exception p){
            System.out.println("------loans------------>"+p);
        }
       t.commit();
        s.close();
        return loans;
    }

    public List<Loan> editLoans(int Id) {
        
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List<Loan> l=null;
      
        try{
            LoanAllotment la=new LoanAllotment();
        Criteria c = s.createCriteria(LoanAllotment.class);
            c.add(Restrictions.eq("id", Id)).uniqueResult();
             l= c.list();
            t.commit();
            s.close();
        }catch(HibernateException he){
            
        }
        finally{
           // s.close();
        }
         return l;
    }

    public void deleteLoans(int id1) {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        LoanAllotment la=new LoanAllotment();
        Criteria c = s.createCriteria(LoanAllotment.class);
         la=(LoanAllotment) c.add(Restrictions.eq("id", id1)).uniqueResult();
            s.delete(la);
            t.commit();
            s.close();
    }

    public void updateLoans(Loan loan, int id1) {
        
        s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        
        try{
            Date j=null,realdate=null;
          
             LoanAllotment la=new LoanAllotment();
             la=(LoanAllotment) s.get(LoanAllotment.class, id1);
            int lid = 0,eid;
            EmployeeProfile emp1=new EmployeeProfile();
            HashMap<Integer,String> h=new HashMap<>();
            String re=loan.getLoanType();
            
             eid=loan.getEmpId();
           
            List<LoansMaster> l=s.createCriteria(LoansMaster.class).list();
            for(LoansMaster l1:l)
             {
                 h.put(l1.getLoanId(), l1.getLoanTypeName());
             }
             Iterator it1=h.entrySet().iterator();
             while(it1.hasNext())
             {
                 Map.Entry<Integer,String> pair=(Map.Entry)it1.next();
                 if(re.equals(pair.getValue())) 
                 {
                    lid=pair.getKey();
                 }
                 it1.remove();
             }
              Criteria c = s.createCriteria(EmployeeProfile.class);
             emp1= (EmployeeProfile) c.add(Restrictions.eq("empId", eid)).uniqueResult();
             LoansMaster lom=new LoansMaster(lid);
             la.setLoanType(re);
              la.setDeptlId(emp1.getDepartments());
             la.setLoansMaster(lom);
             la.setRequestedAmt(loan.getRequestedAmt());
             String z=loan.getStatus();
             if(z.equals("New"))
                la.setStatus("New");
             else if(z.equals("Closed"))
                  la.setStatus("Closed");
              else if(z.equals("Rejected"))
                  la.setStatus("Rejected");
              else if(z.equals("Approved"))
                  la.setStatus("Approved");
             la.setHouseholdThings(loan.getHouseholdThings());
             SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy");
             
            
             la.setEmployeeProfile(emp1);
             if(!(z.equals("Rejected")||z.equals("Closed"))){
                 String dt=loan.getLoanApprovaldate();
             j=sf.parse(dt);
              la.setLoanApprovalDate(j);
             la.setSanctionedAmt(loan.getSanctionedAmt());
             if(re.equals("Cash Loan"))
                 la.setCashLoan(loan.getSanctionedAmt());
             else if(re.equals("Gas Loan"))
                 la.setGasLoan(loan.getSanctionedAmt());
             else if(re.equals("Tra Loan"))
                 la.setTraLoan(loan.getSanctionedAmt());
             else
                 la.setSanctionedAmt(loan.getSanctionedAmt());
             
             }
              s.update(la);
              try{
              Calendar cal = Calendar.getInstance();
               cal.setTime(j);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH)+1;            
               
             List lk=null;
              Criteria c2=s.createCriteria(DeductionMaster.class);
              c2.add(Restrictions.eq("employeeProfileByEmpdId.empId",eid)).setProjection(Projections.property("ddate"));
              lk=c2.list();
              
               //   .add(Restrictions.eq("year(ddate)",year));
              System.out.println("list in Deductions is';;';';;';'';;'--------");
              for(int i1=0; i1<lk.size(); i1++) {
                  Date ddd=(Date) lk.get(i1);
                  System.out.println("iterator is---------"+ddd);
                   cal.setTime(ddd);
                 int year8 = cal.get(Calendar.YEAR);
                int month8 = cal.get(Calendar.MONTH)+1;
                if(year==year8 &&month==month8) {
                    realdate=ddd;
                }
              }
              //List l1=null;
              System.out.println("real date is..............."+realdate);
              DeductionMaster i=new DeductionMaster();
              Criteria c1=s.createCriteria(DeductionMaster.class);
              i=(DeductionMaster) c1.add(Restrictions.eq("ddate",realdate)).add(Restrictions.eq("employeeProfileByEmpdId.empId", eid)).uniqueResult();                
             //l1=c1.list();
            
             int x=i.getTotalDeductions();
             int y=x+loan.getSanctionedAmt();
             int z1=i.getTotalSanctionedAmount();
             i.setTotalSanctionedAmount(loan.getSanctionedAmt()+z1);
             i.setTotalDeductions(y);
             s.update(i);
             
             
             Incentives ip=new Incentives();
             
             Criteria c3=s.createCriteria(Incentives.class);
              ip=(Incentives) c3.add(Restrictions.eq("date",realdate)).add(Restrictions.eq("employeeProfileByEmpiId.empId", eid)).uniqueResult();                
             int xz=ip.getGrossSalary();
             ip.setNetSalary(xz-y);
             s.update(ip);
             
             }catch(NullPointerException n){
                 System.out.println("--------------------dgh"+n);
             }
             
            
            t.commit();
            s.close();
        }catch(Exception e){
            e.printStackTrace();
            
        }
       
    }

    public boolean search(int empId) {
        boolean z = false;
         s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
         List<EmployeeProfile> l=(List<EmployeeProfile>)s.createCriteria(EmployeeProfile.class).list();
       for(EmployeeProfile d : l)
       {
           if(z==true)
               break;
           else{
            if(d.getEmpId()==empId)
                z=true;
                          
            else 
                z=false;
           }
       }
       return z;
        
    }
    
     public List<LoanAllotment> loanView(int id8) {
        Session s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List<LoanAllotment> l=null;
      
        try{
         //   LoanAllotment la=new LoanAllotment();
        Criteria c = s.createCriteria(LoanAllotment.class);
            c.add(Restrictions.eq("employeeProfile.empId", id8)).uniqueResult();
             l= c.list();
              System.out.println("loan is------------->>>>>>>"+l);
            t.commit();
            s.close();
        }catch(HibernateException he){
            
        }
        finally{
           // s.close();
        }
       
         return l;
    }

   
}
