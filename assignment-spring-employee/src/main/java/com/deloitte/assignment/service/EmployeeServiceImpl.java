package com.deloitte.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.assignment.model.Employee;
import com.deloitte.assignment.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee findById(Long id) {
		if(employeeRepository.findById(id).isPresent()) {
			return employeeRepository.findById(id).get();
			
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Employee employee = findById(id);
		employeeRepository.delete(employee);
	}

//	@Override
//	public List<Employee> searchById(int employeeId) {
//		return employeeRepository.searchById(employeeId);
//	}

}
