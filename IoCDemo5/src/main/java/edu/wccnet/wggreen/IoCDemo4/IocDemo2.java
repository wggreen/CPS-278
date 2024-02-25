package edu.wccnet.wggreen.IoCDemo4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocDemo2 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beanConfig2.xml");
		IBird bird = (IBird)context.getBean("bird");
		System.out.println(bird.getEatingHabit());
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
