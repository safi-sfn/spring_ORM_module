package launchApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Employee;
import dao.IEmployeeDao;

public class LaunchMainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IEmployeeDao empDao = (IEmployeeDao) context.getBean("empDao");

/*		
//	Insert operation	
		Employee emp = new Employee();
		emp.setEno(106);
		emp.setEname("Mohit");
		emp.setEsal(4000);
		emp.setEaddr("NYC");
		
		String status = empDao.insert(emp);
		System.out.println(status);
*/
/*
		Employee emp = empDao.search(101);
		if(emp == null) {
			System.out.println("Employee not Existed");
		}else {
			System.out.println("Employee Details");
			System.out.println("---------------------");
			System.out.println("Employee Name     : "+emp.getEname());
			System.out.println("Employee Sallary  : "+emp.getEsal());
			System.out.println("Employee Address  : "+emp.getEaddr());
		}
*/
	/*
		Employee emp = new Employee();
		emp.setEno(106);
		emp.setEname("Mohit");
		emp.setEsal(3000);
		emp.setEaddr("NYC");
		String status = empDao.update(emp);
		System.out.println(status);
	*/
		
		Employee emp = new Employee();
		emp.setEno(106);
		emp.setEname("Mohit");
		emp.setEsal(3000);
		emp.setEaddr("NYC");
		String status = empDao.delete(emp);
		System.out.println(status);
	}

}
