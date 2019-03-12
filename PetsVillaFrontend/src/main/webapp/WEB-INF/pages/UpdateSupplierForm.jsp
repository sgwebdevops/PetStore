<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pet's Villa-Supplier Update</title>
</head>
<body>

<jsp:include page="Header.jsp"/>

	<div class="container">
	<h1 style="font-size:3.1vw;">Update Category</h1>
	<form:form action="${contextRoot}/updateSupplierProcess" method="post" modelAttribute="supplierObj">
		<div class="form-group">
      		<label for="supplierId">Supplier Id:</label>
      		<form:input type="text" class="form-control" id="supplierId" placeholder="Enter Supplier Id" path="supplierId" readonly="true"/>
    	</div>
		<div class="form-group">
      		<label for="supplierName">Category Name:</label>
      		<form:input type="text" class="form-control" id="SupplierName" placeholder="Enter Supplier Name" path="supplierName"/>
    	</div>
    	<div class="form-group">
      		<label for="supplierAddress">Category Description:</label>
      		<form:input type="text" class="form-control" id="supplierAddress" placeholder="Enter Supplier Address" path="supplierAddress"/>
    	</div>
    	<button type="submit" class="btn btn-default">Update Category</button>
    </form:form>
	</div>
<div style="margin-top:300px">

</div>

<%@include file="Footer.jsp"%>