package Attributes;

public class Course {
	
//	5. Finally
//
//	Create a Course class to store information about a course.
//	This includes a course code, subject, and instructor name.
	
	private String code; 
	private String subject; 
	private String instructor; 
	
	//constructor 
	public Course(String c, String s, String i) {
		this.code = c; 
		this.subject = s; 
		this.instructor = i;
	}
	//default constructor 
	public Course() {
		this.code = "NA"; 
		this.subject = "NA"; 
		this.instructor = "NA"; 
	}
	
	//getters and setters 
	
	public String getCode() {
		return this.code;
	}
	public String getSubject() {
		return this.subject; 
	}
	public String getInstructor() {
		return this.instructor; 
	}
	
	public void setCode(String s) {
		this.code = s; 
	}
	
	public void setSubject(String s) {
		this.subject = s; 
	}
	
	public void setInstructor(String s) {
		this.instructor = s; 
	}

}
