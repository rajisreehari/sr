<jsp:include page="../common/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="com.sr.dao.ThingState" %>

<style>
.assFont{
	font-size: 13px;
}
.one{
 padding-left: 20px;padding-right: 20px;
}
.five{
 padding-left: 10px;padding-right: 17px;
}

</style>

<!-- Full Page Image Header Area -->
<div id="top" class="header">
    <div class="vert-text">

<div class="container">

	<form:form class="form-signin" role="form" method="post" action="/SRWeb/secure/create">
		<h2 class="form-signin-heading">
		
		<c:choose>
		    <c:when test="${thing.state != ThingState.SEARCHED_NOT_FOUND_CREATE}">
		        Could not find:<br> 
		        <font style="color: orange; font-style: italic;">${thing.name}</font><br>
		        Create it?
		    </c:when>
		    <c:otherwise>
		        Create
		    </c:otherwise>
		</c:choose>
				
		</h2>
				
		<input name="name" class="form-control" placeholder="Thing That Sucks" required autofocus value="${thing.name}" style="margin-bottom: 10px;">
		<textarea class="form-control" rows="" cols="" placeholder="Why Does It Suck?" required autofocus name="description"></textarea>

		<h4 class="form-signin-heading">
			How Many Ponies Does It Suck?
		</h4>

		<div class="btn-group" data-toggle="buttons" style="padding-top: 10px; padding-bottom: 10px; padding-left: 25px;">
		    <label class="btn btn-default">
		    	<input type="radio" name="rate" id="inputWalls" value="1">
				<img src="<c:url value='/static/images/ponny1.png'/>">
			</label>
		    <label class="btn btn-default">
		    	<input type="radio" name="rate" id="inputWalls" value="2">
				<img src="<c:url value='/static/images/ponny2.png'/>">
			</label>
		    <label class="btn btn-default">
		    	<input type="radio" name="rate" id="inputWalls" value="3">
		    	<img src="<c:url value='/static/images/ponny3.png'/>">
		    </label>
		    <label class="btn btn-default assFont">
		    	<input type="radio" name="rate" id="inputWalls" value="4">
		    	<img src="<c:url value='/static/images/ponny4.png'/>">
		    </label>
		</div>

		
		<div class="checkbox btn btn-lg btn-block" style="float: left; background-color: orange;">
		  <label style="font-size: 20px">
		    <input type="checkbox" name="tweetIt" value="true">Tweet it? 
		  </label>
		</div>

		<button class="btn btn-lg btn-primary btn-block" type="submit">Create</button>
	</form:form>

</div>
<!-- /container -->


    </div>
</div>

<jsp:include page="../common/footer.jsp" />