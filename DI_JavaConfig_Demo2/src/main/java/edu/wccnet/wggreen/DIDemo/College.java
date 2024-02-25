package edu.wccnet.wggreen.DIDemo;

public class College {
	
	private String collegeName;
	private int yearBuilt;
	private String zipCode;
	private int enrollment;
	private CollegeService collegeService;
	


	public College() {
		
	}
	
	public College(String collegeName, int yearBuilt) {
		
		super();

		this.collegeName = collegeName;
		
		this.yearBuilt = yearBuilt;
	}
	
	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeService(CollegeService collegeService) {
		this.collegeService = collegeService;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setEnrollment(int enrollment) {
		this.enrollment = enrollment;
	}


	@Override
	public String toString() {
		return "College [collegeName=" + collegeName + ", yearBuilt=" + yearBuilt + ", zipCode=" + zipCode
				+ ", enrollment=" + enrollment + "]";
	}
	
	public void printCollegeService() {
		System.out.println(collegeService.getService(collegeName));
	}
	
	

}
