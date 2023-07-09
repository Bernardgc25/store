package com.example.demo.Util;

import java.sql.*;

public class DataConnect {
	private static Connection con;//creating reference variable of Connection
	public DataConnect(){
		try
		{
			//for mysql 5 write
			//Class.forName("com.mysql.jdbc.Driver");
			//for mysql 8 write
			Class.forName("com.mysql.cj.jdbc.Driver");
			//It is loading Driver class from jar file
			//driverManager.getConn
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","admin","admin");
		
			/*jdbc-protoocal
			 * mysql-sub protocol
			 * localhost-address of current
			 * 3306 port number
			 * junemap-database name
			 * root-username
			 * mysql-password
			 */
			System.out.println("Connection established");
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	public static Connection getconnect(){
		DataConnect c=new DataConnect();
		return con;
	}
	
	
	public static void main(String[] args) {
		getconnect();
	}
	



}