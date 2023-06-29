<jsp:include page="../header.jsp">
	<jsp:param value="Registration" name="HTMLtitle" />
</jsp:include>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet"/>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
      <link href="css/zephyr.css" rel="stylesheet">
      <link href="css/styles.css" rel="stylesheet">
    <!-- Register Form-->
    <section class="bg-light py-5">
      <div class="container px-5 my-5 px-5">
          <div class="text-center mb-5">
              <div class="feature bg-danger bg-gradient text-white rounded-3 mb-3"><i class="bi bi-pen"></i></div>
              <h2 class="fw-bolder">Register Now!</h2>
              <p class="lead mb-0">Be part of ABC Jobs today!</p>
          </div>
          <div class="row gx-5 justify-content-center">
              <div class="col-lg-6">
                  <form action="registration" method="post">
                      <!-- First Name input-->
                      <div class="form-floating mb-3">
                          <input class="form-control" id="firstName" name="firstName" required type="text" placeholder="Enter your first name..." data-sb-validations="required" />
                          <label for="firstname">First name</label>
                          <div class="invalid-feedback" data-sb-feedback="firstname:required">A First name is required!</div>
                      </div>
                      <!-- Last Name input-->
                      <div class="form-floating mb-3">
                        <input class="form-control" id="lastName" name="lastName" type="text" placeholder="Enter your last name..." data-sb-validations="required" />
                        <label for="lastname">Last name</label>
                        <div class="invalid-feedback" data-sb-feedback="lastname:required">A Last name is required!</div>
                    </div>
                     
                      <!-- Email address input-->
                      <div class="form-floating mb-3">
                          <input class="form-control" id="emailAddress" name="emailAddress" required type="email" placeholder="name@example.com" data-sb-validations="required,email" />
                          <label for="email">Email address</label>
                          <div class="invalid-feedback" data-sb-feedback="email:required">An email is required.</div>
                      </div>
                      <!-- Password input-->
                      <div class="form-floating mb-3">
                        <input class="form-control" id="password" name="password" required type="password" placeholder="p@ssw0rd" data-sb-validations="required" />
                        <label for="password">Password</label>
                        <div class="invalid-feedback" data-sb-feedback="password:required">A password is required.</div>
                    </div>
                      <!-- Confirm Password input-->
                      <div class="form-floating mb-3">
                        <input class="form-control" id="passwordConfirmation" name="passwordConfirmation" required type="password" placeholder="p@ssw0rd" data-sb-validations="required" />
                        <label for="password">Confirm Password</label>
                        <div class="invalid-feedback" data-sb-feedback="password:required">A password is required.</div>
                    </div>

                      <div class="d-none" id="submitSuccessMessage">
                          <div class="text-center mb-3">
                              <div class="fw-bolder">User has been registered!</div>
                              </div>
                      </div>

                      <!-- Submit Button-->
                      <div class="d-grid"><button class="btn btn-danger btn-lg" id="submitButton" type="submit">Register</button></div>
                  </form>
              </div>
          </div>
      </div>
  </section>
  

<jsp:include page="../footer.jsp"></jsp:include>