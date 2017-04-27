/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.struts;

import com.hrms.dto.Loan;
import com.hrms.manager.LoanManager;
import com.hrms.model.LoanAllotment;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Masrat
 */
public class LoanAction extends ActionSupport{
    private Loan loan;
    private LoanManager lm=new LoanManager();
   
   private static List<String> lolist=new ArrayList<>();
   private static List<Loan> listofloans=new ArrayList<>();
   private int id1;
   private static int id2,zx;
   private static int a,b,c,d,e,f,g,h,i,j,k,l;
   private String sample[];

    public String[] getSample() {
        return sample;
    }


    public void setSample(String[] sample) {
        this.sample = sample;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public List<String> getLolist() {
        return lolist;
    }

    public void setLolist(List<String> lolist) {
        this.lolist = lolist;
    }

    
    public List<Loan> getListofloans() {
        return listofloans;
    }

    public void setListofloans(List<Loan> listofloans) {
        this.listofloans = listofloans;
    }

   

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

  
    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public LoanManager getLm() {
        return lm;
    }

    public void setLm(LoanManager lm) {
        this.lm = lm;
    }

    public String addLoan(){
        System.out.println("//////////////////////");
        System.out.println("========+++000000000000++++++++++========"+loan.getGasLoan());
        lm.insertLoan(getLoan());
        return SUCCESS;
    }
    public String getlist(){
        //System.out.println("================");
        zx=0;
      lolist=lm.getId();
      return SUCCESS;
        
    }
    public String getloanslist(){
         lolist=lm.getId();
        listofloans=lm.loansList();
        System.out.println("----------->"+listofloans);
        return SUCCESS;
        
    }
    public String editLoan(){
        zx++;
         lolist=lm.getId();
         listofloans=lm.editLoans(getId1());
        //System.out.println("=================================++++++++++++++++++++++++"+lolist);
        for (Object sub :  listofloans) 
                {
                    LoanAllotment ep = (LoanAllotment) sub;
                      // System.out.println("-------------!!!-----------"+ep);
                     //System.out.println("-------------!!!-----------"+ep.getHouseholdThings());
                    // System.out.println("-------------!!!???????-----------"+ep.getLoansMaster());
                     String x=ep.getHouseholdThings();
                     if(x!=null){
                     sample= x.split(", ");
                     }
                      //System.out.println("-------------!!!-----------"+sample[0]+sample[1]);
                }
        id2=getId1();
       //System.out.println("0000000000"+id2);
        return SUCCESS;
    }
    public String deleteLoan(){
        
        lm.deleteLoans(getId1());
        listofloans=lm.loansList();
        return SUCCESS;
    }
    public String updateLoan(){
        //System.out.println("00000.............00000"+id2);
       // System.out.println("=================================++++++++++++++++++++++++"+getId2());
        lm.updateLoans(getLoan(),getId2());
        listofloans=lm.loansList();
        
        return SUCCESS;
    }
      private int id8;
   private  List<LoanAllotment> listview=new ArrayList();

    public List<LoanAllotment> getListview() {
        return listview;
    }

    public void setListview(List<LoanAllotment> listview) {
        this.listview = listview;
    }
    public int getId8() {
        return id8;
    }

    public void setId8(int id8) {
        this.id8 = id8;
    }
    
        public  String loanView() {
        this.listview=lm.loanView(getId8());
        return "success";
    }
    
 
    public void validate(){
        lolist=lm.getId();
        if(getLoan()!=null){
        boolean sh;
        sh=lm.search(loan.getEmpId());
        if(!(loan.getEmpId()==0 && loan.getLoanType().equals("-1") && loan.getRequestedAmt()==null && loan.getHouseholdThings().length()==0 && loan.getLoanApprovaldate()==null))
        {
        if(sh==false){
         
 	 a++;
                    if (a % 2 != 0) {
                        addFieldError("loan.empId", "No Employee with id "+loan.getEmpId()+". Enter valid id");
                         
                    } else {
                        addFieldError("loan.empId", "");
                       a = 0;
                    }

        }
        if(loan.getLoanType().equals("-1")){
         
	 b++;
                    if (b % 2 != 0) {
                         addFieldError("loan.loanType","Select Loan Type");
                         
                    } else {
                        addFieldError("loan.loanType", "");
                       b = 0;
                    }


        }
        if(!(loan.getLoanType().equals("Cash Loan")||loan.getLoanType().equals("Gas Loan")||loan.getLoanType().equals("Tra Loan"))){
        if(loan.getRequestedAmt()==null){
           
	 c++;
                    if (c % 2 != 0) {
                        addFieldError("loan.requestedAmt", "Enter the requested amount ");
                         
                    } else {
                        addFieldError("loan.requestedAmt", "");
                       c = 0;
                    }

        }
        }
        else{
            if(loan.getLoanType().equals("Cash Loan")){
            if(loan.getCashLoan()==null){
           
	 j++;
                    if (j % 2 != 0) {
                        addFieldError("loan.cashLoan", "Enter the requested cash amount ");
                         
                    } else {
                        addFieldError("loan.cashLoan", "");
                       j = 0;
                    }

        }
            }
             if(loan.getLoanType().equals("Gas Loan")){
            if(loan.getGasLoan()==null){
           
	 k++;
                    if (k % 2 != 0) {
                        addFieldError("loan.gasLoan", "Enter the requested gas amount ");
                         
                    } else {
                        addFieldError("loan.gasLoan", "");
                       k = 0;
                    }

        }
            }
             if(loan.getLoanType().equals("Tra Loan")){
            if(loan.getTraLoan()==null){
           
	 l++;
                    if (l % 2 != 0) {
                        addFieldError("loan.traLoan", "Enter the requested tra amount ");
                         
                    } else {
                        addFieldError("loan.traLoan", "");
                       l = 0;
                    }

        }
            }

        }
        if(loan.getHouseholdThings().length()==0){
           

	 d++;
                    if (d % 2 != 0) {
                       addFieldError("loan.householdThings", "Select House-hold Things");
                         
                    } else {
                        addActionError("");
                       d = 0;
                    }
        }
       
            System.out.println("------,,,,,,,,,---------"+zx);
        if(zx!=0){
            if(!(loan.getStatus().equals("Rejected") || loan.getStatus().equals("Closed"))){
                 System.out.println("------,,,?????,,,,,,---------"+zx);
            if(loan.getSanctionedAmt()==null){
              
	 e++;
                    if (e % 2 != 0) {
                        addFieldError("loan.sanctionedAmt", "Enter Sactioned amount");
                         
                    } else {
                        addFieldError("loan.sanctionedAmt", "");
                       e = 0;
                    }
            }
            if(loan.getLoanApprovaldate().length()==0){
               

	f++;
                    if (f % 2 != 0) {
                        addFieldError("loan.loanApprovaldate", "Select Loan Approval Date");
                         
                    } else {
                        addActionError("");
                       f = 0;
                    }
            }
                System.out.println("-----+++++++"+loan.getStatus());
             if(loan.getStatus().equals("-1")){
             

	g++;
                    if (g% 2 != 0) {
                          addFieldError("loan.status", "Select Loan Status");
                         
                    } else {
                        addFieldError("loan.status", "");
                       g = 0;
                    }
            }
            }
        }
        else{
             
             if(loan.getLoanCreationdate().length()==0){
          

	h++;
                    if (h% 2 != 0) {
                          addFieldError("loan.loanCreationdate", "Select Loan Creation Date");
                         
                    } else {
                        addActionError("");
                       h = 0;
                    }
        }
        }
        }
        else{
          

	i++;
                    if (i% 2 != 0) {
                            addFieldError("loan.empId", "Please fill the form");
                         
                    } else {
                        addFieldError("loan.empId", "");
                       i = 0;
                    }
        }
    }
    }
   
}
