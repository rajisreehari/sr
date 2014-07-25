<jsp:include page="../common/head.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

${twitterAccessRequest.token}<br>
${twitterAccessRequest.tokenSecret}<br>

<script type="text/javascript">
window.open("${twitterAccessRequest.authorizationURL}");
</script>

<form class="navbar-form" role="search" method="post" action="<c:url value='/confirmTwitter'/>">
    <div class="input-group">
        <input type="text" size="40" class="form-control" placeholder="Twitter Pin" name="twitterPin">
        <div class="input-group-btn">
            <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
        </div>
    </div>
</form>


<jsp:include page="../common/footer.jsp" />