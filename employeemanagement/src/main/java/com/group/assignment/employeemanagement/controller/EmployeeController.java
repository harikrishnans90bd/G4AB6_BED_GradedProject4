package com.group.assignment.employeemanagement.controller;

import java.util.List;

import com.group.assignment.employeemanagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.group.assignment.employeemanagement.services.EmployeeServices;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeServices service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Employee> listEmployee = service.listAll();
		model.addAttribute("listEmployee",listEmployee);
		return "index";
	}
	
	@RequestMapping("/new")
	public String newEmployeePage(Model model) {
		Employee employee=new Employee();
		model.addAttribute(employee);
		return "new_employee";
	}
	
	@RequestMapping(value = "/save", method =RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee ) {
		service.save(employee);
		return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditEmployeePage(@PathVariable (name="id") Long id) {
		ModelAndView mav=new ModelAndView("edit_employee");
		Employee employee=service.get(id);
		mav.addObject("employee",employee);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteEmployeePage(@PathVariable (name="id") Long id) {
		service.delete(id);
		return "redirect:/";
	}
	
}
