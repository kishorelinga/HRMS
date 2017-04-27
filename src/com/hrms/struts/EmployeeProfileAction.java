/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.struts;

import com.hrms.dto.EmployeeProfileForm;
import com.hrms.manager.HRMSManager;
import com.hrms.model.EmployeeProfile;
import com.opensymphony.xwork2.ActionSupport;
import java.text.ParseException;
import java.lang.Integer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author NSG
 */
public class EmployeeProfileAction extends ActionSupport {

    HRMSManager e = new HRMSManager();
    private HRMSManager hr;
    private String address;
    private String perminentAddress;
    private static int check,a,b,c,d,f,g,h,i,j,k,l,m,n,o,p,p1,q,r,s,t,u,ua,aa,cc,ja,jb,la,ma,mb,na,nb,oa,qa,qb,qc,qd,qe;
    private static String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

   
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPerminentAddress() {
        return perminentAddress;
    }

    public void setPerminentAddress(String perminentAddress) {
        this.perminentAddress = perminentAddress;
    }

    public HRMSManager getHr() {
        return hr;
    }

    public void setHr(HRMSManager hr) {
        this.hr = hr;
    }

    private EmployeeProfileForm form;
    private EmployeeProfileForm form1;

    public EmployeeProfileForm getForm() {
        return form;
    }

    public void setForm(EmployeeProfileForm form) {
        this.form = form;
    }

    public EmployeeProfileForm getForm1() {
        return form1;
    }

    public void setForm1(EmployeeProfileForm form1) {
        this.form1 = form1;
    }

    private static List<EmployeeProfileForm> list = new ArrayList<>();
    private List<String> deptList = new ArrayList<>();
    private List<String> addrList = new ArrayList<>();
    private List<String> quarterList = new ArrayList<>();
    private List<String> emptypeList = new ArrayList<>();
    private List<String> proofList = new ArrayList<>();
    private static List<EmployeeProfile> list1 = new ArrayList<>();

    public List<EmployeeProfile> getList1() {
        return list1;
    }

    public void setList1(List<EmployeeProfile> list1) {
        this.list1 = list1;
    }

    public EmployeeProfileAction() {
        hr = new HRMSManager();
    }

    public List<EmployeeProfileForm> getList() {
        return list;
    }

    public void setList(List<EmployeeProfileForm> list) {
        this.list = list;
    }

    public List<String> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<String> deptList) {
        this.deptList = deptList;
    }

    public List<String> getAddrList() {
        return addrList;
    }

    public void setAddrList(List<String> addrList) {
        this.addrList = addrList;
    }

    public List<String> getQuarterList() {
        return quarterList;
    }

    public void setQuarterList(List<String> quarterList) {
        this.quarterList = quarterList;
    }

    public List<String> getEmptypeList() {
        return emptypeList;
    }

    public void setEmptypeList(List<String> emptypeList) {
        this.emptypeList = emptypeList;
    }

    public List<String> getProofList() {
        return proofList;
    }

    public void setProofList(List<String> proofList) {
        this.proofList = proofList;
    }

    private int id1;
    private static int z = 0;

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public String Reset()  
    {
        super.clearErrorsAndMessages(); 
        return "success";
    }
    
    public String example() {
        z = 0;
        deptList = hr.getDepts();
        quarterList = hr.getQuarters();
        emptypeList = hr.getEmpType();
        proofList = hr.getproofType();

        return "success";
    }

    public String empInsert() throws ParseException {
        System.out.println("----------------------->");
        hr.insertEmployee(getForm(), getAddress(), getPerminentAddress());
        
        list = e.displayEmployee();
        return "success";
    }

    public String empDisplay() {
        list = e.displayEmployee();
        return "success";
    }

    public String empDelete() {
        e.deleteEmployee(getId1());
        list = e.displayEmployee();
        return "success";
    }

    public String empEdit() {
        z++;
        list1 = e.editEmployee(getId1());
        return "success";
    }

    public String empView() {
        list1 = e.viewEmployee(getId1());
        return "success";
    }

    public String empUpdate() {
        e.updateEmployee(getForm(), getAddress(), getPerminentAddress());
        list = e.displayEmployee();
        return "success";
    }

    @Override
    public void validate() {
        System.out.println("--------------00000000------------------" + url);
        try {
            deptList = hr.getDepts();
            quarterList = hr.getQuarters();
            emptypeList = hr.getEmpType();
            proofList = hr.getproofType();
            String doj = form.getDoj();

            if (!(form.getEmpName().length() == 0 && form.getDoj().length() == 0 && form.getDob().length() == 0 && form.getAadharNumber().length() == 0 && form.getGender() == null
                    && getAddress().length() == 0 && form.getProofNumber().length() == 0 && form.getDept().equals("-1") && form.getEmergencyContactNumber().length() == 0
                    && form.getEmpGrade().length() == 0 && form.getEtype().equals("-1") && form.getMaritialStatus() == null && form.getOtEligibility() == null
                    && getPerminentAddress().length() == 0 && form.getProofType().equals("-1") && form.getQuarter().equals("-1") && form.getSelfContactNumber().length() == 0
                    && form.getEmergencyContactNumber().length() == 0)) {

                if (form.getEmpName().length() == 0) 
                {
                    a++;
                    System.out.println("--------------aa-----------------"+a);
                    if (a % 2 != 0) {
                        addFieldError("form.empName", "Employee Name is required");
                        
                    } else {
                        addFieldError("form.empName", "");
                       a = 0;
                    }

                } 
                else if (!(form.getEmpName().matches("^[a-zA-Z ]*$"))) 
                {
                    aa++;
                    if (aa % 2 != 0) {
                        addFieldError("form.empName", "Only alphabets are allowed");
                        
                    } else {
                        addFieldError("form.empName", "");
                       aa = 0;
                    }
                }
                
                if (form.getEmpId() == null) 
                {
                    b++;
                    if (b % 2 != 0) {
                        addFieldError("form.empId", "Employee id required");
                    } else {
                        
                        addFieldError("form.empId", "");
                       b = 0;
                    }
                }
               
                if (form.getDoj().length() == 0)
                {                    
                     c++;
                    if (c % 2 != 0) {
                         addFieldError("form.doj", "Date of joining is required");
                         
                    } else {
                        addActionError("");
                        c = 0;
                    }
                } 
                else if (doj.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    Date date = sdf.parse(doj);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(date);
                    String parts[] = doj.split("-");
                    boolean valid = true;
                    if (Integer.parseInt(parts[0]) != cal.get(Calendar.DATE))
                    {
                        valid = false;
                         cc++;
                    if (cc % 2 != 0) {
                         addFieldError("form.doj", parts[0] + " is not a valid day of the month " + parts[1]);
                         
                    } else {
                        addActionError("");
                        cc = 0;
                    }
                        
                        System.out.println(parts[1] + " is not a valid day of the month");
                    }
                }
                if (form.getDob().length() == 0) {
                    
                    d++;
                    if (d % 2 != 0) {
                         addFieldError("form.dob", "Date of birth is required");
                         
                    } else {
                       addActionError("");
                       d = 0;
                    }
                    
                } else if (form.getDoj().equals(form.getDob())) {
                   
                     f++;
                    if (f % 2 != 0) {
                         addFieldError("form.doj", "Date of joining and Date of birth must not be same");
                         
                    } else {
                        addActionError("");
                       f = 0;
                    }
                    
                }
                if (form.getProofType().equals("-1")) {
                    
                     g++;
                    if (g % 2 != 0) {
                         addFieldError("form.proofType", "Please select Proof Type");
                         
                    } else {
                        addFieldError("form.proofType", "");
                       g = 0;
                    }
                }

                if (form.getDept().equals("-1")) {
                    
                     h++;
                    if (h % 2 != 0) {
                         addFieldError("form.dept", "Please select Department");
                         
                    } else {
                        addFieldError("form.dept", "");
                       h = 0;
                    }
                    
                }
                if (form.getEtype().equals("-1")) {
                   
                     i++;
                    if (i % 2 != 0) {
                          addFieldError("form.etype", "Please select Employee Type");
                         
                    } else {
                        addFieldError("form.etype", "");
                       i = 0;
                    }
                }
                if (form.getAadharNumber().length() == 0) {
                    
                     j++;
                    if (j % 2 != 0) {
                         addFieldError("form.aadharNumber", "Aadhar number is required");
                         
                    } else {
                        addFieldError("form.aadharNumber", "");
                       j = 0;
                    }
                } else if (form.getAadharNumber().length() < 12) {
                   
                      ja++;
                    if (ja % 2 != 0) {
                         addFieldError("form.aadharNumber", "Aadhar number must have 12 digits");
                         
                    } else {
                        addFieldError("form.aadharNumber", "");
                       ja = 0;
                    }
                } else if (!(form.getAadharNumber().matches("^((\\+[1-9]?[0-9])|0)?(?!0|1+$)[2-9][0-9]{11}$"))) {
                   
                     jb++;
                    if (jb % 2 != 0) {
                         addFieldError("form.aadharNumber", "Invalid aadhar number");
                         
                    } else {
                        addFieldError("form.aadharNumber", "");
                       jb = 0;
                    }
                }
                if (form.getQuarter().equals("-1")) {
                    k++;
                    if (k % 2 != 0) {
                        addFieldError("form.quarter", "Please select Quarter type");
                         
                    } else {
                        addFieldError("form.quarter", "");
                       k = 0;
                    }
                }
                if (getAddress().length() == 0) {
                   
                     l++;
                    if (l % 2 != 0) {
                        addFieldError("address", "Address is required");
                         
                    } else {
                        addFieldError("address", "");
                       l = 0;
                    }
                } else if (getAddress().matches("^([a|n|N|A|.|/|o|e|O|E|\\s])*$")) {
                   
                      la++;
                    if (la % 2 != 0) {
                        addFieldError("address", "please provide valid address");
                         
                    } else {
                        addFieldError("address", "");
                       la = 0;
                    }
                }
                if (form.getSelfContactNumber().length() == 0) {
                    
                      m++;
                    if (m % 2 != 0) {
                       addFieldError("form.selfContactNumber", "Phone no is mandatory");
                         
                    } else {
                        addFieldError("form.selfContactNumber", "");
                       m = 0;
                    }
                } else if (form.getSelfContactNumber().length() < 10) {
                   
                     ma++;
                    if (ma % 2 != 0) {
                       addFieldError("form.selfContactNumber", "Mobile number must have 10 digits");
                         
                    } else {
                        addFieldError("form.selfContactNumber", "");
                       ma = 0;
                    }
                } else if (!(form.getSelfContactNumber().matches("^((\\+[1-9]?[0-9])|0)?[7-9][0-9]{9}$"))) {
                   
                    mb++;
                    if (mb % 2 != 0) {
                       addFieldError("form.selfContactNumber", "invalid mobile number");
                         
                    } else {
                        addFieldError("form.selfContactNumber", "");
                       mb = 0;
                    }
                }
                if (form.getEmergencyContactNumber().length() == 0) {
                   
                     n++;
                    if (n % 2 != 0) {
                        addFieldError("form.emergencyContactNumber", "Phone no is mandatory");
                         
                    } else {
                        addFieldError("form.emergencyContactNumber", "");
                       n = 0;
                    }
                } else if (form.getEmergencyContactNumber().length() < 10) {
                    
                    na++;
                    if (na % 2 != 0) {
                        addFieldError("form.emergencyContactNumber", "Mobile number must have 10 digits");
                         
                    } else {
                        addFieldError("form.emergencyContactNumber", "");
                       na = 0;
                    }
                } else if (!(form.getEmergencyContactNumber().matches("^((\\+[1-9]?[0-9])|0)?[7-9][0-9]{9}$"))) {
                   
                     nb++;
                    if (nb % 2 != 0) {
                        addFieldError("form.emergencyContactNumber", "invalid mobile number");
                         
                    } else {
                        addFieldError("form.emergencyContactNumber", "");
                       nb = 0;
                    }
                }
                if (getPerminentAddress().length() == 0) {
                   
                    o++;
                    if (o % 2 != 0) {
                        addFieldError("perminentAddress", " Perminent address is required");
                         
                    } else {
                        addFieldError("perminentAddress", "");
                       o = 0;
                    }
                } else if (getPerminentAddress().matches("^([a|n|N|A|.|/|o|e|O|E|\\s])*$")) {
                    
                     oa++;
                    if (oa % 2 != 0) {
                        addFieldError("perminentAddress", "Please provide valid perminent address");
                         
                    } else {
                        addFieldError("perminentAddress", "");
                       oa = 0;
                    }
                }
                if (form.getEmpGrade().length() == 0) {
                   
                     p++;
                    if (p % 2 != 0) {
                        addFieldError("form.empGrade", "Employee Grade is required");
                         
                    } else {
                        addFieldError("form.empGrade", "");
                       p = 0;
                    }
                }
                else if (!form.getEmpGrade().matches("^[a-zA-Z0-9 ]*$")) {
                   
                     p1++;
                    if (p1 % 2 != 0) {
                        addFieldError("form.empGrade", "Special Symbols are not Allowed");
                         
                    } else {
                        addFieldError("form.empGrade", "");
                       p1 = 0;
                    }
                }
                if (form.getProofNumber().length() == 0) {
                   
                      q++;
                    if (q % 2 != 0) {
                         addFieldError("form.proofNumber", "Address Proof number is required");
                         
                    } else {
                        addFieldError("form.proofNumber", "");
                       q = 0;
                    }
                } else if (form.getProofType().equals("driving")) {
                    if (!(form.getProofNumber().matches("^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$"))) {
                       
                         qa++;
                    if (qa % 2 != 0) {
                         addFieldError("form.proofNumber", "Please provide valid license number");
                         
                    } else {
                        addFieldError("form.proofNumber", "");
                       qa = 0;
                    }
                    }
                } else if (form.getProofType().equals("voter id")) {
                    if (!(form.getProofNumber().matches("^[A-Z]{3}[0-9]{7}$"))) {
                       
                         qb++;
                    if (qb % 2 != 0) {
                          addFieldError("form.proofNumber", "Please provide valid proof id");
                         
                    } else {
                        addFieldError("form.proofNumber", "");
                       qb = 0;
                    }
                    }
                } else if (form.getProofType().equals("aadhar")) {
                    if (!(form.getProofNumber().matches("^((\\+[1-9]?[0-9])|0)?(?!0|1+$)[2-9][0-9]{11}$"))) {
                        
                         qc++;
                    if (qc % 2 != 0) {
                          addFieldError("form.proofNumber", "Invalid aadhar number");
                         
                    } else {
                        addFieldError("form.proofNumber", "");
                       qc = 0;
                    }
                    } else if (form.getProofType().equals("aadhar")) {
                        if (!(form.getAadharNumber().equals(form.getProofNumber()))) {
                           
                             qd++;
                    if (qd % 2 != 0) {
                           addFieldError("form.proofNumber", "Aadhar number mismatch");
                         
                    } else {
                        addFieldError("form.proofNumber", "");
                       qd = 0;
                    }
                        }
                    }
                } else if (form.getProofType().equals("ration card")) {
                    if (form.getProofNumber().equals("N.A")) {
                       
                         qe++;
                    if (qe % 2 != 0) {
                           addFieldError("form.proofNumber", "invalid ration card number");
                         
                    } else {
                        addFieldError("form.proofNumber", "");
                       qe = 0;
                    }
                    }
                }

                if (form.getGender() == null) {
                    
                     r++;
                    if (r % 2 != 0) {
                           addFieldError("form.gender", "Please select gender");
                         
                    } else {
                        addFieldError("form.gender", "");
                       r = 0;
                    }
                }
                if (form.getMaritialStatus() == null) {
                   
                     s++;
                    if (s % 2 != 0) {
                           addFieldError("form.maritialStatus", "Please select Marital status");
                         
                    } else {
                        addFieldError("form.maritialStatus", "");
                       s = 0;
                    }
                }
                if (form.getOtEligibility() == null) {
                    
                     t++;
                    if (t % 2 != 0) {
                          addFieldError("form.otEligibility", "Please provide overtime eligibility");
                         
                    } else {
                        addFieldError("form.otEligibility", "");
                       t = 0;
                    }
                }

            } else {
                check++;
                if (check % 2 != 0) {
                    addFieldError("form.empId", "Please fill all fields");

                    System.out.println("-----------------...>" + check);
                } else {
                    addFieldError("form.empId", "");
                    check = 0;
                    System.out.println("---------++++++++++--------...>" + check);
                    // addActionError("hello");
                }

            }

            Calendar cal1 = new GregorianCalendar();
            Calendar cal2 = new GregorianCalendar();
            String dob = form.getDob();
            Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(dob);
            Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(form.getDoj());
            cal1.setTime(date1);
            cal2.setTime(date2);
            int age = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
            System.out.println("Your age is: " + age);
            if (age < 18) {
                addFieldError("form.dob", "Employeee must complete 18 till date of joining");
            } else if (dob.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                Date date = sdf.parse(dob);
                Calendar cal3 = Calendar.getInstance();
                cal3.setTime(date);
                String parts[] = dob.split("-");
                boolean valid = true;
                if (Integer.parseInt(parts[0]) != cal3.get(Calendar.DATE)) {
                    valid = false;
                    addFieldError("form.dob", parts[0] + " is not a valid day of the month " + parts[1]);
                    System.out.println(parts[1] + " is not a valid day of the month");
                }
            }

            if (z == 0) {
                for (Object sub : list) {
                    EmployeeProfile ep = (EmployeeProfile) sub;
                    if (getForm().getEmpName().equals(ep.getEmpName())) {
                        addFieldError("form.empName", "User already exists in database");
                    }
                    if (getForm().getEmpId() == ep.getEmpId()) {
                        addFieldError("form.empId", "Id already exists in database");
                    }
                    if (getForm().getAadharNumber().equals(ep.getAadharNumber())) {
                        addFieldError("form.aadharNumber", "Aadhar number already exists in database");
                    }
                    if (getForm().getProofType().equals("driving")) {
                        if (getForm().getProofNumber().equals(ep.getProofNumber())) {
                            addFieldError("form.proofNumber", "driving number already exists in database");
                        }
                    }
                    if (getForm().getProofType().equals("voter id")) {
                        if (getForm().getProofNumber().equals(ep.getProofNumber())) {
                            addFieldError("form.proofNumber", "voter id already exists in database");
                        }
                    }

                }
                if (form.getImage() == null) {
                    
                     u++;
                    if (u % 2 != 0) {
                          addFieldError("form.image", "Upload an image");
                         
                    } else {
                        addFieldError("form.image", "");
                       u = 0;
                    }
                } else if (!(form.getImageFileName().matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|jpeg))$)"))) {
                    
                     ua++;
                    if (ua % 2 != 0) {
                         addFieldError("form.image", "Upload images only ");
                         
                    } else {
                        addFieldError("form.image", "");
                       ua = 0;
                    }
                }

            }

        } catch (Exception e) {
            // System.out.println("\n Exception during validation"+e);
        }
    }

}
