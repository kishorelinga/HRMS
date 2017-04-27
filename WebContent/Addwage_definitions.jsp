<%-- 
    Document   : Wage_definitions
    Created on : Nov 21, 2016, 1:15:26 PM
    Author     : Swathi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@include file="upperlogoMaster.jsp" %>
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
    <s:head/>
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
  <h2 class="text-center text-primary">Wage Definitions</h2>
    <div class="clear">&#x00A0;</div>
        <div class="clear">&#x00A0;</div>
        
     <s:form action="wagedef"  enctype="multipart/form-data" method="post" >          
         <table>
        
             <s:textfield id="i" name="master.wageid" label="Wage ID" size="90" cssClass="form-control form-group"></s:textfield>     
         <s:select id="i" label="Select Employee type" list="emplist"  headerKey="-1" headerValue="Select Employee type"
                          name="master.emptype"  cssClass="form-control form-group"></s:select>
         <s:select id="i" label="Select Wage Calculation type" list="wagecallist"  headerKey="-1" headerValue="Select wage type"
                       name="master.wagetype"  cssClass="form-control form-group"></s:select>
      
        </table>       
   
     <br/>
        <div class="col-sm-6 text-center">
        <s:submit value="Submit" cssClass="btn btn-default" align="center"></s:submit>
      </div> 
        <div class="col-sm-6 text-center"> 
          <button type="button" class="btn btn-default" ><a href="abcde" style="text-decoration:none; color:black">Cancel</a></button>
          </div>
         </s:form> 
     
</center>
    
    </body>
</html>
