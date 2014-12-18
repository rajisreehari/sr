<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>


<c:url value="/j_spring_security_logout" var="logoutUrl" />
<!-- csrt for log out-->
<form action="${logoutUrl}" method="post" id="logoutForm">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<script>
	function formSubmit() {document.getElementById("logoutForm").submit();}
</script>

<nav class="navbar navbar-default" role="navigation">
  	<div class="container-fluid">
	    <a class="navbar-brand" href="<c:url value='/home'/>">search</a>
	
	    <c:if test="${pageContext.request.userPrincipal.name == null}">
	      <a class="navbar-brand" href="<c:url value='/login'/>">login</a>
	      <a class="navbar-brand" href="<c:url value='/register'/>">register</a>
		</c:if>
	
	    <c:if test="${pageContext.request.userPrincipal.name != null}">
	      <a class="navbar-brand" href="<c:url value='/secure/user/profile'/>">account</a>
	      <a class="navbar-brand" href="<c:url value='/secure/user/things'/>">things</a>
		</c:if>
	
	    <c:if test="${pageContext.request.userPrincipal.name != null}">
	      <a class="navbar-brand" href="javascript:formSubmit()">logout</a>
		</c:if>
		
	</div>
</nav>
