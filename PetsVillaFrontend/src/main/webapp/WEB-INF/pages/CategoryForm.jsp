<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pet's Villa-Category Form</title>
</head>
<!-- <body> -->

<%@include file="Header.jsp"%>

<div class="container">
	<h1 style="font-size:3.1vw;">Add Category</h1>
	<form:form action="addCategoryProcess" method="post" modelAttribute="categoryObj">
		<div class="form-group">
			<label for="categoryName">Category Name:</label>
				<form:input type="text" class="form-control" id="categoryName" placeholder="Enter Category Name" path="categoryName"/>
				<form:errors style="color:red" path="categoryName"></form:errors>
				</div>
				<div class="form-group">
			<label for="categoryDescription">Category Description:</label>
				<form:input type="text" class="form-control" id="categoryDescription" placeholder="Enter Category Description" path="categoryDescription"/>
				<form:errors style="color:red" path="categoryDescription"></form:errors>
				</div>
		
			<button type="submit" class="btn btn-default">Add Category</button>
				
	</form:form>
	</div>

<%@include file="Footer.jsp"%>