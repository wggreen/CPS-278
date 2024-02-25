package edu.wccnet.wggreen.DIDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DIDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIDemoJavaConfig.class);

		College college = (College) context.getBean("wcc");

		System.out.println(college);
		
		college.printCollegeService();
		
		FinAid finAid = (FinAid)context.getBean("FinAid");
		
		finAid.displayFinAid();

		context.close();

	}

}
