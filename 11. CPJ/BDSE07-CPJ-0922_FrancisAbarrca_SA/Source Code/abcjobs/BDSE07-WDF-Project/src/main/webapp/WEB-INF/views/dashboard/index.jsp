<jsp:include page="../../header.jsp">
    <jsp:param value="Dashboard" name="HTMLtitle" />
</jsp:include>

<head>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
</head>

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
        
  /* The Modal (background) */
  .modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto;
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
  }

  /* Modal Content/Box */
  .modal-content {
    background-color: #fefefe;
    margin: 15% auto; /* 15% from the top and centered */
    padding: 20px;
    border: 1px solid #888;
    width: 80%; /* Could be more or less, depending on screen size */
  }

  /* The Close Button */
  .close {
    color: #aaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
  }

  .close:hover,
  .close:focus {
    color: black;
    text-decoration: none;
    cursor: pointer;
  }
    </style>

<div class="container">
   <div class="row">
     <div class="col-3"> 
       <div class="d-flex flex-column border rounded-3 pb-4">
       
         <a href="profile" class="text-decoration-none">
           <div class="border p-0 rounded-3 border-5">
             <div class="fs-1 d-flex align-items-center justify-content-center bg-danger text-white" style="height: 25vh;">
              <span>${f}</span>
              <span>${l}</span>
            </div>
          </div>
        </a>
        <div class="px-4 py-3">
          <h2>${fullName}</h2>
          <p>${title} | ${company}</p>
        </div>
        <button class="btn btn-outline-success mx-4">Create post</button>
      </div>
    </div>
    
    <!-- Add a modal to the page -->
<div id="postModal" class="modal">
  <div class="modal-content">
    <span class="close">&times;</span>
    <h2>Create Post</h2>
    <form id="postForm">
  <label for="content">Content:</label><br>
  <input type="text" id="content" name="content"><br>
  <label for="file">Photo:</label><br>
  <input type="file" id="file" name="file"><br><br>
  <input type="submit" value="Submit">
</form>
  </div>
</div>
    
    <div class="col-6">
    	<h1>Posts</h1>

    <div id="postsSection"></div>

    <script src="<URL>"></script>

    <script>
        $(document).ready(function() {
        	
        	// Get the modal
        	  var modal = document.getElementById("postModal");

        	  // Get the button that opens the modal
        	  var btn = document.querySelector(".btn-outline-success");

        	  // Get the <span> element that closes the modal
        	  var span = document.getElementsByClassName("close")[0];

        	  // When the user clicks on the button, open the modal
        	  btn.onclick = function() {
        	    modal.style.display = "block";
        	  }

        	  // When the user clicks on <span> (x), close the modal
        	  span.onclick = function() {
        	    modal.style.display = "none";
        	  }

        	  // When the user clicks anywhere outside of the modal, close it
        	  window.onclick = function(event) {
        	    if (event.target == modal) {
        	      modal.style.display = "none";
        	    }
        	  }
        	  
        	// Submit form to add new post
        	  $("#postForm").submit(function(event) {
        event.preventDefault();
        var creator = "${fullName}";
        var content = $("#content").val();
        var file = $("#file").prop("files")[0];

        // Create a FormData object to hold the form data
        var formData = new FormData();
        formData.append("post", new Blob([JSON.stringify({
            creator: creator,
            content: content
        })], {type: "application/json"}));
        formData.append("file", file);

        // Send the form data to the server using an AJAX request
        $.ajax({
            url: "http://100.77.207.39:5637/api/post/add",
            type: "POST",
            data: formData,
            processData: false,
            contentType: false,
            success: function(data) {
                console.log(data);
                // Reload all posts
                loadPosts();
                // Close the modal
                modal.style.display = "none";
            }
        });
    });


        	// Function to load all posts
        	  function loadPosts() {
    $.ajax({
        url: "http://100.77.207.39:5637/api/post/all",
        type: "GET",
        success: function(data) {
            // Sort the data by post_dateTime in descending order
            data.sort(function(a, b) {
                return new Date(b.post_dateTime) - new Date(a.post_dateTime);
            });

            $("#postsSection").empty();
            data.forEach(function(post) {
                // Format the date
                var date = new Date(post.post_dateTime);
                var formattedDate = date.toLocaleDateString() + " " + date.toLocaleTimeString();

             // Add an image element if the post has a photoURL
                var imageElement = "";
                if (post.photoURL) {
                    imageElement = "<img src='" + post.photoURL + "' alt='Post image' style='max-width: 100%;'>";
                }

                $("#postsSection").append("<div class='col-9'><br /><div class='border rounded-3 mb-3 px-3' id='post" + post.id + "'><div class='d-flex align-items-center gap-2 py-3'><span class='px-3 py-2 rounded-circle border'>" + post.creator.charAt(0) + "</span><a href='' class='text-decoration-none fs-5 text-danger' id='creator'>" + post.creator + "</a><small class='ms-auto'>" + formattedDate + "</small></div><div class=''><p class='fw-bold fs-4' id='content'>" + post.content + "</p>" + imageElement + "</div><div class='d-flex align-items-center gap-2 py-3'><a href='' class='d-flex align-items-center gap-2 btn btn-outline-secondary'><i class='bx bx-message-square-dots'></i> Comments</a></div></div></div>");
});
        }
    });
}

           // Load all posts on page load
           loadPosts();

           // Set refresh timer to update posts every 10 seconds
           setInterval(loadPosts, 10000);

           // Handle like button clicks
           $(document).on("click", ".likeBtn", function() {
               var postId = $(this).data("id");
               $.ajax({
                   url: "http://100.77.207.39:5637/api/post/" + postId,
                   type: "GET",
                   success: function(post) {
                       post.likes++;
                       $.ajax({
                           url: "http://100.77.207.39:5637/api/post/update/" + postId,
                           type: "PUT",
                           data: JSON.stringify(post),
                           contentType: "application/json; charset=utf-8",
                           dataType: "json",
                           success: function(data) {
                               console.log(data);
                               // Reload all posts
                               loadPosts();
                           }
                       });
                   }
               });
           });
       });
    </script>
    </div>


    <!-- <div class="col-6">
    <br />
      <div class="border rounded-3 mb-3 px-3" id="post1">
        <div class="d-flex align-items-center gap-2 py-3">
          <span class="px-3 py-2 rounded-circle border">A</span>
          <a href="" class="text-decoration-none fs-5 text-danger" id="creator">Alicia </a>
          <small class="ms-auto">3 minutes ago</small>
        </div>

        content
        <div class="">
          <p class="fw-bold fs-4" id="content">Come and join us at Alicia Residences!</p>
        </div>

        <div class="d-flex align-items-center gap-2 py-3">
          <a href="" class="d-flex align-items-center gap-2 btn btn-outline-secondary">
          	<i class='bx bx-message-square-dots'></i> Comments
          </a>
          <a href="" class="d-flex align-items-center gap-2 btn btn-outline-secondary">
          	<i class='bx bx-share-alt'></i> Share
       	  </a>
        </div>
      </div>

    </div> -->

    <div class="col-3">
    <br />
      <div class="py-3 px-4 rounded-3 border">
        
        <div class="border-bottom mb-3">
          <p>No new notifications!</p>
        </div>

        <div class="text-center">
          <a href="" class="btn btn-danger">See all notifications</a>
        </div>
      </div>
    </div>
  </div>
</div>

<jsp:include page="../../footer.jsp"></jsp:include>