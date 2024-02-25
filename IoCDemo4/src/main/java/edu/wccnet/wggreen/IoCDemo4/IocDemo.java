package edu.wccnet.wggreen.IoCDemo4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IocDemo {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("beanConfig.xml");
		IBird bird = (IBird)context.getBean("bird");
		System.out.println(bird.getEatingHabit());
		
		((FileSystemXmlApplicationContext)context).close();
	}

}
