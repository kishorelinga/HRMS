<%-- 
    Document   : AddGasConnection
    Created on : Nov 5, 2016, 10:48:42 AM
    Author     : Swathi
--%>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="upperlogogas.jsp" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="/struts-jquery-tags" prefix="sj" %>
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
 <s:head/>
    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
 <link href="css/newcss.css" rel="stylesheet">
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>


	<script src="js/login.js"></script><sj:head/>
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
        </style>

  <div class="container">
  <h2 class="text-center text-primary">Assign Gas Connection</h2>
    <div class="clear">&#x00A0;</div>
        <div class="clear">&#x00A0;</div>
        <center>
    <s:form action="insertGas" method="post">
  <table >
     <tr  ><td> </td></tr>
     <tr> <s:iterator value="glist">         </tr>   
         <tr><td>  <s:textfield name="object.empId"  label="Emp Id" readonly="true" cssClass="form-control form-group" ></s:textfield> </td> </tr>
         <tr><td>  <s:textfield name="residentialQuarters.quarterId" label="Quarter Id" readonly="true" cssClass="form-control form-group" ></s:textfield>   </td></tr>  
           </s:iterator>     
         <tr><td>    <s:select id="i" label="Choose Consumer Number" list="qlist"  headerKey="-1" headerValue="Select Consumer Number"
                          name="object.consumerno" value="defaultdept" cssClass="form-control form-group"></s:select></td></tr>
                 
         <tr>  <td><sj:datepicker readonly="true" changeYear="true" name="object.alloteddate" changeMonth="true" label="Alloted Date" displayFormat="dd-mm-yy" size="90" placeholder="dd-mm-yyyy" cssClass="lab"  /> </td></tr>
           <tr> <td><sj:datepicker readonly="true" changeYear="true"  name="object.closeddate" changeMonth="true" label="Closed date" displayFormat="dd-mm-yy" size="90" placeholder="dd-mm-yyyy" cssClass="lab" /> </td></tr>
              </table> </center>
<!--         
            <center>
          
            </center>-->
         <br/><br/>
            <div class="form-group" >
      <div class="col-sm-6 text-center">
      <s:submit  value="Submit"  cssClass="btn btn-default" align="center" ></s:submit>
      </div>
           <div class="col-sm-6 text-center"> 
          <button type="button" class="btn btn-default" ><a href="retrieve1" style="text-decoration:none; color:black">Cancel</a></button>
          </div>
            </div>
           <br/><br/>	
    </s:form>
  </div>


   

  </body>
  </html>
