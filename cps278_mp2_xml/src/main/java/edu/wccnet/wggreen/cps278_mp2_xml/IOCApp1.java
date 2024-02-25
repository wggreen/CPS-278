package edu.wccnet.wggreen.cps278_mp2_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCApp1 {
	public static void main( String[] args )
    {
        ApplicationContext context = new FileSystemXmlApplicationContext("file:src/main/resources/beans.xml");
        
        Battle b = (Battle)context.getBean("battle");
        
        b.fight();
    }
}
