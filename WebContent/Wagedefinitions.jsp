<%-- 
    Document   : Wagedefinitions
    Created on : Nov 21, 2016, 2:41:05 PM
    Author     : Swathi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="upperlogoMaster.jsp" %>
<%@taglib prefix="s" uri="/struts-tags" %>
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
       
    <center>  <h1 class="text-center text-primary">Wage definitions Masters</h1></center>
 
 <div class="btn-group dropup">
  <s:form action="wage_def">
      <s:submit value="Add wage definitions" cssClass="btn btn-primary activated1"/>
  </s:form>
       </div>  
 <div class="table-responsive">&#x00A0;</div>
<div class="table-responsive">
 
        <table class="table table-striped table-bordered">
          <tr class="info">
            <th>S. No</th>
            <th>Employee type</th>
            <th>wage calculation</th>
            <th>Edit</th>
            <th>Delete</th>
            </tr> 
          
            <s:iterator value="emplist" status="rowstatus">         
            <tr><td><s:property value="#rowstatus.count"/></td>    
                   <td>  <s:property value="empType"/></td>
                <td>  <s:property value="wageCalculation"/></td>
                     
           <td><s:url id="edit1" action="editwagedef1"><s:param name="wageId" value="wageId"></s:param></s:url>
                <s:a href="%{edit1}"><img src="images/edit.png" alt="images" /></s:a></td>
         
           <td><a href="deletewage.action?wageId=<s:property value="wageId"/>"  onclick="return confirm('Are u Sure ?')"><img src="images/delete.png" alt="images" /></a></td>
           
            </tr>
        </s:iterator>
           
        </table>
   




</div>
  


   


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>


 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>

        </div>
  </body>
</html>
