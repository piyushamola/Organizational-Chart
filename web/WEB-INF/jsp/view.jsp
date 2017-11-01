<%-- 
    Document   : view
    Created on : Oct 28, 2017, 4:02:56 PM
    Author     : Piyush
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Employee</title>
    </head>
    <body>
<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
    <div class="container">
     
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li ><a href="home">Home</a></li>
                <li class="active"><a href="table">Table</a></li>
                <li ><a href="list">List</a></li>
             
            </ul>
        </div>
    </div>
</nav>
         <div style="padding: 60px 0 30px;" class="container">  <!-- padding for bread crumb --> 
             <div>
                  <ol class="breadcrumb">
                  <li><a href="home">Home</a></li>
                  <li><a href="table">Employees</a>
                  <li class="active">${emp.empname}</li>
                  </ol>
             </div>
        <div class="clearfix">
            
            <h1 class="pull-left">${emp.empname} <small>[Employee]</small></h1>
        </div>
         </div>
        <div class="container">
         <ul class="nav nav-tabs">
            <li role="presentation" class="active"><a href="">Show</a></li>
            <li role="presentation"><a href="edit?empid=${emp.empid}">Edit</a></li>
        </ul>
        </div>
        
            <div class="row mt40" style="padding: 50px 30px 20px;">
                <div class="col-md-2 text-right">Name</div>
                <div class="col-md-10"><strong>${emp.empname}</strong></div>
            </div>
            <div class="row mt40" style="padding: 50px 30px 20px;">
                <div class="col-md-2 text-right">Designation</div>
                <div class="col-md-10"><strong>${emp.empdesignation}</strong></div>
            </div>
            <div class="row mt40" style="padding: 50px 30px 20px;">
                <div class="col-md-2 text-right">Manager</div>
                                <div class="col-md-10"><strong>${emp.managername}</strong></div>
                            </div>
    </body>
</html>
