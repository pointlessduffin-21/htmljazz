<jsp:include page="../../header.jsp">
    <jsp:param value="verificationcode" name="HTMLtitle" />
</jsp:include>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet"/>

<!-- Enter Email Form-->
    <section class="bg-light py-5">
      <div class="container px-5 my-5 px-5">
          <div class="text-center mb-5">
              <div class="feature bg-danger bg-gradient text-white rounded-3 mb-3"><i class="bi bi-file-lock2"></i></div>
              <h2 class="fw-bolder">Verification Code</h2>
              <p class="lead mb-0">Please enter your verification code below.</p>
          </div>
          <div class="row gx-5 justify-content-center">
              <div class="col-lg-6">
                  <form action="verificationcode" method="post">
                  	<div class="alert alert-danger ${message == null ? "d-none" : "d-block"}" role="alert">
  						${message}
					</div>
                      <!-- Code input-->
                      <div class="form-floating mb-3">
                          <input type="number" class="form-control" id="code" name="code" required/>
                          <label for="verify">Verification Code</label>
                          <div class="invalid-feedback" data-sb-feedback="code:required">Code is required.</div>
                      </div>
                      <!-- Submit Button-->
                      <div class="d-grid"><button class="btn btn-danger btn-lg" type="submit">Submit</button></div>
                  </form>
              </div>
          </div>
      </div>
  </section>
 
  
  

<jsp:include page="../../footer.jsp"></jsp:include>