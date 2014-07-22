<jsp:include page="../common/head.jsp" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="top" class="header">
    <div class="vert-text">

		<div class="container">
			<form class="form-signin" role="form" method="post" action="<c:url value='/registeruser'/>">
				<h2 class="form-signin-heading">Register To Suck</h2>
				<input type="email" class="form-control" placeholder="Email address" required autofocus name="email"> 
				<input type="password" class="form-control" placeholder="Password" required name="password">
				<input type="password" class="form-control" placeholder="Confirm Password" required name="confirmPassword">
				<button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
				<button class="btn btn-lg btn-primary btn-block" type="submit">I'm Already a Sucker</button>
			</form>
		</div>

    </div>
</div>


<jsp:include page="../common/footer.jsp" />ß