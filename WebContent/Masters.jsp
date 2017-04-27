
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="upperlogoMaster.jsp" %>
<%@taglib prefix="s" uri="/struts-tags" %>
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
    <link href="css/newcss.css" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap.css"
    <-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>


	<script src="js/login.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>  

<div class="btn-group dropup">

</div>

<div class="table-responsive">&#x00A0;</div>


<div class="table-responsive">

    <script type="text/javascript">
    function goToNewPage()
    {
        var url = document.getElementById('list').value;
        if(url != 'none') {
            window.location = url;
           
        }
    }
</script>
<style>
.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 10px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
}
.dropbtn {
  /*  background-color: gold;*/
   /* color: white;*/
    padding: 10px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: #3e8e41;
}
</style>
</style>
    </head>
    <body>
    <center>
        <h1 style="color:blue;text-align:center">Select one of the Masters</h1>
        <form name="dropdown">
           
            <select name="list" id="list" accesskey="target" class="dropdown dropbtn " >
               
    <option value='none' selected>Choose </option>
     <option value="EmpTypeDisplay">Employee Type</option>
     <option value="deptDisplay">Departments</option>
     <option value="quarterDisplay">Residential Quarters</option>   
    <option value="gasMasterdisplay">Gas Connection Master</option>
    <option value="deductions">Deduction Master</option>
       <option value="loanDisplay">Loans Application Master</option>
    
    <option value="deductionDisplay">Deduction Rules</option> 
     <option value="dependentsinfo">Dependents Information</option> 
       
        <option value="abcde">Wage Definitions</option>
         <option value="otPayoutdisplay">OT Payout Schedule</option>
         <option value="wagesDisplay">Wages</option>
          <option value="incentivesDisplay">Incentives</option>
</select>

            <input  type="button" class="button" value="Go" onclick="goToNewPage()"  >

        </form>
    
    </center>
   
</div>




    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>


 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>

  </body>
</html>

