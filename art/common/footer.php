</div></td></tr></table>

<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3 text-center">
                <div class="top-scroll">
                    <a href="#top"><i class="fa fa-arrow-circle-up scroll fa-4x pull-center"></i></a>
                </div>
                <hr>
				<p>Copyright &copy; Jorge M. Spiropulo 2014 
				<a href="/art/contact.php"><span class="glyphicon glyphicon-envelope"></span></a>&nbsp;
				<a href="/art/painting/index.php">Catalog</a></p>
			</div>
        </div>
    </div>
</footer>


<!-- Custom JavaScript for the Side Menu and Smooth Scrolling -->
<script>
$("#menu-close").click(function(e) {
    e.preventDefault();
    $("#sidebar-wrapper").toggleClass("active");
});

$("#menu-toggle").click(function(e) {
    e.preventDefault();
    $("#sidebar-wrapper").toggleClass("active");
});

$(function() {
    $('a[href*=#]:not([href=#])').click(function() {
        if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {

            var target = $(this.hash);
            target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
            if (target.length) {
                $('html,body').animate({
                    scrollTop: target.offset().top
                }, 1000);
                return false;
            }
        }
    });
});

(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
})(window,document,'script','//www.google-analytics.com/analytics.js','ga');

ga('create', 'UA-54626116-1', 'auto');
ga('send', 'pageview');
</script>

</body></html>