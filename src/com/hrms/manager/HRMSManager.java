/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.manager;

import com.hrms.dto.EmployeeProfileForm;
import com.hrms.model.Departments;
import com.hrms.model.EmployeeProfile;
import com.hrms.model.EmployeeType;
import com.hrms.model.FamilyIdentity;
import com.hrms.model.ResidentialQuarters;
import com.hrms.util.HibernateUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author NSG
 */
public class HRMSManager
{
    Session s=null;
    
    public EmployeeProfileForm insertEmployee(EmployeeProfileForm f, String address, String perminentAddress) throws ParseException
    {
        s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
       
        System.out.println("com.hrms.manager.HRMSManager.insertEmployee()");
        try
        {
             EmployeeProfile e=new EmployeeProfile();
             String status=f.getStatus();
             String doj=f.getDoj();
             SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy");
             Date doj1=sf.parse(doj);
             String dob=f.getDob();
             Date dob1=sf.parse(dob);
             String record=f.getRecordCreationDate();
             SimpleDateFormat sf1=new SimpleDateFormat("dd-MM-yy");
             Date record1=sf1.parse(record);
             File image=f.getImage();
             byte[] bytefile1=new byte[(int)image.length()];
                FileInputStream fileInputStream = new FileInputStream(image);
                fileInputStream.read(bytefile1);
             int deptid=0,qid=0,eid=0;
             String de=f.getDept();
             System.out.println("-------->"+de);
             String re=f.getQuarter();
             String ee=f.getEtype();
             HashMap<Integer,String> h=new HashMap<>();
             List<Departments> l=s.createCriteria(Departments.class).list();
             List<ResidentialQuarters> r=s.createCriteria(ResidentialQuarters.class).list();
             List<EmployeeType> et=s.createCriteria(EmployeeType.class).list();
             for(Departments d:l)
             {
                 h.put(d.getDeptId(), d.getDeptName());
             } 
             Iterator it=h.entrySet().iterator();
             while(it.hasNext())
             {
                 Map.Entry<Integer,String> pair=(Map.Entry)it.next();
                 if(de.equals(pair.getValue())) 
                 {
                    deptid=pair.getKey();
                 }
                 it.remove();
             }
             for(ResidentialQuarters r1:r)
             {
                 h.put(r1.getQuarterId(), r1.getQuarterType());
             }
             Iterator it1=h.entrySet().iterator();
             while(it1.hasNext())
             {
                 Map.Entry<Integer,String> pair=(Map.Entry)it1.next();
                 if(re.equals(pair.getValue())) 
                 {
                    qid=pair.getKey();
                 }
                 it1.remove();
             }
             
             for(EmployeeType e1:et)
             {
                 h.put(e1.getEmpTypeId(),e1.getDescription());
             }
             
             Iterator it2=h.entrySet().iterator();
             while(it2.hasNext())
             {
                 Map.Entry<Integer,String> pair=(Map.Entry)it2.next();
                 if(ee.equals(pair.getValue())) 
                 {
                    eid=pair.getKey();
                 }
                 it2.remove();
             }
             EmployeeType et1=new EmployeeType(eid);
             Departments d2=new Departments(deptid);
             e.setDepartments(d2);
             e.setEmpId(f.getEmpId());
             e.setStatus(status);
             e.setDoj(doj1);
             e.setDob(dob1);
             e.setOtEligibility(f.getOtEligibility());
             e.setEmpName(f.getEmpName());
             e.setGender(f.getGender());
             e.setMaritialStatus(f.getMaritialStatus());
             e.setProofScannedCopy(bytefile1);
             e.setAddress(address);
             e.setAadharNumber(f.getAadharNumber());
             e.setPerminentAddress(perminentAddress);
             e.setEmergencyContactNumber(f.getEmergencyContactNumber());
             e.setEmpGrade(f.getEmpGrade());
             e.setRecordCreationDate(record1);
             e.setProofNumber(f.getProofNumber());
             e.setSelfContactNumber(f.getSelfContactNumber());
             e.setQuarterType(f.getQuarter());
             e.setEmployeeType(et1);
             e.setProofType(f.getProofType());
             s.save(e);
             t.commit();
               Transaction tx=s.beginTransaction();
             FamilyIdentity fi=new FamilyIdentity();
             fi.setEmployeeProfile(e);
             fi.setFamilyUnitId(f.getEmpId());
             s.save(fi);
             tx.commit();
             
             System.out.println("\n inserted successfully");
             
        }
        catch(HibernateException h)
        {
            System.out.println("\n HibernateException during insertion:"+h);
        }
        catch(Exception ex)
        {
            System.out.println("\n Exception during insertion:"+ex);
        }
        finally
        {
            s.close();
        }
       return f;
    }
    
     public List<String> getDepts()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List<String> dept=new ArrayList<>();
       List<Departments> l=(List<Departments>)session.createCriteria(Departments.class).list();
       for(Departments d : l)
       {
            dept.add(d.getDeptName());
       }
        return dept;
    }
     
      public List<String> getQuarters()
              
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Criteria c = session.createCriteria(ResidentialQuarters.class);
        c.setProjection(Projections.distinct(Projections.property("quarterType")));
        List emp = c.list();
        return emp;
    }
     
       public List<String> getEmpType()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List<String> et=new ArrayList<>();
       List<EmployeeType> l=(List<EmployeeType>)session.createCriteria(EmployeeType.class).list();
       for(EmployeeType e : l)
       {
            et.add(e.getDescription());
       }
        return et;
    }
    
    
    public List getAddress()
    {
        List l=new ArrayList<>();
        l.add("residential");
        l.add("non_residential");
        return l;
    }
    public List getproofType()
    {
        List l=new ArrayList<>();
        l.add("aadhar");
        l.add("driving");
        l.add("voter id");
        l.add("ration card");
        return l;
    }
    
    
    
    public List<EmployeeProfileForm> displayEmployee()
    {
         s=HibernateUtil.getSessionFactory().openSession();
         Transaction t=s.beginTransaction();
         List l = null;
         try
         {
              Criteria cr=s.createCriteria(EmployeeProfile.class);
              l=cr.list();
              t.commit();
              System.out.println("\n displayed successsfully");
         }
         catch(HibernateException h)
         {
              System.out.println("Hibernate Exception during display"+h);
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
    
    public void deleteEmployee(int id)
    {
         s=HibernateUtil.getSessionFactory().openSession();
         Transaction t=s.beginTransaction();
         try
         {
             EmployeeProfile e=new EmployeeProfile();
             Criteria c=s.createCriteria(EmployeeProfile.class);
             e=(EmployeeProfile) c.add(Restrictions.eq("empId",id)).uniqueResult();
             s.delete(e);
             t.commit();
             System.out.println("\n deleted successfully");
         }
         catch(HibernateException h)
         {
             System.out.println("HibernateException during deletion:"+h);
         }
         catch(Exception ex)
         { 
            System.out.println("Exception during deletion:"+ex);
         }
         finally
         {
            s.close();
         }      
    }
    
   
    public List<EmployeeProfile> editEmployee(int id) 
    {
         s=HibernateUtil.getSessionFactory().openSession();
         Transaction t=s.beginTransaction();
         List<EmployeeProfile> l=null;
         try
         {
             EmployeeProfile e=new EmployeeProfile();
             Criteria c=s.createCriteria(EmployeeProfile.class);
             c.add(Restrictions.eq("empId",id)).uniqueResult();
             l=c.list();
              EmployeeProfile empf = null;
            Departments dept;
            EmployeeType emtype;
            for (int i = 0; i < l.size(); i++) {
                empf = (EmployeeProfile) l.get(i);
                dept = empf.getDepartments();
                emtype=empf.getEmployeeType();
                System.out.println(dept);
                System.out.println(emtype);
                //s.save(dept);
            }
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
             s.close();
         }
       return l;
    }

    public void updateEmployee(EmployeeProfileForm f, String address, String perminentAddress) 
    {
        s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try
        {
             EmployeeProfile e=new EmployeeProfile();
             e=(EmployeeProfile) s.get(EmployeeProfile.class, f.getEmpId());
             String status=f.getStatus();
             String doj=f.getDoj();
             SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy");
             Date doj1=sf.parse(doj);
             String dob=f.getDob();
             Date dob1=sf.parse(dob);
             int deptid=0,qid=0,eid=0;
             String de=f.getDept();
             System.out.println("-------->"+de);
             String re=f.getQuarter();
             String ee=f.getEtype();
             HashMap<Integer,String> h=new HashMap<>();
             List<Departments> l=s.createCriteria(Departments.class).list();
             List<ResidentialQuarters> r=s.createCriteria(ResidentialQuarters.class).list();
             List<EmployeeType> et=s.createCriteria(EmployeeType.class).list();
             for(Departments d:l)
             {
                 h.put(d.getDeptId(), d.getDeptName());
             } 
             Iterator it=h.entrySet().iterator();
             while(it.hasNext())
             {
                 Map.Entry<Integer,String> pair=(Map.Entry)it.next();
                 if(de.equals(pair.getValue())) 
                 {
                    deptid=pair.getKey();
                 }
                 it.remove();
             }
             for(ResidentialQuarters r1:r)
             {
                 h.put(r1.getQuarterId(), r1.getQuarterType());
             }
             Iterator it1=h.entrySet().iterator();
             while(it1.hasNext())
             {
                 Map.Entry<Integer,String> pair=(Map.Entry)it1.next();
                 if(re.equals(pair.getValue())) 
                 {
                    qid=pair.getKey();
                 }
                 it1.remove();
             }
             
             for(EmployeeType e1:et)
             {
                 h.put(e1.getEmpTypeId(),e1.getDescription());
             }
             
             Iterator it2=h.entrySet().iterator();
             while(it2.hasNext())
             {
                 Map.Entry<Integer,String> pair=(Map.Entry)it2.next();
                 if(ee.equals(pair.getValue())) 
                 {
                    eid=pair.getKey();
                 }
                 it2.remove();
             }
             EmployeeType et1=new EmployeeType(eid);
             Departments d2=new Departments(deptid);
             e.setDepartments(d2);
             e.setEmpId(f.getEmpId());
             e.setStatus(status);
             e.setDoj(doj1);
             e.setDob(dob1);
             e.setOtEligibility(f.getOtEligibility());
             e.setEmpName(f.getEmpName());
             e.setGender(f.getGender());
             e.setMaritialStatus(f.getMaritialStatus());
             e.setAddress(address);
             e.setAadharNumber(f.getAadharNumber());
             e.setPerminentAddress(perminentAddress);
             e.setEmergencyContactNumber(f.getEmergencyContactNumber());
             e.setEmpGrade(f.getEmpGrade());
             e.setProofNumber(f.getProofNumber());
             e.setSelfContactNumber(f.getSelfContactNumber());
             e.setQuarterType(f.getQuarter());
             e.setEmployeeType(et1);
             e.setProofType(f.getProofType());
             s.update(e);
             t.commit();
             System.out.println("\n updated successfully");
             
        }
        catch(HibernateException h)
        {
             System.out.println("HibernateException during updation:"+h);
        }
        catch(Exception ex)
        {
             System.out.println("Exception during updation:"+ex);
        }
        finally
        {
             s.close();
        }
    }

    public List<EmployeeProfile> viewEmployee(int id1) {
         s=HibernateUtil.getSessionFactory().openSession();
         Transaction t=s.beginTransaction();
         List<EmployeeProfile> l=null;
         try
         {
             EmployeeProfile e=new EmployeeProfile();
             Criteria c=s.createCriteria(EmployeeProfile.class);
             c.add(Restrictions.eq("empId",id1)).uniqueResult();
             l=c.list();
              EmployeeProfile empf = null;
            Departments dept;
            EmployeeType emtype;
            for (int i = 0; i < l.size(); i++) {
                empf = (EmployeeProfile) l.get(i);
                dept = empf.getDepartments();
                emtype=empf.getEmployeeType();
                System.out.println(dept);
                System.out.println(emtype);
                //s.save(dept);
            }
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
             s.close();
         }
       return l;
    }
 
}
