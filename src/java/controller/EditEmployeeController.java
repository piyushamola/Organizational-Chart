/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employee;
import model.Manager;
import service.Employeedb;
public class EditEmployeeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       int empid = Integer.parseInt(request.getParameter("empid"));
       
         ArrayList<Employee> list = Employeedb.getEmployeeNames();  
       
            Employee e=Employeedb.getEmployee(empid);
            String managername=e.getManagername();
            System.out.println(managername);
            Manager m=Employeedb.getManagerId(managername);
             request.setAttribute("list", list);
            request.setAttribute("m",m);
      request.setAttribute("emp", e);
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/edit.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        Employee e=new Employee();
       e.setEmpname(request.getParameter("empname"));
       String empname=request.getParameter("empname");
        e.setEmpdesignation(request.getParameter("empdesignation"));
        e.setEmpid(Integer.parseInt(request.getParameter("manager")));// empid which will be inserted as the manager
        int empid=Employeedb.getEmployeeId(empname);
         boolean status=Employeedb.updateEmployee(e,empid);
         if(status==true)
         {
           
       response.sendRedirect("view?empid="+empid+"");
             
         }
             
      
    }
}