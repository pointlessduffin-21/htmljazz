<jsp:include page="../../header.jsp">
    <jsp:param value="Thread" name="HTMLtitle" />
</jsp:include>
<head>
    <title>Thread Form</title>
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
    </style>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
</head>
<body>
	<section class="bg-light py-5">
      <div class="container px-5 my-5 px-5">
          <div class="text-center mb-5">
              <div class="feature bg-danger bg-gradient text-white rounded-3 mb-3"><i class="bi bi-search"></i></div>
              <h2 class="fw-bolder">Threads</h2>
              <p class="lead mb-0">Find Threads here.</p>
          </div>
          
          <!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#threadModal">
  Add Thread
</button>

<!-- Modal -->
<div class="modal fade" id="threadModal" tabindex="-1" aria-labelledby="threadModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="threadModalLabel">New Thread</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form id="threadForm">
          <div class="form-floating mb-3">
            <input type="text" class="form-control" id="thread_title" name="thread_title" required>
            <label for="thread_title">Thread Title</label>
          </div>
          <div class="form-floating mb-3">
            <input type="text" class="form-control" id="thread_content" name="thread_content" required>
            <label for="thread_content">Thread Content</label>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <input type="submit" value="Submit" form="threadForm" class="btn btn-primary">
      </div>
    </div>
  </div>
</div>


    <div id="threadsSection"></div>

    <script src="<URL>"></script>

    <script>
    $(document).ready(function() {
        // Function to load all threads
        function loadThreads() {
            $.ajax({
                url: "http://100.77.207.39:5637/api/threads/all",
                type: "GET",
                success: function(data) {
                    // Sort threads by newest
                    data.sort(function(a, b) {
                        return new Date(b.thread_dateTime) - new Date(a.thread_dateTime);
                    });

                    $("#threadsSection").empty();
                    data.forEach(function(thread) {
                        // Format the date
                        var date = new Date(thread.thread_dateTime);
                        var formattedDate = date.toLocaleDateString() + " " + date.toLocaleTimeString();

                        $("#threadsSection").append("<div class='col-9'><br /><div class='border rounded-3 mb-3 px-3' id='thread" + thread.id + "'><div class='d-flex align-items-center gap-2 py-3'><span class='px-3 py-2 rounded-circle border'>" + thread.creator.charAt(0) + "</span><a href='' class='text-decoration-none fs-5 text-danger' id='creator'>" + thread.creator + "</a><small class='ms-auto'>" + formattedDate + "</small></div><div class=''><p class='fw-bold fs-4' id='title'>" + thread.thread_title + "</p><p class='fs-5' id='content'>" + thread.thread_content + "</p></div><div id='comments" + thread.id + "'></div><form id='commentForm" + thread.id + "'><input type='text' id='comment" + thread.id + "'><input type='submit' value='Add Comment'></form></div></div>");

                        // Load comments for the thread
                        loadComments(thread.id);
                    });
                }
            });
        }

        // Function to load all comments for a thread
        function loadComments(threadId) {
            $.ajax({
                url: "http://100.77.207.39:5637/api/threads/" + threadId + "/comments/all",
                type: "GET",
                success: function(data) {
                    // Sort comments by newest
                    data.sort(function(a, b) {
                        return new Date(b.comment_dateTime) - new Date(a.comment_dateTime);
                    });

                    $("#comments" + threadId).empty();
                    data.forEach(function(comment) {
                        // Format the date
                        var date = new Date(comment.comment_dateTime);
                        var formattedDate = date.toLocaleDateString() + " " + date.toLocaleTimeString();

                        $("#comments" + threadId).append("<div class=<'border rounded-3 mb-3 px-3' id=<'comment" + comment.id +" '><div class=<'d-flex align-items-center gap-2 py-3'><span class=<'px-3 py-2 rounded-circle border'>" + comment.creator.charAt(0) +" </span><a href='' class=<'text-decoration-none fs-5 text-danger' id=<'creator'>" + comment.creator +" </a><small class=<'ms-auto'>" + formattedDate +" </small></div><div class=<''><p class=<'fs-5' id=<'content'>" + comment.comment_content +
                            "</p></div></div>");
                    });
                }
            });
        }

        // Load all threads on page load
        loadThreads();

        // Set refresh timer to update threads every 10 seconds
        setInterval(loadThreads, 10000);

        // Submit form to add new thread
        $("#threadForm").submit(function(event) {
            event.preventDefault();
            var creator = "${fullName}";
            var thread_title = $("#thread_title").val();
            var thread_content = $("#thread_content").val();
            var thread_likes = $("#thread_likes").val();

            $.ajax({
                url: "http://100.77.207.39:5637/api/threads/add",
                type: "POST",
                data: JSON.stringify({
                    creator: creator,
                    thread_title: thread_title,
                    thread_content: thread_content,
                    thread_likes: thread_likes
                }),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function(data) {
                    console.log(data);
                    // Reload all threads
                    loadThreads();
                    // Close modal
                    $('#threadModal').modal('hide');
                }
            });
        });

        // Submit form to add new comment
        $(document).on("submit", "[id^=commentForm]", function(event) {
            event.preventDefault();
            var comment = $(this).find("input[type=text]").val();
            var threadId = $(this).attr("id").replace("commentForm", "");

            $.ajax({
                url: "http://100.77.207.39:5637/api/threads/" + threadId + "/comments/add",
                type: "POST",
                data: JSON.stringify({
                    creator: "${fullName}",
                    comment_content: comment
                }),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function(data) {
                    console.log(data);
                    // Reload comments for the thread
                    loadComments(threadId);
                }
            });
        });
    });


    </script>
    </div>
    </section>


</body>
<jsp:include page="../../footer.jsp"></jsp:include>