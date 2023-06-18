package tester;

import org.hibernate.SessionFactory;
import static utils.Hibernateutils.getFactory;

public class testHibernate {
	public static void main(String[] args) {
		
		try(SessionFactory sf=getFactory()){
			System.out.println("Hibernate running");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
