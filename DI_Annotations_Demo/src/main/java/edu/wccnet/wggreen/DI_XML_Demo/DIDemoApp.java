package edu.wccnet.wggreen.DI_XML_Demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DIDemoApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		College college = (College) context.getBean("wcc");

		System.out.println(college);
		
		college.printCollegeService();
		
		FinAid finAid = (FinAid)context.getBean("FinAid");
		
		finAid.displayFinAid();

		((ClassPathXmlApplicationContext) context).close();

	}

}
