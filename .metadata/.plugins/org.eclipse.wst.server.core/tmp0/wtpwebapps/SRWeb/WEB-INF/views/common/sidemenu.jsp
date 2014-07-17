<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</style>
    <!-- Side Menu -->
    <a id="menu-toggle" href="#" class="btn btn-primary btn-lg toggle"><i class="fa fa-bars"></i></a>
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <a id="menu-close" href="#" class="btn btn-default btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
            <li class="sidebar-brand"><a href="<c:url value='/home'/>">Suck Rate</a></li>
            <li><a href="#register"><a href="<c:url value='/signin'/>">Sucker Sign In</a></li>
            <li><a href="#register"><a href="<c:url value='/register'/>">Register To Suck</a></li>
            <li><a href="#portfolio"><a href="<c:url value='/sucksomething'/>">Suck Something</a></li>
            <li><a href="#about"><a href="<c:url value='/about'/>">About</a></li>
            <li><a href="#contact"><a href="<c:url value='/contact'/>">Contact</a></li>
        </ul>
    </div>
    
    <!-- /Side Menu -->