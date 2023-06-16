package tester;

import org.hibernate.SessionFactory;
import static utils.HibernetUtils.getFactory;

public class TestHibernate {

	public static void main(String[] args) {
		
		try(SessionFactory sf=getFactory()){   //invoking static method--> class loading-->static init block 
			System.out.println("Hibernet running "+sf);
		}//sf.close() -->cleaning up DBCP(Database connection Pool)
		catch (Exception e) {
			e.printStackTrace();
		}//catch
	}

}
