package hu.lotto_sql;

import java.sql.*;

public class SqlConnection {
	
	
	
	public void connect(){
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lotto","root",""); 
			System.out.println("Csatlakozas sikeres");
			
			
		}
		catch(SQLException e) {
			System.out.println("Csatlakozás nem sikerült");
		}
	}
}
