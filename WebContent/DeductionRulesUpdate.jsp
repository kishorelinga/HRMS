<%-- 
    Document   : DeductionRulesUpdate
    Created on : Nov 22, 2016, 2:58:40 PM
    Author     : NSG
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
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
    <link href="css/newcss.css" rel="stylesheet">
	<link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">

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
    <style type="text/css">
            label[for="i"] {
            color: black;
            font-size: 11pt;
            padding-bottom: 10px;}    
        </style>
    
  </head>

  <body>
  <center>
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
      <a class="navbar-brand" href="login"><span class="glyphicon glyphicon-dashboard" title="Dash Board" aria-hidden="true"></span></a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
           <li class="activated"><a href="Masters.jsp">Masters</a></li>
        <li ><a href="display">Employees <span class="sr-only">(current)</span></a></li>
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

      <%--  <form class="navbar-form navbar-right">
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

   
<div class="container">
  <h2 class="text-center text-primary">Deduction Rules</h2>
    <div class="clear">&#x00A0;</div>
    
    <s:form action="deductionUpdate" method="post">
        <table>
            <s:iterator value="dlist">
                
                
            <tr>
                <td><s:textfield id="i" name="dform.deductionRuleId" value="%{deductionRuleId}" label="Deduction Rule Id" size="90" cssClass="form-control form-group "></s:textfield></td>
            
                <td><s:select id="i" name="dform.empGrade" list="gradeList" value="%{empGrade}" headerKey="-1" headerValue=" --Select-- " label="Employee Grade" cssClass="form-control form-group "></s:select> </td>
                
                <td><s:textfield id="i" name="dform.flatDeductionAmount" value="%{flatDeductionAmount}" label="Flat Deduction Amount" cssClass="form-control form-group "></s:textfield></td>
           
                <td><s:textfield id="i" name="dform.basicRate" value="%{basicRate}" label="Basic Rate" cssClass="form-control form-group"></s:textfield>
           
                    
            </tr>
            </s:iterator>
        </table>
   <br/><br/>
            <div class="form-group" >
      <div class="col-sm-6 text-center">
      <s:submit  value="Update"  cssClass="btn btn-default" align="center" ></s:submit>
      </div>
           <div class="col-sm-6 text-center"> 
          <button type="button" class="btn btn-default" ><a href="deductionDisplay" style="text-decoration:none; color:black">Cancel</a></button>
          </div>
            </div> 
     
        
    </s:form>
  </div>


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>


 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/tooltip.js"></script>
</center>     
  </body>
</html>


