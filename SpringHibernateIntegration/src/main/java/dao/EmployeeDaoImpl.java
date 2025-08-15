package dao;


import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import beans.Employee;


public class EmployeeDaoImpl implements IEmployeeDao {

 
	
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

   @Transactional
	@Override
	public String insert(Employee emp) {
	   Employee emp1 = null;
		String status = "";
		try {
			emp1 = (Employee)hibernateTemplate.get(Employee.class, emp.getEno());
			if(emp1 != null) {
				System.out.println("Employee already existed");
			}else {
			int eno = (Integer)hibernateTemplate.save(emp);
			if(eno == emp.getEno()) {
				status = "Employee inserted  successfull";
			}
			else {
				status = "Employe insertion failure";
			}
		   }
		} catch (Exception e) {
			status = "Employe insertion failure";
			e.printStackTrace();
		}
		return status;
	}

   @Transactional
	@Override
	public Employee search(int eno) {
		Employee emp = null;
		try {
			emp = (Employee)hibernateTemplate.get(Employee.class, eno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Transactional
	@Override
	public String update(Employee emp) {
		String status = "";
		try {
			Employee emp1 = search(emp.getEno());
			if(emp1 ==null) {
					status = "Employee Not Existed";
			}
			else {
				hibernateTemplate.evict(emp1);
				hibernateTemplate.update(emp);
				status = "Employee Updation success";
			}
		} catch (Exception e) {
			status="Employee updation failure";
			e.printStackTrace();
		}
		
		return status;
	}

	@Transactional
	@Override
	public String delete(Employee emp) {
		String status = "";
		try {
			Employee emp1 = search(emp.getEno());
			if(emp1 ==null) {
					status = "Employee Not Existed";
			}
			else {
				hibernateTemplate.evict(emp1);
				hibernateTemplate.delete(emp);
				status = "Employee Deleted success";
			}
		} catch (Exception e) {
			status="Employee deletion failure";
			e.printStackTrace();
		}
		
		return status;
	}

}
