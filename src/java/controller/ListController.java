/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employee;
import service.Employeedb;

public class ListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
         ArrayList<Employee> list = Employeedb.getAllEmployee();
        Map<Employee, List<Employee>> map1 = new HashMap<Employee, List<Employee>>();
         for(int i=0;i<list.size();i++)
         {
         Employee e=list.get(i);
         List<Employee> listk=Employeedb.getEmployees(e.getEmpid());
         map1.put(e, listk);
          
         }
         System.out.println("This is the map"+map1);
        request.setAttribute("map", map1);
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/list.jsp");
       
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doGet(request, response);
    }
}

