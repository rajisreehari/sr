<jsp:include page="../common/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

	<form:form class="form-signin" role="form" method="post" action="/SRWeb/create">
		<h2 class="form-signin-heading">
		
		<c:choose>
		    <c:when test="${thing.state != ThingState.SEARCHED_NOT_FOUND_CREATE}">
		        Could not find ${thing.name}. Create it?
		    </c:when>
		    <c:otherwise>
		        Create
		    </c:otherwise>
		</c:choose>
				
		</h2>
				
		<input name="name" class="form-control" placeholder="Name" required autofocus value="${thing.name}"> 
		<input name="description" class="form-control" placeholder="Description" required autofocus> 

		<div class="btn-group" data-toggle="buttons" style="padding-top: 10px; padding-left: 2px; padding-bottom: 10px;">
		    <label class="btn btn-default **active** assFont one"><input type="radio" name="rate" id="inputWalls" value="1" checked>1 Ass</label>
		    <label class="btn btn-default assFont"><input type="radio" name="rate" id="inputWalls" value="2">2 Asses</label>
		    <label class="btn btn-default assFont"><input type="radio" name="rate" id="inputWalls" value="3">3 Asses</label>
		    <label class="btn btn-default assFont"><input type="radio" name="rate" id="inputWalls" value="4">4 Asses</label>
		
		    <label class="btn btn-default assFont five"><input type="radio" name="rate" id="inputWalls" value="5">5 Asses</label>
		    <label class="btn btn-default assFont"><input type="radio" name="rate" id="inputWalls" value="6">6 Asses</label>
		    <label class="btn btn-default assFont"><input type="radio" name="rate" id="inputWalls" value="7">7 Asses</label>
		    <label class="btn btn-default assFont"><input type="radio" name="rate" id="inputWalls" value="8">8 Asses</label>
		</div>
	
		<button class="btn btn-lg btn-primary btn-block" type="submit">Create</button>
	</form:form>

</div>
<!-- /container -->


    </div>
</div>


<jsp:include page="../common/footer.jsp" />ß