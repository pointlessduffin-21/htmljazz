<jsp:include page="../header.jsp">
	<jsp:param value="Reset" name="HTMLtitle" />
</jsp:include>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet"/>

<!-- Reset Password Form-->
    <section class="bg-light py-5">
      <div class="container px-5 my-5 px-5">
          <div class="text-center mb-5">
              <div class="feature bg-danger bg-gradient text-white rounded-3 mb-3"><i class="bi bi-key-fill"></i></div>
              <h2 class="fw-bolder">Reset your password</h2>
          </div>
          <div class="row gx-5 justify-content-center">
              <div class="col-lg-6">
                  <form action="reset" method="post">
                      
                      <!-- Password input-->
                      <div class="form-floating mb-3">
                        <input type="password" class="form-control" id="password" name="password" required />
                        <label for="password">Password</label>
                        <div class="invalid-feedback" data-sb-feedback="password:required">A password is required.</div>
                    </div>
                      <!-- Confirm Password input-->
                      <div class="form-floating mb-3">
                        <input type="password" class="form-control" id="passwordConfirmation" required />
                        <label for="password">Confirm Password</label>
                        <div class="invalid-feedback" data-sb-feedback="password:required">A password is required.</div>
                    </div>

                      <div class="d-none" id="submitSuccessMessage">
                          <div class="text-center mb-3">
                              <div class="fw-bolder">Reset Success.</div>
                              </div>
                      </div>

                      <!-- Submit Button-->
                      <div class="d-grid"><button class="btn btn-danger btn-lg" type="submit">Update Password</button></div>
                  </form>
              </div>
          </div>
      </div>
  </section>
  


<jsp:include page="../footer.jsp"></jsp:include>