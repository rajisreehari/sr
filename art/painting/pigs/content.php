<?php include $_SERVER['DOCUMENT_ROOT']."/art/template/classes.php"; ?>

<?php
$paintingTitle = "Pigs";
$arrayOfImages = array(
new Painting('pigs', 'america', 'America'),
new Painting('pigs', 'england', 'England'),
new Painting('pigs', 'france', 'France'),
new Painting('pigs', 'germany', 'Germany'),
new Painting('pigs', 'japan', 'Japan')
	);
?>

<?php include $_SERVER['DOCUMENT_ROOT']."/art/template/content_t.php"; ?>