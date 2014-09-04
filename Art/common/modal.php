<ul class="pagination pagination-sm">
  <li><a href="/jorge/painting/anxiety/content.php" data-toggle="modal" data-target="#myModal">1</a></li>
  <li><a href="/jorge/painting/city/content.php" data-toggle="modal" data-target="#myModal">2</a></li>
  <li><a href="/jorge/painting/cubes/content.php" data-toggle="modal" data-target="#myModal">3</a></li>
  <li><a href="/jorge/painting/ghosts/content.php" data-toggle="modal" data-target="#myModal">4</a></li>
  <li><a href="/jorge/painting/hollywood/content.php" data-toggle="modal" data-target="#myModal">5</a></li>
  <li><a href="/jorge/painting/mix/content.php" data-toggle="modal" data-target="#myModal">6</a></li>
  <li><a href="/jorge/painting/pigs/content.php" data-toggle="modal" data-target="#myModal">7</a></li>
  <li><a href="/jorge/painting/politics/content.php" data-toggle="modal" data-target="#myModal">8</a></li>
  <li><a href="/jorge/painting/turnheads/content.php" data-toggle="modal" data-target="#myModal">9</a></li>
  <li><a href="/jorge/painting/war/content.php" data-toggle="modal" data-target="#myModal">10</a></li>
</ul>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div>
      <button type="button" class="close" data-dismiss="modal" style="float: left;"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
      <h4 class="modal-title" id="myModalLabel">&nbsp;</h4>
    </div>
    <div class="modal-content">
    </div>
  </div>
</div>

<script type="text/javascript">
$(document.body).on('hidden.bs.modal', function () {
    $('#myModal').removeData('bs.modal')
});

//Edit SL: more universal
$(document).on('hidden.bs.modal', function (e) {
    $(e.target).removeData('bs.modal');
});
</script>