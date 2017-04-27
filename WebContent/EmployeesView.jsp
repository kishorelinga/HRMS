<%-- 
    Document   : EmployeesView
    Created on : Nov 24, 2016, 10:14:12 AM
    Author     : Masrat
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/newcss.css">
        <script>
          function myFunction(divName) {
               var printContents = document.getElementById(divName).innerHTML;
     var originalContents = document.body.innerHTML;

     document.body.innerHTML = printContents;

          window.print();
           document.body.innerHTML = originalContents;
           }
        </script>
    </head>
  
    <body style="background-color: #e7e7e7"> <div id="printablearea">
    <center> 
        <table width='70%'  class="abc" frame="box">
              <center><h1 style="color: black">Employee Details</h1></center>
     <s:iterator value="list1" >
     <tr>
         <td><b>Employee Id</b></td>
         <td><b>:</b></td>
         <td style="padding-left: 35px"><s:property value="empId" /></td></tr><br />
     <tr>
          <td><b>Employee Name</b></td>
          <td><b>:</b></td>
         <td style="padding-left: 35px"><s:property value="empName" /></td></tr><br />
      <tr>
          <td><b>Date Of Joining</b></td>
          <td><b>:</b></td>
          <td style="padding-left:35px"><s:date format="dd-MM-yyyy" var="date" name="%{doj}"/><s:property value="date" /></td></tr>
      <tr>
          <td><b>Gender</b></td>
          <td><b>:</b></td>
         <td style="padding-left: 35px"><s:property value="gender" /></td></tr>
      <tr>
          <td><b>Department</b></td>
          <td><b>:</b></td>
         <td style="padding-left: 35px"><s:property value="departments.deptName" /></td></tr>
      <tr>
          <td><b>Date Of Birth</b></td>
          <td><b>:</b></td>
         <td style="padding-left: 35px"><s:date format="dd-MM-yyyy" var="date" name="%{dob}"/><s:property value="date" /></td></tr>
      <tr>
          <td><b>Address</b></td>
          <td><b>:</b></td>
         <td style="padding-left: 35px"><s:property value="address" /></td></tr>
      <tr>
          <td><b>Self Contact Number</b></td>
          <td><b>:</b></td>
         <td style="padding-left: 35px"><s:property value="selfContactNumber" /></td></tr>
      <tr>
          <td><b>Emergency Contact Number</b></td>
          <td><b>:</b></td>
         <td style="padding-left: 35px"><s:property value="emergencyContactNumber" /></td></tr>
      <tr>
          <td><b>Permanent Address</b></td>
          <td><b>:</b></td>
         <td style="padding-left: 35px"><s:property value="perminentAddress" /></td></tr>
      <tr>
          <td><b>Proof Type</b></td>
          <td><b>:</b></td>
         <td style="padding-left: 35px"><s:property value="proofType" /></td></tr>
      <tr>
          <td><b>Proof Number</b></td>
          <td><b>:</b></td>
         <td style="padding-left: 35px"><s:property value="proofNumber" /></td></tr>
      <tr>
          <td><b>Employee Type</b></td>
          <td><b>:</b></td>
         <td style="padding-left: 35px"><s:property value="employeeType.description" /></td></tr>
      <tr>
          <td><b>Quarters</b></td>
          <td><b>:</b></td>
         <td style="padding-left: 35px"><s:property value="quarterType" /></td></tr>
      <tr>
          <td><b>Overtime Eligibility</b></td>
          <td><b>:</b></td>
         <td style="padding-left: 35px"><s:property value="otEligibility" /></td></tr>
       <tr>
          <td><b>Employee Grade</b></td>
          <td><b>:</b></td>
         <td style="padding-left: 35px"><s:property value="empGrade" /></td></tr>
      <tr>
          <td><b>Record Creation Date</b></td>
          <td><b>:</b></td>
          <td style="padding-left: 35px"><s:date name="%{recordCreationDate}" format="dd-MM-yyyy" var="date"/><s:property value="date" /></td></tr>
     
     </s:iterator>
        </table>
    </center> </div>
        <br /><br />
        <div class="im">
       <%--     <img src='<s:url value="com.hrms.struts.EmployeeProfileAction" action="image"/>'  border="0" width="50" height="50" alt="image"> --%>
        </div>
        <center><button onclick="myFunction('printablearea')">Print this page</button></center>

</body>
    
</html>
