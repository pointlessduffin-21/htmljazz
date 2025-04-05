<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../header.jsp">
    <jsp:param value="Job Manager" name="HTMLtitle" />
    <jsp:param value="../css/zephyr.css" name="isNested" />
</jsp:include>
<head>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

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

                        $("#jobsTable tbody").empty();
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

                            $("#jobsTable tbody").append("<tr><td>" + job.id + "</td><td>" + job.company_name + "</td><td>" + formattedDate + "</td><td>" + job.job_title + "</td><td>" + job.job_description + "</td><td><a href='#' class='applyJobLink" + (applied ? " disabled" : "") + "' data-job-id='" + job.id+ "'>" + applyJobText+ "</a></td><td><button class='deleteJobButton' data-job-id='" + job.id+ "'>Delete Job</button></td></tr>");
                        });
                    }
                });
            }

            // Load all jobs on page load
            loadJobs();

            // Set refresh timer to update jobs every 10 seconds
            setInterval(loadJobs, 10000);

            // Handle clicks on delete buttons
            $(document).on("click", ".deleteJobButton", function() {
                var jobId = $(this).data("job-id");
                $.ajax({
                    url: "http://100.77.207.39:5637/api/job/delete/" + jobId,
                    type: "DELETE",
                    success: function() {
                        alert("Job deleted successfully!");
                        loadJobs();
                    }
                });
            });
        });
    </script>
</head>
<body>
   <section class="bg-light py-5">
      <div class="container px-5 my-5 px-5">
          <div class="text-center mb-5">
              <div class="feature bg-danger bg-gradient text-white rounded-3 mb-3"><i class="bi bi-search"></i></div>
              <h2 class="fw-bolder">Job Manager</h2>
              <p class="lead mb-0">Monitor jobs here!</p>
          </div>
          <div class="container">
    <table class="table table-hover my-3" id="jobsTable">
        <thead>
            <tr>
                <th>ID</th>
                <th>Company Name</th>
                <th>Creation Date</th>
                <th>Title</th>
                <th>Description</th>
                <th>Actions</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody></tbody>
    </table>
    </div>
    </div>
    </section>
</body>


<jsp:include page="../../footer.jsp"></jsp:include>

