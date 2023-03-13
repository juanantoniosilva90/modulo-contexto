package org.test.app;

import org.dao.impl.DaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		DaoImpl daoImpl = context.getBean("daoImpl", DaoImpl.class);
		daoImpl.selectS_Region();
		
		
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}
