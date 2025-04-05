<jsp:include page="../../header.jsp">
    <jsp:param value="Feedback" name="HTMLtitle" />
</jsp:include>
<head>
    <title>Feedback</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
</head>
<body>
	<section class="bg-light py-5">
      <div class="container px-5 my-5 px-5">
          <div class="text-center mb-5">
              <div class="feature bg-danger bg-gradient text-white rounded-3 mb-3"><i class="bi bi-search"></i></div>
              <h2 class="fw-bolder">Feedback</h2>
              <p class="lead mb-0">Have a complaint? Paste them here.</p>
          </div>
          
          <!--  Feedback Form -->
          <form id="feedbackForm">
  <div class="form-floating mb-3">
    <input type="text" class="form-control" id="name" name="name" required>
    <label for="name">Name</label>
  </div>
  <div class="form-floating mb-3">
    <input type="text" class="form-control" id="issue_type" name="issue_type" required>
    <label for="issue_type">Issue Type</label>
  </div>
  <div class="form-floating mb-3">
    <input type="text" class="form-control" id="issue_title" name="issue_title" required>
    <label for="issue_title">Issue Title</label>
  </div>
  <div class="form-floating mb-3">
    <input type="text" class="form-control" id="issue_description" name="issue_description" required>
    <label for="issue_description">Issue Description</label>
  </div>
  <div class="form-floating mb-3">
    <input type="text" class="form-control" id="issue_steps" name="issue_steps" required>
    <label for="issue_steps">Issue Steps</label>
  </div>
  <div class="form-floating mb-3">
    <input type="text" class="form-control" id="issue_expected" name="issue_expected" required>
    <label for="issue_expected">Issue Expected</label>
  </div>
    <div class="form-floating mb-3">
    <input type="text" class="form-control" id="issue_actual" name="issue_actual" required>
    <label for="issue_actual">Issue Actual</label>
  </div>
  <input type="submit" value="Submit" class="btn btn-primary">
</form>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>

<script>
    $("#feedbackForm").submit(function(event) {
        event.preventDefault();
        var name = $("#name").val();
        var issue_type = $("#issue_type").val();
        var issue_title = $("#issue_title").val();
        var issue_description = $("#issue_description").val();
        var issue_steps = $("#issue_steps").val();
        var issue_expected = $("#issue_expected").val();
        var issue_actual = $("#issue_actual").val();

        // Create a JSON object representing the feedback data
        var feedbackData = {
            name: name,
            issue_type: issue_type,
            issue_title: issue_title,
            issue_description: issue_description,
            issue_steps: issue_steps,
            issue_expected: issue_expected,
            issue_actual: issue_actual
        };

        $.ajax({
            url: "http://100.77.207.39:8080/api/feedback/add",
            type: "POST",
            data: JSON.stringify(feedbackData),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(data) {
                console.log(data);
                // Replace the form with a thank you message
                $("#feedbackForm").replaceWith("<h1 class='fw-bolder'>Thank you for your feedback!</h1><h2 class='lead mb-0'>Our team will be glad to review it!</h2>");
            }
        });
    });
</script>

    </div>
    </section>


</body>
<jsp:include page="../../footer.jsp"></jsp:include>