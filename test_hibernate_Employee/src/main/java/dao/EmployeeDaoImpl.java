package dao;

import pojos.Employee;
import pojos.EmploymentType;

import static utils.HibernetUtils.getFactory;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.*;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String insertEmployeeDetails(Employee emp) {
		String mgs="Adding Emp Failed";
		//get session from Session Factory
		Session session=getFactory().openSession();  //connection from dbcp pools out,wraps it in session ibj and returns this to the caller
		
		//begin a transaction
		Transaction tx=session.beginTransaction();
		try {
			session.save(emp);
			tx.commit();
			mgs="Added emp details "+emp.getEmpId();
		}catch(Exception e) {
			//roolback tx
			if(tx!=null)
				tx.rollback();
			//rethrow the same execp to the caller : to inform
			throw e;
			
		}finally {
			//session closing
			if(session!=null)
				session.close(); //pooled out session simply returns to the pool
		}
		return mgs;
	}

	@Override
	public String insertEmployeeDetailsGetsession(Employee emp) {
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		String mgs="Insert fail";
		try {
			session.save(emp);
			tx.commit();
			mgs="Insert Successfull";
			
		}catch (Exception e) {
			tx.rollback();
			throw e;
			
		}
		return mgs;
	}

	@Override
	public Employee getEmpbyid(int id) {
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		Employee emp=null;
		try {
			emp=session.get(Employee.class, id);
			tx.commit();
			
		}catch (Exception e) {
			tx.rollback();
			throw e;
		}
		return emp;
	}

	@Override
	public List<Employee> getAllEmps() {
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		List<Employee> emplist=null;
		String jpql="select e from Employee e";
		try {
			emplist=session.createQuery(jpql, Employee.class).getResultList();
			
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return emplist;
	}

	@Override
	public List<Employee> getEmpsByDateandSal(LocalDate startDate, LocalDate endDate, double minsal) {
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		String jpql="select e from Employee e where joinDate between :startdate and :enddate and salary>:sal";
		List<Employee> emplist=null;
		try {
			emplist=session.createQuery(jpql, Employee.class).setParameter("startdate", startDate)
					.setParameter("enddate", endDate)
					.setParameter("sal", minsal)
					.getResultList();
			
			tx.commit();
			
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return emplist;
	}

	@Override
	public List<Employee> getEmpLastNamesByType(EmploymentType type) {
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		String jpql="select new pojos.Employee(firstName,lastName,salary) from Employee e where e.type=:type";
		List<Employee> emplist=null;
		try {
			emplist=session.createQuery(jpql, Employee.class)
					.setParameter("type", type)
					.getResultList();
			tx.commit();
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return emplist;
	}

}
