<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../common/head.jsp" />
<jsp:include page="../common/search_bar.jsp" />


<div align="center">
	<form method="POST" action="<c:url value='/secure/user/uploadProfileImage' />" enctype="multipart/form-data" >
	    <div class="form-group srMaxWidth">
	        <input id="file-1" type="file" name="file" data-preview-file-type="any">
	    </div>
	</form>

	
<div class="srMaxWidth">
	<table>
		<tr>
			<td width="20%" style="padding-right: 10px;">
				<img src="<c:url value='${command.mainImagePath}'/>" class="img-thumbnail">
			</td>
			<td>
			
				<form:form method="post" action="/SRWeb/secure/user/update">
				<table id="profile" class="table table-striped table-bordered table-condensed">
					<tr>
						<td class="fontForFieldTitle">First Name</td>
						<td><form:input type="text" class="form-control fontForFieldValue"
								path="firstName" placeholder="Firs Name"
								name="firstName" id="firstName" /></td>
					</tr>
					<tr>
						<td class="fontForFieldTitle">Last Name</td>
						<td><form:input type="text" class="form-control fontForFieldValue"
								path="lastName" placeholder="Last Name"
								name="lastName" id="lastName" /></td>
					</tr>
					<tr>
						<td class="fontForFieldTitle">Gender</td>
						<td><form:select path="gender">
								<form:option value="" label="Select Gender"/>
								<form:options items="${command.genderList}"/>
							</form:select></td>
					</tr>
					<tr>
						<td class="fontForFieldTitle">Birth Date</td>
						<td><form:input type="text" class="form-control fontForFieldValue"
								path="dateOfBirthInput" placeholder="yyyy/mm/dd"
								name="dateOfBirthInput" id="dateOfBirthInput" /></td>
					</tr>
					<tr>
						<td colspan="2"><div align="right"><button type="submit" class="btn btn-default fontForFieldValue">Save</button></div></td>
					</tr>
				</table>
				</form:form>					
			
			</td>
		</tr>
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
</script>

<jsp:include page="../common/footer.jsp" />