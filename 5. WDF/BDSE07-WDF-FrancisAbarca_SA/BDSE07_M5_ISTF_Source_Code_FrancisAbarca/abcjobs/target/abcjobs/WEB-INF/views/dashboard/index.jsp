<jsp:include page="../../header.jsp">
    <jsp:param value="Dashboard" name="HTMLtitle" />
</jsp:include>
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


    <div class="col-6">
    <br />
      <div class="border rounded-3 mb-3 px-3" id="post1">
        <div class="d-flex align-items-center gap-2 py-3">
          <span class="px-3 py-2 rounded-circle border">A</span>
          <a href="" class="text-decoration-none fs-5 text-danger">Alicia</a>
          <small class="ms-auto">3 minutes ago</small>
        </div>

        <!-- content -->
        <div class="">
          <p class="fw-bold fs-4">Come and join us at Alicia Residences!</p>
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

    </div>

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

-->
<jsp:include page="../../footer.jsp"></jsp:include>