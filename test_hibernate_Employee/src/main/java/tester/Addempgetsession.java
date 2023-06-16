package tester;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import pojos.Employee;
import pojos.EmploymentType;

import static utils.HibernetUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

public class Addempgetsession {

	public static void main(String[] args) {
		
		EmployeeDao dao=new EmployeeDaoImpl();
		
		try(SessionFactory sf=getFactory() ; Scanner sc=new Scanner(System.in)){
			System.out.println("Enter  firstName,  lastName,  email,  password,  confirmpassword,\r\n"
					+ "			 joinDate,  type,  salary");
			
			Employee e=new Employee(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), LocalDate.parse(sc.next()), EmploymentType.valueOf(sc.next().toUpperCase()), sc.nextDouble());
			System.out.println(dao.insertEmployeeDetailsGetsession(e));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
