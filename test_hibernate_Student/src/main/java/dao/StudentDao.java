package dao;

import pojos.Student;

public interface StudentDao {
	
	String registerStudent(Student student);
	
	Student loginStudent(String email,String password);

}
