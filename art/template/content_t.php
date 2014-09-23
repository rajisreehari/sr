<?php
print "<h1>" . $paintingTitle . "</h1>";

print "<div id=\"columns\" align=\"center\">";

foreach ($arrayOfImages as &$value) {
	$folder = $value->{'folder'};

	if($folder=="paper"){
    	print "<div class=\"pin\" align=\"center\">";
	    print "<IMG src=\"/art/painting/" . $value->{'folder'} . "/" .
		  $value->{'imageName'} . ".jpg\" class=\"img-thumbnail lonelyImage indexImage370\"><p>" .
		  $value->{'title'} . "</p></div>";
	} else {
    	print "<div class=\"pin\" align=\"center\">";
	    print "<a href=\"/art/painting/" . $value->{'folder'} . 
		  "/" . $value->{'imageName'} . ".php\"><IMG src=\"/art/painting/" . $value->{'folder'} . "/" .
		  $value->{'imageName'} . ".jpg\" class=\"img-thumbnail lonelyImage indexImage370\"></a><p>" .
		  $value->{'title'} . "</p></div>";
	}
}

print "</div>";
?>