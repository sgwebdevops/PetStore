<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="secure" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" scope="application"/>
<spring:url value="/resource/images" var="images" scope="session" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pet's Villa</title>
<meta charset="utf-8">


	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="css//footer.css">  
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


<style>
.dropbtn {
  background-color: black;
  color: white;
  padding: 15px;
  font-size: 14px;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 125px;
  /* box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2); */
  z-index: 1;
}
.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #3e8e41;}
</style>


</head>
<body>
<!-- Begin Navbar -->
<div id="nav">
  <div class="navbar navbar-inverse navbar-fixed-top" data-spy="affix" data-offset-top="100">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<c:url value="/" />"><img class="img-responsive logo" src="<c:url value="/resource/images/logo.png"/>" alt="Pet's Villa"></a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">

          <ul class="nav navbar-nav navbar-center">
          
            <li class="active"><a href="<c:url value="/" />">Home</a>
            <li>
            <div class="dropdown">
  				<button class="dropbtn">Pets With us</button>
 			 		<div class="dropdown-content">
  			  			<c:forEach items="${sessionScope.categoryList}" var="categoryObj">
          				<a href="${contextRoot}/getAllProductsByCategory/${categoryObj.categoryId}">${categoryObj.categoryName}</a>
          				</c:forEach>
			  		</div>
			</div></li>
			
			
			<secure:authorize access="hasAuthority('Admin')">
            <li>
            <div class="dropdown">
  				<button class="dropbtn">Category</button>
 			 		<div class="dropdown-content">
  			  			<a href="<c:url value="/addCategory" />">Add Category</a>
   			  			<a href="<c:url value="/viewAllCategories" />">View All Categories</a>
			  		</div>
			</div></li>
			<li>
            <div class="dropdown">
  				<button class="dropbtn">Supplier</button>
 			 		<div class="dropdown-content">
  			  			<a href="<c:url value="/addSupplier" />">Add Supplier</a>
   			  			<a href="<c:url value="/viewAllSuppliers" />">View All Suppliers</a>
			  		</div>
			</div></li>
			 <li>
            <div class="dropdown">
  				<button class="dropbtn">Pets</button>
 			 		<div class="dropdown-content">
  			  			<a href="<c:url value="/addProduct" />">Add Pet</a>
   			  			<a href="<c:url value="/viewAllProducts" />">View All Pets</a>
			  		</div>
			</div></li>
			</secure:authorize>
			
            <li><a href="#about">About</a>
            </li>
            <li><a href="#contact">Contact</a>
            </li>
          </ul>
        </div>
         <ul class="nav navbar-nav navbar-right">
         <secure:authorize access="hasAuthority('User')">
          <a href="${contextRoot}/viewCart" class="btn btn-info btn-sm">
          <span class="glyphicon glyphicon-shopping-cart"></span> View Cart ${totalItems}
        </a>
         </secure:authorize>
         
        <secure:authorize access="isAnonymous()">
        <li><a href="${contextRoot}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        <li><a href="${contextRoot}/registerUser"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        </secure:authorize>
        </br>
        <secure:authorize access="isAuthenticated()">
        <li style="color:white">Welcome : <span class="glyphicon glyphicon-user"></span> ${sessionScope.userObj.firstName} ${sessionScope.userObj.lastName}</li>
        <li><a href="${contextRoot}/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </secure:authorize>
        </ul>
        <!--/.nav-collapse -->
      </div>
      <!--/.contatiner -->
</div>
</div>
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        </div></div>        




 