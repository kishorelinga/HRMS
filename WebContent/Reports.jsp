<%-- 
    Document   : Reports
    Created on : Nov 19, 2016, 10:03:59 AM
    Author     : Swathi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="upperreports.jsp" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  
     <title>..:: HRMS ::..</title>
     <sj:head/>
  </head>

  <body>
          <div class="container-fluid">

    <div class="btn-group dropup">
 <button type="button" align="left" class="btn btn-primary activated1"><a href="Generatepayslip.jsp"/>Generate Pay Slip</a></button>

</div>
<div><br/>
 </div>
        <center>
        <style type="text/css">
            label[for="i"] {
            font-family:  sans-serif;
            font-style: normal;
            color: black;
            font-size: 11pt;
            padding-bottom: 10px;}    
        </style>	
   <div class="table-responsive">&#x00A0;</div>    
         <div class="panel panel-primary">
  <!-- Default panel contents -->
  <div class="panel-heading">HRMS Reports</div>
   
  <div class="panel-body">
     
  <div class="row">
      <table>
      
<%--          <tr align="left"><td>   <sj:datepicker size="40" name="object.date" changeMonth="true"  changeYear="true" placeholder="dd-mm-yyyy" label="Enter Date to Generate Pay Sheet" displayFormat="dd-mm-yy"  cssClass="lab" /></td></tr>--%>
  <div class="col-lg-3"></div>
  <tr><td><a href="Reportdate1.jsp"  class="btn btn-primary activated1" align="left">Generate Pay sheet of  employee details</a>
      </td> </tr>        <div class="col-lg-3"></div>

  <div class="row">&#x00A0;</div>

  <div class="row">
  <div class="col-lg-3"></div>
   <tr><td></td></tr>
  <tr><td></td></tr>
  <tr><td></td></tr>
  <tr><td></td></tr>
  <tr><td><a href="Reportdate.jsp"  class="btn btn-primary activated1" align="center">Department wise Salary Abstract  </a></td> </tr></table>
  <div class="col-lg-3"></div>
     </div>
</div>
  
</div>
         </div>           
      </center>
  
 
   
          </div>
      
  </body>
</html>