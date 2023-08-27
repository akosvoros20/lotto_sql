package hu.lotto_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Kivalasztas {
	private int topElem;
	
	private ArrayList<Integer> elemtmp = new ArrayList();
	private int[] elemek = new int[3];

	public ArrayList<Integer> getElemtmp() {
		return elemtmp;
	}

	public void setElemtmp(ArrayList<Integer> elemtmp) {
		this.elemtmp = elemtmp;
	}

	public int getTopElem() {
		return topElem;
	}

	public void setTopElem(int topElem) {
		this.topElem = topElem;
	}
	
	public int[] getElemek() {
		return elemek;
	}

	public void setElemek(int[] elemek) {
		this.elemek = elemek;
	}

	public void kivalaszt() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lotto","root","");
			
			String query1 = "SELECT szam, count(*) as db FROM `sorsolas_proba2` GROUP by szam order by db desc LIMIT 3";
			PreparedStatement preparedStatement = conn.prepareStatement(query1);
			ResultSet resultset = preparedStatement.executeQuery(); 
			
			while(resultset.next()) {
				elemtmp.add(resultset.getInt("szam"));
			}
			for(int i = 0; i<elemtmp.size(); i++) {
				elemek[i] = elemtmp.get(i);
			}
			System.out.println("Az adatok bekerultek a tombbe.");
		}
		catch(SQLException e)  {
			System.out.println("Valami hiba tortent...");
		}
	}
	
	public void kiir() {
		System.out.println("A harom leggyakrabban kihuzott szam: "+Arrays.toString(elemek));
	}

}
