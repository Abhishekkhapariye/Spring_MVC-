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
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.update(employee);
		session.getTransaction().commit();
		session.close();

	}

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


  public Employee findEmpByEmpId( Employee employee){ 
	
	Session session=sessionfactory.openSession();
	Employee em= session.createNativeQuery("select * from  EMPLOYEE where id="+employee.getId(),Employee.class).getSingleResult();	
   System.out.print(em);
   return em;
  }
  

  public void editEmployee(Employee employee) { 
	  Session session=sessionfactory.openSession();
	  session.beginTransaction();
	  System.out.println("********"+employee+"*********");
	 // employee=findEmpByEmpId(employee);
	 // String sql = "UPDATE EMPLOYEE SET firstName="+ employee.getFirstName()+", lastName="+employee.getLastName()+", email="+employee.getEmail()+" WHERE id ="+employee.getId();
		/*
		 * Map m = new HashMap();
		 * 
		 * m.put("firsttName", employee.getFirstName()); m.put("lastName",
		 * employee.getLastName()); m.put("email", employee.getEmail());
		 */
     session.update(employee);
     session.getTransaction().commit();
     session.close();
		/*
		 * Session session=sessionfactory.openSession(); session.beginTransaction();
		 * Employee e= EmployeeDaoImpl.this.findEmpByEmpId(employee); //s m=
		 * session.createNativeQuery("update EMPLOYEE set firstName='"+e.setFirstName(
		 * "akash")+"', lastName="+e.setLastName("verma")+",email='"+e.setEmail("ak@345"
		 * )+"' where id="+e.getId()); e.setFirstName(employee.getFirstName());
		 * e.setLastName(employee.getLastName()); e.setEmail(employee.getEmail());
		 * 
		 * System.out.print(e); session.flush(); return e;
		 */
	 /*
		 * em.setFirstName(e.getFirstName()); em.setLastName(e.getLastName());
		 * em.setEmail(em.getEmail());
		 */
	//e= session.createNativeQuery("UPDATE EMPLOYEE SET firstName="+em.setFirstName(e.getFirstName())+",lastName="+em.setLastName(e.getLastName())+",email="+em.setEmail(e.getEmail())+" WHERE id="+id,Employee.class).getSingleResult();
	//e=session.createNativeQuery("UPDATE EMPLOYEE SET firstName='Abhi',lastName='Pawar',email='ak@123' WHERE id="+id,Employee.class).getSingleResult();
	
	
	
	/*
	 * String
	 * sql="update EMPLOYEE set firstName='"+em.getFirstName()+"', lastName="+em.
	 * getLastName()+",email='"+em.getEmail()+"' where id="+em.getId()+""; return
	 * session.update(sql);
	 */
	
  }
 
}