<%-- 
    Document   : add
    Created on : Oct 27, 2017, 1:44:50 PM
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
        <title>Add Employee</title>
    </head>
    <body>
      <nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
    <div class="container">
     
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li ><a href="home">Home</a></li>
                <li ><a href="table">Table</a></li>
                <li ><a href="list">List</a></li>
             
            </ul>
        </div>
    </div>
</nav>
         <div style="padding: 60px 0 30px;" class="container">  <!-- padding for bread crumb --> 
             <div>
                  <ol class="breadcrumb">
                  <li><a href="home">Home</a></li>
                   <li><a href="table">Employees</a></li>
                  <li class="active">Add New</li>
                  </ol>
             </div>
        <div class="clearfix">
            
            <h1 class="pull-left">Add New Employee</h1>
        </div>
         </div>
        <hr>
        <div class="container">
            <form method="post">
  <div class="form-group">
    <label for="name">Name</label>
    <input type="text" class="form-control"  name="empname" required="required" placeholder="Enter Full Name..">
 
  </div>
  <div class="form-group">
    <label for="designation">Designation</label>
    <input type="text" class="form-control" name="empdesignation" required="required" placeholder="Designation">
  </div>
  <div class="form-group">
    <label for="manager">Manager</label>
    <select class="form-control" name="manager">
      <option>-- Select Reporting Manager --</option>
      <c:forEach items="${list}" var="e">
          <option value="${e.empid}">${e.empname}</option>
                </c:forEach>
    </select>
  </div>              
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
        </div>
        <hr>
    </body>
</html>
