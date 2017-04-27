<%-- 
    Document   : IncentiveDisplay
    Created on : Dec 12, 2016, 10:50:00 AM
    Author     : nsg
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
  </head>

  <body>
    <div class="container">
    <div class="row">
    <div class="col-lg-12 mainLogo1">
	<a href="Home.jsp"><img src="images/mainLogo.png" alt="images" /></a>
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
           <li  class="activated"><a href="Masters.jsp">Masters</a></li>
        <li><a href="Employees.jsp">Employees <span class="sr-only">(current)</span></a></li>
        <li><a href="Quarters.jsp">Quarters</a></li>
        <li><a href="GasConnections.jsp">Gas Connections</a></li>
        <li><a href="Loans.jsp">Loans</a></li>
       
        <li><a href="Reports.jsp">Reports</a></li>
      </ul>

      <ul class="nav navbar-nav navbar-right">
		<li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user" title="Dash Board" aria-hidden="true"></span> <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="MyProfile.jsp">My Profile</a></li>
            <li><a href="chPwd.jsp">Change Password</a></li>
            <li><a href="Settings.jsp">Settings</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="index.jsp">Logout</a></li>
          </ul>
        </li>
      </ul>

     

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
    </div> <!-- /row -->
  <center>  <h1 class="text-center text-primary">Incentives</h1></center>


<div class="btn-group dropup">
  <button type="button" class="btn btn-primary activated1"><a href="incentivesEnroll">Add Incentives</a></button>
</div>

<div class="table-responsive">&#x00A0;</div>


<div class="table-responsive">
<table class="table table-striped table-bordered">

<tr class="info">
<th class="text-center">S. No</th>
<th class="text-center">Incentive Id</th>
<th class="text-center">Incentive Name</th>
<th class="text-center">Incentive Code</th>
<th class="text-center">Incentive Amount</th>
<th class="text-center">Edit</th>
<th class="text-center">Delete</th>
</tr>
<s:iterator value="incentiveList" status="rowstatus" var="myobj">
    <tr>
        <td><s:property value="#rowstatus.count" /></td>
       
        <td><s:property value="incentiveId"></s:property></td>
        <td><s:property value="incentiveName"></s:property></td>
        <td><s:property value="incentiveCode"></s:property></td>
        <td><s:property value="incAmount"></s:property></td>
       
        <td><a href="editincentive?id1=<s:property value='id' /> " > <img src="images/edit.png" alt="images" /></a></td>
        <td><a href="deleteincentive?id1=<s:property value='id' /> " onclick="return confirm('Are u Sure ?')"> <img src="images/delete.png" alt="images" /></a></td>
        
    </tr>
</s:iterator>
</table>
</div>


    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>


 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>


 </body>
</html>