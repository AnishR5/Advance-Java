package tester;
import static utils.Hibernateutils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
public class RemoveDepartment {

	public static void main(String[] args) {
		
		try(SessionFactory sf=getFactory();Scanner sc=new Scanner(System.in)){
			DepartmentDao dao=new DepartmentDaoImpl();
			System.out.println("Enter department name to remove");
			System.out.println(dao.removeDept(sc.next()));
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
