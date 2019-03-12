<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pet's Villa-Supplier Form</title>
</head>
<body>


<%@include file="Header.jsp"%>

<div class="container">
	<h1 style="font-size:3.1vw;">Add Supplier</h1>
	<form:form action="addSupplierProcess" method="post" modelAttribute="supplierObj">
		
		<div class="form-group">
			<label for="supplierName">Supplier Name:</label>
				<form:input type="text" class="form-control" id="supplierName" placeholder="Enter Supplier Name" path="supplierName"/>
				<form:errors style="color:red" path="supplierName"></form:errors>
				</div>	
				<div class="form-group">
			<label for="supplierAddress">Supplier Address:</label>
				<form:input type="text" class="form-control" id="supplierAddress" placeholder="Enter Supplier Address" path="supplierAddress"/>
				<form:errors style="color:red" path="supplierAddress"></form:errors>
				</div>
				<button type="submit" class="btn btn-default">Add Supplier</button>
			
	</form:form>
	</div>


<%@include file="Footer.jsp"%>