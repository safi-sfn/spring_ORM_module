package launchApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Employee;
import dao.IEmployeeDao;

public class LaunchMainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IEmployeeDao empDao = (IEmployeeDao) context.getBean("empDao");
		
		Employee emp = new Employee();
		emp.setEno(104);
		emp.setEname("Mohit");
		emp.setEsal(4000);
		emp.setEaddr("NYC");
		
		String status = empDao.insert(emp);
		System.out.println(status);

	}

}
