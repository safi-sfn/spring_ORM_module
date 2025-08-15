package dao;

import beans.Employee;

public interface IEmployeeDao {
		public String insert(Employee emp);
		public Employee search(int eno);
		public String update(Employee emp);
		public String delete(Employee emp);
}
