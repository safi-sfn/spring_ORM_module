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
			if (sessionFactory == null) {
				throw new RuntimeException("SessionFactory creation failed");
			}
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Employee emp = new Employee();
			emp.setEno(101);
			emp.setEname("Rayyan");
			emp.setEsal(2000);
			emp.setEaddr("HYD");
			session.persist(emp);   // session.save(); but save is deprecated
			transaction.commit();
			System.out.println("Eplmloyee Inserted Successful");
			System.out.println("Transaction success");
			
		} catch (Exception e) {
			transaction.rollback();
			System.out.println("Transaction failure");
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
			
		}

	}

}
