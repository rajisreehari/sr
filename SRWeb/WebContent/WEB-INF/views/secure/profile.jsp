<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../common/head.jsp" />
<div class="container-fluid srMaxWidth">
	<img alt="logo" src="#" width="100px;" height="100px;" style="margin-bottom: 10px;" class="img-thumbnail">

	<div style="margin-bottom: 10px;" align="center">
		<img src="<c:url value='${command.mainImagePath}'/>" class="img-thumbnail">
	</div>

	<form method="POST" action="<c:url value='/secure/user/uploadProfileImage' />" enctype="multipart/form-data" >
	    <div class="form-group">
	        <input id="file-1" type="file" name="file" data-preview-file-type="any">
	    </div>
	</form>

	<form:form class="navbar-form" method="post" action="/SRWeb/secure/user/update">
		<!-- User Profile Data -->
		<table id="profile" class="table table-striped table-bordered">
			<tr>
				<th>First Name</th>
				<th><form:input type="text" class="form-control"
						path="firstName" placeholder="Firs Name"
						name="firstName" id="firstName" /></th>
			</tr>
			<tr>
				<th>Last Name</th>
				<th><form:input type="text" class="form-control"
						path="lastName" placeholder="Last Name"
						name="lastName" id="lastName" /></th>
			</tr>
			<tr>
				<th>Gender</th>
				<th><form:select path="gender">
						<form:option value="" label="Select Gender" />
						<form:options items="${command.genderList}"/>
					</form:select></th>
			</tr>
			<tr>
				<th>Birth Date</th>
				<th><form:input type="text" class="form-control"
						path="dateOfBirthInput" placeholder="yyyy/mm/dd"
						name="dateOfBirthInput" id="dateOfBirthInput" /></th>
			</tr>
			<tr>
				<th colspan="2"><button
						class="btn btn-lg btn-primary btn-block" type="submit">Save</button></th>
			</tr>
		</table>
	</form:form>
</div>

<script>
   $("#file-1").fileinput({
       initialPreview: [],
       overwriteInitial: false,
       maxFileSize: 2000,
       maxFilesNum: 10
});
</script>

<jsp:include page="../common/footer.jsp" />