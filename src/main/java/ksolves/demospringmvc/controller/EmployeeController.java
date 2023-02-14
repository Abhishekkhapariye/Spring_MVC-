package ksolves.demospringmvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ksolves.demospringmvc.CustumException.ApplicationException;
import ksolves.demospringmvc.Dao.EmployeeDaoImpl;
import ksolves.demospringmvc.entity.Employee;
import ksolves.demospringmvc.model.EmployeeModel;
import ksolves.demospringmvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeservice;

	@Autowired
	SessionFactory sessionfactory;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveRepo(@Valid @ModelAttribute("emp1") Employee employee,Errors error) {
		if (error.hasErrors()) {
			return new ModelAndView("registration");
		}

		else
			employeservice.edit(employee);

		return new ModelAndView("save");
	}
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ModelAndView getEmp(Employee employee) throws IOException {
		EmployeeModel emplist = new EmployeeModel();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view");
		mv.addObject("emplist1", emplist);
		return mv;
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView viewEmp() throws IOException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view");
		mv.addObject("listEmployees", employeservice.viewEmployeeDetails());
		return mv;

	}
	/*
	 * @RequestMapping(value = "/find/{freeText}") public ModelAndView
	 * searchEm(Model m, HttpSession session, ("freeText") Integer freeText) {
	 * Integer id = (Integer) session.getAttribute("id"); Employee e = new
	 * Employee(); m.addAttribute("freeText", employeservice.findById(e));
	 * ModelAndView mv = new ModelAndView(); mv.setViewName("page");
	 * mv.addObject("em", m);
	 * 
	 * return mv;// jsp page
	 * 
	 * }
	 */

	@RequestMapping(value = "/find/{id}")
	public ModelAndView findById(@PathVariable("id") @ModelAttribute("emp") Integer id) {
		ModelAndView mv = new ModelAndView();
		Employee em = new Employee();
		em.setId(id);
		mv.setViewName("page");
		mv.addObject("em", employeservice.findById(em));

		return mv;

	}

	@RequestMapping(value = "/delete")
	public ModelAndView deleteEmployee(@RequestParam("id") int id) throws IOException {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("show");
		mv.addObject("emp1", id);
		employeservice.deleteEmployee(id);
		return mv;

	}

	@RequestMapping(value = "/edit")
	public String editEmployee(Model m, @RequestParam("id") Integer id, Employee e) {
		Session session = sessionfactory.openSession();
		ModelAndView mv = new ModelAndView();
		Employee em = new Employee();
		em = employeservice.findById(e);
		m.addAttribute("emp1", em);

		employeservice.edit(em);

		return "edit";

	}

}
