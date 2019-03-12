<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="Header.jsp" %>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="container">
	<div class="row text-center">
        <div class="col-sm-6 col-sm-offset-3">
        <br><br> <h2 style="color:#0fad00">Success</h2>
        <img src="${images}/Success.gif" width = 25% height = 25%>
        <h3>Dear, ${name} </h3>
        <p style="font-size:20px;color:#5C5C5C;">Thank you. Payment Successful. Your Order will reach you within a week.</p>
        <a href="<c:url value="/" />" class="btn btn-success"> � � Shop more  � � </a>
    <br><br>
        </div>
        
	</div>
</div>

<%@include file="Footer.jsp" %>