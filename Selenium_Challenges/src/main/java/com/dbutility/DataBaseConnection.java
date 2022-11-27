package com.dbutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DataBaseConnection {
	
static String query = "select * from employees";
// db parameters
private static String url       = "jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_6af8d9e8b2a3369";
private static String user      = "b11b443ae40b6a";
private static String password  = "264c8906";


	@Test
	public static void dbConnection() throws SQLException, ClassNotFoundException {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.230:1521/database_name", "user", "password");
		Connection con = DriverManager.getConnection(url, user, password);
		
		Statement smt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = smt.executeQuery(query);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		
		while (rs.next()) {
		String id = rs.getString(2);
		System.out.println(id);

		for (int i = 1; i <= columnsNumber; i++) {
	        if (i > 1) System.out.print(",  ");
	        String columnValue = rs.getString(i);
	        System.out.print(columnValue + " " + rsmd.getColumnName(i));
	    }
	    System.out.println("");
		
		}
		
		
}
}
