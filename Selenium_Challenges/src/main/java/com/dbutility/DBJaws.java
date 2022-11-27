package com.dbutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DBJaws {
	
	static String query = "select * from products";
	// db parameters
	private static String url       = "jdbc:mysql://y6aj3qju8efqj0w1.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/uu0ybqc2z9vrwtnb";
	private static String user      = "u25ra7dpvcb4t4mn";
	private static String password  = "p1cdgp12fi5d9cwv";


		@Test
		public static void dbConnection() throws SQLException, ClassNotFoundException {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.230:1521/database_name", "user", "password");
			Connection con = DriverManager.getConnection(url, user, password);
			
			Statement smt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = smt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			
			while (rs.next()) {
			String item = rs.getString(2);
			System.out.println(item);

			for (int i = 1; i <= columnsNumber; i++) {
		        if (i > 1) System.out.print(",  ");
		        String columnValue = rs.getString(i);
		        System.out.print(columnValue);
		    }
		    //System.out.println("");
			
			}
			
			
	}

}
