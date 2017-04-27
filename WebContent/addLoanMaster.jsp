<%-- 
    Document   : addLoanMaster
    Created on : Nov 18, 2016, 3:06:40 PM
    Author     : NSG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@include file="linkMasters.jsp" %>
<!DOCTYPE html>
<html>
    
  <head>
    <style type="text/css">
            label[for="i"] {
            color: black;
            font-size: 11pt;
            padding-bottom: 10px;}    
        </style>
</head><body>
<center>      
<div class="container">
  <h2 class="text-center text-primary">Loan Application Master</h2>
    <div class="clear">&#x00A0;</div>
    
    <s:form action="loanInsert" method="post">
        <table>
            <tr>
                <td><s:textfield id="i" name="lform.loanId" label="Loan Type Id" size="90" cssClass="form-control form-group "></s:textfield></td>
                
                    <td><s:textfield id="i" name="lform.loanTypeName" label="Loan Type Name"  cssClass="form-control form-group "></s:textfield></td>
           
               <%-- <td><s:select id="i" name="lform.eligibilityRuleId" list="loanEligibilityList" headerKey="-1" headerValue=" --Select-- " label="Loan Eligibility Role Id" cssClass="form-control form-group "></s:select></td>--%>
           
                <td><s:select id="i" name="lform.empGrade" list="empGradeList" headerKey="-1" headerValue=" --Select-- " label="Employee Grade" cssClass="form-control form-group "></s:select> </td>
            </tr>
            
        </table>
            <br/><br/>
    <div class="form-group">
    <div class="col-sm-6 text-center">
    <s:submit  label="Submit"  cssClass="btn btn-default" align="center" ></s:submit>
    </div>
   <div class="col-sm-6 text-center"> 
          <button type="button" class="btn btn-default" ><a href="loanDisplay" style="text-decoration:none; color:black">Cancel</a></button>
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

