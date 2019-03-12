<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pet's Villa-Suppliers List</title>
</head>
<body>

<%@include file="Header.jsp"%>

	<div align="center" style="color: blue">
		<h2 style="font-size:3.1vw;">Pets Suppliers with Us</h2>
	</div>

	<div align="center" style=font-family:"Georgia", Georgia, serif;color:blue>
		<table class="table">
			<c:if test="${not empty msg}">
				<h3 style="color: green">${msg}</h3>
			</c:if>
			<thead class="thead-dark">
				<tr>
					<th scope="col">Supplier Id</th>
					<th scope="col">Supplier Name</th>
					<th scope="col">Supplier Address</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.supplierList}" var="supplierObj">
					<tr>
						<td>${supplierObj.supplierId}</td>
						<td>${supplierObj.supplierName}</td>
						<td>${supplierObj.supplierAddress}</td>
						<td><a href="${contextRoot}/updateSupplier/${supplierObj.supplierId}" class="btn btn-info btn-md"><span class="glyphicon glyphicon-pencil"></span>Update</a></td>
						<td><a href="${contextRoot}/deleteSupplier/${supplierObj.supplierId}" class="btn btn-info btn-md"><span class="glyphicon glyphicon-remove"></span>Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

<%@include file="Footer.jsp"%>