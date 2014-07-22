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
 
    <!-- Side Menu -->
    <a id="menu-toggle" href="#" class="btn btn-primary btn-lg toggle"><i class="fa fa-bars"></i></a>
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <a id="menu-close" href="#" class="btn btn-default btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
            <li class="sidebar-brand"><a href="<c:url value='/home'/>">Home</a></li>
            
            <c:if test="${pageContext.request.userPrincipal.name == null}">
	            <li><a href="#login"><a href="<c:url value='/login'/>">Sucker Login</a></li>
	            <li><a href="#register"><a href="<c:url value='/register'/>">Register To Suck</a></li>
			</c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
	            <li><a href="javascript:formSubmit()">Sucker Logout</a></li>
			</c:if>
            
            <li><a href="#about"><a href="<c:url value='/about'/>">About</a></li>
            <li><a href="#contact"><a href="<c:url value='/contact'/>">Contact</a></li>
        </ul>
    </div>
    
    <!-- /Side Menu -->