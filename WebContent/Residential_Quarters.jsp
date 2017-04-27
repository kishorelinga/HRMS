<%-- 
    Document   : Quarters
    Created on : Nov 5, 2016, 10:54:25 AM
    Author     : Swathi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file="upperlogoMaster.jsp" %>
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
       <div class="container-fluid">
            <h2 class="text-center text-primary">Residential Quarters</h2>
  <div class="btn-group dropup">
  <s:form action="quarterEnroll">
      <s:submit value="Add Residential Quarters" cssClass="btn btn-primary activated1"/>
  </s:form>
</div>

<div class="table-responsive">&#x00A0;</div>


<div class="table-responsive">
<table class="table table-striped table-bordered">

<tr class="info">
<th>S.No</th>
<th>Quarter Id</th>
<th>Quarter Type</th>
<th>Quarter Code</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<s:iterator value="qlist" status="rowstatus">
<tr>
    <td><s:property value="#rowstatus.count" /></td>
 <td> <s:property value="quarterId" ></s:property></td>
 <td> <s:property value="quarterType"></s:property></td>
 <td> <s:property value="quarterCode"></s:property></td>
<td><a href="quarterEdit?id1=<s:property value='quarterId' /> " data-toggle="tooltip" data-placement="bottom" title="Edit"> <img src="images/edit.png" alt="images" /></a></td>
<td><a href="quarterDelete?id1=<s:property value='quarterId' /> " data-toggle="tooltip" data-placement="bottom" title="Delete" onclick="return confirm('Are u Sure want to delete ?')"> <img src="images/delete.png" alt="images" /></a></td>
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
