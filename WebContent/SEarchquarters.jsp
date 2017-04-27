<%-- 
    Document   : SEarchquarters
    Created on : Nov 7, 2016, 10:47:02 AM
    Author     : Swathi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@include file="upperlogo.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
        <sj:head/>
    </head>
    <body>
        <style type="text/css">
            label[for="i"] {
                color: black;
                font-size: 11pt;
                padding-bottom: 10px;}    
            </style> <center>
            <s:form action="search">
                <br/><br/>
                <table>                   
                    <tr> <td><s:textfield id="i" size="90" name="object.empId" label="Enter Employee ID to add quarters" cssClass="form-control form-group"/>  </td>       
                </table>
                <br/>
                <div class="form-group">
                <div class="col-sm-6 text-center">
                    <s:submit value="Submit" cssClass="btn btn-default" align="center"></s:submit>
                    </div>
                    <div class="col-sm-6 text-center"> 
          <button type="button" class="btn btn-default" ><a href="retrieve" style="text-decoration:none; color:black">Cancel</a></button>
          </div>

                </div>

        </s:form></center>
</body>
</html>
