<%-- 
    Document   : QuarterView
    Created on : Dec 2, 2016, 4:49:48 PM
    Author     : Swathi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>..::HRMS::..</title>
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
        <table width="30%" class="abc" >
              <center><h1 style="color: #31708f">Quarters Details</h1></center>
     <s:iterator value="quarterslist" >
     <tr>
         <td><b>Employee Id</b></td>
         <td><b>:</b></td>
         <td style="padding-left: 35px"><s:property value="employeeProfile.empId" /></td>
      </tr><br />    
       <tr>
         <td><b>Quarter Code</b></td>
         <td><b>:</b></td>
         <td style="padding-left: 35px"><s:property value="residentialQuarters.quarterCode"/></td>
      </tr><br />      
       <tr>
         <td><b>Check In Date</b></td>
         <td><b>:</b></td>
         <td style="padding-left: 35px"><s:property value="checkInDate" /></td>
      </tr><br />     
     
     
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
