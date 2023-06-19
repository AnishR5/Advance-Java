package dao;

import pojos.Department;

public interface DepartmentDao {
//Launch a new department
	String launchNewDept(Department dept);
	
	String removeDept(String Deptname);
	
	Department getDepartmentDetails(String name);
}
