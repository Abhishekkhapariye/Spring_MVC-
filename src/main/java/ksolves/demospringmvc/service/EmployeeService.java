package ksolves.demospringmvc.service;

import java.util.List;

import ksolves.demospringmvc.CustumException.ApplicationException;
import ksolves.demospringmvc.entity.Employee;
import ksolves.demospringmvc.model.EmployeeModel;

public interface EmployeeService {

	// void saveEmployeeDetails(Employee employee) ;

	List<EmployeeModel> viewEmployeeDetails();

	public void edit(Employee employee);

	public void deleteEmployee(int id);

	public Employee findById(Employee employee);

}
