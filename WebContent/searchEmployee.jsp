<%-- 
    Document   : searchEmployee
    Created on : Nov 9, 2016, 3:42:35 PM
    Author     : Swathi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="upperlogogas.jsp" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <s:head/>
    </head>
    <body>
        <style type="text/css">
            label[for="i"] {
            color: black;
            font-size: 11pt;
            padding-bottom: 10px;}    
        </style>
    
           <center>
            <s:form action="searchemp">
                <br/><br/>
                <table>                   
                    <tr> <td><s:textfield id="i" size="90" name="object.empId" label="Enter Employee ID to add Gas Connection" cssClass="form-control form-group"/>  </td>       
                        </table>
           <br/><br/>
            <div class="form-group" >
      <div class="col-sm-6 text-center">
      <s:submit  value="Submit"  cssClass="btn btn-default" align="center" ></s:submit>
      </div>
           <div class="col-sm-6 text-center"> 
          <button type="button" class="btn btn-default" ><a href="retrieve1" style="text-decoration:none; color:black">Cancel</a></button>
          </div>
            </div>
            
            </s:form></center>
    </body>
</html>
