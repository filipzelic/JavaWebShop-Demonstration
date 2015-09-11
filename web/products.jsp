<%-- 
    Document   : index
    Created on : Sep 9, 2015, 10:21:02 AM
    Author     : filipzelic
--%>

<%@include file="common/header.jsp" %>
	<body>
		<!----container---->
		<div class="container">
			<%@include file="common/top_header.jsp" %>
			<!----content---->
				<div class="content">
					<div class="container">
				<!----->
				<div class="special-products all-poroducts latest-products">
					<div class="s-products-head">
						<div class="s-products-head-left">
							<h3>MUSKA <span>OBUCA</span></h3>
						</div>
						<div class="clearfix"> </div>
					</div>
					<!----special-products-grids---->
					<div class="special-products-grids">
                                            <c:forEach items="${products}" var="product">
						<div class="col-md-3 special-products-grid text-center">
							<a class="product-here" href="products?id=${product.id}"><img src="${product.imageUrl}" title="product-name" /></a>
							<h4><a href="products?id=${product.id}">${product.name}</a></h4>
							<a class="product-btn" href="products?id=${product.id}"><span>${product.price}HRK</span><small>DETALJI</small><label> </label></a>
						</div>
                                            </c:forEach>
						<div class="clearfix"> </div>
					</div>
					<!---//special-products-grids---->
				</div>
				<!---//speical-products---->
				</div>
			<!----content---->
<%@include file="common/footer.jsp" %>



					