package dao;

import java.time.LocalDate;
import java.util.List;

import pojos.Employee;
import pojos.EmploymentType;

public interface EmployeeDao {
	//add a method to insert new emp details
	String insertEmployeeDetails(Employee emp);  //no throws cuz hiberbate converts checked exception to hibernate unchecked exception
	String insertEmployeeDetailsGetsession(Employee emp);
	
	Employee getEmpbyid(int id);
	
	List<Employee> getAllEmps();
	
	List<Employee> getEmpsByDateandSal(LocalDate startDate,LocalDate endDate,double salary);
	
	List<Employee> getEmpLastNamesByType(EmploymentType type);
}
