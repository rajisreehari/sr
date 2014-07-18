<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../common/head.jsp" />

<style>
body { font-size: 140%; }
</style>
<script>
$(document).ready(function() {
    $('#example').dataTable();
} );
</script>

<div id="top" class="header">
	<div class="vert-text">
		<h1>Search Results Page</h1>

<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Suck Rate</th>
                <th>Created</th>
            </tr>
        </thead>
 
        <tfoot>
            <tr>
                <th>Name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Age</th>
            </tr>
        </tfoot>
 
        <tbody>
		<c:forEach items="${searchResults}" var="aResult">
            <tr>
                <td>${aResult.name}</td>
                <td>${aResult.description}</td>
                <td>${aResult.rate}</td>
                <td>${aResult.createdTime}</td>
            </tr>
		</c:forEach>
        </tbody>
    </table>

	</div>
</div>

<jsp:include page="../common/footer.jsp" />