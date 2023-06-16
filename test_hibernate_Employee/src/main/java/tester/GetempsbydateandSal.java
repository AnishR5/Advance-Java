package tester;
import static utils.HibernetUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;

public class GetempsbydateandSal {

	public static void main(String[] args) {
		
		try(SessionFactory sf=getFactory() ; Scanner sc=new Scanner(System.in)){
			EmployeeDao dao=new EmployeeDaoImpl();
			System.out.println("Enter start date, end date and minimum salary");
			
			dao.getEmpsByDateandSal(LocalDate.parse(sc.next()), LocalDate.parse(sc.next()), sc.nextDouble()).forEach(e->System.out.println());
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
