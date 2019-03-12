<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="Header.jsp"/>

	<div class="container">
</br></br>
<div>
		<c:if test="${not empty addressObj}">
                    <tr>
                    <h3>
                    	<td>To be Delivered at : </td></h3>
                    	<td></td>
                    	<h4>
                    	<td>${addressObj.addressLine1} ${addressObj.addressLine2}</td>
                    	<td>${addressObj.city} ${addressObj.state} ${addressObj.pinCode}</td><h4>
                    	<div align="right">
                    	 <a href="${contextRoot}/getAddressPage" class="btn btn-info">Change the Address</a>
                    	 </div>
                    </tr>
                    </c:if>
                    
                   
</div>
                    
     <div>
     <table id="order" class="table table-hover table-condensed">
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
	<%-- <c:set var="grandTotal" value="${0}"/> --%>
	<c:forEach items="${sessionScope.cartItemList}" var="cartItem">
	<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"><img src="${images}/${cartItem.product.imgName}" alt="${cartItem.product.imgName}" class="img-responsive"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin">${cartItem.product.productName}</h4>
										<p>${cartItem.product.productDescription}</p>
									</div>
								</div>
							</td>
							<td data-th="Price">${cartItem.price}</td>
							<td data-th="Quantity">${cartItem.quantity}</td>
							<c:set var="SubTotal" value="${cartItem.quantity*cartItem.price}" />
							<td data-th="Subtotal" class="text-center">${SubTotal}</td>
							<c:set var="grandTotal" value="${grandTotal + subTotal}" />
							</tr>
							
	</c:forEach>
	
	<%-- <tr>
	<td><strong> Total Amount to be Paid : ${grandTotal}</strong></td>
						</tr> --%>
	</tbody>
	</table>
	<div align="left">
	<a href="${contextRoot}/viewCart" class="btn btn-info">Edit Cart Items</a>
	</div>
	<div align="right">
	<strong> Total Amount to be Paid : ${grandTotal}</strong>
	<br/><br/>
	<a href="${contextRoot}/payment" class="btn btn-primary btn-md">Proceed to Payment <i class="fa fa-angle-right"></i></a>
	</div>
	
	
	
	</div>
<div style="margin-top:300px">
<jsp:include page="Footer.jsp"/>
</div>

style>
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