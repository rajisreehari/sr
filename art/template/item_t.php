<?php include $_SERVER['DOCUMENT_ROOT']."/art/common/header.php"; ?>

<div><h1><?php echo $title ?><br><small class="<?php echo $inspiredClass ?>">(Inspired By <?php echo $inspired ?>)</small></h1></div>
<IMG src="<?php echo $imagePath ?>.jpg" class="img-thumbnail mainImage">

<div align="left" class="mainText">
	<small>
		<table class="table table-condensed detailsTable">
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
		<td>
			<div style="margin-bottom: 8px;" class="social">
				<?php include $_SERVER['DOCUMENT_ROOT']."/art/template/facebook.php"; ?>
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<div class="social">
				<?php include $_SERVER['DOCUMENT_ROOT']."/art/template/twitter.php"; ?>
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<div class="social">
				<?php include $_SERVER['DOCUMENT_ROOT']."/art/template/google.php"; ?>
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<div class="social">
				<?php include $_SERVER['DOCUMENT_ROOT']."/art/template/pinterest.php"; ?>
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