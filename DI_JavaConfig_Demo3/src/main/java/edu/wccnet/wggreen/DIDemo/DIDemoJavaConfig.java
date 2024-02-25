package edu.wccnet.wggreen.DIDemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("edu.wccnet.wggreen.DIDemo")
@PropertySource("classpath:college.properties")
public class DIDemoJavaConfig {

}
