<%-- 
    Document   : Insertion
    Created on : Oct 7, 2016, 1:14:52 PM
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
    <style type="text/css">
            label[for="i"] {
            color: black;
            font-size: 11pt;
            padding-bottom: 10px;
            }  
            input[type="radio"]{
                width: 25px;
               
                margin-left: 10px;
            }
        </style>
        <script type="text/javascript">
            function FillBilling(f){
                if(f.billingtoo.checked == true){
                    f.perminentAddress.value=f.address.value;
                }
            }
        </script>
    <sj:head/>
    <s:head/>
    
  </head>

  <body>
  <center>
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
           <li><a href="Masters.jsp">Masters</a></li>
        <li class="activated"><a href="display">Employees <span class="sr-only">(current)</span></a></li>
        <li><a href="retrieve">Quarters</a></li>
        <li><a href="retrieve1">Gas Connections</a></li>
        <li><a href="loanslist">Loans</a></li>
       
        <li><a href="Reports.jsp">Reports</a></li>
      </ul>

     <%-- <ul class="nav navbar-nav navbar-right">
		<li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user" title="Dash Board" aria-hidden="true"></span> <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="MyProfile.html">My Profile</a></li>
            <li><a href="chPwd.html">Change Password</a></li>
            <li><a href="Settings.html">Settings</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="logout">Logout</a></li>
          </ul>
        </li>
      </ul>

      <form class="navbar-form navbar-right">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
      </form>--%>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
    </div> <!-- /row -->

 
        <center>   
<div class="container">
  <h2 class="text-center text-primary">Registration Form</h2>
    <div class="clear">&#x00A0;</div>
        <div class="clear">&#x00A0;</div>
     <s:form action="insertEmp"  enctype="multipart/form-data" method="post" >          
        
         <table>
             <td><s:textfield id="i" name="form.empId" label="Employee Id" cssClass="form-control form-group " placeholder="Enter Employee Id" autofocus="autofocus"></s:textfield></td> 
            
            <td><s:textfield id="i" name="form.empName" label="Employee Name" cssClass="form-control form-group" placeholder="Enter Employee Name"></s:textfield></td> 
            
            <td><s:textfield id="i" name="form.status" label="Status" cssClass="form-control form-group" placeholder="Status"></s:textfield></td> 

            
            <td><sj:datepicker  name="form.doj"  changeYear="true" yearRange="1960:2050" changeMonth="true" label="Date of Joining"  size="90" readonly="true" displayFormat="dd-mm-yy" cssClass="lab" placeholder="dd-mm-yyyy"/> </td>
            
            <td><s:radio id="i" list="# {'M':'Male','F':'Female'}" name="form.gender" label="Gender" cssClass="form-group" ></s:radio></td> 
            
            <td><s:select id="i" name="form.dept" list="deptList" label="Select Department" headerKey="-1" headerValue=" --Select-- " cssClass="form-control form-group"/></td>
            
            <td><sj:datepicker  name="form.dob" readonly="true" changeYear="true" changeMonth="true" label="Date of Birth"  size="90" cssClass="lab" displayFormat="dd-mm-yy" placeholder="dd-mm-yyyy"/> </td>
            
            <td><s:textfield id="i" name="form.aadharNumber" label="Aadhar No" cssClass="form-control form-group" placeholder="Enter Aadhar Number"></s:textfield></td>
            
            <td><s:radio id="i" list="# {'married':'Married','single':'Single'}" name="form.maritialStatus" label="Marital Status" cssClass="form-group" ></s:radio></td>
            
            <td><s:textarea id="i" name="address" label="Address" rows="5" cols="20" cssClass="form-control form-group" placeholder="Enter Address"/></td>
            
             <td><s:checkbox name="billingtoo" onclick="FillBilling(this.form)" fieldValue="true" label="Check if Permanent Address same as the Address"></s:checkbox></td>
            
             <td><s:textarea id="i" name="perminentAddress"  label="Permanent Address" rows="5" cols="20" cssClass="form-control form-group" placeholder="Enter Permanent Address"/></td>
            
            <td><s:textfield id="i" name="form.selfContactNumber" label="Contact No" cssClass="form-control form-group" placeholder="Enter Contact Number"/></td>
            
            <td><s:textfield id="i" name="form.emergencyContactNumber" label="Emergency Contact No" cssClass="form-control form-group" placeholder="Enter Emergency Contact Number"/></td>
            
            
            
           
            <td><s:select id="i" name="form.proofType" label="Address Proof Type" list="proofList" headerKey="-1" headerValue=" --Select-- " cssClass="form-control form-group"/></td>
            
            <td><s:textfield id="i" name="form.proofNumber" label="Proof Number" cssClass="form-control form-group" placeholder="Enter Proof Number"></s:textfield></td>
            
            <td><s:select id="i" name="form.etype"  list="emptypeList" label="Employee Type" headerKey="-1" headerValue=" --Select-- " cssClass="form-control form-group"/></td>
            
            <td><s:select  id="i" name="form.quarter" list="quarterList" label="Quarter Type" headerKey="-1" headerValue=" --Select-- " cssClass="form-control form-group"/></td>
            
            <td><s:radio id="i" name="form.otEligibility" label="OT Eligibility" list="{'Yes','No'}" cssClass="form-group"/></td>
            
            <s:date name="%{ new java.util.Date()}" var="formattedDate" format="dd-MM-yyyy" />

        <td><s:textfield id="i" name="form.recordCreationDate" value="%{formattedDate}"  readonly="true" cssClass="form-control form-group " label="Record Creation Date" > 
        </s:textfield></td>
        
            <td><s:textfield  id="i" name="form.empGrade" label="Employee Grade" cssClass="form-control form-group" placeholder="Enter Employee Grade"></s:textfield></td>
            
            <td><s:file id="i" name="form.image" label="Image" cssClass="form-control form-group " accept="image/*" ></s:file></td>
            
         </table> 
      <div class="form-group">
      <div class="col-sm-6 text-center">
      <s:submit  label="Submit"  cssClass="btn btn-default" align="center" ></s:submit>
      </div>
      <div class="col-sm-6 text-center"> 
      <s:reset  value="Cancel" cssClass="btn btn-default" align="center"></s:reset>
      </div>
      </div> 
    </s:form>
        </center>
</body>
</html>   
