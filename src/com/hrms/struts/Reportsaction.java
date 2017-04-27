/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.struts;

import com.hrms.dto.Pdfdto;
import com.hrms.manager.PdfManager;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionSupport;
//import com.sun.corba.se.spi.presentation.rmi.StubAdapter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author anusha
 */
public class Reportsaction extends ActionSupport{
    private InputStream inputStream;
    private String empdate;

    public String getEmpdate() {
        return empdate;
    }

    public void setEmpdate(String empdate) {
        this.empdate = empdate;
    }
    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
    
     public String employeePdf() {
         HttpServletResponse res=ServletActionContext.getResponse();
        Rectangle envelope = new Rectangle(1300,1300);
        Document d=new Document(envelope, 10f, 10f, 100f, 0f);
        ByteArrayOutputStream b=new ByteArrayOutputStream();
        d.addTitle("Salary Abstract For the Month of JUNE 2016");
         Font ffont = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);           
           
        try
        {
            String date=object.getEmpdate();
            System.out.println("ssdff"+date);
            SimpleDateFormat s1=new SimpleDateFormat("dd-MM-yy");
              Date d1=s1.parse(date);
              System.out.println("Date is [[[[[[[[[[[[[[["+d1);
               Calendar cal = Calendar.getInstance();
                cal.setTime(d1);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH)+1;         
                 System.out.println("Incentives year year isssssssss"+year);
                
                String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            String newmonth=monthNames[month-1];     
                
               
                Chunk reportTitle= new Chunk("Pay Sheet  For the Month of "+newmonth+year,ffont);
            
             Phrase p = new Phrase(reportTitle);
          //  p.add(reportTitle);
           Paragraph para = new Paragraph();
           para.add(p);
            para.setAlignment(Element.ALIGN_CENTER);
            PdfWriter.getInstance(d, b);
            
            Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD);
       //     Phrase  zzz=new Phrase("S. No",boldFont);
            Phrase one = new Phrase("Dept Name", boldFont ); 
            Phrase two = new Phrase("Days", boldFont );
            Phrase five = new Phrase("Wage", boldFont ); 
            Phrase four = new Phrase("Earn", boldFont ); 
            Phrase three = new Phrase("Inc", boldFont ); 
            Phrase six = new Phrase("Gross Salary", boldFont ); 
            Phrase seven= new Phrase("PF", boldFont ); 
            Phrase seven2= new Phrase("Salary Advance", boldFont ); 
            Phrase eight= new Phrase("Cash Loan", boldFont ); 
            Phrase nine = new Phrase("Gas Loan", boldFont ); 
            Phrase ten = new Phrase("Tra Loan", boldFont ); 
            Phrase ten4 = new Phrase("Power", boldFont ); 
              Phrase ten5 = new Phrase("Meals", boldFont ); 
               Phrase ten6 = new Phrase("Tiffin", boldFont ); 
                Phrase ten7 = new Phrase("Tea", boldFont ); 
                 Phrase ten8 = new Phrase("Store", boldFont ); 
                  Phrase ten9 = new Phrase("Medicines", boldFont ); 
                   Phrase ten11 = new Phrase("Cable", boldFont ); 
             Phrase one1 = new Phrase("Gas", boldFont ); 
            Phrase two1 = new Phrase("Adv2", boldFont );
            Phrase five1 = new Phrase("Eggs", boldFont ); 
            Phrase four1 = new Phrase("Uniform", boldFont ); 
            Phrase three1 = new Phrase("Total Deductions", boldFont ); 
            Phrase six1 = new Phrase("Net Salary", boldFont ); 
          
             
 //   PdfPCell pdfWordCel1zz= new PdfPCell();                
    PdfPCell pdfWordCell1= new PdfPCell();   
    PdfPCell pdfWordCell2= new PdfPCell();   
    PdfPCell pdfWordCell3= new PdfPCell();  
   PdfPCell pdfWordCell4= new PdfPCell();
    PdfPCell pdfWordCell5= new PdfPCell();   
    PdfPCell pdfWordCell6= new PdfPCell();   
    PdfPCell pdfWordCell7= new PdfPCell();
    PdfPCell pdfWordCell8= new PdfPCell();  
    PdfPCell pdfWordCell9= new PdfPCell();   
    PdfPCell pdfWordCell10= new PdfPCell(); 
    PdfPCell pdfWordCell11= new PdfPCell();   
    PdfPCell pdfWordCell12= new PdfPCell();   
    PdfPCell pdfWordCell13= new PdfPCell();  
    PdfPCell pdfWordCell14= new PdfPCell();
    PdfPCell pdfWordCell15= new PdfPCell();   
        PdfPCell pdfWordCell16= new PdfPCell();   
   PdfPCell pdfWordCell17= new PdfPCell();
   PdfPCell pdfWordCell18= new PdfPCell();  
    PdfPCell pdfWordCell19= new PdfPCell();   
    PdfPCell pdfWordCell20= new PdfPCell();    
    PdfPCell pdfWordCell21= new PdfPCell(); 
    PdfPCell pdfWordCell22= new PdfPCell();
    PdfPCell pdfWordCell23= new PdfPCell();
    PdfPCell pdfWordCell24= new PdfPCell();
  
    
        //    pdfWordCel1zz.addElement(zzz);
            pdfWordCell1.addElement(one);
            pdfWordCell2.addElement(two);
            pdfWordCell3.addElement(five);
            pdfWordCell4.addElement(four);
            pdfWordCell5.addElement(three);
            pdfWordCell6.addElement(six);
            pdfWordCell7.addElement(seven);
            pdfWordCell8.addElement(seven2);
            pdfWordCell9.addElement(eight);
            pdfWordCell10.addElement(nine);
            pdfWordCell11.addElement(ten);
            pdfWordCell12.addElement(ten4);
            pdfWordCell13.addElement(ten5);
            pdfWordCell14.addElement(ten6);
            pdfWordCell15.addElement(ten7);
            pdfWordCell16.addElement(ten8);
            pdfWordCell17.addElement(ten9);
            pdfWordCell18.addElement(ten11);
                       
            pdfWordCell19.addElement(one1);
            pdfWordCell20.addElement(two1);
            pdfWordCell21.addElement(five1);
            pdfWordCell22.addElement(four1);
            pdfWordCell23.addElement(three1);
            pdfWordCell24.addElement(six1);
                             
               
           
            d.open();
             PdfPTable table = new PdfPTable(24);
         
       
      table.setTotalWidth(1250);
      //table.setWidths(new int[] {40,40});
      table.setLockedWidth(true);
 
          
         
//            table.addCell( pdfWordCel1zz );
            table.addCell( pdfWordCell1 );
            table.addCell( pdfWordCell2 );
 
     table.addCell( pdfWordCell3 );  
    table.addCell(pdfWordCell4);
      table.addCell(pdfWordCell5);   
      table.addCell(pdfWordCell6);  
      table.addCell(pdfWordCell7);
     table.addCell(pdfWordCell8);   
      table.addCell(pdfWordCell9);   
      table.addCell(pdfWordCell10); 
     table.addCell(pdfWordCell11);
     table.addCell(pdfWordCell12);  table.addCell(pdfWordCell13);  table.addCell(pdfWordCell14); table.addCell(pdfWordCell15);
     table.addCell(pdfWordCell16);  table.addCell(pdfWordCell17);  table.addCell(pdfWordCell18); table.addCell(pdfWordCell19);
     table.addCell(pdfWordCell20);  table.addCell(pdfWordCell21); 
     table.addCell(pdfWordCell22); table.addCell(pdfWordCell23);
      table.addCell(pdfWordCell24);
   
     
      
      
    
      Connection connection=null;
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrmsdp_10","root", "nivriti@123");
     Statement st=connection. createStatement(); 
     CallableStatement st1=null;
      String sql = "{Call deptwise1(?,?)}";
          st1=connection.prepareCall(sql);
          st1.setString(1,newmonth);
          st1.setInt(2, year); int days2=0; int wage2=0; int earn2=0; int inc2=0; int gross2=0; int pf2=0; int sal_adv2=0;
          int cash2=0; int gasl2=0; int tra2=0; int power2=0; int meals2=0; int tiffin2=0; int tea2=0; int store2=0; int medi2=0;
          int cable2=0; int gas22=0; int adv22=0; int eggs2=0; int unif2=0; int tot_ded2=0; int net_sal2=0;
       ResultSet rs= st1.executeQuery();
       while(rs.next())
       {
       table.addCell(rs.getString("dept_name")); 
       table.addCell(rs.getString("sum(distinct days)"));
       table.addCell(rs.getString("wages")); 
       table.addCell(rs.getString("earnings")); 
       table.addCell(rs.getString("increments")); 
       table.addCell(rs.getString("gross_salary")); 
       table.addCell(rs.getString("pf")); 
       table.addCell(rs.getString("salary_advance")); 
       table.addCell(rs.getString("cash_loan")); 
       table.addCell(rs.getString("gas_loan")); 
       table.addCell(rs.getString("tra_loan")); 
       table.addCell(rs.getString("power")); 
       table.addCell(rs.getString("meals")); 
       table.addCell(rs.getString("tiffin")); 
       table.addCell(rs.getString("tea")); 
       table.addCell(rs.getString("store")); 
       table.addCell(rs.getString("medicines"));
       table.addCell(rs.getString("cable")); 
       table.addCell(rs.getString("gas")); 
       table.addCell(rs.getString("adv2"));
       table.addCell(rs.getString("eggs")); 
       table.addCell(rs.getString("uniform")); 
       table.addCell(rs.getString("total_deductions"));
       table.addCell(rs.getString("net_salary")); 
       
       
       String days=rs.getString("sum(distinct days)");  
        
       String wage=rs.getString("wages"); 
       int wage1=Integer.parseInt(wage);
       String earn=(rs.getString("earnings")); 
       int earn1=Integer.parseInt(earn);
       String inc=rs.getString("increments"); 
       int inc1=Integer.parseInt(inc);
       String gross_sal=rs.getString("gross_salary"); 
       int gross_sal1=Integer.parseInt(gross_sal);
      
       
       String pf=rs.getString("pf"); 
       int pf1=Integer.parseInt(pf);
       String sal_adv=rs.getString("salary_advance"); 
       int sal_adv1=Integer.parseInt(sal_adv);
       int cash1=0,gas1=0,tra1=0;
 try{
       String cash=rs.getString("cash_loan"); 
        cash1=Integer.parseInt(cash);
         System.out.println("Incentives month isssssssss"+newmonth);
         
       String gas12=rs.getString("gas_loan"); 
      gas1=Integer.parseInt(gas12);
       
       String tra=rs.getString("tra_loan"); 
     tra1=Integer.parseInt(tra);
 }catch(NumberFormatException nm)
 {
     System.out.println("------------------------>"+nm);
 }
       String power=rs.getString("power"); 
       int power1=Integer.parseInt(power);
       String meals=rs.getString("meals"); 
        int meals1=Integer.parseInt(meals);
       String tiffin=rs.getString("tiffin");
       int tiffin1=Integer.parseInt(tiffin);
       String tea=rs.getString("tea"); 
       int tea1=Integer.parseInt(tea);
       String store=rs.getString("store"); 
       int store1=Integer.parseInt(store);
       String medicines=rs.getString("medicines");
       int medicines1=Integer.parseInt(medicines);
       String cable= rs.getString("cable"); 
       
       int cable1=Integer.parseInt(cable);
       String gas2=rs.getString("gas"); 
       int gas3=Integer.parseInt(gas2);
       String adv2=rs.getString("adv2");
       int adv21=Integer.parseInt(adv2);
       String egg=rs.getString("eggs"); 
       int egg1=Integer.parseInt(egg);
       String uniform=rs.getString("uniform"); 
       int uniform1=Integer.parseInt(uniform);
       String tot=rs.getString("total_deductions");
       int tot1=Integer.parseInt(tot);
       String net=rs.getString("net_salary"); 
       int net1=Integer.parseInt(net);
        
        int days1=Integer.parseInt(days);
        
        System.out.println("ddddddddddddddddddd"+days1);
       days2=days1+days2;
           System.out.println("ddddddddddddddddddd"+days2);
         wage2=wage1+wage2;   earn2=earn1+earn2; inc2=inc1+inc2; gross2=gross_sal1+gross2; pf2=pf1+pf2;
         sal_adv2=sal_adv1+sal_adv2; cash2=cash1+cash2; gasl2=gas1+gasl2; tra2=tra1+tra2; power2=power1+power2;
         meals2=meals1+meals2; tiffin2=tiffin1+tiffin2; tea2=tea1+tea2; store2=store1+store2; medi2=medicines1+medi2;
         cable2=cable1+cable2; gas22=gas3+gas22; adv22=adv21+adv22; eggs2=egg1+eggs2; unif2=uniform1+unif2;
         tot_ded2=tot1+tot_ded2; net_sal2=net1+net_sal2;
         
           
       }
       
       
       String days3=Integer.toString(days2);
        String wage3=Integer.toString(wage2);
           String earn3=Integer.toString(earn2);
            String inc3=Integer.toString(inc2);
             String gross3=Integer.toString(gross2);
              String pf3=Integer.toString(pf2);
               String sal_adv3=Integer.toString(sal_adv2);
                String cash3=Integer.toString(cash2);
                 String gas13=Integer.toString(gasl2);
                  String tra3=Integer.toString(tra2);
                   String power3=Integer.toString(power2);
                    String meals3=Integer.toString(meals2);
                     String tiffin3=Integer.toString(tiffin2);
                      String tea3=Integer.toString(tea2);
                       String store3=Integer.toString(store2);
                        String medi3=Integer.toString(medi2);
                         String cable3=Integer.toString(cable2);
                          String gas33=Integer.toString(gas22);
                           String adv33=Integer.toString(adv22);
                            String eggs3=Integer.toString(eggs2);
                             String unif3=Integer.toString(unif2);
                              String tot_ded3=Integer.toString(tot_ded2);
                               String net_sal3=Integer.toString(net_sal2);
       PdfPTable table1 = new PdfPTable(24);
        Phrase total = new Phrase("TOTAL", boldFont );
        table1.setTotalWidth(1250);
       table1.setLockedWidth(true); 
      
        table1.addCell(total); 
       table1.addCell(days3); table1.addCell(wage3); table1.addCell(earn3); table1.addCell(inc3); 
        table1.addCell(gross3); table1.addCell(pf3);  table1.addCell(sal_adv3); table1.addCell(cash3); 
       table1.addCell(gas13); table1.addCell(tra3); table1.addCell(power3); table1.addCell(meals3); 
     table1.addCell(tiffin3); table1.addCell(tea3); table1.addCell(store3); table1.addCell(medi3); 
       table1.addCell(cable3); table1.addCell(gas33); table1.addCell(adv33); table1.addCell(eggs3); 
       table1.addCell(unif3); table1.addCell(tot_ded3); table1.addCell(net_sal3);   
        
    d.add(para);
     d.add( Chunk.NEWLINE );
      d.add( Chunk.NEWLINE );
      d.add(table); 
      d.add(table1);
      d.close();
     
     }
     
        catch(Exception e)
        {
            System.out.println(e);
        }
        byte[] bytes=null;
        bytes=b.toByteArray();
        res.setContentLength(bytes.length);
        if(bytes!=null)
        {
            inputStream=new ByteArrayInputStream(bytes);
        }
        return "success";
    }
    
     
      public String generateemployees()  {
    //    System.out.println(pdf.getEmp_id());
    //    System.out.println(pdf.getName());
    
      
              
        HttpServletResponse res=ServletActionContext.getResponse();
        Rectangle envelope = new Rectangle(1300,1300);
        Document d=new Document(envelope, 10f, 10f, 100f, 0f);
        ByteArrayOutputStream b=new ByteArrayOutputStream();
        d.addTitle("Salary Abstract For the Month of JUNE 2016");
         Font ffont = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);           
           
        try
        {
            String date=object.getEmpdate();
            System.out.println("ssdff"+date);
            SimpleDateFormat s1=new SimpleDateFormat("dd-MM-yy");
              Date d1=s1.parse(date);
              System.out.println("Date is [[[[[[[[[[[[[[["+d1);
               Calendar cal = Calendar.getInstance();
                cal.setTime(d1);
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH)+1;         
                 System.out.println("Incentives year year isssssssss"+year);
                
                String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            String newmonth=monthNames[month-1];     
               System.out.println("Incentives month isssssssss"+newmonth); 
               
                Chunk reportTitle= new Chunk("Pay Sheet  For the Month of "+newmonth+year,ffont);
            
             Phrase p = new Phrase(reportTitle);
          //  p.add(reportTitle);
           Paragraph para = new Paragraph();
           para.add(p);
            para.setAlignment(Element.ALIGN_CENTER);
            PdfWriter.getInstance(d, b);
            
            PdfWriter.getInstance(d, b);
            
            Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD);
            Phrase two = new Phrase("Code No", boldFont ); Phrase three = new Phrase("Name", boldFont ); 
            Phrase four = new Phrase("Status", boldFont ); Phrase five = new Phrase("Dept", boldFont ); Phrase six = new Phrase("Days", boldFont ); 
            Phrase seven= new Phrase("Wage", boldFont ); Phrase eight= new Phrase("Inc", boldFont ); Phrase nine = new Phrase("Earn", boldFont ); 
            Phrase ten = new Phrase("Inc Amt", boldFont ); Phrase eleven = new Phrase("Gross Earn", boldFont ); Phrase twelve = new Phrase("PF", boldFont ); 
            Phrase thirteen = new Phrase("PPP", boldFont ); Phrase fourteen = new Phrase("PF No", boldFont ); Phrase fifteen = new Phrase("Sal Advance", boldFont ); 
                
                 
    PdfPCell pdfWordCell2= new PdfPCell();   PdfPCell pdfWordCell3= new PdfPCell();   PdfPCell pdfWordCell4= new PdfPCell();
    PdfPCell pdfWordCell5= new PdfPCell();   PdfPCell pdfWordCell6= new PdfPCell();   PdfPCell pdfWordCell7= new PdfPCell();
    PdfPCell pdfWordCell8= new PdfPCell();   PdfPCell pdfWordCell9= new PdfPCell();   PdfPCell pdfWordCell10= new PdfPCell();  PdfPCell pdfWordCell11= new PdfPCell();
    PdfPCell pdfWordCell12= new PdfPCell();  PdfPCell pdfWordCell13= new PdfPCell();  PdfPCell pdfWordCell14= new PdfPCell();  PdfPCell pdfWordCell15= new PdfPCell();
    PdfPCell pdfWordCell50= new PdfPCell(new Phrase("Gas Loan", boldFont)); 
    PdfPCell pdfWordCell16= new PdfPCell(new Phrase("Cash Loan", boldFont));          PdfPCell pdfWordCell17= new PdfPCell(new Phrase("Tra Loan", boldFont));         PdfPCell pdfWordCell18= new PdfPCell(new Phrase("Power", boldFont));    
    PdfPCell pdfWordCell19= new PdfPCell(new Phrase("Meals", boldFont));              PdfPCell pdfWordCell20= new PdfPCell(new Phrase("Tiffin", boldFont));           PdfPCell pdfWordCell21= new PdfPCell(new Phrase("Tea", boldFont));
    PdfPCell pdfWordCell22= new PdfPCell(new Phrase("Store", boldFont));              PdfPCell pdfWordCell23= new PdfPCell(new Phrase("Medicine", boldFont));         PdfPCell pdfWordCell24= new PdfPCell(new Phrase("Cable", boldFont));
    PdfPCell pdfWordCell25= new PdfPCell(new Phrase("Gas", boldFont));                PdfPCell pdfWordCell26= new PdfPCell(new Phrase("Adv2", boldFont));             PdfPCell pdfWordCell27= new PdfPCell(new Phrase("Eggs", boldFont));
    PdfPCell pdfWordCell28= new PdfPCell(new Phrase("Uniform", boldFont));            PdfPCell pdfWordCell29= new PdfPCell(new Phrase("Total Deduction", boldFont));  PdfPCell pdfWordCell30= new PdfPCell(new Phrase("Net Salary", boldFont));
 //   PdfPCell pdfWordCell31= new PdfPCell(new Phrase("Signature", boldFont));
             
           pdfWordCell2.addElement(two); pdfWordCell3.addElement(three); pdfWordCell4.addElement(four);
            pdfWordCell5.addElement(five); pdfWordCell6.addElement(six); pdfWordCell7.addElement(seven); pdfWordCell8.addElement(eight);
            pdfWordCell9.addElement(nine); pdfWordCell10.addElement(ten); pdfWordCell11.addElement(eleven); pdfWordCell12.addElement(twelve);
            pdfWordCell13.addElement(thirteen); pdfWordCell14.addElement(fourteen); pdfWordCell15.addElement(fifteen);
          
            d.open();
             PdfPTable table = new PdfPTable(30);
        //     PdfPTable table1 = new PdfPTable(2);
         //    table.setWidths(new int[]{4,5,6,5,7,5,5,5,4,7,6,4,4,6,8,7,6,6,6,6,4,5,9,5,4,2,2,2,2,2,2});
              table.setTotalWidth(1250);
      table.setWidths(new int[] {40,40,40,40,40,40,40,40,40,40,40,40,40,40,45,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40});
      table.setLockedWidth(true);
        //   table.addCell(  pdfWordCell );  
  
//      table.setTotalWidth(1250);
//      table.setLockedWidth(true);

       table.addCell( pdfWordCell2 ); table.addCell(pdfWordCell3);  table.addCell(pdfWordCell4);
      table.addCell(pdfWordCell5);   table.addCell(pdfWordCell6);   table.addCell(pdfWordCell7);
      table.addCell(pdfWordCell8);   table.addCell(pdfWordCell9);   table.addCell(pdfWordCell10); table.addCell(pdfWordCell11);
      table.addCell(pdfWordCell12);  table.addCell(pdfWordCell13);  table.addCell(pdfWordCell14); table.addCell(pdfWordCell15);
     table.addCell(pdfWordCell50);
      table.addCell(pdfWordCell16);  table.addCell(pdfWordCell17);  table.addCell(pdfWordCell18); table.addCell(pdfWordCell19);
      table.addCell(pdfWordCell20);  table.addCell(pdfWordCell21);  table.addCell(pdfWordCell22); table.addCell(pdfWordCell23);
      table.addCell(pdfWordCell24);  table.addCell(pdfWordCell25);  table.addCell(pdfWordCell26); table.addCell(pdfWordCell27);
      table.addCell(pdfWordCell28);  table.addCell(pdfWordCell29);  table.addCell(pdfWordCell30); 
     // table.addCell(pdfWordCell31);
      
      
      Connection connection=null;
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrmsdp_10","root", "nivriti@123");
   //   Statement st=connection. createStatement(); 
          
      Statement st1=connection.createStatement();
        CallableStatement st=null;
      String sql = "{Call emp_payslip123(?,?)}";
          st=connection.prepareCall(sql);
          
          st.setString(1,newmonth);
          st.setInt(2,year);
    //  String sql="Call calc(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      //  PreparedStatement st=connection.prepareStatement(sql);
         //    ResultSet rs= st.executeQuery("Call calc(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
     ResultSet rs=st.executeQuery();
      while(rs.next())
      { 
          
          table.addCell(rs.getString("emp_id")); 
          table.addCell(rs.getString("emp_name")); 
          table.addCell(rs.getString("status")); 
          table.addCell(rs.getString("dept_name")); 
          table.addCell(rs.getString("days"));
          table.addCell(rs.getString("wage"));
          table.addCell(rs.getString("inc"));
          table.addCell(rs.getString("earn"));
          table.addCell(rs.getString("inc_amount"));
          table.addCell(rs.getString("gross_salary"));
          table.addCell(rs.getString("pf"));
          table.addCell(rs.getString("ppp"));
          table.addCell(rs.getString("pf_no"));
          table.addCell(rs.getString("salary_advance"));
          table.addCell(rs.getString("sum(gas_loan)"));
          table.addCell(rs.getString("sum(cash_loan)"));
          table.addCell(rs.getString("sum(tra_loan)"));
          table.addCell(rs.getString("power"));
          table.addCell(rs.getString("meals"));
          table.addCell(rs.getString("tiffin"));
          table.addCell(rs.getString("tea"));
          table.addCell(rs.getString("store"));
          table.addCell(rs.getString("medicines"));
          table.addCell(rs.getString("cable"));
          table.addCell(rs.getString("gas"));
          table.addCell(rs.getString("adv2"));
          table.addCell(rs.getString("eggs"));
          table.addCell(rs.getString("uniform"));
          table.addCell(rs.getString("total_deductions"));
          table.addCell(rs.getString("net_salary"));
       //   table.addCell("");
         // table.addCell(image);
      }
        //ResultSet rs1=st1.executeQuery("SELECT   sum(days) as days , sum(wage) as wages, sum(earn) as earn ,sum(inc) as inc,sum(gros_earn) as gross_earn,sum(sal_advance) as sal_adv,sum(cash_loan) as cash_loan,sum(gas_loan) as gas_loan,sum(tra_loan) as tra_loan,sum(power) as power,sum(meals) as meals,sum(tiffin) as tiffin,sum(tea) as tea,sum(store) as store,sum(medicines) as medicines,sum(cable) as cable,sum(gas) as gas,sum(adv2) as adv2,sum(eggs) as eggs,sum(uniform) as uniform,sum(total_deduction) as totla_deduction  FROM caluclation ");
//            ResultSet rs1=st1.executeQuery("select sum(days),sum(wage) from caluclation");
      //      String s1=rs1.getString(1);
        
          
      
   //   table.setTotalWidth(PageSize.LARGE_CROWN_OCTAVO.getWidth());   
      d.add(para);
      d.add( Chunk.NEWLINE );
      d.add( Chunk.NEWLINE );
      d.add(table); 
      d.close();
     }
        catch(Exception e)
        {
            System.out.println(e);
        }
        byte[] bytes=null;
        bytes=b.toByteArray();
        res.setContentLength(bytes.length);
        if(bytes!=null)
        {
            inputStream=new ByteArrayInputStream(bytes);
        }
        return "success";
    }
     private PdfManager pmanager;
     private static int c;
     private Pdfdto object;

    public Pdfdto getObject() {
        return object;
    }

    public void setObject(Pdfdto object) {
        this.object = object;
    }
    public PdfManager getPmanager() {
        return pmanager;
    }

    public void setPmanager(PdfManager pmanager) {
        this.pmanager = pmanager;
    }

    public Reportsaction() {
        pmanager=new PdfManager();
    }

    @Override
    public void validate() {
          System.out.println("555555555555555555555555///////");
       if (pmanager.trivs(getObject())) {
           System.out.println("ddddddddddddaaaaaaaaaad///////");
                 c++;
                    if (c % 2 != 0) {
                         addFieldError("object.empdate", "Invalid Month or Year");
                     } 
                    else {
                        addFieldError("object.empdate", "");
                       c = 0;
                    }
            }
      }
    }
   
   
    

