package com.deloitte.assignment.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="employement_history")
@Data
public class EmployementHistory {

	@Id
	private Long id;
	
	private Long empId;
	private String organizationName;
	private Date fromDate;
	private Date untilDate;
	private String location;
	private String country;
	private String post;
	private String skillUsed;
}
