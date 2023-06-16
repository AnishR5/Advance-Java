package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Student;

import static utils.HibernetUtils.getFactory;

import java.io.Serializable;

public class StudentDaoImpl implements StudentDao{

	@Override
	public String registerStudent(Student student) {
		String mgs="Registering failed";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Serializable id= session.save(student);
			tx.commit();
			 mgs="Registering Successfull with id "+id;
			
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return mgs;
	}

	@Override
	public Student loginStudent(String email, String password) {
		System.out.println("Email"+email);
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		Student student=null;
		String jpql="select s from Student s where s.email=:em and s.password=:pass";
		try {
			student=session.createQuery(jpql, Student.class)
					.setParameter("em", email)
					.setParameter("pass", password)
					.getSingleResult();
			tx.commit();
			System.out.println(student);
			return student;
			
			
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		
	}

	

}
