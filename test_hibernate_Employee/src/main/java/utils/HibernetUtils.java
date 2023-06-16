package utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernetUtils {
	private static SessionFactory factory; //singleton,immutable,
	//inherently thread safe object created one per database 
	//Job: session provider
	
	static {
		System.out.println("in static intit block");
		factory=new Configuration()  //empty
				.configure() //reads props n mappings from hibernate.cfg.xml
				.buildSessionFactory(); //builds Session factory
	}

	public static SessionFactory getFactory() {
		return factory;
	}


  

}
