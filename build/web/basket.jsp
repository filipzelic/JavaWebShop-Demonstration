<%-- 
    Document   : basket
    Created on : Sep 11, 2015, 4:23:00 PM
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
					
				<div class="special-products all-poroducts latest-products">
					<div class="s-products-head">
						<div class="s-products-head-left">
							<h3>MOJA <span>KOSARA</span></h3>
						</div>
						<div class="clearfix"> </div>
					</div>
					<!----special-products-grids---->
					<div class="special-products-grids">
						
						<table class="cart-table">
							<tr>
								<th>Proizvod</th>
								<th width="100px">Kolicina</th>
								<th width="60px"> </th>
							</tr>
                                                        
                                                        <c:choose> 
                                                            <c:when test="${isEmptyBasket}">
                                                                <tr>
                                                                    <td>Nema proizvoda u kosarici!</td>
                                                                <tr>
                                                            </c:when>
                                                            <c:otherwise>
                                                              <c:forEach items="${productsInBasket}" var="item">
                                                                <tr>
                                                                        <td>${item.value.name}</td>
                                                                        <td>
                                                                                <select class="quantity-input">
                                                                                        <option>1</option>
                                                                                        <option>2</option>
                                                                                        <option>3</option>
                                                                                        <option>4</option>
                                                                                </select>
                                                                        </td>
                                                                        <td><a href="#" class="remove">X</a></td>
                                                                </tr>
                                                                </c:forEach>
                                                            </c:otherwise>
                                                          </c:choose>
                                                        <tr>
                                                            <td></td>
                                                            <td><input type="submit" value="Potvrdi narudzbu"></td>
                                                            <td></td>
							</tr>
						</table>
						
						<div class="clearfix"> </div>
					</div>
					<!---//special-products-grids---->
				</div>
				<!---//speical-products---->
				</div>
			<!----content---->
<%@include file="common/footer.jsp" %>