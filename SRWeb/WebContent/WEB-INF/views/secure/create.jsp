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



<div class="container">

	<form class="form-signin" role="form" method="post" action="<c:url value='/secure/create'/>">
		<c:choose>
		    <c:when test="${thing.state != ThingState.SEARCHED_NOT_FOUND_CREATE}">
		        Could not find: 
		        <font style="color: red; font-style: italic;">${thing.name}</font><br>
		        Throw The First Sucker Punch?
		    </c:when>
		    <c:otherwise>
		        Sucker Punch It!
		    </c:otherwise>
		</c:choose>
				
		<input name="name" class="form-control" placeholder="Thing That Sucks" required autofocus value="${thing.name}" style="margin-bottom: 10px;">
		<textarea class="form-control" rows="" cols="" placeholder="Why Does It Suck?" required autofocus name="description"></textarea>

		How Many Ponies Does It Suck?

		<div class="btn-group" data-toggle="buttons">
		    <label class="btn btn-default downColor1">
		    	<input type="radio" name="rate" id="inputWalls" value="1">
				<span class="glyphicon glyphicon-thumbs-down"></span>
			</label>
		    <label class="btn btn-default downColor2">
		    	<input type="radio" name="rate" id="inputWalls" value="2">
				<span class="glyphicon glyphicon-thumbs-down"></span>
			</label>
		    <label class="btn btn-default downColor3">
		    	<input type="radio" name="rate" id="inputWalls" value="3">
				<span class="glyphicon glyphicon-thumbs-down"></span>
		    </label>
		    <label class="btn btn-default downColor4">
		    	<input type="radio" name="rate" id="inputWalls" value="4">
				<span class="glyphicon glyphicon-thumbs-down"></span>
		    </label>
		    <label class="btn btn-default downColor5">
		    	<input type="radio" name="rate" id="inputWalls" value="5">
				<span class="glyphicon glyphicon-thumbs-down"></span>
		    </label>
		    <label class="btn btn-default downColor6">
		    	<input type="radio" name="rate" id="inputWalls" value="6">
				<span class="glyphicon glyphicon-thumbs-down"></span>
		    </label>
		    <label class="btn btn-default downColor7">
		    	<input type="radio" name="rate" id="inputWalls" value="7">
				<span class="glyphicon glyphicon-thumbs-down"></span>
		    </label>
		</div>

		
		<div class="checkbox btn btn-xs btn-block" style="float: left; background-color: #0088cc;">
		  <label style="font-size: 15px; color: #fff;">
		    <input type="checkbox" name="tweetIt" value="true">Tweet it? 
		  </label>
		</div>

		<div class="checkbox btn btn-xs btn-block" style="float: left; background-color: #0088cc;">
		  <label style="font-size: 15px; color: #fff;">
		    <input type="checkbox" name="facebookIt" value="true">Facebook it?
		  </label>
		</div>

		<button class="btn btn-md btn-primary btn-block" type="submit">Create</button>
	</form>

</div>
<!-- /container -->


<jsp:include page="../common/footer.jsp" />