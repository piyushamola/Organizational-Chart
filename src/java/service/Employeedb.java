/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Employee;
import model.Manager;
/**
 *
 * @author Piyush
 */
public class Employeedb {
     public static ArrayList<Employee> getAllEmployee(){
        ArrayList<Employee> list = new ArrayList<>();
        try{   
            Connection conn = DBConnection.getConnection();
            PreparedStatement st = conn.prepareStatement("select employee.empid, employee.empname, employee.empdesignation, manager.managername from employee LEFT JOIN manager on employee.manager_id=manager.manager_id");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Employee e = new Employee();
              
                e.setEmpid(rs.getInt("empid"));
                e.setEmpname(rs.getString("empname"));
                e.setEmpdesignation(rs.getString("empdesignation"));
                e.setManagername(rs.getString("managername"));
             
               
                list.add(e);
            }
            rs.close();
            conn.close();
        }
        catch(Exception ex){            
        }    
        return list;
    }
    public static ArrayList<Employee> getEmployeeNames()
    {
        ArrayList<Employee> list=new ArrayList<>();
        try
        {
            Connection con=DBConnection.getConnection();
            PreparedStatement st=con.prepareStatement("select empname, empid from employee");
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
                Employee e=new Employee();
                e.setEmpname(rs.getString("empname"));
                e.setEmpid(rs.getInt("empid"));
                list.add(e);
            }
            rs.close();
            con.close();
        }
        catch(Exception ex)
        {
            
        }
        return list;
    }
    public static boolean insertEmployee(Employee e)
    {    int manager_id=e.getEmpid();
        
    
        boolean status=false;
        String empname="";
      try
        {
            Connection con=DBConnection.getConnection();
            PreparedStatement sk=con.prepareStatement("select empname from employee where empid=?");
            sk.setInt(1, manager_id);
            ResultSet rs=sk.executeQuery();
           if(rs.next())
           {
             empname=rs.getString("empname");
           }
            rs.close();
       
            PreparedStatement st=con.prepareStatement("insert into employee(empname,empdesignation,manager_id) values(?,?,?)");
            st.setString(1,e.getEmpname());
            st.setString(2,e.getEmpdesignation());
            st.setInt(3,manager_id);
            if(!isPresent(manager_id))
            {
            PreparedStatement ps=con.prepareStatement("insert into manager(manager_id,managername) values(?,?)");
           ps.setInt(1, manager_id);
            ps.setString(2,empname);
             ps.executeUpdate();
            }
            st.executeUpdate();
           
          
            con.close();
            status=true;
        }
        catch(Exception ex)
        {
           System.out.println(ex); 
        }
      return status;
    }
         public static boolean isPresent(int id)
       {
           boolean flag=false;
           try
           {
               Connection con=DBConnection.getConnection();
               PreparedStatement st=con.prepareStatement("select managername from manager where manager_id=?");
               st.setInt(1, id);
               ResultSet rs=st.executeQuery();
               if(rs.next())
               {
                   flag=true;
               }
           }
           catch(Exception ex)
           {
               System.out.println(ex);
           }
           return flag;
       }
         public static Employee getEmployee(int empid)
         {
             Employee e=new Employee();
             try
             {
                 Connection con=DBConnection.getConnection();
                 PreparedStatement st=con.prepareStatement("select empname, empdesignation,manager_id from employee where empid=?");
                 st.setInt(1, empid);
                 ResultSet rs=st.executeQuery();
                 if(rs.next())
                 {
                    e.setEmpid(empid);
                     e.setEmpdesignation(rs.getString("empdesignation"));
                     e.setEmpname(rs.getString("empname"));
                     int manager_id=rs.getInt("manager_id");
                     PreparedStatement ps=con.prepareStatement("select managername from manager where manager_id=?");
                     ps.setInt(1,manager_id);
                     ResultSet ks=ps.executeQuery();
                     if(ks.next())
                     {
                         e.setManagername(ks.getString("managername"));
                     }
                     ps.close();
                     ks.close();
                     
                 }
                 rs.close();
                 st.close();
                 con.close();
             }
             catch(Exception ex)
             {
                 
             }
             return e;
         }
         public static String getEmployeeName(int empid)
         {
             
         String empname="";
             try
             {
                 Connection con=DBConnection.getConnection();
                 PreparedStatement ps=con.prepareStatement("select empname from employee where empid=?");
                 ps.setInt(1, empid);
                 ResultSet rs=ps.executeQuery();
                 if(rs.next())
                 {
                 empname=rs.getString("empname");   
                 }
             
         }
             catch(Exception ex)
             {
                 
             }
             return empname;
}
         public static Manager getManagerId(String managername)
         {
Manager m=null;
             try
             {
                 Connection con=DBConnection.getConnection();
                 PreparedStatement ps=con.prepareStatement("select manager_id from manager where managername=?");
                 ps.setString(1,managername);
                 ResultSet rs=ps.executeQuery();
                 if(rs.next())
                 {
                    m=new Manager();
                    m.setManagername(managername);
                m.setManagerid(rs.getInt("manager_id"));
                 }
                 
                         
             }
             catch(Exception ex)
             {
                 
             }
             return m;
         }
         public static boolean updateEmployee(Employee e,int empid)
         {
         int manager_id=e.getEmpid();
        
    
        boolean status=false;
        String empname="";
      try
        {
            Connection con=DBConnection.getConnection();
            PreparedStatement sk=con.prepareStatement("select empname from employee where empid=?");
            sk.setInt(1, manager_id);
            ResultSet rs=sk.executeQuery();
           if(rs.next())
           {
             empname=rs.getString("empname");
           }
            rs.close();
       
            PreparedStatement st=con.prepareStatement("update employee set empname=?, empdesignation=?, manager_id=? where empid=?");
            st.setString(1,e.getEmpname());
            st.setString(2,e.getEmpdesignation());
            st.setInt(3,manager_id);
            st.setInt(4,empid);
            if(!isPresent(manager_id))
            {
            PreparedStatement ps=con.prepareStatement("insert into manager(manager_id,managername) values(?,?)");
           ps.setInt(1, manager_id);
            ps.setString(2,empname);
             ps.executeUpdate();
            }
            st.executeUpdate();
           
          
            con.close();
            status=true;
        }
        catch(Exception ex)
        {
           System.out.println(ex); 
        }
      return status;
         }
         public static int getEmployeeId(String empname)
         {
             int id=0;
             try
             {
                 Connection con=DBConnection.getConnection();
                 PreparedStatement ps=con.prepareStatement("select empid from employee where empname=?");
                 ps.setString(1,empname);
                 ResultSet rs=ps.executeQuery();
                 if(rs.next())
                 {
                    id=rs.getInt("empid"); 
                 }
                         
             }catch(Exception ex)
             {
                 
             }
             return id;
         }
          public static ArrayList<Employee> getEmployees(int manager_id)
          {
                  ArrayList<Employee> list=new ArrayList<>();
        try
        {
            Connection con=DBConnection.getConnection();
            PreparedStatement st=con.prepareStatement("select empname,empdesignation from employee where manager_id=?");
            st.setInt(1,manager_id);
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
                Employee e=new Employee();
                e.setEmpid(rs.getInt("empid"));
                e.setEmpname(rs.getString("empname"));
                e.setEmpdesignation(rs.getString("empdesignation"));
                list.add(e);
            }
            rs.close();
            con.close();
        }
        catch(Exception ex)
        {
            
        }
        return list;
          }
}