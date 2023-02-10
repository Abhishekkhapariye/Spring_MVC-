
package ksolves.demospringmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ksolves.demospringmvc.model.EmployeeModel;
import ksolves.demospringmvc.service.EmployeeServiceImpl;

@Controller
public class HomeController {

	@Autowired
	EmployeeServiceImpl employeeserviceimpl;

	@RequestMapping(value = "/")
	public ModelAndView test() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView test2() {
		EmployeeModel emp = new EmployeeModel();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("registration");
		mv.addObject("emp1", emp);
		return mv;
	}

}
