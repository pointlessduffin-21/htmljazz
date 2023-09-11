<jsp:include page="../header.jsp">
    <jsp:param value="Forgot Password" name="HTMLtitle" />
</jsp:include>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet"/>

<!-- Enter Email Form-->
    <section class="bg-light py-5">
      <div class="container px-5 my-5 px-5">
          <div class="text-center mb-5">
              <div class="feature bg-danger bg-gradient text-white rounded-3 mb-3"><i class="bi bi-file-lock2"></i></div>
              <h2 class="fw-bolder">Reset your password</h2>
              <p class="lead mb-0">Enter your email address below.</p>
          </div>
          <div class="row gx-5 justify-content-center">
              <div class="col-lg-6">
                  <form action="forgot-password" method="post">
                  	<div class="alert alert-danger ${message == null ? "d-none" : "d-block"}" role="alert">
  						${message}
					</div>
                      <!-- Email address input-->
                      <div class="form-floating mb-3">
                          <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="emailAddress" required/>
                          <label for="email">Email address</label>
                          <div class="invalid-feedback" data-sb-feedback="email:required">An email is required.</div>
                          <div class="invalid-feedback" data-sb-feedback="email:email">Email is not valid.</div>
                      </div>
                      <!-- Reset your password Button-->
                      <div class="d-grid"><button class="btn btn-danger btn-lg" type="submit">Reset</button></div>
                  </form>
              </div>
          </div>
      </div>
  </section>
  

<jsp:include page="../footer.jsp"></jsp:include>