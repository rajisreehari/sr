<jsp:include page="../common/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-fluid">
	<div style="max-width:280px;">
	    <form class="navbar-form" role="search" method="post" action="<c:url value='/search'/>">
	        <div class="input-group">
	            <input type="text" size="40" class="form-control" placeholder="Suck Search" name="phrase">
	            <div class="input-group-btn">
	                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
	            </div>
	        </div>
	    </form>
	</div>
	
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th colspan="2" class="info">${thing.thingDto.name}</th>
			</tr>
		</thead>
	
		<tbody>
			<tr>
				<th>Description</th>
				<th>${thing.thingDto.description}</th>
			</tr>
			<tr>
				<th>Current Suck Rate</th>
				<th>${thing.thingDto.rate}</th>
			</tr>
			<tr>
				<th>Number Of People That Voted</th>
				<th>${thing.thingDto.numberOfVotes}</th>
			</tr>
			<tr>
				<th>Author Voted</th>
				<th>
				<c:if test="${thing.thingDto.authorVote == 1.0}"><img src="<c:url value='/static/images/ponny1.png'/>"></c:if>
				<c:if test="${thing.thingDto.authorVote == 2.0}"><img src="<c:url value='/static/images/ponny2.png'/>"></c:if>
				<c:if test="${thing.thingDto.authorVote == 3.0}"><img src="<c:url value='/static/images/ponny3.png'/>"></c:if>
				<c:if test="${thing.thingDto.authorVote == 4.0}"><img src="<c:url value='/static/images/ponny4.png'/>"></c:if>
				</th>
			</tr>
		</tbody>
	</table>

	<form method="post" action="<c:url value='/secure/addCommnet'/>">
	  <div class="form-group">
	  	<textarea rows="" cols="" class="form-control" placeholder="Your Comment" style="margin-bottom: 10px;" name="comment"></textarea>
	  	<input type="hidden" name="id" value="${thing.thingDto.id}"/>
		<button type="submit" class="btn btn-default">Comment</button>
	  </div>
	</form>
	
	<table class="table table-striped table-bordered table-hover">
		<c:forEach items="${thing.thingComments}" var="thingComment">
			<tr>
				<td>
					${thingComment.id}
				</td><td>
					${thingComment.comment}
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<jsp:include page="../common/footer.jsp" />