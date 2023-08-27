package hu.lotto_sql;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Sorsolas {
		private int maxElem;
		private int sorsolasSzama;
		private ArrayList<Integer> sorsolas = new ArrayList();
		private int szam1;
		private int szam2;
		private int szam3;
		private int szam4;
		private int szam5;
		private SqlConnection sql;
		
		public Sorsolas() {
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

		public ArrayList<Integer> getSorsolas() {
			return sorsolas;
		}

		public void setSorsolas(ArrayList<Integer> sorsolas) {
			this.sorsolas = sorsolas;
		}
		
		public int getSzam1() {
			return szam1;
		}

		public void setSzam1(int szam1) {
			this.szam1 = szam1;
		}

		public int getSzam2() {
			return szam2;
		}

		public void setSzam2(int szam2) {
			this.szam2 = szam2;
		}

		public int getSzam3() {
			return szam3;
		}

		public void setSzam3(int szam3) {
			this.szam3 = szam3;
		}

		public int getSzam4() {
			return szam4;
		}

		public void setSzam4(int szam4) {
			this.szam4 = szam4;
		}

		public int getSzam5() {
			return szam5;
		}

		public void setSzam5(int szam5) {
			this.szam5 = szam5;
		}

		public void sorsolas() {
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lotto","root","");
				System.out.println("Csatlakozas sikeres");
				
				String query1 = "INSERT INTO sorsolas_proba (ID, szam1, szam2, szam3, szam4, szam5) VALUES (?, ?, ?, ?, ?, ?)";
				PreparedStatement preparedStatement = conn.prepareStatement(query1);
				for(int i= 0; i < getSorsolasSzama(); i++) {
						Random rand = new Random();
						
						szam1 = rand.nextInt(90)+1;
						szam2 = rand.nextInt(90)+1;
						
						while(szam1 == szam2) {
							szam2=rand.nextInt(90)+1;
						}
						
						szam3 = rand.nextInt(90)+1;
						
						while(szam1 == szam3 || szam2 == szam3) {
							szam3 = rand.nextInt(90)+1;
						}
						
						szam4 = rand.nextInt(90)+1;
						
						while(szam1 == szam4 || szam2 == szam4 || szam3 == szam4) {
							szam4 = rand.nextInt(90)+1;
						}
						
						szam5 = rand.nextInt(90)+1; 
						
						while(szam1 == szam5 || szam2 == szam5 || szam3 == szam5 || szam4 == szam5) {
							szam5 = rand.nextInt(90)+1;
						}
						
						preparedStatement.setInt(1, i+1);
						preparedStatement.setInt(2, szam1);
						preparedStatement.setInt(3, szam2);
						preparedStatement.setInt(4, szam3);
						preparedStatement.setInt(5, szam4);
						preparedStatement.setInt(6, szam5);
						
						preparedStatement.executeUpdate();
						System.out.println("A huzasok bekerültek az adatbázisba.");
				}
			}
			catch(SQLException e)  {
				System.out.println("Csatlakozás nem sikerült");
			}


}
}
