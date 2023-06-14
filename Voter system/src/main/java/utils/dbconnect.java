package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnect {
	
	public static Connection cn;
	
	public static Connection openconnection() throws SQLException {
		
		String dbURl="jdbc:mysql://localhost:3306/advjava?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
		cn=DriverManager.getConnection(dbURl, "root", "admin@123");
		System.out.println("Db connection successfull");
		return cn;
	}
	
	public static void closeconnection() throws SQLException {
		
		if(cn!=null)
		{
			cn.close();
		}
		System.out.println("Db connection closed");
	}

}
