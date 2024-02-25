package edu.wccnet.wggreen.restDemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("edu.wccnet.wggreen.restDemo")
public class RestDemoConfig {

}
