package ksolves.demospringmvc.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import ksolves.demospringmvc.CustumException.ApplicationException;
import ksolves.demospringmvc.Dao.EmployeeDao;
import ksolves.demospringmvc.Dao.EmployeeDaoImpl;
import ksolves.demospringmvc.entity.Employee;
import ksolves.demospringmvc.model.EmployeeModel;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeedao;

	/*
	 * @Override public void saveEmployeeDetails(Employee employee) {
	 * 
	 * employeedao.saveEmployee(employee);
	 * 
	 * }
	 */

	public List<EmployeeModel> viewEmployeeDetails() {
		List<EmployeeModel> emp1 = new ArrayList<EmployeeModel>();
		for (Employee emp : employeedao.viewEmployeeDetail()) {
			emp1.add(convertEntityToModel(emp));
			System.out.println(emp1);
		}
		return emp1;
	}

	@Override
	public Employee findById(Employee employee) {
		// TODO Auto-generated method stub
		return employeedao.findEmpByEmpId(employee);
	}

	public void deleteEmployee(int id) {
		employeedao.deleteEmployee(id);
	}

	public void edit(Employee employee) {
		employeedao.editEmployee(employee);
	}

	private Employee convertModelToEntity(EmployeeModel employeemodel) {

		Employee employee = new Employee();
		employee.setId(employeemodel.getId());
		employee.setFirstName(employeemodel.getFirstName());
		employee.setLastName(employeemodel.getLastName());
		employee.setEmail(employeemodel.getEmail());
		return employee;
	}

	private EmployeeModel convertEntityToModel(Employee employee) {
		EmployeeModel employeemodel = new EmployeeModel();
		employeemodel.setId(employee.getId());
		employeemodel.setFirstName(employee.getFirstName());
		employeemodel.setLastName(employee.getLastName());
		employeemodel.setEmail(employee.getEmail());
		return employeemodel;
	}

}
