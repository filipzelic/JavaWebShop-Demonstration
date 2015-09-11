<%-- 
    Document   : register
    Created on : Sep 10, 2015, 4:45:31 PM
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
					 	<form id="RegistrationForm" name="LoginForm" action="login" method="Post">
					          <div class="contact-form">
								<div class="contact-to">
                                                                    <input type="text" name="email" class="text" value="Email..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email...';}">
                                                                    <input type="text" name="password" class="text" value="Lozinka..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Lozinka...';}">
								</div>
				               <span><input type="submit" class="" value="Prijava"></span>
				                <div class="clearfix"></div>
				               </div>
				           </form>
                                        </div>
			</div>
			<!---//contact---->
<%@include file="common/footer.jsp" %>