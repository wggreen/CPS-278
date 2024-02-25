package edu.wccnet.wggreen.DI_XML_Demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("FinAid")
public class FinAid {
	
	@Autowired
	private College college;
	@Autowired	
	private FinAidService finAidService;
	
//	public FinAid() {
//		
//	}
//	
//	@Autowired
//	public FinAid(College college, FinAidService finAidService) {
//		super();
//		this.college = college;
//		this.finAidService = finAidService;
//	}
	
	public void displayFinAid() {
		System.out.println("You received " + finAidService.getFinAidType() + " from " + college.getCollegeName());
	}
	
	
}
