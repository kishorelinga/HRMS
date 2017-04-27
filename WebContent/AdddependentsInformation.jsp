<%-- 
    Document   : AdddependentsInformation
    Created on : Nov 22, 2016, 10:42:36 AM
    Author     : Swathi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="/upperlogoMaster.jsp" %>
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
    <body><s:head/> 
       <style type="text/css">
            label[for="i"] {
            color: black;
            font-size: 11pt;
            padding-bottom: 10px;}    
        </style> 
        <script src="Javascripts/jquery.js"></script>
   <script type="text/javascript">
      function findselected(item) {
        
      if(item === 'no'){       
        alert("Are You Sure that the dependent is not working"); 
         $("#listdb").hide();
         
      }
      else{
           alert("Are You Sure that the dependent is  working, Enter employee id"); 
           $("#listdb").show();
      }
    }
  </script>   
  
    <center>  <div id="div2"> <div class="container"> 
  <h2 class="text-center text-primary">Add dependent</h2>
    <div class="clear">&#x00A0;</div>
        <div class="clear">&#x00A0;</div>
        <table> 
       
            <s:form action="insertdepnt" method="post" name="two">
            <tr>
                
         <td>     <s:textfield id="i" name="depnt.empId"  size="90" readonly="true" label="Family Head Id"  cssClass="form-control form-group"/></td>
         <td>     <s:textfield id="i" name="depnt.name"  label="Dependent Name"  cssClass="form-control form-group"></s:textfield></td>
         <td>     <s:textfield id="i" name="depnt.age"  label="Dependent Age"  cssClass="form-control form-group"></s:textfield> </td>
        
             
        <td><s:select name="depnt.status" label="status" id="i"  list="{'yes','no'}" onChange="findselected(this.value)" cssClass="form-control form-group" headerKey="-1" headerValue="choose status"/></td>
     
            </table>   <div id="listdb" > 
                 <table>
        <tr>
            <td > <s:textfield name="depnt.depid" id="one" size="90" label="Dependent Employee ID" placeholder="Enter Dependent Employee Id" cssClass="form-control form-group" ></s:textfield></td>
               </tr>
                </table>
                </div>
            
               
               
               
         
         
               <div class="form-group">
         <div class="col-sm-6 text-center">
        <s:submit value="Submit" cssClass="btn btn-default" align="center"></s:submit>
      </div>  
        <div class="col-sm-6 text-center"> 
          <button type="button" class="btn btn-default" ><a href="dependentsinfo" style="text-decoration:none; color:black">Cancel</a></button>
          </div>
               </div>
            
      </s:form>
    </center>
    
   
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
      
    <script type="text/javascript">
            
            
    $(function () {
        $("#chkPassport2").click(function () {
            if ($(this).is(":checked")) {
                $("#dvPassport1").show();
            } else {
                $("#dvPassport1").hide();
            }
           
        });
    });
    
    

</script>
</body>
</html>
