package hu.lotto_sql;

import java.util.Scanner;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Menu {
	
	private String menuValaszto;
	

	public String getMenuValaszto() {
		return menuValaszto;
	}

	public void setMenuValaszto(String menuValaszto) {
		this.menuValaszto = menuValaszto;
	}

	public void proc() {
		Resource resource= new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		Sorsolas2 sors = (Sorsolas2)factory.getBean("sorsolas");
		Kivalasztas kivalaszt = new Kivalasztas();
		Kiurit torles = new Kiurit();
		Hibakezeles hiba = new Hibakezeles();
		
		if(menuValaszto.equals("sima")) {
			boolean exit = false;
			torles.urites();
			hiba.uresadatbazis();
			while(!exit) {
				System.out.println("Valassz egy menupontot:");
				System.out.println("A. Lottoszamok huzasa");
				System.out.println("B. Leggyakoribb 3 szam kigyujtese");
				System.out.println("C. Tomb kiiratasa");
				System.out.println("T. Adatbazis kiuritese");
				System.out.println("P. Tovabbi sorsolasok");
				System.out.println("D. Kilepes");
				System.out.print("> "); Scanner sc = new Scanner(System.in);
					char valasztas = sc.next().charAt(0);	
				
						switch(valasztas){
							case 'A':	
								if(sors.getId() > 0) {
									System.out.println("Mar van adat az adatbazisban hasznald a P betut");
								} else {
								sors.sorsolas();}
								break;
							case 'B':
								hiba.uresadatbazis();
								if(hiba.getAbmeret() == 0) {
									System.out.println("Meg nincs adat elobb sorsolj elobb...");
								}
								else {kivalaszt.kivalaszt();}
							  break;
							case 'C':
								if(kivalaszt.getElemtmp().isEmpty()) {
									System.out.println("Meg nem kerultek kivalasztasra a leggyakoribb szamok...");
								}else {
								kivalaszt.kiir();}
							  break;
							case 'T':
								torles.urites();
								System.out.println("Az adatbazis kiurult");
								break;
							case 'P':
								hiba.uresadatbazis();
								if(sors.getId() == 0 || hiba.getAbmeret() == 0) {
									System.out.println("Meg ures az adatbazis kerem az elso sorsolast hasznalni.");
								} else {
								sors.tovabbisorsolas();}
								break;	
							case 'D':
							  System.out.println("Viszontlatasra");
							  exit = true;
							  break;
							default:
								System.out.println("Hibas betu");
						    	break;
						}
			}
		}else {
				System.out.println("NEM LÉTEZŐ MENÜ OPCIÓ");
			  }
	}
}