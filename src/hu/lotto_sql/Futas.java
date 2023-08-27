package hu.lotto_sql;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class Futas {

	public static void main(String[] args) {
			Resource resource= new ClassPathResource("applicationContext.xml");
			BeanFactory factory = new XmlBeanFactory(resource);
			
			Menu menu = (Menu)factory.getBean("menu");
			menu.proc();

	}

}
