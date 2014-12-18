<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
	<div class="srMaxWidth srSearchBar">
		    <form role="search" method="post" action="<c:url value='/search'/>">
		        <div class="input-group">
		            <input type="text" class="form-control" placeholder="Suck Search" name="phrase">
		            <div class="input-group-btn">
		                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
		            </div>
		        </div>
		    </form>
	</div>
</div>