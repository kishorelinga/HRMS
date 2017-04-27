<%-- 
    Document   : DeductionMaster
    Created on : Nov 21, 2016, 1:03:39 PM
    Author     : nsg
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="upperlogoMaster.jsp" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
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
    <link href="css/newcss.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
 
    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
 
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
             input[type="checkbox"]{
                width: 25px;
                    margin-left: 10px;
                   height: 15px;
            }
            .rowwidth{
               width: 890px;
            }
        </style>

      
    
  <center>
<div class="container">
  <h2 class="text-center text-primary">Deduction Master</h2>
    <div class="clear">&#x00A0;</div>
        <div class="clear">&#x00A0;</div>
     <s:form action="updatededuction"  enctype="multipart/form-data" method="post" >          
         <table class="rowwidth">
        <tr>
            <s:iterator value="listofdeducs" status="rowstatus" var="myobj" >
                <td><s:textfield id="i" name="deduc.deductionId" value="%{deductionId}" size="90" label="Deduction Id" cssClass="form-control form-group" autofocus="autofocus" readonly="true" ></s:textfield></td> </tr>
            <tr><td><s:textfield id="i" name="deduc.deductionCode" value="%{deductionCode}" label="Deduction Code" cssClass="form-control form-group"></s:textfield></td> </tr>
           <%-- <tr><td><s:textfield id="i" name="deduc.deductionRuleId" value="%{deductionRules.deductionRuleId}" label="Deduction Rule Id" headerKey="-1" headerValue="--Select Deduction Rule Id---" cssClass="form-control form-group" readonly="true" ></s:textfield></td></tr>--%>
            <tr><td><s:textfield id="i" name="deduc.deductionName" value="%{deductionName}" label="Deduction Name" cssClass="form-control form-group" ></s:textfield></td></tr>
            <tr><td><s:textfield id="i" name="deduc.empId" value="%{employeeProfile.empId}" label="Employee Id" cssClass="form-control form-group" readonly="true" ></s:textfield></td></tr>
            <tr><td><s:textfield id="i" name="deduc.pfNum" value="%{pfNo}" label="PF Number" cssClass="form-control form-group" ></s:textfield></td></tr>
           <tr><td><s:textfield id="i" name="deduc.pf" value="%{pf}" label="Provident Fund" cssClass="form-control form-group" ></s:textfield></td></tr>
           <tr><td><s:textfield id="i" name="deduc.ppp" value="%{ppp}" label="PPP" cssClass="form-control form-group" ></s:textfield></td></tr>
       <tr><td><s:textfield id="i" name="deduc.salaryAdvance" value="%{salaryAdvance}" label="Salary Advance" cssClass="form-control form-group" ></s:textfield></td></tr>
      <tr><td><s:textfield id="i" name="deduc.power" value="%{power}" label="Power" cssClass="form-control form-group" ></s:textfield></td></tr>
         <tr><td><s:textfield id="i" name="deduc.meals" value="%{meals}" label="Meals" cssClass="form-control form-group" ></s:textfield></td></tr>
        <tr><td><s:textfield id="i" name="deduc.tiffin" value="%{tiffin}" label="Tiffin" cssClass="form-control form-group" ></s:textfield></td></tr> 
        <tr><td><s:textfield id="i" name="deduc.tea" value="%{tea}" label="Tea" cssClass="form-control form-group" ></s:textfield></td></tr>
         <tr><td><s:textfield id="i" name="deduc.store" value="%{store}" label="Store" cssClass="form-control form-group" ></s:textfield></td></tr>
         <tr><td><s:textfield id="i" name="deduc.medicines" value="%{medicines}" label="Medicines" cssClass="form-control form-group" ></s:textfield></td></tr>
         <tr><td><s:textfield id="i" name="deduc.cable" value="%{cable}" label="Cable" cssClass="form-control form-group" ></s:textfield></td></tr>
         <tr><td><s:textfield id="i" name="deduc.gas" value="%{gas}" label="Gas" cssClass="form-control form-group" ></s:textfield></td></tr>
         <tr><td><s:textfield id="i" name="deduc.adv2" value="%{adv2}" label="Advance 2" cssClass="form-control form-group" ></s:textfield></td></tr>
         <tr><td><s:textfield id="i" name="deduc.eggs" value="%{eggs}" label="Eggs" cssClass="form-control form-group" ></s:textfield></td></tr>
         <tr><td><s:textfield id="i" name="deduc.uniform" value="%{uniform}" label="Uniform" cssClass="form-control form-group" ></s:textfield></td></tr>
         <tr><td><s:textfield id="i" value="%{ddate}" label="Created Date" cssClass="form-control form-group" readonly="true" ></s:textfield></td></tr>
        <s:date name="%{ new java.util.Date()}" var="formattedDate" format="dd-MM-yyyy" />

        <td><s:textfield id="i" name="deduc.recordCreationDate" value="%{formattedDate}"  readonly="true" cssClass="form-control form-group " label="Record Creation Date" > 
        </s:textfield></td>
        </s:iterator>
       
    </table>
           <br/><br/> 
           <div class="form-group" style="margin-right:10em" >
      <div class="col-sm-6 text-center">
      <s:submit  value="Update"  cssClass="btn btn-default" align="center" ></s:submit>
            </div>
          <div class="col-sm-6 text-center"> 
          <button type="button" class="btn btn-default" ><a href="deductions" style="text-decoration:none; color:black">Cancel</a></button>
          </div>
            </div> 
    </s:form>
</div>
    </center>
    </body>
</html>


