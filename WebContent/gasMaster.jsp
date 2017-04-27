<%-- 
    Document   : gasMaster
    Created on : Nov 17, 2016, 12:41:17 PM
    Author     : NSG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

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
	<link rel="stylesheet" href="css/font-awesome.min.css">

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
    <sj:head/>
    <s:head/>
  </head>

  <body>
    <div class="container">
    <div class="row">
    <div class="col-lg-12 mainLogo1">
	<img src="images/mainLogo.png" alt="images" />
	</div>
	</div>
	</div>


    <div class="container-fluid">
    <div class="row">
<nav style="background-color: #154360" class="navbar navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="Home.jsp"><span class="glyphicon glyphicon-dashboard" title="Dash Board" aria-hidden="true"></span></a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
           <li class="activated"><a href="Masters.jsp">Masters</a></li>
        <li><a href="display">Employees <span class="sr-only">(current)</span></a></li>
        <li><a href="retrieve">Quarters</a></li>
        <li><a href="retrieve1">Gas Connections</a></li>
        <li><a href="loanslist">Loans</a></li>
       
        <li><a href="Reports.jsp">Reports</a></li>
      </ul>

    <ul class="nav navbar-nav navbar-right">
		<li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user" title="Dash Board" aria-hidden="true"></span> <span class="caret"></span></a>
          <ul class="dropdown-menu">
<!--            <li><a href="MyProfile.html">My Profile</a></li>
            <li><a href="chPwd.html">Change Password</a></li>
            <li><a href="Settings.html">Settings</a></li>
            <li role="separator" class="divider"></li>-->
            <li><a href="logout">Logout</a></li>
          </ul>
        </li>
      </ul>

     <%--   <form class="navbar-form navbar-right">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
      </form>
--%>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
    </div> <!-- /row -->
    
<style type="text/css">
            label[for="i"] {
            color: black;
            font-size: 11pt;
            padding-bottom: 10px;}    
        </style>

<center>   
<div class="container">
  <h2 class="text-center text-primary">Gas Connection Form</h2>
    <div class="clear">&#x00A0;</div>
        <div class="clear">&#x00A0;</div>
     <s:form action="gasMasterinsert"  enctype="multipart/form-data" method="post" >  
     <table>
         <td><s:textfield id="i" name="form.connectionId" label="Gas Connection Id" cssClass="form-control form-group " placeholder="Gas Connection Id" autofocus="autofocus" ></s:textfield></td> 
            
         <td><s:select id="i" list="gasCompanyList" name="form.gasCompanyName" label="Gas Company Name" cssClass="form-control form-group" headerKey="-1" headerValue=" -- Select -- "></s:select></td> 
         
         <td><s:textfield id="i" name="form.gasStoveId" label="Gas Stove Id" cssClass="form-control form-group" placeholder="Gas Stove Id"></s:textfield></td> 
         
         <td><s:textfield id="i" name="form.consumerNumber" label="Consumer Number" cssClass="form-control form-group" placeholder="Consumer Number"></s:textfield></td> 
         
         <td><s:textfield id="i" name="form.gasConnectionAmount" label="Gas Connection Amount" cssClass="form-control form-group" placeholder="Gas Connection Amount"></s:textfield></td> 
         
         <td><s:select id="i" list="gasCylinderList" name="form.gasCylinderCount" label="Gas Cylinder Count" cssClass="form-control form-group" headerKey="-1" headerValue=" -- Select --"></s:select></td> 
         
         <td><s:textfield id="i" name="form.gasConnectionHolderName" label="Gas Connection Holder Name" cssClass="form-control form-group" placeholder="Gas Connection Holder Name"></s:textfield></td> 
         
         <td><sj:datepicker readonly="true" changeYear="true" name="form.gasConnectionValidateDate" changeMonth="true" size="90" label="Gas Connection Validity Date" displayFormat="dd-mm-yy" cssClass="lab" placeholder="dd-mm-yyyy" ></sj:datepicker></td>
     </table>
     <br/><br/>
            <div class="form-group" >
      <div class="col-sm-6 text-center">
      <s:submit  value="Submit"  cssClass="btn btn-default" align="center" ></s:submit>
      </div>
          <div class="col-sm-6 text-center"> 
          <button type="button" class="btn btn-default" ><a href="gasMasterdisplay" style="text-decoration:none; color:black">Cancel</a></button>
          </div>
            </div> 
   </s:form>

</center>
  </body>
</html>

