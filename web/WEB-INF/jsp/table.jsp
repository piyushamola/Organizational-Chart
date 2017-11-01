<%-- 
    Document   : table
    Created on : Oct 26, 2017, 8:31:20 PM
    Author     : Piyush
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Table View</title>
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
                  <li class="active">Table View</li>
                  </ol>
             </div>
        <div class="clearfix">
            <div class="pull-right" style="padding-top: 15px;">
                <a href="add" class="btn btn-primary btn-lg">+ Add New</a>
            </div>
            <h1 class="pull-left">All Employees</h1>
        </div>
         
        <div>
            <table class="table table-bordered table-striped" width='100%'>
                <thead>
                    <tr>
                        <th>E.ID</th>
                        <th>Name</th>
                        <th>Designation</th>
                        <th>Manager</th>
                        <th>View</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="e">
                <tr>
                    <td>${e.empid}</td>
                    <td>${e.empname}</td>
                    <td>${e.empdesignation}</td>
                    <td>${e.managername}</td>
                    
                    <td><a href="view?empid=${e.empid}">View</a></td>
                        
                </tr>
                </c:forEach>
                           
                               
                 </tbody>
            </table>
        </div>

    </div>
    </body>
</html>
