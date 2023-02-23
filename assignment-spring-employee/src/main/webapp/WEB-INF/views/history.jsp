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
<body bgcolor="E3EBEE">
		
	<br><br>
	<table class="center">	
		<tr>
			<th>Organization</th>
			<th>Period</th>
			<th>Location</th>
			<th>Post</th>
		</tr>
		<c:forEach var="employee" items="${employees}">
			<tr>
				<td>${employee.organizationName}</td>
				<td>${employee.fromDate}<br>${employee.untilDate}</td>
				<td>${employee.location}<br>${employee.country}</td>
				<td>${employee.post}</td>
					
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>