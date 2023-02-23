package com.deloitte.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deloitte.assignment.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	List<Employee> findAll();
	
//	@Query(value="select * from employees where emp_id = :employeeId", nativeQuery = true)
//	List<Employee> searchById(int employeeId);
}



