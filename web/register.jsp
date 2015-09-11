<%-- 
    Document   : register
    Created on : Sep 10, 2015, 4:32:31 PM
    Author     : filipzelic
--%>

<%@include file="common/header.jsp" %>
	<body>
		<!----container---->
		<div class="container">
                        <%@include file="common/top_header.jsp" %>
			<!----contact---->
			<div class="contact-info">
					 <div class="container">
					 	<form id="RegistrationForm" name="RegistrationForm" action="register" method="Post">
					          <div class="contact-form">
								<div class="contact-to">
                                                                    <input type="text" name="firstName" class="text" value="Ime..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Ime...';}">
                                                                    <input type="text" name="lastName" class="text" value="Prezime..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Prezime...';}">
                                                                    <input type="text" name="phone" class="text" value="Mobitel..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Mobitel...';}">
                                                                    <input type="text" name="address" class="text" value="Adresa..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Adresa...';}">
                                                                    <input type="text" name="city" class="text" value="Grad..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Grad...';}">
                                                                    <input type="text" name="postalCode" class="text" value="Postanski broj..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Postanski broj...';}">
                                                                    <input type="text" name="country" class="text" value="Drzava..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Drzava...';}">
                                                                    <input type="text" name="email" class="text" value="Email..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email...';}">
                                                                    <input type="text" name="password" class="text" value="Lozinka..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Lozinka...';}">
								</div>
				               <span><input type="submit" class="" value="Resgistriraj se"></span>
				                <div class="clearfix"></div>
				               </div>
				           </form>
                                        </div>
			</div>
			<!---//contact---->
<%@include file="common/footer.jsp" %>