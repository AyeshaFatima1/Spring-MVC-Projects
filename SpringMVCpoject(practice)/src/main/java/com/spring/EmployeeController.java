package com.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;
	
	@RequestMapping("/")
	public String homePage(Model model) {
		List<Employee> employees=employeeService.listAll();
		model.addAttribute("employees", employees);
		return "homePage";
	}
	@RequestMapping("/new")
	public String newEmployeeDetails(Model model) {
		Employee emp=new Employee();
		model.addAttribute("emp",emp);
		return "newEmployee";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveEmployeeDetails(@ModelAttribute("emp") Employee emp) {
		employeeService.addEmployee(emp);
		return "redirect:/";
	}
	@RequestMapping("/delete/{id}")
	public String deleteEmployeeDetails(@PathVariable(name="id") Integer id) {
		employeeService.deleteEmployee(id);
		return "redirect:/";
	}
	
}
