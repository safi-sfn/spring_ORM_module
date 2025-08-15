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
		String status = "";
		try {
			int eno = (Integer)hibernateTemplate.save(emp);
			if(eno == emp.getEno()) {
				status = "Employee inserted  successfull";
			}
			else {
				status = "Employe insertion failure";
			}
		} catch (Exception e) {
			status = "Employe insertion failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Employee search(int eno) {
	
		return null;
	}

	@Override
	public String update(Employee emp) {

		return null;
	}

	@Override
	public String delete(Employee emp) {
		
		return null;
	}

}
