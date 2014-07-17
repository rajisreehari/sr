<jsp:include page="../common/head.jsp" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!-- Full Page Image Header Area -->
<div id="top" class="header">
    <div class="vert-text">

<div class="container">

	<form:form class="form-signin" role="form">
		<h2 class="form-signin-heading">Sign In To Suck</h2>
		<input type="email" class="form-control" placeholder="Email address"
			required autofocus> <input type="password"
			class="form-control" placeholder="Password" required>
		<div class="checkbox">
			<label> <input type="checkbox" value="remember-me">
				Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
	</form:form>

</div>
<!-- /container -->


    </div>
</div>


<jsp:include page="../common/footer.jsp" />