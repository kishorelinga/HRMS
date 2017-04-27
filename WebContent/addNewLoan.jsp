<%-- 
    Document   : addNewLoan
    Created on : Nov 14, 2016, 11:41:28 AM
    Author     : nsg
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="upperlogoLoans.jsp" %>
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
            input[type="radio"]{
                width: 25px;
                margin-left: 10px;
            }
            input[type="checkbox"]{
                width: 25px;
                    margin-left: 10px;
            }
        </style>
 <script type="text/javascript">
                function findselected(item) {
                 alert("hello");
                 if(item === 'Cash Loan' ||item === 'Gas Loan' ||item === 'Tra Loan'){
                    if (item === 'Cash Loan') {
                        $("#dvPassport1").hide(); 
                         $("#dvPassport2").show();
                         $("#dvPassport3").hide();
                          $("#dvPassport4").hide();
                }
                  
              else if(item === 'Gas Loan'){
                     $("#dvPassport1").show();
                      $("#dvPassport2").hide();
                      $("#dvPassport3").hide();
                       $("#dvPassport4").hide();
                          
                }
                 
              else if(item === 'Tra Loan'){
                           $("#dvPassport2").hide();
                            $("#dvPassport1").hide();
                            $("#dvPassport3").show();
                              $("#dvPassport4").hide();
                }
                 }
                 else {
                      $("#dvPassport1").hide(); 
                       $("#dvPassport2").hide();
                      $("#dvPassport3").hide();
                        $("#dvPassport4").show();
                    }
                
                }
            </script>   
      
  <center>
  
<div class="container">
  <h2 class="text-center text-primary">New Loan Form</h2>
    <div class="clear">&#x00A0;</div>
        <div class="clear">&#x00A0;</div>
     <s:form action="assignLoan"  enctype="multipart/form-data" method="post" >          
    <table>
        <tr>
            <td><s:textfield id="i" name="loan.empId" label="Employee Id" placeholder="Enter Employee ID" cssClass="form-control form-group"  autofocus="autofocus"></s:textfield></td> 
          <%-- <td><s:select id="i" name="loan.loanId" label="Loan Id" list="{''}" cssClass="form-control form-group"  headerKey="-1" headerValue=" --Select Loan Id -- "/></td>
         <td><s:textfield id="i" name="loan.sanctionedAmt" label="Loan Amount" placeholder="Enter Loan Ammount" cssClass="form-control form-group"></s:textfield></td>
          --%>
              <td><s:textfield id="i" name="loan.status" size="90" label="Status" value="New" cssClass="form-control form-group" readonly="true"></s:textfield></td>
             
             <td><s:checkboxlist list="{'T.V','Refrigerator','Air Conditioner'}" name="loan.householdThings" label="House-hold Things" cssClass="form-group"/></td>
            
              <s:date name="%{ new java.util.Date()}" var="formattedDate" format="dd-MM-yyyy" />

        <td><s:textfield id="i" name="loan.loanCreationdate" value="%{formattedDate}"  readonly="true" cssClass="form-control form-group " label="Loan Creation Date" > 
        </s:textfield></td>
        
              
              <%--<td><sj:datepicker  name="loan.loanCreationdate" changeMonth="true" label="Loan Creation Date" placeholder="dd-mm-yyyy" displayFormat="dd-mm-yy" size="90" cssClass="lab"/> </td>--%>
             
             <td><s:select id="i" name="loan.loanType" onChange="findselected(this.value)" label="Loan Type" list="lolist"  cssClass="form-control form-group"  headerKey="-1" headerValue=" --Select Loan Type -- "/></td>
            
            
        </tr>
    </table>
             <div id="dvPassport1" hidden="true"> 
           <table> <tr>
                   <td><s:textfield id="i"  name="loan.gasLoan" size="90" label="Gas Amount" placeholder="Enter Requested Gas Loan Amount" cssClass="form-control form-group" ></s:textfield></td>
           </tr></table></div>
            <div id="dvPassport2" hidden="true"> 
           <table> <tr>              
                  <td><s:textfield id="i" name="loan.cashLoan" size="90" label="Cash Amount" placeholder="Enter Requested Cash Loan Amount" cssClass="form-control form-group" ></s:textfield></td>
             </tr></table></div>
            <div id="dvPassport3" hidden="true"> 
           <table> <tr>  
                  <td><s:textfield id="i" name="loan.traLoan" size="90" label="Tra Amount" placeholder="Enter Requested Tra Loan Amount" cssClass="form-control form-group" ></s:textfield></td>
              </tr></table></div>
              <div id="dvPassport4" hidden="true"> 
           <table> <tr>
                  <td><s:textfield id="i" name="loan.requestedAmt" size="90" label="Requested Amount" placeholder="Enter Requested Amount" cssClass="form-control form-group" ></s:textfield></td>
             </tr></table></div>
             <br/><br/>
           <div class="form-group" >
      <div class="col-sm-6 text-center">
      <s:submit  label="Submit"  cssClass="btn btn-default" align="center" ></s:submit>
      </div>
          <div class="col-sm-6 text-center"> 
          <button type="button" class="btn btn-default" ><a href="loanslist" style="text-decoration:none; color:black">Cancel</a></button>
          </div>
            </div> 
    </s:form>
</div>
  </center>
 
  
    </body>
</html>
