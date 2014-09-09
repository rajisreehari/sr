<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/head.jsp" />

<script type="text/javascript">
function localVote(id){
	var rate = document.getElementById(id).value;
	vote(id, rate, '${pageContext.request.contextPath}');
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

<div class="container-fluid srMaxWidth">
	<img alt="logo" src="#" width="100px;" height="100px;" style="margin-bottom: 10px;">

	<table id="searchResults" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th colspan="3">
					<div>
						<form class="navbar-form" method="post"
							action="<c:url value='/search'/>">
							<div class="input-group">
								<input type="text" size="100%" class="form-control"
									placeholder="Suck Search" name="phrase">
								<div class="input-group-btn">
									<button class="btn btn-default" type="submit">
										<i class="glyphicon glyphicon-search"></i>
									</button>
								</div>
							</div>
						</form>
					</div>
				</th>
			</tr>
			<c:if test="${searchResponse.userName != null}">
				<tr>
					<th colspan="3">Hello ${searchResponse.userName}</th>
				</tr>
			</c:if>
		</thead>

		<tbody>
			<c:forEach items="${searchResponse.searchResults}" var="thing">
				<tr>
					<td>
						<table width="100%">
							<tr>
								<td width="60%" class="searchCell">
									<a href="<c:url value='/thing/${thing.id}'/>">${thing.name}</a>
								</td>
								<td class="searchCell">
									<a href="<c:url value='/thing/${thing.id}'/>">${thing.description}</a>
								</td>
							</tr>
							<tr>
								<td width="60%" class="searchCell">
									<img src="<c:url value='${thing.thumbImagePath}'/>" class="img-thumbnail">
								</td>
								<td class="searchCell">
									<c:if test="${pageContext.request.userPrincipal.name == null}">
										<input id="${thing.id}" value="${thing.currentRate}" type="number" class="rating" min=0 max=5 step=0.3 data-size="xs" onClick="window.open('<c:url value='/login?register'/>', '_self');">
									</c:if> 
									<c:if test="${pageContext.request.userPrincipal.name != null}">
										<div onClick="javascript:localVote(${thing.id});"><input id="${thing.id}" value="${thing.currentRate}" type="number" class="rating" min=0 max=5 step=0.3 data-size="xs"></div>
									</c:if>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<script>
    jQuery(document).ready(function () {
        $(".rating-kv").rating();
    });
</script>
<jsp:include page="../common/footer.jsp" />