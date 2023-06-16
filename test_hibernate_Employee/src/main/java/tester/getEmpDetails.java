package tester;
import static utils.HibernetUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import pojos.Employee;
public class getEmpDetails {

	public static void main(String[] args) {
		
		try(SessionFactory sf=getFactory() ; Scanner sc=new Scanner(System.in)){
			EmployeeDao dao= new EmployeeDaoImpl();
			System.out.println("Enter Empid");
			System.out.println(dao.getEmpbyid(sc.nextInt()));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
