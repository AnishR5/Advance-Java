package tester;
import static utils.HibernetUtils.getFactory;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
public class GetAllEmps {

	public static void main(String[] args) {
		
		try(SessionFactory sf=getFactory()){
			EmployeeDao dao=new EmployeeDaoImpl();
			dao.getAllEmps().forEach(e->System.out.println(e));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
