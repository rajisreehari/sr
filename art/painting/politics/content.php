<?php include $_SERVER['DOCUMENT_ROOT']."/art/template/classes.php"; ?>

<?php
$paintingTitle = "Politics";
$arrayOfImages = array(
new Painting('politics', 'animal_farm', 'Animal Farm'),
new Painting('politics', 'business', 'Business'),
new Painting('politics', 'fair', 'Fair'),
new Painting('politics', 'fox', 'Fox'),
new Painting('politics', 'political_speech', 'Political Speech')
	);
?>

<?php include $_SERVER['DOCUMENT_ROOT']."/art/template/content_t.php"; ?>