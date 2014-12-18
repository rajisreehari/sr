<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/head.jsp" />
<jsp:include page="../common/search_bar.jsp" />

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
	<table>
		<tbody>
			<c:forEach items="${searchResponse.searchResults}" var="thing">
				<tr>
					<td>
						<table class="table">
							<tr>
								<td width="20%">
									<img src="<c:url value='${thing.thumbImagePath}'/>" class="img-circle">
								</td>
								<td valign="middle">
									<a href="<c:url value='/thing/${thing.id}'/>">${thing.name}</a><br>
									${thing.description}<br>
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