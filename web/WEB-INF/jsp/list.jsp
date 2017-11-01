<%-- 
    Document   : list
    Created on : Oct 26, 2017, 8:31:28 PM
    Author     : Piyush
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.Employee"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>List View</title>
    </head>
    <body>
       <nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
    <div class="container">
     
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li ><a href="home">Home</a></li>
                <li ><a href="table">Table</a></li>
                <li class="active"><a href="list">List</a></li>
             
            </ul>
        </div>
    </div>
</nav>
           <div style="padding: 60px 0 30px;" class="container">  <!-- padding for bread crumb --> 
             <div>
                  <ol class="breadcrumb">
                  <li><a href="home">Home</a></li>
                  <li class="active">List View</li>
                  </ol>
             </div>
        <div class="clearfix">
            
            <h1 class="pull-left">EMPLOYEE HIERARCHY</h1>
           
        </div>
           </div>
        <div class="container">
           <%
                Map<Employee, List<Employee>> map1 =(Map)request.getAttribute("map");
for(Map.Entry<Employee,List<Employee>> e:map1.entrySet()){
    Employee key = e.getKey();
     List<Employee> emp = e.getValue();
          %>
          <ul><li><a href=""><%=key.getEmpname()%></a>
                  <% for(int i=0;i<emp.size();i++)
                  {
                      Employee em=emp.get(i);
                  %>
                  <ul><li><a href=""><%=em.getEmpname()%></a></li></ul>
                 <% }
                  %>
              </li>
             
                  
          </ul>
                   <%}%>
        </div>
    </body>
</html>
