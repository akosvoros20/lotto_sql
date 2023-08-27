package hu.lotto_sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Sorsolas2 {
		private int maxElem;
		private int sorsolasSzama;
		private int szam1;
		private int id;


		public Sorsolas2() {
		}
		
		public int getMaxElem() {
			return maxElem;
		}

		public void setMaxElem(int maxElem) {
			this.maxElem = maxElem;
		}

		public int getSorsolasSzama() {
			return sorsolasSzama;
		}

		public void setSorsolasSzama(int sorsolasSzama) {
			this.sorsolasSzama = sorsolasSzama;
		}
		
		public int getSzam1() {
			return szam1;
		}

		public void setSzam1(int szam1) {
			this.szam1 = szam1;
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void sorsolas() {
			setId(1);
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lotto","root","");
				String query1 = "INSERT INTO sorsolas_proba2 (ID, szam) VALUES (?, ?)";
				PreparedStatement preparedStatement = conn.prepareStatement(query1);
				ArrayList <Integer> listtmp = new ArrayList();
				Random rand = new Random();
				for (int k=0; k <getSorsolasSzama(); k++) {
					listtmp.clear();
					for(int i= 0; i < getMaxElem(); i++) {
						szam1 = rand.nextInt(90)+1;				
						while(listtmp.contains(szam1) && szam1 == 0) {
							szam1 = rand.nextInt(90)+1;
						}
						listtmp.add(szam1);
						
						preparedStatement.setInt(1, id);
						preparedStatement.setInt(2, szam1);
						preparedStatement.executeUpdate();
					}
					id++;
				}
			}
			catch(SQLException e)  {
				System.out.println("Csatlakozás nem sikerült");
			}
				System.out.println("Adatok betoltve az adatbazisba");
			}
		
		public void tovabbisorsolas(){
			id = getId();
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lotto","root","");
				String query1 = "INSERT INTO sorsolas_proba2 (ID, szam) VALUES (?, ?)";
				PreparedStatement preparedStatement = conn.prepareStatement(query1);
				ArrayList <Integer> listtmp = new ArrayList();
				Random rand = new Random();
				for (int k=0; k <getSorsolasSzama(); k++) {
					listtmp.clear();
					for(int i= 0; i < getMaxElem(); i++) {
						szam1 = rand.nextInt(90)+1;				
						while(listtmp.contains(szam1) && szam1 == 0) {
							szam1 = rand.nextInt(90)+1;
						}
						listtmp.add(szam1);
						
						preparedStatement.setInt(1, id);
						preparedStatement.setInt(2, szam1);
						preparedStatement.executeUpdate();
					}
					id++;
				}
			}
			catch(SQLException e)  {
				System.out.println("Csatlakozás nem sikerült");
			}
			System.out.println("Tovabbi adatok betoltve az adatbazisba");
		}
			
}
