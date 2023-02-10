package ksolves.demospringmvc.Dao;

import java.util.*;

import org.springframework.ui.Model;

import ksolves.demospringmvc.entity.Employee;
import ksolves.demospringmvc.model.EmployeeModel;

public interface EmployeeDao {

	void saveEmployee(Employee employee);

	List<Employee> viewEmployeeDetail();

	public void deleteEmployee(Integer id);
	
	public void editEmployee(Employee employee) ;
	
	public Employee findEmpByEmpId(Employee employee);


}
