<link rel="icon" href="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets/img/kynlogo.png">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<link rel="stylesheet" href="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i&amp;display=swap">
<link rel="stylesheet" href="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets/css/baguetteBox.min.css">
<link rel="stylesheet" href="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets/css/vanilla-zoom.min.css">


<!-- Navbar -->
<nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
	<div class="container">
		<a class="navbar-brand logo" href="/">
			<img src="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets/img/kynlogo.png" alt="Know Your Neighborhood" style="width: 30px; height: auto;">
		</a>
		<button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1">
			<span class="visually-hidden">Toggle navigation</span>
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navcol-1">
			<ul class="navbar-nav ms-auto">
				<button type="button" class="navbar-toggler"
						data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
					<span class="navbar-toggler-icon"></span>
				</button>

				<sec:authorize access="!isAuthenticated()">
					<div class="navbar-nav">

						<a href="register_user" class="nav-item nav-link">Register</a>
					</div>
					<div class="navbar-nav ms-auto">
						<a href="login" class="nav-item nav-link">Login</a>
					</div>
				</sec:authorize>


				<sec:authorize access="isAuthenticated()">


					<div class="navbar-nav">
						<a class="nav-item nav-link" href="home">Home</a>

					</div>

					<a class="nav-item nav-link" href="addStore">Add Store</a>

					<a class="nav-item nav-link" href="viewStore">View Store</a>

					<div class="navbar-nav ms-auto">

						<form action="logout" method="post" style="padding: 7px;">
							<input type="hidden" name="${_csrf.parameterName}"
								   value="${_csrf.token}" /> <input type="submit" name="Logout"
																	value="Logout" class="btn btn-primary"></input>
						</form>
					</div>

				</sec:authorize>
			</ul>
		</div>
	</div>
</nav>






