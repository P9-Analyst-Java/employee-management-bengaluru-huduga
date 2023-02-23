<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page isELIgnored="false" %>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<style>
		body{
			background-image: url("https://wallpaperaccess.com/full/449967.jpg");
			background-position: center center;
			background-repeat: no-repeat;
			background-attachment: fixed;
			background-size: 1440px;
		}
		hr{
			border: 2px solid black;
		}
		button {
			background-color: #5D6D7E; /* Green */
			border: 2px solid black;
			color: black;
			
			padding: 16px 32px;
			text-align: center;
			text-decoration: none;
			display: inline-block;
			font-size: 16px;
			margin: 4px 2px;
			transition-duration: 0.4s;
			cursor: pointer;
		}
		input{
			margin: 5px;
			width: 180px;
			padding: 4px;
			border: 1px solid black;
			border-radius: 7px;
		}
		.error{
			color: red;
		}
	</style>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body bgcolor="E3EBEE" align="center">
	<h1>Add/Edit Employee</h1>
	<hr>
	
	<form:form action="${contextRoot}/employee" method="post" modelAttribute="employee"><br>
	<table align="center">
		<tr>
			<td>Employee ID: <form:input path="empId"/></td>
			<td>First Name: <form:input path="firstName"/><br></td>
		</tr>
		<tr>
			<td>Last Name: <form:input path="lastName"/></td>
			<td>Gender: <form:input path="gender" placeholder="M/F"/><br></td>
		</tr>
			<td>Date Of Birth: <form:input path="dob" type="date" data-date-inline-picker="false" data-date-open-on-focus="true"/></td>
			<td>PAN Number: <form:input path="panNum"/><br></td>
		<tr>
			<td>Aadhaar Number: <form:input path="aadharNum"/></td>
			<td>Mobile Number: <form:input path="mobileNum"/><br></td>
		</tr>
		<tr>
			<td>Email ID: <form:input path="emailId"/></td>
			<td>Office Email: <form:input path="officeMail"/><br></td>
		</tr>
		<tr>
			<td>Permanent Address: <form:input path="permanentAddress"/></td>
			<td>Present Address: <form:input path="presentAddress"/><br></td>
		</tr>
		<tr>
			<td>Blood Group: <form:input path="bloodGroup"/></td>
			<td>Date Of Joining: <form:input path="doj" type="date" data-date-inline-picker="false" data-date-open-on-focus="true"/><br></td>

		</tr>
		<tr>
			<td>Employee Level: <form:input path="empLevel"/></td>
			<td>Post Name: <form:input path="postName"/><br></td>
		</tr>
		<tr>
			<td>Basic Pay: <form:input path="basicPay" type="number"/></td>
			<td>   Home Allowance: <form:input path="houseAllowance" type="number"/><br></td>
		</tr>
		<tr>
			<td><button type="submit">Submit</button></td>
			<td><button type="reset">Cancel</button></td>
		</tr>	
		<tr>
			<td><form:errors path="empId" cssClass="error"/></td>
			<td><form:errors path="firstName" cssClass="error"/></td>
			<td><form:errors path="lastName" cssClass="error"/></td>
			<td><form:errors path="gender" cssClass="error"/></td>
			<td><form:errors path="dob" cssClass="error"/></td>
			<td><form:errors path="panNum" cssClass="error"/></td>
			<td><form:errors path="aadharNum" cssClass="error"/></td>
			<td><form:errors path="mobileNum" cssClass="error"/></td>
			<td><form:errors path="emailId" cssClass="error"/></td>
			<td><form:errors path="officeMail" cssClass="error"/></td>
			<td><form:errors path="permanentAddress" cssClass="error"/></td>
			<td><form:errors path="presentAddress" cssClass="error"/></td>
			<td><form:errors path="bloodGroup" cssClass="error"/></td>
			<td><form:errors path="doj" cssClass="error"/></td>
			<td><form:errors path="empLevel" cssClass="error"/></td>
			<td><form:errors path="postName" cssClass="error"/></td>
			<td><form:errors path="basicPay" cssClass="error"/></td>
			<td><form:errors path="houseAllowance" cssClass="error"/></td>
		</tr>
	</table>
	</form:form>
	

</body>
</html>