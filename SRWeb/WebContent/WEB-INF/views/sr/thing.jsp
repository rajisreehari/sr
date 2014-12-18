<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../common/head.jsp" />
<jsp:include page="../common/search_bar.jsp" />

<div align="center">
	
	<form method="POST" action="<c:url value='/secure/user/uploadThingImage' />" enctype="multipart/form-data" >
	    <div class="form-group srMaxWidth">
	        <input id="file-1" type="file" name="file" data-preview-file-type="any">
	        <input type="hidden" name="id" value="${thing.thingDto.id}"/>
	    </div>
	</form>
	
	<div class="srMaxWidth">
	<table class="table table-striped table-bordered table-hover table-condensed">

		<tr>
			<th colspan="2" class="info">${thing.thingDto.name}</th>
		</tr>

	
		<tr>
			<td class="fontForFieldTitle">Description</td>
			<td class="fontForFieldValue">${thing.thingDto.description}</td>
		</tr>
		<tr>
			<td class="fontForFieldTitle">Current Suck Rate</td>
			<td class="fontForFieldValue">
			
			<c:if test="${pageContext.request.userPrincipal.name == null}">
				<input id="${thing.thingDto.id}" value="${thing.thingDto.currentRate}" type="number" class="rating" min=0 max=5 step=0.3 data-size="xs" onClick="window.open('<c:url value='/login?register'/>', '_self');">
			</c:if> 
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<span class="glyphicon glyphicon-plane"></span>
				<div onClick="javascript:localVote(${thing.thingDto.id});"><input id="${thing.thingDto.id}" value="${thing.thingDto.currentRate}" type="number" class="rating" min=0 max=5 step=0.3 data-size="xs"></div>
			</c:if>
			
			</td>
		</tr>
		<tr>
			<td class="fontForFieldTitle">Number Of People That Voted</td>
			<td class="fontForFieldValue">${thing.thingDto.numberOfVotes}</td>
		</tr>
		<tr>
			<td class="fontForFieldTitle">Author Voted</td>
			<td class="fontForFieldValue">
				${thing.thingDto.authorVote}
			</td>
		</tr>
		<tr>
			<td class="fontForFieldTitle">Image</td>
			<td class="fontForFieldValue">
				<div data-toggle="modal" data-target="#GSCCModal">
				<img src="<c:url value='${thing.thingDto.thumbImagePath}'/>" class="img-thumbnail">
				</div>
			</td>
		</tr>
	</table>
	</div>
	
	<form method="post" action="<c:url value='/secure/addCommnet'/>" onsubmit="return validateComment();">
	  <div class="form-group srMaxWidth">
	  	<textarea rows="" cols="" class="form-control fontForFieldValue srMaxWidth" id="comment"
	  		placeholder="Your Comment" style="margin-bottom: 10px;" name="comment"></textarea>
	  	<input type="hidden" name="id" value="${thing.thingDto.id}"/>
		<div align="right"><button type="submit" class="btn btn-default fontForFieldValue">Comment</button></div>
	  </div>
	</form>
	
	<div class="srMaxWidth">
	<table class="table table-striped table-bordered table-hover table-condensed srMaxWidth">
		<c:forEach items="${thing.thingComments}" var="thingComment">
			<tr>
				<td class="fontForFieldValue">
					${thingComment.comment}
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</div>

<script>
   $("#file-1").fileinput({
       initialPreview: [],
       overwriteInitial: false,
       maxFileSize: 2000,
       maxFilesNum: 10
});
   
function validateComment(){
	var str = document.getElementById("comment").value;
	if(!str || /^\s*$/.test(str)){
		return false;
	}
	return true;
}

function localVote(id){
	var rate = document.getElementById(id).value;
	vote(id, rate, '${pageContext.request.contextPath}');
}
</script>

<div id="GSCCModal" class="modal fade srMaxWidth">
    <div class="modal-content myModal">
    	<button type="button" class="close" data-dismiss="modal" style="margin-right: 5px; margin-bottom: 2px;"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		<img src="<c:url value='${thing.thingDto.mainImagePath}'/>" class="img-thumbnail">
    </div>
</div>

<jsp:include page="../common/footer.jsp" />