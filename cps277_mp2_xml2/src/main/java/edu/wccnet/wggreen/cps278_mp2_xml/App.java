package edu.wccnet.wggreen.cps278_mp2_xml;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
	public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MP2BeanConfig.class);
        
        Battle b = (Battle)context.getBean("battle");
        
        b.fight();
        
        context.close();
    }
}
