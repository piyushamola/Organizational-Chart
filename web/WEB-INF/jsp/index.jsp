<%-- 
    Document   : index
    Created on : Oct 26, 2017, 7:16:50 PM
    Author     : Piyush
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
           <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
    <div class="container">
     
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="home">Home</a></li>
                <li ><a href="table">Table</a></li>
                <li ><a href="list">List</a></li>
             
            </ul>
        </div>
    </div>
    
</nav>
       

    <div style="padding: 80px 0 40px;" class="container">
        <h1 align="center" style="padding-bottom: 50px">ORGANIZATIONAL CHART</h1>        
        <hr>
   
        <div class="row mt40">
            <div class="col-md-2 col-md-offset-3">
                <a href="table" class="btn btn-block btn-lg btn-primary" style="line-height: 2.5em;">Table View</a>
            </div>
            <div class="col-md-2 col-md-offset-2">
                <a href="list" class="btn btn-block btn-lg btn-primary" style="line-height: 2.5em;">List View</a>
            </div>
           
        </div>
    </div>
  
        <hr>
    </body>
</html>
