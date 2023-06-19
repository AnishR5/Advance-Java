package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernateutils {
	
	private static SessionFactory factory;
	
	static {
		factory=new Configuration()  //config object created
				.configure()
				.buildSessionFactory();				
	}

	public static SessionFactory getFactory() {
		return factory;
	}

	

}
