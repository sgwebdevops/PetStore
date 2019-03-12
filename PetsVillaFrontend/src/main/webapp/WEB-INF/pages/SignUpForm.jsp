<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="Header.jsp"/>


<div class="container">
<c:if test="${not empty msg}">
		<div class="alert alert-success">${msg}</div>
	</c:if>
	<fieldset>
		<legend>SignUp Form</legend>
		<form:form action="${contextRoot}/register" method="post" modelAttribute="userObj">
       	
       	<div class="form-group">
    	<label for="email">Email : </label>
    	<form:input type="emailId" class="form-control" path="emailId"/>
    	<form:errors style="color:red" path="emailId"/>
		</div>
  
  		<div class="form-group">
  		<label for="firstName">First Name:</label>
    	<form:input type="text" class="form-control" path="firstName"/>
    	<form:errors style="color:red" path="firstName"/>
	  	</div>
	  	
	  	<div class="form-group">
  		<label for="lastName">Last Name:</label>
    	<form:input type="text" class="form-control" path="lastName"/>
    	<form:errors style="color:red" path="lastName"/>
	  	</div>
  	
  		<div class="form-group">
  		<label for="password">Password:</label>
    	<form:input type="password" class="form-control" id="password" path="password" />
    	<form:errors style="color:red" path="password"/>
    	</div>
    	
    	<div class="form-group">
  		<label for="confirmPassword">Confirm Password:</label>
    	<form:input type="password" class="form-control" id="confirmPassword" path="confirmPassword" />
    	<form:errors style="color:red" path="confirmPassword"/>
    	</div>
	  	
	  	<div class="form-group">
  		<label for="mobileNumber">Contact Number:</label>
    	<form:input type="text" class="form-control" path="mobileNumber"/>
    	<form:errors style="color:red" path="mobileNumber"/>
    	</div>
	  	
	  		<button type="submit" class="btn btn-primary">Register User</button>
	  </form:form>	
	</fieldset>
</div>

<br/><br/>
<jsp:include page="Footer.jsp"/>

<!-- <script>
var check = function() {
	  if (document.getElementById('password').value ==
	    document.getElementById('confirmPassword').value) {
	    document.getElementById('message').style.color = 'green';
	    document.getElementById('message').innerHTML = 'matching';
	  } else {
	    document.getElementById('message').style.color = 'red';
	    document.getElementById('message').innerHTML = 'not matching';
	  }
	}
</script> -->