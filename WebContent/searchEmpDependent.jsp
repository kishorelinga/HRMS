<%-- 
    Document   : searchEmpDependent
    Created on : Nov 23, 2016, 1:08:15 PM
    Author     : Swathi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="/upperlogoMaster.jsp" %>
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
             <center><br/>
                 <s:form action="searchEmpdependent"><table>    <div id="div1">                 
                    <tr> <td><s:textfield id="i" size="60" name="depnt.empId" label="Enter Employee ID to add Dependents" cssClass="form-control form-group"/>  </td>       
                         <td class="activated">   <s:submit value="Click here to add dependents" cssClass="btn btn-default activated"  align="center" /></td></tr></table>
                     </div> </s:form>    </center>
             <center><br/>
            <s:form action="goback"><table>    <div id="div1">                 
                        <td>   <s:submit value="Go to Dependents Infomation Masters page " cssClass="btn btn-default"  align="center" /></td></tr></table>
            </div> </s:form>    </center>  
    </body>
</html>
