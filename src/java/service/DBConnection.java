/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Piyush
 */
public class DBConnection {
   private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/organizationalchart";
    private static final String DBUSER = "";
    private static final String DBPASSWORD = "";
	
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
    
}