package tester;

import org.hibernate.SessionFactory;

import dao.EmployeeDaoImpl;
import pojos.Employee;
import pojos.EmploymentType;

import static utils.HibernetUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

public class AddEmpDetails {

	public static void main(String[] args) {
		
		try(SessionFactory sf=getFactory();Scanner sc=new Scanner(System.in)){   //invoking static method--> class loading-->static init block 
			System.out.println("Hibernet running "+sf);
			System.out.println("Enter emp details : firstname,lastname,email,password,confimpass,joindate,type, salary");
			Employee newEmp=new Employee(sc.next(), sc.next(), sc.next(), sc.next(),sc.next() , LocalDate.parse(sc.next()), EmploymentType.valueOf(sc.next().toUpperCase()), sc.nextDouble());
		
			EmployeeDaoImpl dao=new EmployeeDaoImpl();
			System.out.println(dao.insertEmployeeDetails(newEmp));
			
		}//sf.close() -->cleaning up DBCP(Database connection Pool)
		catch (Exception e) {
			e.printStackTrace();
		}//catch
	}

}
