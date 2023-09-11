<jsp:include page="../../header.jsp">
    <jsp:param value="Job" name="HTMLtitle" />
</jsp:include>
<head>
    <title>Job Form</title>
    <style>
        /* Style the cards */
        .card {
            box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
            transition: 0.3s;
            width: 300px;
            margin: 10px;
            display: inline-block;
        }

        .card:hover {
            box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
        }

        .container {
            padding: 2px 16px;
        }
        
        .applyJobLink.disabled {
    pointer-events: none;
    color: #999;
}
        
    </style>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
</head>
<body>

<section class="bg-light py-5">
      <div class="container px-5 my-5 px-5">
          <div class="text-center mb-5">
              <div class="feature bg-danger bg-gradient text-white rounded-3 mb-3"><i class="bi bi-search"></i></div>
              <h2 class="fw-bolder">Jobs</h2>
              <p class="lead mb-0">Find jobs here.</p>
          </div>
          
          <!-- Button to trigger the modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#jobModal">
  Add Job
</button>

<!-- Modal -->
<div class="modal fade" id="jobModal" tabindex="-1" aria-labelledby="jobModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="jobModalLabel">Add Job</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form id="jobForm">
          <div class="form-floating mb-3">
            <input type="text" class="form-control" id="job_title" name="job_title" required>
            <label for="job_title">Job Title</label>
          </div>
          <div class="form-floating mb-3">
            <input type="text" class="form-control" id="job_description" name="job_description" required>
            <label for="job_description">Job Description</label>
          </div>
          <div class="form-floating mb-3">
            <input type="text" class="form-control" id="company_name" name="company_name" required>
                        <label for="company_name">Company Name</label>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <input type="submit" form="jobForm" value="Submit" class="btn btn-primary">
      </div>
    </div>
  </div>
</div>

    <div id="jobsSection"></div>

    <script src="<URL>"></script>
<script>
    $(document).ready(function() {
        // Function to load all jobs
        function loadJobs() {
            $.ajax({
                url: "http://100.77.207.39:5637/api/job/all",
                type: "GET",
                success: function(data) {
                    // Sort jobs by newest
                    data.sort(function(a, b) {
                        return new Date(b.job_creation) - new Date(a.job_creation);
                    });

                    $("#jobsSection").empty();
                    data.forEach(function(job) {
                        // Format the date
                        var date = new Date(job.job_creation);
                        var formattedDate = date.toLocaleDateString() + " " + date.toLocaleTimeString();

                        // Check if the current user has already applied for this job
                        var applied = false;
                        $.ajax({
                            url: "http://100.77.207.39:5637/api/job/" + job.id + "/applicants/all",
                            type: "GET",
                            async: false,
                            success: function(applicants) {
                                applicants.forEach(function(applicant) {
                                    if (applicant.applicant_name === "${fullName}") {
                                        applied = true;
                                    }
                                });
                            }
                        });

                        // Update the text of the Apply Job link
                        var applyJobText = applied ? "Applied" : "Apply Job";

                        $("#jobsSection").append("<div class='col-9'><br /><div class='border rounded-3 mb-3 px-3' id='job" + job.id + "'><div class='d-flex align-items-center gap-2 py-3'><span class='px-3 py-2 rounded-circle border'>" + job.company_name.charAt(0) + "</span><a href='' class='text-decoration-none fs-5 text-danger' id='company_name'>" + job.company_name + "</a><small class='ms-auto'>" + formattedDate + "</small></div><div class=''><p class='fw-bold fs-4' id='job_title'>" + job.job_title + "</p><p class='fs-5' id='content'>" + job.job_description + "</p></div><a href='#' class='applyJobLink" + (applied ? " disabled" : "") + "' data-job-id='" + job.id + "'>" + applyJobText + "</a></div></div>");
                    });
                }
            });
        }

        // Load all jobs on page load
        loadJobs();

        // Set refresh timer to update jobs every 10 seconds
        setInterval(loadJobs, 10000);

        // Submit form to add new job
        $("#jobForm").submit(function(event) {
            event.preventDefault();
            var creator = "${fullName}";
            var job_title = $("#job_title").val();
            var job_description = $("#job_description").val();
            var company_name = $("#company_name").val();

            $.ajax({
                url: "http://100.77.207.39:5637/api/job/add",
                type: "POST",
                data: JSON.stringify({
                    creator: creator,
                    job_title: job_title,
                    job_description: job_description,
                    company_name: company_name
                }),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function(data) {
                    console.log(data);
                    // Reload all jobs
                    loadJobs();
                    // Close the modal
                    $("#jobModal .btn-close").click();
                }
            });
        });

        // Add event listener for clicking the Apply Job link
        $(document).on("click", ".applyJobLink", function(event) {
            event.preventDefault();
            var jobId = $(this).data("job-id");
            var applicantName = "${fullName}";
            var link = $(this);

            $.ajax({
                url: "http://100.77.207.39:5637/api/job/" + jobId + "/applicants/add",
                type: "POST",
                data: JSON.stringify({
                    applicant_name: applicantName
                }),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function(data) {
                    console.log(data);
                    alert("You have successfully applied for the job!");
                    link.text("Applied");
                    link.addClass("disabled");
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    if (jqXHR.status === 409) {
                        alert("You have already applied for this job!");
                        link.text("Applied");
                        link.addClass("disabled");
                    } else {
                        console.error(jqXHR, textStatus, errorThrown);
                    }
                }
            });
        });
    });
</script>




    </div>
    </section>

</body>
<jsp:include page="../../footer.jsp"></jsp:include>
