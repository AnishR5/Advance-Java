package dao;

import pojos.Employee;

public interface EmployeeDao {
//add new emp
	String addNewEmployee(Employee emp,long deptId);
	
	String removeEmployee(String empemail,String deptname);
}
