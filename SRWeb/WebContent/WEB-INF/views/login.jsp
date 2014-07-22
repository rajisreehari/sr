<jsp:include page="common/head.jsp" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>

.messageBox{
	max-width: 285px;
}

</style>

<!-- Full Page Image Header Area -->
<div id="top" class="header">
	<div class="vert-text">

		<div class="container">
	 		
			<form name='loginForm' class="form-signin" role="form" action="<c:url value='j_spring_security_check' />" method='POST'>
				<div class="messageBox">
				<c:if test="${not empty loggingError}">
					<div class="alert alert-warning">
					    <a href="#" class="close" data-dismiss="alert">&times;</a>
					    <strong>Warning:</strong> Invalid email or password!
					</div>
				</c:if>
				<c:if test="${not empty loggedOut}">
					<div class="alert alert-success messageBox">
					    <a href="#" class="close" data-dismiss="alert">&times;</a>
					    You've been logged out successfully!
					</div>
				</c:if>
				</div>
				
	 			<h2 class="form-signin-heading">Sign In To Suck</h2>
	 			<input type='email' name='username' value='' class="form-control" placeholder="Email address" required autofocus>
	 			<input type="password" class="form-control" placeholder="Password" required name="password">
				<div class="checkbox">
					<label> <input type="checkbox" value="remember-me">
						Remember me
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
			
		</div>
	</div>
</div>

<jsp:include page="common/footer.jsp" />