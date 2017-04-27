
<%@page import="org.hibernate.Session"%>
<%@page import="com.hrms.dto.Users"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="updatedlogo.jsp" %>
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
         <link href="css/Styles.css" rel="stylesheet">

        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">
<%-- <script type="text/javascript">
   function SomeFunction(){
       
       var xz=document.getElementById('field1').value;
        alert("hello "+xz);
        if(xz==='drawing'){
           
     disableLink();
 }
else if(xz==='godown'){
  disableLink1()
   }


function disableLink()
        {

        document.getElementById('Link1').disabled=true;
        document.getElementById('Link1').removeAttribute('href');    
        document.getElementById('Link1').style.textDecoration = 'none';
        document.getElementById('Link1').style.cursor = 'default';
        }
        function disableLink1()
        {

        document.getElementById('Link2').disabled=true;
        document.getElementById('Link2').removeAttribute('href');    
        document.getElementById('Link2').style.textDecoration = 'none';
        document.getElementById('Link2').style.cursor = 'default';
        }

        function showLink()
        {
        document.getElementById('Link1').disabled=false;
        //assign href dynamically
        document.getElementById('Link1').href = "somepage.html";
        document.getElementById("Link1").style.textDecoration = "underline";
        document.getElementById("Link1").style.cursor = "hand";
        }
    }
  </script>
<body onload="javascript:SomeFunction()">
--%>
    </head>
<body>
 

      
 
<div class="container-fluid">

                <div class="panel panel-primary">
                    <!-- Default panel contents -->
                    <div class="panel-heading">Dash Board</div>
                    <div class="panel-body">

                        <div class="row"><!-- /panel-body 1st row started -->
                            <div class="col-lg-4"><!-- /panel-body 1st row col-lg-4 -->
                                <div class="panel panel-primary">
                                    <!-- Default panel contents -->
                                    <div class="panel-heading">Employee Details</div>
                                    <div class="panel-body">
                                        Total Staff: <s:property value="count" /><br />
                                    No. of Male Employees: <s:property value="malecount" /><br />
                                    No. of Female Employees: <s:property value="femcount" /> <br /><br />
                                </div>
                            </div>
                        </div><!-- /panel-body row col-lg-4 Ended -->

                        <div class="col-lg-4"><!-- /panel-body 1st row col-lg-4 -->
                            <div class="panel panel-primary">
                                <!-- Default panel contents -->
                                <div class="panel-heading">Quarters Details</div>
                                <div class="panel-body">
                                    Total Quarters: <s:property value="tqrts" /><br />
                                    No. of Families: <s:property value="famly" /><br />
                                    No. of Male Employees: <s:property value="malecount" /> <br />
                                    No. of Female Employees: <s:property value="femcount" />
                                </div>
                            </div>
                        </div><!-- /panel-body row col-lg-4 Ended -->

                        <div class="col-lg-4"><!-- /panel-body 1st row col-lg-4 -->
                            <div class="panel panel-primary">
                                <!-- Default panel contents -->
                                <div class="panel-heading">Gas Connection Details</div>
                                <div class="panel-body">
                                    Total Gas Connections: <s:property value="tgasconn" /> <br />
                                    No. of Alloted connections: <s:property value="usedg" /> <br />
                                    No. of Vacant connections: <s:property value="unusedg" /> <br /><br />
                                </div>
                            </div>
                        </div><!-- /panel-body row col-lg-4 Ended -->

                    </div><!-- /panel-body row Ended -->

                </div>

            </div>



        </div> <!-- /container -->


        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        
        <%--<s:a cssClass="navbar-brand" href="%{outLink}">Log out</s:a>
        <s:property value="description" />
<s:hidden  value="%{description}" name="test" id="field1" />
<a href="Loans.jsp" id="Link1">Godown</a><br/><br/>
<a href="Quarters.jsp" id="Link2">Drawing</a>--%>
    </body>
</html>