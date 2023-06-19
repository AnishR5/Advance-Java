package tester;
import static utils.Hibernateutils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
public class RemoveEmpfromDept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(SessionFactory sf=getFactory() ; Scanner sc=new Scanner(System.in)){
			EmployeeDao dao=new EmployeeDaoImpl();
			System.out.println("Enter employye email and department name");
			System.out.println(dao.removeEmployee(sc.next(), sc.next()));
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
