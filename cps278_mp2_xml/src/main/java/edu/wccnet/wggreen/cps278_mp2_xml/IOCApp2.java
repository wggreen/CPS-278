package edu.wccnet.wggreen.cps278_mp2_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCApp2 {
	public static void main( String[] args )
  {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
     
    Battle b = (Battle)context.getBean("battle");
     
    b.fight();
  }
}