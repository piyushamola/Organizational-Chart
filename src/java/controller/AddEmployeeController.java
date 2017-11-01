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
import service.Employeedb;

public class AddEmployeeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
          ArrayList<Employee> list = Employeedb.getEmployeeNames();  
        request.setAttribute("list", list);
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/add.jsp");
           
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
      Employee e=new Employee();
       e.setEmpname(request.getParameter("empname"));
        e.setEmpdesignation(request.getParameter("empdesignation"));
        e.setEmpid(Integer.parseInt(request.getParameter("manager")));// empid which will be inserted as the manager
        boolean status=Employeedb.insertEmployee(e);
             if(status){
       response.sendRedirect("table");
      
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/add.jsp");
        rd.forward(request, response); 
        }
      
        
       
        
        
    }
}

