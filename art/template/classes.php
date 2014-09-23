<?php
class Painting
{
    public $folder;
	public $imageName;
	public $title;

    public function __construct($folder, $imageName, $title)
    {
        $this->folder = $folder;
        $this->imageName = $imageName;
        $this->title = $title;
    }

    public function __toString()
    {
        return $this->folder;
        return $this->imageName;
        return $this->title;
    }
}
?>