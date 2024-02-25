package edu.wccnet.wggreen.DIDemo;

public class FinAid {
	
	private College college;
	private FinAidService finAidService;
	
	/*public FinAid() {
		
	}
	*/
	
	public FinAid(College college, FinAidService finAidService) {
		super();
		this.college = college;
		this.finAidService = finAidService;
	}
	
	public void displayFinAid() {
		System.out.println("You received " + finAidService.getFinAidType() + " from " + college.getCollegeName());
	}
	
	
}
