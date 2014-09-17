<?php include $_SERVER['DOCUMENT_ROOT']."/art/common/header.php"; ?>

<div><h1><?php echo $title ?><br><small class="<?php echo $inspiredClass ?>">(Inspired By <?php echo $inspired ?>)</small></h1></div>
<IMG src="<?php echo $imagePath ?>.jpg" class="img-thumbnail mainImage">

<div align="left" class="mainText">
	<small>
		<table class="table table-hover table-condensed detailsTable">
			<tbody>
				<tr><td><strong>Available</td><td><?php echo $available ?></td></tr>
				<tr><td><strong>Price</td><td><?php echo $price ?></td></tr>
				<tr><td><strong>Medium</td><td><?php echo $medium ?></td></tr>
				<tr><td><strong>Dimension</td><td><?php echo $dimension ?></td></tr>
				<tr><td><strong>Year</td><td><?php echo $year ?></td></tr>
				<tr><td><strong>Location</td><td><?php echo $location ?></td></tr>
				<tr><td><strong>Social</td><td>
				
<table>
	<tr>
		<td><div style="margin-bottom: 8px;" class="social"><?php include $_SERVER['DOCUMENT_ROOT']."/art/template/facebook.php"; ?></div></td>
	</tr>
	<tr>
		<td><div class="social"><?php include $_SERVER['DOCUMENT_ROOT']."/art/template/twitter.php"; ?></div></td>
	</tr>
	<tr>
		<td>
			<div class="social">
				<!-- Place this tag in your head or just before your close body tag. -->
				<script src="https://apis.google.com/js/platform.js" async defer></script>
				
				<!-- Place this tag where you want the +1 button to render. -->
				<div class="g-plusone"></div>
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<div class="social">
				<a href="//www.pinterest.com/pin/create/button/" data-pin-do="buttonBookmark"  data-pin-shape="round" data-pin-height="28"><img src="//assets.pinterest.com/images/pidgets/pinit_fg_en_round_red_28.png" /></a>
				<!-- Please call pinit.js only once per page -->
				<script type="text/javascript" async src="//assets.pinterest.com/js/pinit.js"></script>
			</div>
		</td>
	</tr>
</table>

  
  
  
  

				</td></tr>
			</tbody>
		</table>
		
		<?php echo $description ?>
<?php
if (isset($wikiPath)) {
   print "<br>";
   print "<a href='{$wikiPath}' target='_blank'>WIKI</a>";
}
?>
	</small>
</div>

<?php include $_SERVER['DOCUMENT_ROOT']."/art/common/footer.php"; ?>