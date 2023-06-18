package tester;
import static utils.Hibernateutils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AuthorDao;
import dao.AuthorDaoImpl;
import pojos.Author;
public class AddAuthor {

	public static void main(String[] args) {
	
		try(SessionFactory sf=getFactory() ; Scanner sc=new Scanner(System.in)){
			AuthorDao dao=new AuthorDaoImpl();
			System.out.println("Enter fname, lname, email, password");
			Author author=new Author(sc.next(), sc.next(), sc.next(), sc.next());
			System.out.println(dao.addAuthor(author));
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
