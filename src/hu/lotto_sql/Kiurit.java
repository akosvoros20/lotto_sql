package hu.lotto_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Kiurit {
	
	public void urites(){
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lotto","root","");
		
			String query1 = "DELETE from sorsolas_proba2";
			PreparedStatement preparedStatement = conn.prepareStatement(query1);
	
			preparedStatement.executeUpdate();
		}
		catch(SQLException e)  {
			System.out.println("Csatlakozás nem sikerült");
		}
	}
}
