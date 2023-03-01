package ksolves.demospringmvc.Dao;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.orm.hibernate5.HibernateTemplate;

import ksolves.demospringmvc.entity.Employee;
import ksolves.demospringmvc.model.EmployeeModel;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public List<Employee> viewEmployeeDetail() {
		Session session = sessionfactory.openSession();
		List<Employee> data = session.createNativeQuery("select * from employee", Employee.class).getResultList();
		return data;

	}

	public void deleteEmployee(Integer id) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Employee employee = new Employee();
		employee.setId(id);
		session.delete(employee);
		session.getTransaction().commit();
		session.close();

	}

	public Employee findEmpByEmpId(Employee employee) {

		Session session = sessionfactory.openSession();
		Employee em = session.createNativeQuery("select * from  EMPLOYEE where id=" + employee.getId(), Employee.class)
				.getSingleResult();
		if(viewEmployeeDetail().contains(em)!=true) {
			
			throw new NoResultException("Not in a record");
			}
		else
		System.out.print(em);
		return em;
	}

	public void editEmployee(Employee employee) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(employee);
		session.getTransaction().commit();
		session.close();

	}
	/*
	 * @Override public void saveEmployee(Employee employee) { // TODO
	 * Auto-generated method stub Session session = sessionfactory.openSession();
	 * session.beginTransaction(); session.save(employee); session.update(employee);
	 * session.getTransaction().commit(); session.close();
	 * 
	 * }
	 */

}
