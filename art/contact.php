<?php include("common/header.php"); ?>

<form role="form" form action="/webformmailer.php" method="post">
<input type="hidden" name="subject" value="Submission" />
<input type="hidden" name="redirect" value="/index.php" />
<input type="hidden" name="form_delivery" value="digest"/>
<input type="hidden" name="form_format" value="html"/>

  <div class="form-group">
    <label style="float: left;">Your Name</label>
    <input type="text" class="form-control" placeholder="Your Name" name="FirstName" maxlength="400">
  </div>
  <div class="form-group">
    <label style="float: left;">Email Address</label>
    <input type="email" class="form-control" placeholder="Enter email" name="email" maxlength="400">
  </div>
  <div class="form-group">
    <label style="float: left;">Comments</label>
    <textarea rows="11" class="form-control" placeholder="Comments" name="comments" maxlength="2000"></textarea>
  </div>
  <div class="actions">
    <input type="submit" value="Send Your Message" name="submit" id="submitButton" class="btn pull-right" title="Click here to submit your message!" />
  </div>
</form>

<?php include("common/footer.php"); ?>