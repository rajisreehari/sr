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

.myModal {
  width: 300px ;
  margin-left: auto ;
  margin-right: auto ;
}
.myGroupModal {
  display: inline-block;
  padding-left: 10%;
  padding-right: 15%;
  padding-bottom: 10px;
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
	<b>Hello ${searchResponse.userName}<br>Here is your list of suckers:</b>
	<table id="searchResults" class="table table-striped table-bordered" cellspacing="0" width="100%">
	       <thead>
	           <tr>
	               <th>Name</th>
	               <th>Description</th>
	               <th colspan="2">Rate</th>
	           </tr>
	       </thead>
	
	       <tbody>
				<c:forEach items="${searchResponse.searchResults}" var="thing">
					
			           <tr>
			               <td><a href="<c:url value='/thing/${thing.id}'/>">${thing.name}</a></td>
			               <td>${thing.description}</td>
			               <td><div id="rate_${thing.id}">${thing.rate}</div></td>
			               <td>
			               
			               <c:if test="${pageContext.request.userPrincipal.name == null}">
				               <div class="span4 proj-div btn btn-lg btn-primary btn-block" 
				               onClick="window.open('<c:url value='/login?register'/>', '_self');">Vote</div>
			               </c:if>
			               <c:if test="${pageContext.request.userPrincipal.name != null}">
				               <div class="span4 proj-div btn btn-lg btn-primary btn-block" data-toggle="modal" 
				               		data-id="${thing.id}" data-target="#GSCCModal" onClick="javascript:setCurrentId(${thing.id});">Vote</div>
			               </c:if>
			               		
			               	</td>
			           </tr>
			        
				</c:forEach>
	        </tbody>
	</table>
</div>

<div id="GSCCModal" class="modal fade" id="voteModal">
    <div class="modal-content myModal">
      <h4 style="text-align:center;">How Many Ponies Does It Suck?</h4>
      <div class="myGroupModal">
		    <label class="btn btn-default" onClick="javascript:localVote(1);" data-dismiss="modal">
		    	<img src="<c:url value='/static/images/ponny1.png'/>">
		    </label>
		    <label class="btn btn-default" onClick="javascript:localVote(2);" data-dismiss="modal">
		    	<img src="<c:url value='/static/images/ponny2.png'/>">
		    </label>
		    <label class="btn btn-default" onClick="javascript:localVote(3);" data-dismiss="modal">
		    	<img src="<c:url value='/static/images/ponny3.png'/>">
		    </label>
		    <label class="btn btn-default" onClick="javascript:localVote(4);" data-dismiss="modal">
		    	<img src="<c:url value='/static/images/ponny4.png'/>">
		    </label>
		</div>
    </div>
</div>

<jsp:include page="../common/footer.jsp" />