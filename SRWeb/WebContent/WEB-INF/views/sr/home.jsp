<jsp:include page="../common/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="top" class="header">
	<div class="vert-text">
		<div class="container-fluid">
			<div class="pull-center">
				<form class="navbar-form" role="search" method="post" action="<c:url value='/search'/>">
					<div class="input-group">
						<input type="text" size="40" class="form-control" placeholder="Suck Search" name="phrase">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<jsp:include page="../common/footer.jsp" />