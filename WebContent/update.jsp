<%-- 
    Document   : update
    Created on : Nov 8, 2016, 12:15:00 PM
    Author     : anusha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib  uri="/struts-tags" prefix="sj" %>
<%@include file="upperlogo.jsp" %>
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
    <sj:head/>
    <s:head/>
    </head>
    <body>
        <style type="text/css">
            label[for="i"] {
            color: black;
            font-size: 11pt;
            padding-bottom: 10px;}    
        </style>
        
        <div class="container">
  <h2 class="text-center text-primary">Update Quarters</h2>
    <div class="clear">&#x00A0;</div>
        <div class="clear">&#x00A0;</div>
        <center>
            <s:form action="update" method="post">
            <table>
                <s:iterator value="qlist1">
                    <tr>
                      <td><s:textfield id="i" name="object.id" size="90" label=" ID" value="%{id}" readonly="true" cssClass="form-control form-group"/></td>
                        <td><s:textfield id="i" name="object.empId" label="Employee ID" value="%{employeeProfile.empId}" readonly="true" cssClass="form-control form-group"/></td>
      
                        <td><s:select id="i" label="Choose ur Quarters" list="qlist3" headerValue="%{residentialQuarters.quarterCode}"  headerKey="%{residentialQuarters.quarterCode}" 
                           name="object.quartercode"  cssClass="form-control form-group" ></s:select></td>
                        <%-- <td><s:submit value="Save" cssClass="btn btn-default"></s:submit></td>--%>
                    </tr>
                </s:iterator>
            </table></center>
             <br/><br/>
        <div class="form-group" >
      <div class="col-sm-6 text-center">
      <s:submit  value="Update"  cssClass="btn btn-default" align="center" ></s:submit>
      </div>
           <div class="col-sm-6 text-center"> 
          <button type="button" class="btn btn-default" ><a href="retrieve" style="text-decoration:none; color:black">Cancel</a></button>
          </div>
            </div>
            
        </s:form>
       <%-- <div class="col-sm-6 text-center">
          <a href="Quarters.jsp"><s:submit value="cancel" cssClass="btn btn-default"/></a>
      </div>--%>
        </div> 
    </body>
</html>
