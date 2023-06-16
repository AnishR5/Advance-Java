package tester;
import static utils.HibernetUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import pojos.EmploymentType;
public class Getemplastname {

	public static void main(String[] args) {
		
		try(SessionFactory sf=getFactory() ; Scanner sc=new Scanner(System.in)){
			EmployeeDao dao=new EmployeeDaoImpl();
			
			System.out.println("Enter Employeement type");
			
			dao.getEmpLastNamesByType(EmploymentType.valueOf(sc.next().toUpperCase()))
			.forEach(e->System.out.println(e.getFirstName()+" "+e.getLastName()+" "+e.getSalary()));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
