package com.deloitte.assignment.controller;

import java.io.IOException;	
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.deloitte.assignment.model.Employee;
import com.deloitte.assignment.model.EmployeeDao;
import com.deloitte.assignment.model.EmployementHistory;
import com.deloitte.assignment.service.EmployeeService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;


@Controller
public class MasterController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeDao employeeDao;
	
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		List<Employee> employees = employeeService.findAll();
		mav.addObject("employees", employees);
		return mav;	
	}
	
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public ModelAndView search(@Param("empId")Long empId, @Param("firstName")String firstName, @Param("lastName")String lastName, @ModelAttribute("emp") Employee employee) {
		ModelAndView mav = new ModelAndView("home");
		List<Employee> employees = new ArrayList<>();
		employees = employeeDao.search(empId, firstName, lastName);
		mav.addObject("employees",employees);
//		for(Employee e:employees)
//			System.out.println(e);
		return mav;
	}
	
	@RequestMapping(value="/history/{empId}")
	public ModelAndView history(@PathVariable("empId")Long empId) {
		ModelAndView mav = new ModelAndView("history");
		List<EmployementHistory> employees = new ArrayList<>();
		employees = employeeDao.searchHistory(empId);
		mav.addObject("employees",employees);
//		for(Employee e:employees)
//			System.out.println(e);
		return mav;
	}
	
//	@RequestMapping("/employee")
//	public String submitForm(@Valid @ModelAttribute("employee") Employee e, BindingResult br) {
//		if(br.hasErrors()) {
//			return "employee";
//		}
//		else {
//			return "redirect:/";
//		}
//	}
	
	@RequestMapping(value="/export",method=RequestMethod.GET)
	public void exportToCSV(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String currentDateTime = dateFormatter.format(new Date());
		 
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Employee_" + currentDateTime + ".csv";
		response.setHeader(headerKey, headerValue);
		 
		List<Employee> listUsers = employeeService.findAll();
		 
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		String[] csvHeader = {"Emp Id", "Name", "Doj", "Post", "Level","Mobile","Personal Mail","Office Mail","Dob",
		"Blood Group","Pan no","Aadhar no"};
		String[] nameMapping = {"empId", "firstName", "doj", "postName", "empLevel","mobileNum","emailId","officeMail","dob",
		"bloodGroup","panNum","aadharNum"};
		 
		csvWriter.writeHeader(csvHeader);
		 
		for (Employee user : listUsers) {
		csvWriter.write(user, nameMapping);
		}
		csvWriter.close();
	}




	
	@RequestMapping("/employee")
	public ModelAndView addExpense() {
		ModelAndView mav = new ModelAndView("employee");
		mav.addObject("employee", new Employee());
		return mav;
	}
	
	@RequestMapping(value="/employee", method=RequestMethod.POST)
	public String save(@Valid @ModelAttribute("employee")Employee employee, BindingResult br) {
		if(br.hasErrors()) {
			return "employee";
		}
		else {
			employeeService.save(employee);
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(value="/employee/{empId}")
	public ModelAndView edit(@PathVariable("empId")Long id) {
		ModelAndView mav = new ModelAndView("employee");
		Employee employee = employeeService.findById(id);
		mav.addObject("employee", employee);
		return mav;
	}
	
	@RequestMapping(value="/{empId}")
	public String delete(@PathVariable("empId")Long id) {
		employeeService.delete(id);
		return "redirect:/";
	}
}
