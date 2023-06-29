<jsp:include page="../header.jsp">
    <jsp:param value="Login" name="HTMLtitle" />
</jsp:include>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet"/>
<!-- Log-in Form-->
    <section class="bg-light py-5">
      <div class="container px-5 my-5 px-5">
          <div class="text-center mb-5">
              <div class="feature bg-danger bg-gradient text-white rounded-3 mb-3"><i class="bi bi-key"></i></div>
              <h2 class="fw-bolder">Log-in</h2>
              <p class="lead mb-0">Don't have an account? <a href="registration">Register Now</a></p>
          </div>
          <div class="row gx-5 justify-content-center">
              <div class="col-lg-6">
                  <form action="login" method="post">
                  	<div class="alert alert-danger alert-dismissible fade show my-3 ${ message == null ? "d-none" : "d-block" }" role="alert">
  						${ message }
  						<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
	
					<div class="alert alert-success alert-dismissible fade show my-3 ${ scMessage == null ? "d-none" : "d-block" }" role="alert">
  						${ scMessage }
  						<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
                      <!-- Email address input-->
                      <div class="form-floating mb-3">
                          <input type="email" class="form-control" id="emailAddress" name="emailAddress" required/>
                          <label for="email">Email address</label>
                      </div>
                      <!-- Password input-->
                      <div class="form-floating mb-3">
                        <input type="password" class="form-control" id="password" name="password" required/>
                        <label for="password">Password</label>
                        <a href="forgot-password">Forgot Password?</a>
                    </div>
                    
                   
                      <!-- Submit Button-->
                      <div class="d-grid"><button class="btn btn-danger btn-lg" id="submitButton" type="submit">Log-in</button></div>
                  </form>
              </div>
          </div>
      </div>
  </section>
  
<jsp:include page="../footer.jsp"></jsp:include>