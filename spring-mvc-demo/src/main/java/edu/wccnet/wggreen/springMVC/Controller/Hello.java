package edu.wccnet.wggreen.springMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
	@RequestMapping("/")
	public String helloPage() {
		return "hello";
	}
}
