<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../common/head.jsp" />

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
<script>
$(document).ready(function() {
    $('#searchResults').dataTable();
} );
</script>

<div class="container-fluid">
<div style="max-width:300px;">
    <form class="navbar-form" role="search" method="post" action="<c:url value='/search'/>">
        <div class="input-group">
            <input type="text" size="40" class="form-control" placeholder="Suck Search" name="phrase">
            <div class="input-group-btn">
                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
            </div>
        </div>
    </form>
</div>  

<h1>Search Results Page</h1>
<table id="searchResults" class="table table-striped table-bordered" cellspacing="0" width="100%">
       <thead>
           <tr>
               <th>Name</th>
               <th>Description</th>
               <th>Suck Rate</th>
           </tr>
       </thead>

       <tfoot>
           <tr>
               <th>Name</th>
               <th>Description</th>
               <th>Suck Rate</th>
           </tr>
       </tfoot>

       <tbody>
	<c:forEach items="${searchResults}" var="aResult">
           <tr>
               <td>${aResult.name}</td>
               <td>${aResult.description}</td>
               <td>${aResult.rate}</td>
           </tr>
	</c:forEach>
        </tbody>
</table>

</div>

<jsp:include page="../common/footer.jsp" />