<br><br>
<p>Copyright &copy; Jorge M. Spiropulo 2014 <a href="/art/contact.php">
<span class="glyphicon glyphicon-envelope"></span></a>&nbsp;
<a href="https://www.artfinder.com/jorge-spiropulo" target="_blank"><span class="glyphicon glyphicon-shopping-cart"></span></a>&nbsp;
<a href="/art/painting/index.php">Catalog</a></p>
</div></td></tr></table>



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