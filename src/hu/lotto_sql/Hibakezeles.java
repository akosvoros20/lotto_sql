package hu.lotto_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Hibakezeles {
	private int abmeret;

	
	public int getAbmeret() {
		return abmeret;
	}

	public void setAbmeret(int abmeret) {
		this.abmeret = abmeret;
	}
	
	public void uresadatbazis() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lotto","root","");
			
			String query1 = "SELECT count(*) as db FROM `sorsolas_proba2`";
			PreparedStatement preparedStatement = conn.prepareStatement(query1);
			ResultSet resultset = preparedStatement.executeQuery(); 
			
			while(resultset.next()) {
				abmeret = resultset.getInt("db");
			}
			
		}
		catch(SQLException e)  {
			System.out.println("Valami hiba tortent...");
		}
	}
}
