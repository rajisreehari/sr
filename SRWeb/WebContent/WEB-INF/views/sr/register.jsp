<jsp:include page="../common/head.jsp" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!-- Full Page Image Header Area -->
<div id="top" class="header">
    <div class="vert-text">

<div class="container">

	<form:form class="form-signin" role="form">
		<h2 class="form-signin-heading">Register To Suck</h2>
		<input type="text" class="form-control" placeholder="User Name" required autofocus> 
		<input type="email" class="form-control" placeholder="Email address" required autofocus> 
		<input type="password" class="form-control" placeholder="Password" required>
		<input type="password" class="form-control" placeholder="Confirm Password" required>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
		<button class="btn btn-lg btn-primary btn-block" type="submit">I'm Already a Sucker</button>
	</form:form>

</div>
<!-- /container -->


    </div>
</div>


<jsp:include page="../common/footer.jsp" />ß