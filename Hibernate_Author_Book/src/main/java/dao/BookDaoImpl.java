package dao;

import pojos.Author;
import pojos.Book;
import static utils.Hibernateutils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDaoImpl implements BookDao {

	@Override
	public String AddBook(Book book,int authorId) {
		String mgs="Book not added";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Author author=session.get(Author.class, authorId);
			if(author!=null) {
				author.addBook(book);
				session.persist(book);
				tx.commit();
				mgs="Book added Successfully";
			}
			
			
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		return mgs;
	}

}
