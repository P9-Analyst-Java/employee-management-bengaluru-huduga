package com.deloitte.assignment.model;

import java.util.List;



public interface EmployeeDao {

	List<Employee> search(Long empId, String firstName, String lastName);
	List<EmployementHistory> searchHistory(Long empId);
}
