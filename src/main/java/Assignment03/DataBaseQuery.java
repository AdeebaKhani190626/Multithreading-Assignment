package Assignment03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataBaseQuery {

	public void Connection()
	{
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("\nDriver Loaded Successfully!");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","tiger1234"); 
		System.out.println("Connection Established!");
	}catch(Exception e)
	{
		System.out.println(e);
	}
	}
}
