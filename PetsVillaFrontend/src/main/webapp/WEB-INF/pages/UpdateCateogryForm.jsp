<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="Header.jsp"/>

	<div class="container">
	<h1 style="font-size:3.1vw;">Update Category</h1>
	<form:form action="${contextRoot}/updateCategoryProcess" method="post" modelAttribute="categoryObj">
		<div class="form-group">
      		<label for="categoryId">Category Id:</label>
      		<form:input type="text" class="form-control" id="categoryName" placeholder="Enter Category Id" path="categoryId" readonly="true"/>
    	</div>
		<div class="form-group">
      		<label for="categoryName">Category Name:</label>
      		<form:input type="text" class="form-control" id="categoryName" placeholder="Enter Category Name" path="categoryName"/>
    	</div>
    	<div class="form-group">
      		<label for="categoryDesc">Category Description:</label>
      		<form:input type="text" class="form-control" id="categorydesc" placeholder="Enter Category Description" path="categoryDescription"/>
    	</div>
    	<button type="submit" class="btn btn-default">Update Category</button>
    </form:form>
	</div>
<div style="margin-top:300px">

</div>

<%@include file="Footer.jsp"%>