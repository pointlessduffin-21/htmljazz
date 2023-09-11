<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../../header.jsp">
	<jsp:param value="Registration" name="HTMLtitle" />
</jsp:include>

<!-- Register Form-->
    <section class="bg-light py-5">
      <div class="container px-5 my-5 px-5">
          <div class="text-center mb-5">
              <div class="feature bg-danger bg-gradient text-white rounded-3 mb-3"><i class="bi bi-pen"></i></div>
              <h2 class="fw-bolder">Register Now!</h2>
              <p class="lead mb-0">Be part of ABC Jobs today!</p>
              <p>Have an account? <a href="login">Login</a></p>
          </div>
          <div class="row gx-5 justify-content-center">
              <div class="col-lg-6">
                  <form action="registration" method="post">
                  
                  	<!--  Error -->
                  	<div class="alert alert-danger ${errMsg != null ? " d-block" : "d-none" }" role="alert">
      					${errMsg}
    				</div>
                      <!-- First Name input-->
                      <div class="form-floating mb-3">
                          <input type="text" class="form-control" id="firstName" name="firstName" required/>
                          <label for="firstname">First name</label>
                          <div class="invalid-feedback" data-sb-feedback="firstname:required">A First name is required!</div>
                      </div>
                      <!-- Last Name input-->
                      <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="lastName" name="lastName" required/>
                        <label for="lastname">Last name</label>
                        <div class="invalid-feedback" data-sb-feedback="lastname:required">A Last name is required!</div>
                    </div>
                     
                      <!-- Email address input-->
                      <div class="form-floating mb-3">
                          <input type="email" class="form-control" id="emailAddress" name="email" value="<%= request.getParameter("email") != null ? request.getParameter("email") : "" %>" required/>
                          <label for="email">Email address</label>
                          <div class="invalid-feedback" data-sb-feedback="email:required">An email is required.</div>
                      </div>
                      <!-- Password input-->
                      <div class="form-floating mb-3">
                        <input type="password" class="form-control" id="password" name="password" required/>
                        <label for="password">Password</label>
                        <div class="invalid-feedback" data-sb-feedback="password:required">A password is required.</div>
                    </div>
                      <!-- Confirm Password input-->
                      <div class="form-floating mb-3">
                        <input type="password" class="form-control" id="passwordConfirmation" name="passwordConfirmation" required/>
                        <label for="password">Confirm Password</label>
                        <div class="invalid-feedback" data-sb-feedback="password:required">A password is required.</div>
                    </div>
                    

                      <div class="d-none" id="submitSuccessMessage">
                          <div class="text-center mb-3">
                              <div class="fw-bolder">User has been registered!</div>
                              </div>
                      </div>

                      <!-- Submit Button-->
                      <div class="d-grid"><button class="btn btn-danger btn-lg" type="submit">Register</button></div>
                  </form>
              </div>
          </div>
      </div>
  </section>
  
<jsp:include page="../../footer.jsp"></jsp:include>