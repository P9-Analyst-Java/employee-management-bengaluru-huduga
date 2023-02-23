package com.deloitte.assignment.model;

import java.sql.Blob;
import java.sql.Date;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name="employees")
@Data
public class Employee {
	@Id
	@Column(name="emp_id")
	@NotNull(message="Employee ID cannot be empty!")
	private Long empId;
	
	@Column(name="first_name")
	@Pattern(regexp="^[A-Za-z]*$", message="Name must contain only alphabets!")
	@Size(min=1, max=50, message="Name must be between 1 and 50 characters!")
	@NotBlank(message="First name cannot be blank")
	private String firstName;
	
	@Column(name="last_name")
	@Pattern(regexp="^[A-Za-z]*$", message="Name must contain only alphabets!")
	@Size(min=1, max=50, message="Name must be between 1 and 50 characters!")
	@NotBlank(message="Last name cannot be blank")
	private String lastName;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="pan_num")
	@Pattern(regexp="^[A-Za-z0-9]*$", message="Pan Number must contain only alphanumeric characters!")
	@Size(min=10, max=10, message="Pan Number must contain only 10 digits!")
	@NotBlank(message="Pan Number cannot be blank")
	private String panNum;
	
	@Column(name="aadhar_num")
	@Pattern(regexp="^[0-9]*$", message="Aadhaar Number must contain only numeric characters!")
	@Size(min=12, max=12, message="Aadhaar Number must contain only 10 digits!")
	@NotBlank(message="Aadhaar Number cannot be blank")
	private String aadharNum;
	
	@Column(name="mobile_num")
	@Pattern(regexp="^[0-9]*$", message="Mobile Number must contain only numeric characters!")
	@Size(min=10, max=10, message="Mobile Number must contain only 10 digits!")
	@NotBlank(message="Mobile cannot be blank")
	private String mobileNum;
	
	@Column(name="email_id")
	@Email(message="Email ID must be of valid format!")
	@NotBlank(message="Email ID cannot be blank")
	private String emailId;
	
	@Column(name="office_mail")
	@Email(message="Email ID must be of valid format!")
	@NotBlank(message="Email ID cannot be blank")
	private String officeMail;
	
	@Column(name="permanent_address")
	@Size(max=200, message="Address must not exceed 200 characters!")
	@NotBlank(message="Address cannot be blank")
	private String permanentAddress;
	
	@Column(name="present_address")
	@Size(max=200, message="Address must not exceed 200 characters!")
	@NotBlank(message="Address cannot be blank")
	private String presentAddress;
	
	@Column(name="blood_group")
	@Pattern(regexp="^(A|B|AB|O)[+-]$", message="Blood group must be of a valid format!")
	@NotBlank(message="Blood group cannot be blank")
	private String bloodGroup;
	
	@Column(name="profile_pict")
	private Blob profilePict;
	
	@Column(name="doj")
	private Date doj;
	
	@Column(name="emp_level")
	@NotNull(message="Employement level cannot be blank")
	@Min(value=1, message="Employement level must be greater than 1")
	@Max(value=20, message="Employement level must be lesser than 20")
	private Long empLevel;
	
	@Column(name="post_name")
	@NotBlank(message="Post name cannot be blank")
	@Size(max=30, message="Post cannot exceed 30 characters!")
	@Pattern(regexp="^[A-Za-z]*|[\\s]*$", message="Post name must be alphabets and space only!")
	private String postName;
	
	@Column(name="basic_pay")
	@NotNull(message="Basic pay cannot be blank")
	@Min(value=10000, message="Basic pay must be greater than 10000")
	@Max(value=99999999, message="Basic pay must be lesser than 99999999")
	private Long basicPay;
	
	@Column(name="house_allowance")
	@NotNull(message="House allowance cannot be blank")
	@Min(value=1000, message="House allowance must be greater than 1000")
	@Max(value=99999, message="House allowance must be lesser than 99999")
	private Long houseAllowance;
	
	@Column(name="gender")
	@Pattern(regexp="^M$|^F$|^ND$", message="Gender must be M, F or ND only!")
	@NotBlank(message="Gender cannot be blank")
	private String gender;

	

	public Employee() {
		super();
	}
	
	
}
