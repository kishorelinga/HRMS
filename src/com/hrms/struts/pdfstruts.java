/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.struts;

import com.hrms.dto.Pdfdto;
import com.hrms.manager.PdfManager;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionSupport;
import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Swathi
 */
public class pdfstruts  extends ActionSupport{
    
    private Pdfdto object;
    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
    public Pdfdto getObject() {
        return object;
    }

    public void setObject(Pdfdto object) {
        this.object = object;
    }
  
    
     private static int a,b,c,d,e,f;

  
   
  
    public String Reset()  {
        super.clearErrorsAndMessages(); 
        return "success";
    }
    
    public String generatePayslip() {
        return "success";
    }
    
    private PdfManager pmanager;

    public PdfManager getPmanager() {
        return pmanager;
    }

    public void setPmanager(PdfManager pmanager) {
        this.pmanager = pmanager;
    }
    private List<Integer> plist;
    private List elist;
    private List incentivelist;
    private List deductionList;
    private List<Integer> deductionList1;
    private List<Integer> year;
    private List<String> month;

    public List<Integer> getYear() {
        return year;
    }

    public void setYear(List<Integer> year) {
        this.year = year;
    }

    public List<String> getMonth() {
        return month;
    }

    public void setMonth(List<String> month) {
        this.month = month;
    }

   

    public List<Integer> getDeductionList1() {
        return deductionList1;
    }

    public void setDeductionList1(List<Integer> deductionList1) {
        this.deductionList1 = deductionList1;
    }

    public List getDeductionList() {
        return deductionList;
    }

    public void setDeductionList(List deductionList) {
        this.deductionList = deductionList;
    }

    public List getIncentivelist() {
        return incentivelist;
    }

    public void setIncentivelist(List incentivelist) {
        this.incentivelist = incentivelist;
    }

    public List getElist() {
        return elist;
    }

    public void setElist(List elist) {
        this.elist = elist;
    }
    public List<Integer> getPlist() {
        return plist;
    }

    public void setPlist(List<Integer> plist) {
        this.plist = plist;
    }
    
    
    public pdfstruts() {
        pmanager=new PdfManager();
        plist=new ArrayList();
        elist=new ArrayList();
        incentivelist=new ArrayList();
        deductionList=new ArrayList();
        deductionList1=new ArrayList();
    }
    
    public String searchPayslip() {
        this.plist=pmanager.searchEmployee(getObject());
        this.elist=pmanager.empList(getObject());
        this.incentivelist=pmanager.incentiveList(getObject());
        this.deductionList=pmanager.deductionList(getObject());
        this.deductionList1=pmanager.deductionListtotal(getObject());
        this.year=pmanager.getYear(getObject());
        this.month=pmanager.getMonth(getObject());
        System.out.println("list is -------------//////////"+deductionList1);
        
        return "success";
    }
   
    @Override
    public void validate() {
        if(pmanager.validateUser(getObject()) || object.getEmp_id()==0) {
            a++;
            if(a%2!=0) {
                addFieldError("object.emp_id", "Employee Doesn't exists in wages");
            }
           else {
                        addFieldError("object.emp_id", "");
                       a = 0;
                    } 
        }
      else if (pmanager.validateDeductionlist(getObject()) && pmanager.validateUserIncentives(getObject())) {
               
                 c++;
                    if (c % 2 != 0) {
                         addFieldError("object.date", "Invalid Month or Year");
                         
                    } else {
                        addFieldError("object.date", "");
                       c = 0;
                    }
            }
      
    }
    
   
    
    
}
