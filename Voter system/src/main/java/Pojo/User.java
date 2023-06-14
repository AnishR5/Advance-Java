package Pojo;
// id | first_name | last_name | email             | password | dob        | status | role

import java.sql.Date;

public class User {
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private Date dob;
	private boolean votingstatus;
	private String role;
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", dob=" + dob + ", votingstatus=" + votingstatus + ", role=" + role + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public boolean getVotingstatus() {
		return votingstatus;
	}


	public void setVotingstatus(boolean votingstatus) {
		this.votingstatus = votingstatus;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public User(int id ,String firstname, String lastname, String email, String password, Date dob,
			boolean votingstatus, String role) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.votingstatus = false;
		this.role = role;
	}
	
	
	
	
}
