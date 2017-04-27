<%-- 
    Document   : Reportdate
    Created on : Dec 16, 2016, 12:46:51 PM
    Author     : Swathi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="upperreports.jsp" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
    <head>
       <title>..:: HRMS ::..</title>
     <sj:head/>
     <s:head/>
    </head>
    <body>
       
         <style type="text/css">
            label[for="i"] {
            font-family:  sans-serif;
            font-style: normal;
            color: black;
            font-size: 11pt;
            padding-bottom: 10px;}    
        </style>
    <div id="div2">
           <center>
               <s:form action="reportemp">
                <br/><br/>
                <table>                   
                    <tr> <td><sj:datepicker readonly="true" size="40" name="object.empdate" changeMonth="true"  changeYear="true" placeholder="dd-mm-yy" label="Enter Date to generate Employees details" displayFormat="dd-mm-yy"  cssClass="lab" /> </td></tr>
                </table>
           <br/><br/>
            <div class="form-group" >
      <div class="col-sm-6 text-center">
      <s:submit  value="Submit"  cssClass="btn btn-default" align="center" ></s:submit>
      </div>
        </s:form>   
          
            <s:reset value="Reset" cssClass="btn btn-default" align="center"/>
            
            
            </div></center>
           </div>
           
    </body>
</html>
