package Pojo;

public class Student {
	
	private String fname;
	private String lname;
	private int marks;
	private Courses course;
	private boolean admitted;
	public Student(String fname, String lname, int marks, Courses course, boolean admitted) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.marks = marks;
		this.course = course;
		this.admitted = admitted;
	}
	@Override
	public String toString() {
		return "Student [fname=" + fname + ", lname=" + lname + ", marks=" + marks + ", course=" + course
				+ ", admitted=" + admitted + "]";
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Courses getCourse() {
		return course;
	}
	public void setCourse(Courses course) {
		this.course = course;
	}
	public boolean isAdmitted() {
		return admitted;
	}
	public void setAdmitted(boolean admitted) {
		this.admitted = admitted;
	}
	
	

}
