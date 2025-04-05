<jsp:include page="../header.jsp">
    <jsp:param value="Thank You !" name="HTMLtitle" />
</jsp:include>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet"/>

    <!-- Thank You Form-->
    <section class="bg-light py-5">
      <div class="container px-5 my-5 px-5">
          <div class="text-center mb-5">
              <div class="feature bg-danger bg-gradient text-white rounded-3 mb-3"><i class="bi bi-file-lock2"></i></div>
              <h2 class="fw-bolder">Thank You!</h2>
              <p class="lead mb-0">Please check <span class="fw-bold">${email}</span> for the registration link!</p>
          </div>
               <!-- Get Confirmation Link Button-->
                      <div class="d-grid"><button class="btn btn-danger btn-lg" data-bs-toggle="modal" data-bs-target="#ver" id="submitButton" type="submit">Get Confirmation Link</button></div>
              </div>
  </section>

<!-- Modal -->
<div class="modal fade text-center" id="ver" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body">
      	<i class='bx bxs-envelope fs-2'></i>
      	<h2>Successful</h2>
      	<p>The link has been sent it to your email</p>
       	<a href="verificationcode" class="btn btn-danger">Continue</a>
      </div>
    </div>
  </div>
</div>

<jsp:include page="../footer.jsp"></jsp:include>