<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!------ Include the above in your HEAD tag ---------->

<%@include file="Header.jsp"%>
</br>
</br>


<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<div class="container">
	<c:choose>
		<c:when test="${not empty msg}">
			${msg}
		</c:when>
		<c:otherwise>
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${cartItems}" var="item">
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"><img src="${images}/${item.product.imgName}" alt="${item.product.imgName}" class="img-responsive"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin">${item.product.productName}</h4>
										<p>${item.product.productDescription}</p>
									</div>
								</div>
							</td>
							<td data-th="Price">${item.price}</td>
							<td data-th="Quantity">
								
								<a class="btn btn-primary" href="${contextRoot}/decreaseQuantity/${item.itemId}">-</a>
								
								<input type="text" class="form-control text-center" value="${item.quantity}">
									<%-- <c:choose>
    									<c:when test="${item.product.quantity<item.quantity}">
      										<input type="button" value="+" disabled="disabled"/>
    									</c:when>
    									<c:otherwise>
     									 	<input type="button" value="+" onclick="${contextRoot}/increaseQuantity/${item.itemId}/${item.product.productId}" />
   										 </c:otherwise>
 									</c:choose> --%>

							<a class="btn btn-primary" href="${contextRoot}/increaseQuantity/${item.itemId}/${item.product.productId}">+</a>
								
							</td>
							<td data-th="Subtotal" class="text-center">${item.quantity*item.price}</td>
							<td> <a href="${contextRoot}/deleteItem/${item.itemId}" class="btn btn-info btn-sm"> <span class="glyphicon glyphicon-trash"></span></a>								
							</td>
						</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>${total}</strong></td>
						</tr>
						
						<tr>
							<td><a href="<c:url value="/" />" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>${total}</strong></td>
							<td><a href="${contextRoot}/getAddressPage" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
						</tr>
					</tfoot>
				</table>
				 </c:otherwise>
	</c:choose>
</div>

<%@include file="Footer.jsp" %>

<style>
.table>tbody>tr>td, .table>tfoot>tr>td{
    vertical-align: middle;
}
@media screen and (max-width: 600px) {
    table#cart tbody td .form-control{
		width:20%;
		display: inline !important;
	}
	.actions .btn{
		width:36%;
		margin:1.5em 0;
	}
	
	.actions .btn-info{
		float:left;
	}
	.actions .btn-danger{
		float:right;
	}
	
	table#cart thead { display: none; }
	table#cart tbody td { display: block; padding: .6rem; min-width:320px;}
	table#cart tbody tr td:first-child { background: #333; color: #fff; }
	table#cart tbody td:before {
		content: attr(data-th); font-weight: bold;
		display: inline-block; width: 8rem;
	}
	
	
	
	table#cart tfoot td{display:block; }
	table#cart tfoot td .btn{display:block;}
	
}
</style>