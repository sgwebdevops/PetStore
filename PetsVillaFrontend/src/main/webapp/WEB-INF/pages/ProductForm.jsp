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
	<h1 style="font-size:3.1vw;">Add Pet</h1>
	<form:form action="addProductProcess" method="post" modelAttribute="productObj" enctype="multipart/form-data">
		<div class="form-group">
			<label for="productName">Pet Name:</label>
				<form:input type="text" class="form-control" id="productName" placeholder="Enter Pet Name" path="productName"/>
				<form:errors style="color:red" path="productName"></form:errors>
				</div>
		<div class="form-group">
			<label for="productDescription">Pet Description:</label>
				<form:input type="text" class="form-control" id="productDescription" placeholder="Enter Pet Description" path="productDescription"/>
				<form:errors style="color:red" path="productDescription"></form:errors>
				</div>	
		<div class="form-group">
			<label for="productQuantity">Quantity:</label>
				<form:input type="number" class="form-control" id="productQuantity" placeholder="Enter Quantity" path="productQuantity"/>
				<form:errors style="color:red" path="productQuantity"></form:errors>
				</div>	
		<div class="form-group">
			<label for="productPrice">Price:</label>
				<form:input type="number" class="form-control" id="productPrice" placeholder="Enter Price" path="productPrice"/>
				<form:errors style="color:red" path="productPrice"></form:errors>
				</div>
				
		<div class="form-group">
  		<label for="categoryId">Category:</label>
    	<form:select path="categoryId" class="form-control">
    		<form:option value="0">-----Choose Category-----</form:option>
    		<c:forEach items="${sessionScope.categoryList}" var="categoryObj">
    			<form:option value="${categoryObj.categoryId}">${categoryObj.categoryName}</form:option>
    		</c:forEach>	
    	</form:select>
    	<form:errors style="color:red" path="categoryId"></form:errors>
	  	</div>
	  	<div class="form-group">
  		<label for="supplierId">Supplier:</label>
    	<form:select path="supplierId" class="form-control">
    		<form:option value="0">-----Choose Category-----</form:option>
    		<c:forEach items="${sessionScope.supplierList}" var="supplierObj">
    			<form:option value="${supplierObj.supplierId}">${supplierObj.supplierName}</form:option>
    		</c:forEach>	
    	</form:select>
    	<form:errors style="color:red" path="supplierId"></form:errors>
	  	</div>
	  	<div class="form-group">
	<label for="pimage2" class="col-md-4 control-label" > UploadImage :	</label>
	<div class="col-md-5">
	<form:input type="file" class="form-control" id="pImage"
			placeholder="Choose Image" path="pImage"/>
			<form:errors style="color:red" path="pImage"></form:errors>
	</div>
	</div>
	  	<button type="submit" class="btn btn-default">Add Pet</button>
		
	</form:form>
	</div>


<%@include file="Footer.jsp"%>