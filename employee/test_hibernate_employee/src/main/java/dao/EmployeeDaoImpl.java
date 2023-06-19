package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Department;
import pojos.Employee;
import static utils.Hibernateutils.getFactory;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String addNewEmployee(Employee emp, long deptId) {
		String mesg = "adding emp failed!!!!!!!!!!!";
		// 1 get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			// get persistent dept from db
			Department dept = session.get(Department.class, deptId);
			if (dept != null) {
				// dept : PERSISTENT
//				// add emp ref to dept's AL
//				dept.getEmpList().add(emp);// parent ---> emp
//				// add dept ref to the emp
//				emp.setAssignedDept(dept); // child --> parent'
				dept.addEmployee(emp);
				// save emp rec
				session.persist(emp);
				mesg = "Added new emp to Dept " + dept.getDepartmentName();
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String removeEmployee(String empemail, String deptname) {
		String mgs="Employee not removed";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		String empjpql="select e from Employee e where email=:em ";
		String deptjpql="select d from Department d where departmentName=:dname";
		try {
			Department dept=session.createQuery(deptjpql, Department.class)
					.setParameter("dname", deptname)
					.getSingleResult();
			Employee emp=session.createQuery(empjpql, Employee.class)
					.setParameter("em", empemail)
					.getSingleResult();
			dept.removeEmployee(emp);
			tx.commit();
			mgs="Employee removed";
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return mgs;
	}

}
