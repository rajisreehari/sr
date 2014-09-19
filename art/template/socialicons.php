<?php
function curPageURL() {
 $pageURL = 'http';
 if ($_SERVER["HTTPS"] == "on") {$pageURL .= "s";}
 $pageURL .= "://";
 if ($_SERVER["SERVER_PORT"] != "80") {
  $pageURL .= $_SERVER["SERVER_NAME"].":".$_SERVER["SERVER_PORT"].$_SERVER["REQUEST_URI"];
 } else {
  $pageURL .= $_SERVER["SERVER_NAME"].$_SERVER["REQUEST_URI"];
 }
 return $pageURL;
}

$currentPagePath = curPageURL();
$pos = strripos($currentPagePath, "/");
$currentImgPath = substr($currentPagePath, 0, $pos) . "/" . $imagePath . ".jpg";

$pinterestData = "http://www.pinterest.com/pin/create/button/?" . 
				 "media=" . $currentImgPath .
				 "&url=" . $currentPagePath . 
				 "&description=" . $title;
?>
<!-- Twitter -->
<a href="http://twitter.com/home?status=<?php echo curPageURL() ?>" title="Share on Twitter" target="_blank" class="btn btn-twitter btn-xs"><i class="fa fa-twitter"></i> Twitter</a>
 <!-- Facebook -->
<a href="https://www.facebook.com/sharer/sharer.php?u=<?php echo curPageURL() ?>" title="Share on Facebook" target="_blank" class="btn btn-facebook btn-xs"><i class="fa fa-facebook"></i> Facebook</a>
<!-- Google+ -->
<a href="https://plus.google.com/share?url=<?php echo curPageURL() ?>" title="Share on Google+" target="_blank" class="btn btn-googleplus btn-xs"><i class="fa fa-google-plus"></i> Google+</a>
<!-- Pinterest -->
<a href="<?php echo $pinterestData ?>" title="Share on Pinterest" target="_blank" data-placement="top" class="btn btn-pinterest btn-xs"><i class="fa fa-pinterest"></i> Pinterest</a>
