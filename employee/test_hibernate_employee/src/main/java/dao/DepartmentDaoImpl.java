package dao;

import pojos.Department;
import org.hibernate.*;
import static utils.Hibernateutils.getFactory;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public String launchNewDept(Department dept) {
		String mesg = "Adding new dept failed!!!!!!!!!";
		// 1 get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			session.persist(dept);
		//	dept.getEmpList().forEach(e -> session.persist(e));
			tx.commit();
			mesg = "added new dept with auto generated id=" + dept.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String removeDept(String Deptname) {
		String mgs="department not removed";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		String jpql="select d from Department d where departmentName=:dname";
		try {
			Department dept=session.createQuery(jpql, Department.class)
					.setParameter("dname", Deptname)
					.getSingleResult();
			session.delete(dept);
			tx.commit();
			mgs="department deleted";
			
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return mgs;
	}

	@Override
	public Department getDepartmentDetails(String name) {
		Department dept=null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		//String jpql="select d from Department d where departmentName=:dname";
		String jpql="select d from Department d left join fetch d.empList where d.departmentName=:dname";
		try {
			 dept=session.createQuery(jpql, Department.class)
					.setParameter("dname", name)
					.getSingleResult();
			 //int emplistsize=dept.getEmpList().size();
			tx.commit();
			
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return dept;
	}

}
