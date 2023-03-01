package ksolves.demospringmvc.CustumException;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import ksolves.demospringmvc.entity.Employee;

@RestControllerAdvice
public class ApplicationException 
{
	
	 @ExceptionHandler(ConstraintViolationException.class)
	 public ModelAndView handleInvalidArgument(ConstraintViolationException ex) {
		 ModelAndView mv = new ModelAndView();
		 Employee emp=new Employee();
		 Map<String, String> errormsg = new HashMap<>();
		  
	       
	            errormsg.put(ex.getLocalizedMessage() ,  ex.getMessage());

	            
	            mv.setViewName("registration");
	    		mv.addObject("emp1", errormsg);
	        
	        return new ModelAndView("register");
	      
			}
	
	
			@ExceptionHandler(NoResultException.class)
			public ModelAndView handleNoRecordException(NoResultException exc) {
				ModelAndView mv=new ModelAndView();
				
		            mv.setViewName("page");
		    		mv.addObject("emp1", exc.getMessage());
		        
		        return mv;
		      
				
			}
	 }

