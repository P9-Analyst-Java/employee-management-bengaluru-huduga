package com.deloitte.assignment.service;

import java.util.List;
import com.deloitte.assignment.model.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	void save(Employee employee);
	Employee findById(Long id);
	void delete(Long id);
//	List<Employee> searchById(int employeeId);
}
