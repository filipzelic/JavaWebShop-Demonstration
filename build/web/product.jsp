<%-- 
    Document   : product
    Created on : Sep 10, 2015, 2:50:16 PM
    Author     : filipzelic
--%>

<%@include file="common/header.jsp" %>
	<body>
		<!----container---->
		<div class="container">
                        <%@include file="common/top_header.jsp" %>
			<!----content---->
				<!----product-details--->
				<div class="product-details">
					<div class="container">
					<div class="product-details-row1">
						<div class="product-details-row1-head">
							<h2>${product.name}</h2>
							<p>${product.shortDescription}</p>
						</div>
						<div class="col-md-4 product-details-row1-col1">
							<!----details-product-slider--->
						<!-- Include the Etalage files -->
							<link rel="stylesheet" href="css/etalage.css">
							<script src="js/jquery.etalage.min.js"></script>
						<!-- Include the Etalage files -->
						<script>
								jQuery(document).ready(function($){
					
									$('#etalage').etalage({
										thumb_image_width: 300,
										thumb_image_height: 400,
										source_image_width: 900,
										source_image_height: 1000,
										show_hint: true,
										click_callback: function(image_anchor, instance_id){
											alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
										}
									});
									// This is for the dropdown list example:
									$('.dropdownlist').change(function(){
										etalage_show( $(this).find('option:selected').attr('class') );
									});
		
							});
						</script>
						<!----//details-product-slider--->
						<div class="details-left">
							<div class="details-left-slider">
								<ul id="etalage">
									<li>
										<a href="optionallink.html">
											<img class="etalage_thumb_image" src="${product.imageUrl}" />
											<img class="etalage_source_image" src="${product.imageUrl}" />
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-md-8 product-details-row1-col2">
						<div class="product-price">
							<div class="product-price-left text-right">
								<h5>${product.price}HRK</h5>
							</div>
							<div class="product-price-right">
								<a href="#"><span> </span></a>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="product-price-details">
                                                    <form id="RegistrationForm" name="ProductForm" action="basket?add=true" method="Post">
                                                        <input type="hidden" name="productId" value="${product.id}" >
							<p class="text-right">${product.longDescription}</p>
							<a class="shipping" href="#"><span> </span>Besplatna dostava</a>
							<div class="clearfix"> </div>
							<div class="product-size-qty">
								<div class="pro-qty">
									<span>Kolicina:</span>
                                                                        <select name="productAmount">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
									</select>
								</div> 
								<div class="clearfix"> </div>
							</div>
							<div class="clearfix"> </div>
							<div class="product-cart-share">
								<div class="add-cart-btn">
									<input type="submit" value="Dodaj u " />
								</div>
								<ul class="product-share text-right">
									<h3>Podijeli:</h3>
									<ul>
										<li><a class="share-face" href="#"><span> </span> </a></li>
										<li><a class="share-twitter" href="#"><span> </span> </a></li>
										<li><a class="share-google" href="#"><span> </span> </a></li>
										<li><a class="share-rss" href="#"><span> </span> </a></li>
										<div class="clear"> </div>
									</ul>
								</ul>
							</div>
                                                    </form>
						</div>
					</div>
						<div class="clearfix"> </div>
				<!--//product-details--->
				</div>
				<!---- product-details ---->
				<div class="product-tabs">
					<!--Horizontal Tab-->
				    <div id="horizontalTab">
				        <ul>
				            <li><a href="#tab-1">Detaljan opis</a></li>
				        </ul>
				        <div id="tab-1" class="product-complete-info">
				        	<h3>Opis:</h3>
				        	<p>${product.longDescription}</p>
				        </div>
				    </div>
				    <!-- Responsive Tabs JS -->
				    <script src="js/jquery.responsiveTabs.js" type="text/javascript"></script>
				
				    <script type="text/javascript">
				        $(document).ready(function () {
				            $('#horizontalTab').responsiveTabs({
				                rotate: false,
				                startCollapsed: 'accordion',
				                collapsible: 'accordion',
				                setHash: true,
				                disabled: [3,4],
				                activate: function(e, tab) {
				                    $('.info').html('Tab <strong>' + tab.id + '</strong> activated!');
				                }
				            });
				
				            $('#start-rotation').on('click', function() {
				                $('#horizontalTab').responsiveTabs('active');
				            });
				            $('#stop-rotation').on('click', function() {
				                $('#horizontalTab').responsiveTabs('stopRotation');
				            });
				            $('#start-rotation').on('click', function() {
				                $('#horizontalTab').responsiveTabs('active');
				            });
				            $('.select-tab').on('click', function() {
				                $('#horizontalTab').responsiveTabs('activate', $(this).val());
				            });
				
				        });
				    </script>
				</div>
				<!-- //product-details ---->
				</div>
				</div>
			<!----content---->
			<div class="clearfix"> </div>
<%@include file="common/footer.jsp" %>