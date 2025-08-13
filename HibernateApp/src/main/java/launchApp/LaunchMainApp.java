package launchApp;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Employee;

public class LaunchMainApp {

	public static void main(String[] args) {
		
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		
		
		
		try {
			configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
//			
//			Employee emp = new Employee();
//			emp.setEno(101);
//			emp.setEname("Anjali");
//			emp.setEsal(3000);
//			emp.setEaddr("HYD");
//			session.persist(emp);   // session.save(); but save is deprecated
//		//	session.update(emp);  // for updation
//		//	session.delete(emp);
//			transaction.commit();
//			System.out.println("Eplmloyee Updated Successful");
//			System.out.println("Transaction success");
//			
			Employee emp = (Employee) session.get("entity.Employee", 101);
			System.out.println("Employee details");
			System.out.println("-----------------");
			System.out.println("Employee Number  : "+emp.getEno());
			System.out.println("Employee Name    : "+emp.getEname());
			System.out.println("Employee Salary  : "+emp.getEsal());
			System.out.println("Employee Address : "+emp.getEaddr());
			
		} catch (Exception e) {
//			transaction.rollback();
//			System.out.println("Transaction failure");
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
			
		}

	}

}

