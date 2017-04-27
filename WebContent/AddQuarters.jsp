<%-- 
    Document   : AddQuarters
    Created on : Nov 5, 2016, 10:50:50 AM
    Author     : Swathi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@include file="upperlogo.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="images/favicon.ico">

    <title>..:: HRMS ::..</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/SkyHRMS.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
    <link href="css/newcss.css" rel="stylesheet">
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>
    <s:head/>
    <sj:head/>
	<script src="js/login.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
    
<style type="text/css">
            label[for="i"] {
            color: black;
            font-size: 11pt;
            padding-bottom: 10px;}    
        </style> <center>  

<div class="container">
  <h2 class="text-center text-primary">Assign Quarters</h2>
    <div class="clear">&#x00A0;</div>
        <div class="clear">&#x00A0;</div>
        
     <s:form action="insertQrt"  enctype="multipart/form-data" method="post" >          
        
         <table> <s:iterator value="qlist1">
                 <td><s:textfield id="i" name="object.empId" label="Employee Id" readonly="true" cssClass="form-control form-group"></s:textfield></td> 
                 <td><s:textfield id="i" name="gender" label="Gender" readonly="true" cssClass="form-control form-group"></s:textfield></td> 
                 <td><s:textfield id="i" name="maritialStatus" label="Marital Status" readonly="true" cssClass="form-control form-group"></s:textfield></td> 
                 <td><s:textfield id="i" name="count" label="No of Family Members" readonly="true" cssClass="form-control form-group"></s:textfield></td>     
                 <td><s:textfield id="i" name="count1" label="No. of Family members as Employees" readonly="true" cssClass="form-control form-group"></s:textfield></td>      
        <td><s:textfield id="i" name="quarterType" label="Quarter type" readonly="true"  cssClass="form-control form-group"></s:textfield> </td> 
         </s:iterator> 
         <td><s:select id="i" label="Choose ur Quarters" list="quarterslist"  headerKey="-1" headerValue="Select ur quarter"
                           name="object.quartercode" value="defaultdept" cssClass="form-control form-group"></s:select></td>
            <td><sj:datepicker readonly="true" changeYear="true"  name="object.doissued" changeMonth="true"  placeholder="dd-mm-yyyy" label="Date of Joining" displayFormat="dd-mm-yy" size="90" cssClass="lab" /> </td>
      <%--  <td><s:submit id="i" label="Submit" cssClass="btn btn-default" ></s:submit></td>--%>
        
         </table>
        <br/><br/>
        <div class="form-group" >
      <div class="col-sm-6 text-center">
      <s:submit  value="Submit"  cssClass="btn btn-default" align="center" ></s:submit>
      </div>
           <div class="col-sm-6 text-center"> 
          <button type="button" class="btn btn-default" ><a href="retrieve" style="text-decoration:none; color:black">Cancel</a></button>
          </div>
            </div>
        
        
    </s:form>
       <%-- <div class="col-sm-6 text-center">
          <a href="Quarters.jsp"><s:submit value="cancel" cssClass="btn btn-default"/></a>
      </div>--%>
</center>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    

  </body>
</html>