package tester;
import static utils.Hibernateutils.getFactory;

import java.util.Scanner;


import org.hibernate.SessionFactory;

import dao.AuthorDao;
import dao.AuthorDaoImpl;
import pojos.Author;
import pojos.Book;
public class AddAuthorwithBooks {

	public static void main(String[] args) {
		
		try(SessionFactory sf=getFactory() ; Scanner sc=new Scanner(System.in)){
			AuthorDao dao=new AuthorDaoImpl();
			System.out.println("Enter author fname, lname, email, password");
			Author newauthor=new Author(sc.next(), sc.next(), sc.next(), sc.next());
			System.out.println("Enter number of books to add");
			int n=sc.nextInt();
			for(int i=1;i<=n;i++) {
				System.out.println("Enter book title and price");
				Book book=new Book(sc.next(),sc.nextDouble());
				newauthor.addBook(book);
			}
		  System.out.println(dao.addAuthor(newauthor));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
