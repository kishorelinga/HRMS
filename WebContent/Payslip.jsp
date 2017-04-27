<%-- 
    Document   : Payslip
    Created on : Dec 14, 2016, 10:51:42 AM
    Author     : Swathi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
         <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="images/favicon.ico">
    <link href="css/newcss.css" rel="stylesheet">
    <title>..:: HRMS ::..</title>

    <!-- Bootstrap core CSS -->
     <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
     <!-- Custom styles for this template -->
     <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>
    <s:head/>
   
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
        <script>
          function myFunction(divName) {
               var printContents = document.getElementById(divName).innerHTML;
     var originalContents = document.body.innerHTML;

     document.body.innerHTML = printContents;

          window.print();
           document.body.innerHTML = originalContents;
           }
        </script>
        
    </head>
    <body>
        <div id="printablearea"> 
            <center> <h1 style="color: green">Pay Slip for the month of <s:iterator value="month"><s:property/></s:iterator> <s:iterator value="year"><s:property/></s:iterator>  </h1>
     </center>
  
<!--    <table>
        <tr>
        <th style="color: #000" style="font-size: larger;">Employee ID:</th>
        </tr>
        <tr>
        <th style="color: #000" style="font-size: larger;">Employee Name:</th>
        </tr>
        
        
    </table>-->
    
    
   
        <TABLE  width='75%'  style="background-color: #FFF"> 
           
              
              <h2 style="color: green;">Employee Details</h2>
               
                <tr style="color: #000">
			  <div align="center" style="border:1px solid black">
                          </tr>
                          <tr>         <tr><td></td> </tr>  
                          <s:iterator value="elist">    
                    <TH  style="font-size: larger;" align="left"> Employee ID </TH><th>:</th><th></th>   <td style="font-size: larger"><s:property value="empId"/> </td>
                  
                    <TH   style="font-size: larger; align-content: center" > Employee Name </TH> <th>:</th><th></th> <th></th>   <td style="font-size: larger"><s:property value="empName"/> </td>
                          </tr>
                          </div>
                
                <tr><td></td></tr>
                <tr><td></td></tr>
               
                
                <TR style="color: #000">
			<tr><td></td></tr>	
                    <TH   style="font-size: larger;"  align="left"> Department </TH> <th>:</th><th></th>   <td style="font-size: larger"><s:property value="departments.deptName"/> </td>
              </s:iterator>       <TH   style="font-size: larger; align-content: center">No. of Working Days </TH><th>:</th> <th></th><th></th>   <s:iterator value="incentivelist">  <td style="font-size: larger"><s:property value="days"/> </td></s:iterator>
                </tr>
                
               <tr><td></td></tr>
               <tr><td></td></tr>
               
               
                <TR style="color: #000">
			<tr><td></td></tr>	                   
        <s:iterator value="deductionList">     <TH   style="font-size: larger;" align="left">P.F Number </TH><th>:</th><th></th>   <td style="font-size: larger"><s:property value="pfNo"/> </td></s:iterator>
                </tr>
               
     
             
        </table>
&nbsp;&nbsp;
     <TABLE  width='75%'  style="background-color: #FFF"> 
            <s:iterator value="elist">
              
              <h2 style="color: green;">Current Monthly Earnings</h2>
               
                <tr style="color: #000">
			  <div align="center" style="border:1px solid black;">
                              
                              <tr><td></td> </tr> 
                           
                          </div>
               
                <tr>
                    <th></th>
                    <th></th> <th><h2 style="color: green; text-decoration: underline">Amount(Rs.)</h2>  </th> <th></th>
                   <th></th> <TH><h2  style="color: green; align-content: 30em; text-decoration: underline " >Deductions</h2></TH>  <th></th>
             <th></th>  <th><h2 style="color: green; text-decoration: underline">Amount(Rs.)</h2>  </th>
                </tr>
               
                    
                <TH  style="font-size: larger;" align="left"> Basic Salary </TH><th>:</th> <s:iterator value="incentivelist">   <td style="font-size: larger;" align="center"><s:property value="wage"/> </td></s:iterator> <th></th> <th></th>
                  
                    <TH   style="font-size: larger; align-content: center" > Provident Fund </TH><th></th><th>:</th> <s:iterator value="deductionList">  <td style="font-size: larger" align="center"><s:property value="pf"/> </td> </s:iterator> <th></th> <th></th>
                          </div>
                </tr>
                
                <tr><td></td></tr>
                <tr><td></td></tr>
               
                <tr><td></td></tr>
                <tr><td></td></tr>
                <TR style="color: #000">
			<tr><td></td></tr>
                      
                    <TH   style="font-size: larger;"  align="left">Incentive Amount </TH><th>:</th>  <s:iterator value="incentivelist"> <td style="font-size: larger" align="center"><s:property value="incAmount"/> </td></s:iterator> <th></th> <th></th>
     <TH   style="font-size: larger; align-content: center">Misc </TH><th></th><th>:</th>  <s:iterator value="deductionList1">  <td style="font-size: larger" align="center"><s:property /> </td> </s:iterator> <th></th> <th></th>
                </tr>
                
               <tr><td></td></tr>
               <tr><td></td></tr>
               <tr><td></td></tr>
               <tr><td></td></tr>
               <tr><td></td></tr>
               <tr><td></td></tr>
              
                <TR style="color: #000">
			<tr><td></td></tr>	
                        <TH   style="font-size: larger;"  align="left"> Gross Salary </TH><th>:</th>   <s:iterator value="incentivelist"> <th style="font-size: larger" align="center"><s:property value="grossSalary"/> </th> </s:iterator><th></th> <th></th>
    <TH   style="font-size: larger; align-content: center">Total Deductions </TH><th></th><th>:</th>   <s:iterator value="deductionList"> <th style="font-size: larger" align="center"><s:property value="totalDeductions"/> </th> </s:iterator><th></th> <th></th>
                </tr>
                <tr><td></td></tr>
               <tr><td></td></tr>
               <tr><td></td></tr>
               <tr><td></td></tr>
               <tr><td></td></tr>
               <tr><td></td></tr>
               
               <TR style="color: #000">
                 <TH   style="font-size: larger;"  align="left"> Net Salary per month </TH><th>:</th>   <s:iterator value="incentivelist"> <th style="font-size: larger" align="center"><s:property value="netSalary"/> </th> </s:iterator>   
               </TR> 
      </s:iterator>
                <tr><td></td></tr>
               <tr><td></td></tr>
               <tr><td></td></tr>
               <tr><td></td></tr>
               <tr><td></td></tr>
               <tr><td></td></tr>
               <tr><td></td></tr> </table>
</div>   
<center>      <button onclick="myFunction('printablearea')" class="bfsbutton">Print Pay slip</button> </center>
       
        
    </body>
</html>

