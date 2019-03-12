<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="Header.jsp"/>

	<div class="container">
	<h1 style="font-size:3.1vw;">Update Category</h1>
	<form:form action="${contextRoot}/updateProductProcess" method="post" modelAttribute="productObj" enctype="multipart/form-data">
		<div class="form-group">
      		<label for="productId">Product Id:</label>
      		<form:input type="text" class="form-control" id="productId" placeholder="Enter Product Id" path="productId" readonly="true"/>
    	</div>
		<div class="form-group">
      		<label for="productName">Product Name:</label>
      		<form:input type="text" class="form-control" id="productName" placeholder="Enter Product Name" path="productName"/>
    	</div>
    	<div class="form-group">
      		<label for="productDescription">Product Description:</label>
      		<form:input type="text" class="form-control" id="productDescription" placeholder="Enter Product Description" path="productDescription"/>
    	</div>
    	
    	<div class="form-group">
      		<label for="productQuantity">Product Description:</label>
      		<form:input type="number" class="form-control" id="productQuantity" placeholder="Enter Product Quantity" path="productQuantity"/>
    	</div>
    	
    	<div class="form-group">
      		<label for="productPrice">Product Description:</label>
      		<form:input type="number" class="form-control" id="productPrice" placeholder="Enter Product Price" path="productPrice"/>
    	</div>
    	
    	<div class="form-group">
  		<label for="categoryId">CategoryId:</label>
    	<form:select path="categoryId" class="form-control">
    		<form:option value="0">-----Select Category-----</form:option>
    		<c:forEach items="${sessionScope.categoryList}" var="categoryObj">
    			<form:option value="${categoryObj.categoryId}">${categoryObj.categoryName}</form:option>
    		</c:forEach>	
    	</form:select>
	  	</div>
	  	
	  	<div class="form-group">
  		<label for="supplierId">CategoryId:</label>
    	<form:select path="supplierId" class="form-control">
    		<form:option value="0">-----Select Supplier-----</form:option>
    		<c:forEach items="${sessionScope.supplierList}" var="supplierObj">
    			<form:option value="${supplierObj.supplierId}">${supplierObj.supplierName}</form:option>
    		</c:forEach>	
    	</form:select>
	  	</div>

	  	<div class="form-group">
	<label for="pimage2" class="col-md-4 control-label" > UploadImage :	</label>
	<div class="col-md-5">
	<form:input type="file" class="form-control" id="pImage"
			placeholder="Choose Image" path="pImage"/>
	</div>
	</div>
    	<button type="submit" class="btn btn-default">Update Category</button>
    </form:form>
	</div>
<div style="margin-top:300px">

</div>

<%@include file="Footer.jsp"%>