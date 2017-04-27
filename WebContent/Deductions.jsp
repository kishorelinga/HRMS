<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="upperlogoMaster.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>
      
    </head>
<body>
    
    <div class="container-fluid">
         <h2 class="text-center text-primary">Deduction Master</h2>
            <div class="btn-group dropup">
  <s:form action="getDedId">
      <s:submit value="Add New Deduction" cssClass="btn btn-primary activated1"/>
  </s:form>
       </div>


            <div class="table-responsive">&#x00A0;</div>


            <div class="table-responsive">
                <table class="table table-striped table-bordered text-center">

                    <tr class="info text-center">
                        <th class="text-center">S. No</th>
                        <th class="text-center">Deduction Id</th>
                        <th class="text-center">Deduction Code</th>
                        <th class="text-center">Deduction Name</th>
                        
                        <th class="text-center">Edit</th>
                        <th class="text-center">Delete</th>
                    </tr>
                    <s:iterator value="listofdeducs" status="rowstatus" var="myobj" >
                        <tr>
                            <td><s:property value="#rowstatus.count" /></td>
                            <td><s:property value="deductionId" ></s:property></td>
                            <td><s:property value="deductionCode"></s:property></td>
                            <td><s:property value="deductionName"></s:property></td>  

                     <%--  <td><a href="viewEmp.jsp" data-toggle="tooltip" data-placement="bottom" title="View"><img src="images/view.png" alt="images" /></a></td> --%>
                            <td><a href="editdeduction.action?id=<s:property value="id" /> " > <img src="images/edit.png" alt="images" /></a></td>
                            <td><a href="deletededuc?id=<s:property value="id" /> " onclick="return confirm('Are u Sure ?')"> <img src="images/delete.png" alt="images" /></a></td>
                        </tr>
                    </s:iterator>
                </table>
            </div>
    </div>
                    </body>
                    </html>