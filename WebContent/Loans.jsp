<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="logoLoans.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>
     
    </head>
<body>
    <div class="container-fluid">
            <s:form action="addNewLoan">
      <s:submit value="Assign New Loan" cssClass="btn btn-primary activated1"/>
  </s:form>


            <div class="table-responsive">&#x00A0;</div>


            <div class="table-responsive">
                <table class="table table-striped table-bordered text-center">

                    <tr class="info text-center">
                        <th class="text-center">S. No</th>
                        <th class="text-center">Employee ID</th>
                         <th class="text-center">Loan Type</th>
                        <th class="text-center">Sanctioned Amount <i class="fa fa-inr"></i></th>
                        <th class="text-center">Status</th>
                        <th class="text-center">View</th>
                        <th class="text-center">Edit</th>
                        <th class="text-center">Delete</th>
                    </tr>
                    <s:iterator value="listofloans" status="rowstatus" var="myobj" >
                        <tr>
                            <td><s:property value="#rowstatus.count" /></td>
                            <td><s:property value="employeeProfile.empId" ></s:property></td>
                             <td><s:property value="loanType" ></s:property></td>
                            <td><s:property value="sanctionedAmt"></s:property></td>
                                <td><a href="#" data-toggle="tooltip" data-placement="bottom" title="Status Image">
                                    <s:if test="#myobj.status == 'New'">
                                        <img src="images/statusY.png" alt="images" />
                                    </s:if>
                                    <s:elseif test="#myobj.status == 'Closed'">
                                        <img src="images/statusB.png" alt="images" />
                                    </s:elseif>
                                    <s:elseif test="#myobj.status == 'Approved'">
                                        <img src="images/statusG.png" alt="images" />
                                    </s:elseif>
                                    <s:elseif test="#myobj.status == 'Rejected'">
                                        <img src="images/statusR.png" alt="images" />
                                    </s:elseif>
                                </a>
                            </td>

                           <td><a href="loanView?id8=<s:property value="id" /> "  data-toggle="tooltip" target="_blank" data-placement="bottom" title="view"> <img src="images/view.png" alt="images" /></a></td>
                            <td><a href="editloan.action?id1=<s:property value="id" /> " > <img src="images/edit.png" alt="images" /></a></td>
                            <td><a href="deleteloan?id1=<s:property value="id" /> " onclick="return confirm('Are u Sure ?')"> <img src="images/delete.png" alt="images" /></a></td>
                        </tr>
                    </s:iterator>
                  
                </table>
            </div>
    </div>
    
                    </body>
                    </html>