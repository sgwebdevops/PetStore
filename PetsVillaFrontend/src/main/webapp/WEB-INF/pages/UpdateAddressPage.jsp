<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="Header.jsp"/>
<br/>
<br/>
	<h1>Update your Address</h1>
	<f:form action="${contextRoot}/updateAddressProcess" method="post" modelAttribute="addressObj">
	<div class="form-group">
      		<label for="addressId">Address Id:</label>
      		<f:input type="text" class="form-control" id="addressId" placeholder="Enter Address Id" path="addressId" readonly="true"/>
      	</div>
    	
		<div class="form-group">
      		<label for="addressLine1">Address Line 1:</label>
      		<f:input type="text" class="form-control" id="addressLine1" placeholder="Enter Address Line1" path="addressLine1"/>
      		<f:errors style="color:red" path="addressLine1"/>	
    	</div>
    	
    	<div class="form-group">
      		<label for="addressLine2">Address Line 2:</label>
      		<f:input type="text" class="form-control" id="addressLine2" placeholder="Enter Address Line2" path="addressLine2"/>
      		<f:errors style="color:red" path="addressLine2"/>	
    	</div>
    	
    	<div class="form-group">
      		<label for="city">City:</label>
      		<f:input type="text" class="form-control" id="city" placeholder="Enter City" path="city"/>
      		<f:errors style="color:red" path="city"/>	
    	</div>
    	
    	<div class="form-group">
      		<label for="state">State:</label>
      		<f:input type="text" class="form-control" id="state" placeholder="Enter State" path="state"/>
      		<f:errors style="color:red" path="state"/>	
    	</div>
    	
    	<div class="form-group">
      		<label for="pincode">Pin Code:</label>
      		<f:input type="text" class="form-control" id="pincode" placeholder="Enter Pin Code" path="pinCode"/>
      		<f:errors style="color:red" path="pinCode"/>	
    	</div>
    	
    	<button type="submit" class="btn btn-default">Update Address</button>
    </f:form>	
	</div>
<div style="margin-top:300px">

<%@include file="Footer.jsp"%>