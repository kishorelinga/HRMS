<%-- 
    Document   : Generatepayslip
    Created on : Dec 12, 2016, 10:26:53 AM
    Author     : Swathi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@include file="upperreports.jsp"%>
<!DOCTYPE html>
<html>
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
            font-family:  sans-serif;
            font-style: normal;
            color: black;
            font-size: 11pt;
            padding-bottom: 10px;}    
        </style>
    <div id="div2">
           <center>
               <s:form action="payslip">
                <br/><br/>
                <table>                   
                    <tr> <td><s:textfield id="i" size="90"   name="object.emp_id" label="Enter Employee ID" cssClass="form-control form-group"/>  </td>        </tr>
                    <tr> <td><sj:datepicker readonly="true" name="object.date" changeMonth="true"  changeYear="true" placeholder="dd-mm-yy" label="Enter Date" displayFormat="dd-mm-yy"  cssClass="lab" /> </td></tr>
                </table>
           <br/><br/>
            <div class="form-group" >
      <div class="col-sm-6 text-center">
      <s:submit  value="Submit"  cssClass="btn btn-default" align="center" ></s:submit>
      </div>
          
          
            <s:reset value="Reset" cssClass="btn btn-default" align="center"/>
            
            
            </div></center>
           </div>
            </s:form>
    </body>
</html>
