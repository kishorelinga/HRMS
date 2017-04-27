<%-- 
    Document   : AddPdfdetails
    Created on : Nov 19, 2016, 5:56:32 PM
    Author     : Swathi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="upperreports.jsp" %>
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
  
  
	<script src="js/login.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    </head>
    <body>
       
            <s:head/>
        <style type="text/css">
            label[for="i"] {
            color: black;
            font-size: 11pt;
            padding-bottom: 10px;}    
        </style>
        
          <center>  <div id="div2"> <div class="container"> 
  <h2 class="text-center text-primary">Enter details of Employee to generate pay sheet</h2>
    <div class="clear">&#x00A0;</div>
        <div class="clear">&#x00A0;</div>
        <table> 
       
            <s:form action="generatePdf" method="post" >
            <tr>
                
                <td>  <s:textfield name="emp_id"  requiredLabel="true" requiredPosition="left" label="Employee ID"  size="90" cssClass="form-control form-group" ></s:textfield> </td>
          <td>   <s:textfield name="name" requiredLabel="true" requiredPosition="left" label="Name"  cssClass="form-control form-group" ></s:textfield>    </td>
          <td>   <s:textfield name="status" requiredLabel="true" requiredPosition="left" label="Status"  cssClass="form-control form-group" ></s:textfield>   </td>
          <td>   <s:textfield name="dept" requiredLabel="true" requiredPosition="left" label="Dept"  cssClass="form-control form-group" ></s:textfield> </td>
         <td>    <s:textfield name="days" requiredLabel="true" requiredPosition="left" label="Days"  cssClass="form-control form-group" ></s:textfield> </td>
         <td>    <s:textfield name="wage" requiredLabel="true" requiredPosition="left" label="Wage"  cssClass="form-control form-group" ></s:textfield></td>
         <td>    <s:textfield name="inc"  label="Incentives"  cssClass="form-control form-group" ></s:textfield> </td>
         <td>    <s:textfield name="pf"  label="PF"  cssClass="form-control form-group" ></s:textfield>  </td>
         <td>    <s:textfield name="ppp"  label="PPP"  cssClass="form-control form-group" ></s:textfield> </td>
          <td>   <s:textfield name="pf_no"  label="PF No"  cssClass="form-control form-group" ></s:textfield> </td>
          <td>   <s:textfield name="sal_adv"  label="Salary Advance"  cssClass="form-control form-group" ></s:textfield> </td>
          <td>   <s:textfield name="cash_loan"  label="Cash Loan"  cssClass="form-control form-group" ></s:textfield> </td>
          <td>   <s:textfield name="gas_loan"  label="Gas Loan"  cssClass="form-control form-group" ></s:textfield> </td>
         <td>    <s:textfield name="tra_loan"  label="tra_loan"  cssClass="form-control form-group" ></s:textfield> </td>
          <td>   <s:textfield name="power"  label="power"  cssClass="form-control form-group" ></s:textfield> </td>
         <td>    <s:textfield name="meals"  label="Meals"  cssClass="form-control form-group" ></s:textfield> </td>
         <td>    <s:textfield name="tiffins"  label="Tiffin"  cssClass="form-control form-group" ></s:textfield> </td>
          <td>   <s:textfield name="tea"  label="Tea"  cssClass="form-control form-group" ></s:textfield>   </td>
          <td>   <s:textfield name="store"  label="Store"  cssClass="form-control form-group" ></s:textfield> </td>
         <td>    <s:textfield name="medicines"  label="Medicines"  cssClass="form-control form-group" ></s:textfield> </td>
           <td>  <s:textfield name="cable"  label="Cable"  cssClass="form-control form-group" ></s:textfield> </td>
           <td>  <s:textfield name="gas"  label="Gas"  cssClass="form-control form-group" ></s:textfield> </td>
         <td>    <s:textfield name="adv2"  label="adv2"  cssClass="form-control form-group" ></s:textfield></td>
           <td>  <s:textfield name="eggs"  label="eggs"  cssClass="form-control form-group" ></s:textfield> </td>
            </tr>
                </table>
                </div>     
               
               
         
         
       <div class="form-group">
       <div class="col-sm-6 text-center">
       <s:submit value="Submit and Generate Paysheet"  cssClass="bfsbutton"   ></s:submit>
        </div>  
       <div class="col-sm-6 text-center"> 
    
      </div>
              
      </s:form>
              <div class="col-sm-6 text-center">
              <s:form action="reset">
            <s:submit value="Reset" cssClass="bfsbutton"/>
              </s:form> </div> </div>
            </div>
    </center>
   
     
    </body>
</html>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
  
        
            
                
   
