package tester;
import static utils.Hibernateutils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.BookDao;
import dao.BookDaoImpl;
import pojos.Book;

public class AddBookwithAuthor {

	public static void main(String[] args) {
		
		try(SessionFactory sf=getFactory() ; Scanner sc=new Scanner(System.in)){
			BookDao dao=new BookDaoImpl();
			System.out.println("Enter book title and price");
			Book book=new Book(sc.next(),sc.nextDouble());
			System.out.println("Enter Author id");
			int authorid=sc.nextInt();
			System.out.println(dao.AddBook(book, authorid));
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
