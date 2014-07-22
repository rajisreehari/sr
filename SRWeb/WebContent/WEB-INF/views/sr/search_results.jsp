<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../common/head.jsp" />
<script type="text/javascript">
var currentId;
function localVote(rate){
	vote(currentId, rate);
}
function setCurrentId(id){
	currentId = id;
}
</script>

<style>
body { font-size: 140%; }
.form-control {
  display: block;
  width: 100%;
  height: 34px;
  padding: 6px 12px;
  font-size: 14px;
  line-height: 1.42857143;
  color: #555;
  float: right;
  background-color: #fff;
  background-image: none;
  border: 1px solid #ccc;
  border-radius: 4px;
  -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
          box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
  -webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow ease-in-out .15s;
       -o-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
          transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
}
</style>

<div class="container-fluid">
	<div style="max-width:250px;">
	    <form class="navbar-form" role="search" method="post" action="<c:url value='/search'/>">
	        <div class="input-group">
	            <input type="text" size="40" class="form-control" placeholder="Suck Search" name="phrase">
	            <div class="input-group-btn">
	                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
	            </div>
	        </div>
	    </form>
	</div>  
	<br>
	<table id="searchResults" class="table table-striped table-bordered" cellspacing="0" width="100%">
	       <thead>
	           <tr>
	               <th>Name</th>
	               <th>Description</th>
	               <th colspan="2">Rate</th>
	           </tr>
	       </thead>
	
	       <tbody>
				<c:forEach items="${searchResults}" var="aResult">
					
			           <tr>
			               <td>${aResult.name}</td>
			               <td>${aResult.description}</td>
			               <td><div id="rate_${aResult.id}">${aResult.rate}</div></td>
			               <td>
			               
			               <c:if test="${pageContext.request.userPrincipal.name == null}">
				               <div class="span4 proj-div btn btn-lg btn-primary btn-block" 
				               onClick="window.open('<c:url value='/login?register'/>');">Vote</div>
			               </c:if>
			               <c:if test="${pageContext.request.userPrincipal.name != null}">
				               <div class="span4 proj-div btn btn-lg btn-primary btn-block" data-toggle="modal" 
				               		data-id="${aResult.id}" data-target="#GSCCModal" onClick="javascript:setCurrentId(${aResult.id});">Vote</div>
			               </c:if>
			               		
			               	</td>
			           </tr>
			        
				</c:forEach>
	        </tbody>
	</table>
</div>

<div id="GSCCModal" class="modal fade" tabindex="-1" id="voteModal">
 <div class="modal-dialog">
    <div class="modal-content">
      <div class="btn-group" data-toggle="buttons" style="padding-top: 10px; padding-left: 2px; padding-bottom: 10px;">
		    <label class="btn btn-default **active** assFont one" onClick="javascript:localVote(1);" data-dismiss="modal">
		    	<img alt="Cute Monkey" src="<c:url value='/static/images/cutemonkey.jpg'/>">
		    </label>
		    <label class="btn btn-default assFont" onClick="javascript:localVote(2);" data-dismiss="modal">
		    	<img alt="Baboon Army" src="<c:url value='/static/images/baboonarmy.jpg'/>">
		    </label>
		    <label class="btn btn-default assFont" onClick="javascript:localVote(3);" data-dismiss="modal">
		    	<img alt="Cozy Cow" src="<c:url value='/static/images/crazycow.jpg'/>">
		    </label>
		    <label class="btn btn-default assFont" onClick="javascript:localVote(4);" data-dismiss="modal"><input type="radio" name="rate" id="inputWalls" value="4">4 Asses</label>
		
		    <label class="btn btn-default assFont five" onClick="javascript:localVote(5);" data-dismiss="modal"><input type="radio" name="rate" id="inputWalls" value="5">5 Asses</label>
		    <label class="btn btn-default assFont" onClick="javascript:localVote(6);" data-dismiss="modal"><input type="radio" name="rate" id="inputWalls" value="6">6 Asses</label>
		    <label class="btn btn-default assFont" onClick="javascript:localVote(7);" data-dismiss="modal"><input type="radio" name="rate" id="inputWalls" value="7">7 Asses</label>
		    <label class="btn btn-default assFont" onClick="javascript:localVote(8);" data-dismiss="modal"><input type="radio" name="rate" id="inputWalls" value="8">8 Asses</label>
		</div>
    </div>
  </div>
</div>

<jsp:include page="../common/footer.jsp" />