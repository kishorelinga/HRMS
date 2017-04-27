


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
            label[for="i"]{
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



    <center>

        <div class="container">
            <h2 class="text-center text-primary">Loan Details</h2>
            <script src="Javascripts/jquery.js"></script>
            <script type="text/javascript">
                function findselected(item) {
                 
                    if (item === 'Rejected' || item === 'Closed') {
                        if(item==='Rejected')
                        {
                        alert("Are you sure to Reject");
                        $("#dvPassport1").hide();
                    }
                    else{
                        alert("Are you sure to Close"); 
                         $("#dvPassport1").hide();
                    }
 
                }
                    else {
                        $("#dvPassport1").show();
                    }
                
                }
            </script>   


            <div class="clear">&#x00A0;</div>
            <div class="clear">&#x00A0;</div>
            <s:form action="updateLoan"  enctype="multipart/form-data" method="post" name="two" >          

                <s:iterator value="listofloans" status="rowstatus"  var="myobj" >
                    <table>
                        <tr>
                            <td><s:textfield name="loan.empId" id="i" size="90" value="%{employeeProfile.empId}" label="Employee Id" placeholder="Enter Employee ID" cssClass="form-control form-group"  autofocus="autofocus"></s:textfield></td> 
                            <td><s:textfield name="loan.loanType" id="i" value="%{loanType}" label="Loan Type" list="lolist"  cssClass="form-control form-group" readonly="true" /></td>
                            
                            <td> <s:if test="#myobj.loanType == 'Cash Loan'">
                                      <s:textfield name="loan.cashLoan" id="i" value="%{cashLoan}" label="Cash Loan" placeholder="Enter Request Cash Ammount" cssClass="form-control form-group" ></s:textfield>
                                    </s:if>
                                 <s:elseif test="#myobj.loanType == 'Gas Loan'">
                                      <s:textfield name="loan.gasLoan" id="i" value="%{gasLoan}" label="Gas Loan" placeholder="Enter Request Gas Ammount" cssClass="form-control form-group" ></s:textfield>
                                    </s:elseif>
                                <s:elseif test="#myobj.loanType == 'Tra Loan'">
                                      <s:textfield name="loan.traLoan" id="i" value="%{traLoan}" label="Tra Loan" placeholder="Enter Request Tra Ammount" cssClass="form-control form-group" ></s:textfield>
                                    </s:elseif>
                                 <s:else>
                                      <s:textfield name="loan.requestedAmt" id="i" value="%{requestedAmt}" label="Requested Amount" placeholder="Enter Request Ammount" cssClass="form-control form-group" ></s:textfield>
                                 </s:else>
                            </td>
                            
                                    
                           <td><s:select name="loan.status" label="Status" id="i" value="%{status}" list="{'Closed','Rejected','Approved'}" onChange="findselected(this.value)" cssClass="form-control form-group" headerKey="-1" headerValue="%{status}"/></td>


                            <td><s:checkboxlist list="{'T.V','Refrigerator','Air Conditioner'}" id="i" value="%{sample}" name="loan.householdThings" label="House-hold Things" cssClass="form-group"/></td>



                            <td><s:date format="dd-MM-yyyy" name="%{loanCreationDate}" var="date" /><s:textfield value="%{date}" id="i" label="Loan Creation Date" readonly="true" cssClass="form-control form-group" ></s:textfield></td>
                            </tr>
                        </table>

                        <div id="dvPassport1" > 
                            <table>
                                <tr>
                                    <td> <s:textfield name="loan.sanctionedAmt" id="i" size="90" value="%{sanctionedAmt}" label="Sanctioned Amount" placeholder="Enter Sanctioned Ammount" cssClass="form-control form-group" ></s:textfield></td>
                                <td><sj:datepicker readonly="true" changeYear="true"  name="loan.loanApprovaldate" value="%{loanApprovalDate}" placeholder="dd-mm-yy" changeMonth="true" displayFormat="dd-mm-yy" label="Loan Aproval Date" cssClass="lab"/> </td>
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
          <button type="button" class="btn btn-default" ><a href="loanslist" style="text-decoration:none; color:black">Cancel</a></button>
          </div>
      </div> 
            </s:form>
        </div>
    </center>

</body>
</html>
