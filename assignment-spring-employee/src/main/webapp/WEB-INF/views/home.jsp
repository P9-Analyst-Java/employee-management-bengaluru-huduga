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
		table{
			width: 1100px;
			border: 3px solid black;
			border-collapse: collapse;
			background-color: #dfe3ee;
		}
		hr{
			border: 2px solid black;
		}
		body{
			background-image: url("https://wallpaperaccess.com/full/449967.jpg");
			background-position: center center;
			background-repeat: no-repeat;
			background-attachment: fixed;
			background-size: 1440px;
		}
		
		a.button {
			background-color: #5D6D7E;
			border: 2px solid black;
			color: black;
			padding: 16px 32px;
			border-radius: 6px;
			text-align: center;
			text-decoration: none;
			display: inline-block;
			font-size: 16px;
			margin: 4px 2px;
			transition-duration: 0.4s;
			cursor: pointer;
		}


		th{
			background-color: #5D6D7E;
			
		}
		th, td{
			padding: 12px;
			border: 2px solid black;
		}
		table.center {
			margin-left: auto;
			margin-right: auto;
		}
	</style>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body bgcolor="BFACE2">
	<h1 align="center">Employee Search List Screen</h1>
	<hr>
	<br><br>
	<h3 align="center">Search for an employee: </h3>
	<form action="/search" method="post" align="center">
	Employee ID: <input type="number" id="empId" name="empId"/>
	First Name: <input type="text" id="firstName" name="firstName"/>
	Last Name: <input type="text" id="lastName" name="lastName"/>
	<button type="submit" value="submit">Submit</button>
	</form>


	
	
	<br><br>
	<table class="center">	
		<tr>
			<th>Employee</th>
			<th>Contact</th>
			<th>Level & Post</th>
			<th>Action</th>
		</tr>
		<c:forEach var="employee" items="${employees}">
			<tr>
				<td>#${employee.empId}<br>${employee.firstName} ${employee.lastName}</td>
				<td>${employee.mobileNum}<br>${employee.emailId}</td>
				<td>${employee.empLevel}<br>${employee.postName}</td>
				<td><a href="${contextRoot}/employee/${employee.empId}">Edit</a>/
					<a href="${contextRoot}/${employee.empId}">Delete</a>/
					<a href="${contextRoot}/history/${employee.empId}">History</a></td>
			</tr>
		</c:forEach>
	</table>
	<br><br>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
	<a href="${contextRoot}/employee" class="button">Add New Employee</a>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  
	<a href="${contextRoot}/export" class="button">Download</a>
</body>
</html>