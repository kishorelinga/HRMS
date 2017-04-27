/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.manager;

import com.hrms.dto.GasConnectionMasterForm;
import com.hrms.model.GasConnectionMaster;
import com.hrms.util.HibernateUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class GasMasterManager 
{
    Session s=null;
    public GasConnectionMasterForm insertGasMaster(GasConnectionMasterForm f) throws ParseException
    {
        s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try
        {
             GasConnectionMaster gm=new GasConnectionMaster();
             
             gm.setConnectionId(f.getConnectionId());
             gm.setGasCompanyName(f.getGasCompanyName());
             gm.setGasConnectionAmount(f.getGasConnectionAmount());
             gm.setGasConnectionHolderName(f.getGasConnectionHolderName());
             String count=f.getGasCylinderCount();
             int c=Integer.parseInt(count);
             gm.setGasCylinderCount(c);
             gm.setGasStoveId(f.getGasStoveId());
             String d=f.getGasConnectionValidateDate();
             SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy");
             Date validdate=sf.parse(d);
             gm.setGasConnectionValidateDate(validdate);
             gm.setConsumerNumber(f.getConsumerNumber());
             s.save(gm);
             t.commit();
             System.out.println("\n gas master inserted successfully");
        }
        catch(HibernateException h)
        {
            System.out.println("Hibernate Exception during insertion"+h);
        }
        catch(Exception e)
        {
            System.out.println("Exception during insertion"+e);
        }
        finally
        {
            s.close();
        }    
        return f;
    }
    
    public List getCompanyName()
    {
        List l=new ArrayList<>();
        l.add("Indane");
        l.add("Bharatgas");
        l.add("HP");
        l.add("ESSAR");
        l.add("Reliance Industries Limited");
        return l;
    }
     public List getCylinderCount()
    {
        List l=new ArrayList<>();
        l.add("1");
        l.add("2");
        return l;
    }
    public List<GasConnectionMasterForm> displayGasMaster()
    {
         s=HibernateUtil.getSessionFactory().openSession();
         Transaction t=s.beginTransaction();
         List l = null;
         try
         {
              Criteria cr=s.createCriteria(GasConnectionMaster.class);
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

    public void deleteGasMaster(int id)
    {
        s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try
        {
            GasConnectionMaster g=new GasConnectionMaster();
            Criteria cr=s.createCriteria(GasConnectionMaster.class);
            g=(GasConnectionMaster) cr.add(Restrictions.eq("connectionId", id)).uniqueResult();
            s.delete(g);
            t.commit();
            System.out.println("\n deleted successfully");
        }
         catch(HibernateException h)
        {
            System.out.println("Hibernate Exception during deletion"+h);
        }
        catch(Exception e)
        {
            System.out.println("Exception during deletion"+e);
        }
        finally
         {
            s.close();
         }    
    }

    public List<GasConnectionMasterForm> editGasMaster(int id1) 
    {
        s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        List<GasConnectionMasterForm> l=null;
        try
        {
            GasConnectionMaster gm=new GasConnectionMaster();
            Criteria cr=s.createCriteria(GasConnectionMaster.class);
            cr.add(Restrictions.eq("connectionId", id1)).uniqueResult();
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

    public void updateGasMaster(GasConnectionMasterForm form) 
    {
        s=HibernateUtil.getSessionFactory().openSession();
        Transaction t=s.beginTransaction();
        try
        {
            GasConnectionMaster g=new GasConnectionMaster();
            g=(GasConnectionMaster) s.get(GasConnectionMaster.class, form.getConnectionId());
            g.setConnectionId(form.getConnectionId());
            g.setGasCompanyName(form.getGasCompanyName());
            g.setGasConnectionAmount(form.getGasConnectionAmount());
            g.setGasConnectionHolderName(form.getGasConnectionHolderName());
            String count=form.getGasCylinderCount();
            int c=Integer.parseInt(count);
            g.setGasCylinderCount(c);
            g.setGasStoveId(form.getGasStoveId());
            String d=form.getGasConnectionValidateDate();
            SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy");
            Date validdate=sf.parse(d);
            g.setGasConnectionValidateDate(validdate);
            g.setConsumerNumber(form.getConsumerNumber());
            s.update(g);
            t.commit();
            System.out.println("\n updated successfully");
            
        }
        catch(HibernateException h)
        {
            System.out.println("Hibernate exception during Update"+h);
        }
        catch(Exception e)
        {
            System.out.println("Exception during Update"+e);
        }
        finally
        {
            s.close();
        }
    }
    
    
}
