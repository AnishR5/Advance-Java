	package tester;
	import static utils.HibernetUtils.getFactory;
	
	import java.util.Scanner;
	
	import org.hibernate.SessionFactory;
	
	import dao.StudentDao;
	import dao.StudentDaoImpl;
	import pojos.Student;
	public class testLogin {
	
		public static void main(String[] args) {
			
			try(SessionFactory sf=getFactory() ; Scanner sc=new Scanner(System.in)){
				StudentDao dao=new StudentDaoImpl();
				System.out.println("Enter email and password");
				Student stud=dao.loginStudent(sc.next(), sc.next());
				if(stud!=null) {
					System.out.println("Login Sucssesfull");
				}else 
					System.out.println("Login Unsucessfull");
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	
	}
