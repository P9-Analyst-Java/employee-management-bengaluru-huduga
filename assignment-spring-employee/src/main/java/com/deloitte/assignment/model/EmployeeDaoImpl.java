package com.deloitte.assignment.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Employee> search(Long empId, String firstName, String lastName) {
		if(empId!=null)
			return jdbcTemplate.query("select * from employees where emp_id = "+empId+"", new BeanPropertyRowMapper<Employee>(Employee.class));
		else
			return jdbcTemplate.query("select * from employees where first_name LIKE '%"+firstName+"%' AND last_name LIKE '%"+lastName+"%'", new BeanPropertyRowMapper<Employee>(Employee.class));

	}

	@Override
	public List<EmployementHistory> searchHistory(Long empId) {
		return jdbcTemplate.query("select * from employement_history where emp_id = "+empId+"", new BeanPropertyRowMapper<EmployementHistory>(EmployementHistory.class));
	}

}
