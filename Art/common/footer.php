</div></td></tr></table>

<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3 text-center">
                <?php include $_SERVER['DOCUMENT_ROOT']."/jorge/common/modal.php"; ?>
                <div class="top-scroll">
                    <a href="#top"><i class="fa fa-arrow-circle-up scroll fa-4x"></i></a>
                </div>
                <hr>
<p>Copyright &copy; Jorge M. Spiropulo 2014 <span class="glyphicon glyphicon-thumbs-up"></span>&nbsp;<a href="/jorge/painting/index.php">Catalog</a></p>            </div>
        </div>
    </div>
</footer>


<!-- Custom JavaScript for the Side Menu and Smooth Scrolling -->
<script>
$("#menu-close").click(function(e) {
    e.preventDefault();
    $("#sidebar-wrapper").toggleClass("active");
});
</script>
<script>
$("#menu-toggle").click(function(e) {
    e.preventDefault();
    $("#sidebar-wrapper").toggleClass("active");
});
</script>
<script>
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
</script>

</body></html>