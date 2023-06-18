package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Author;

import static utils.Hibernateutils.getFactory;

public class AuthorDaoImpl implements AuthorDao {

	@Override
	public String addAuthor(Author a) {
		String mgs="Author not added";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			session.persist(a);
			tx.commit();
			mgs="Author added succesfully";
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return mgs;
	}

//	@Override
//	public String addAuthorwithBooks(Author a) {
//		String mgs="Author added";
//		Session session =getFactory().getCurrentSession();
//		Transaction tx=session.beginTransaction();
//		try {
//			
//			
//		}catch (Exception e) {
//			if(tx!=null)
//				tx.rollback();
//			throw e;
//		}
//		return mgs;
//	}

}
