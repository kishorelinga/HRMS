<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@include file="/upperlogoMaster.jsp" %>
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
 <link href="css/newcss.css" rel="stylesheet">
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
            </style>
     

       
  
  <center>
  
<div class="container">
  <h2 class="text-center text-primary">Dependents Information</h2>
  <script src="Javascripts/jquery.js"></script>
   <script type="text/javascript">
      function findselected(item) {
        alert("Are You Sure");  
      if(item === 'no'){       
       
         $( "#dvPassport1" ).hide();
         
      }
      else{
           $( "#dvPassport1" ).show();
      }
    }
  </script>   
  
  
    <div class="clear">&#x00A0;</div>
        <div class="clear">&#x00A0;</div>
        <s:form action="abcdef"  enctype="multipart/form-data" method="post" name="two" >          
     <table>  <s:iterator value="dlist">      <tr>
            <td><s:textfield id="i" size="90" readonly="true" name="depnt.id" label="ID" value="%{id}"  cssClass="form-control form-group"/></td> 
                                <td><s:textfield id="i" name="depnt.empId" label="Family Head ID" value="%{familyIdentity.employeeProfile.empId}"  readonly="true" cssClass="form-control form-group"/></td> 
                                <td><s:textfield id="i" name="depnt.name" label="Dependent Name" value="%{depName}" cssClass="form-control form-group"/></td>
                                <td><s:textfield id="i" name="depnt.age" label="Dependent Age" value="%{depAge}" cssClass="form-control form-group"/></td>
            <td><s:select name="depnt.status" label="Status" id="i" value="%{status}" list="{'yes','no'}" onChange="findselected(this.value)" cssClass="form-control form-group" headerKey="%{depStatus}" headerValue="%{depStatus}"/></td>
          </tr>       </table>           
               
             
               
            
                           
 
                
                <div id="dvPassport1" > 
                 <table>
        <tr>
            <td > <s:textfield name="depnt.depid" id="one" size="90" value="%{depId}" label="Sanctioned Amount" placeholder="Enter Sanctioned Ammount" cssClass="form-control form-group" ></s:textfield></td>
               </tr>
                </table>
                </div>
         
     </s:iterator>
    
     <br/><br/>
           <div class="form-group" >
      <div class="col-sm-6 text-center">
      <s:submit  value="Update"  cssClass="btn btn-default" align="center" ></s:submit>
      </div>
          <div class="col-sm-6 text-center"> 
          <button type="button" class="btn btn-default" ><a href="dependentsinfo" style="text-decoration:none; color:black">Cancel</a></button>
          </div>
            </div> 
    </s:form>
           </div>
  </center>
  
    </body>
</html>
