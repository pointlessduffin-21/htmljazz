<%@ page contentType="text/html; charset=US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<!--  Enable Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


<!--  Access the Static Resources without using spring URL -->
<link href="/css/style.css" rel="stylesheet" />
<script src="/js/script.js"></script>

</head>

<body>


	<%@ include file="header.jsp"%>

	<main class="page contact-us-page">
		<section class="clean-block clean-form dark">
			<div class="container">
				<div class="block-heading">
					<h2 class="text-info">Register</h2>
					<p>Come and join us in the Know Your Neighborhood community!</p>
				</div>
				<%--@elvariable id="store" type=""--%>
				<sf:form action="register" method="post" class="was-validated" modelAttribute="user">

					<div class="mb-3 mt-3">
						<label for="name" class="form-label">Name:</label> <sf:input
							type="text" class="form-control"
							placeholder="Enter name" name="name" path="name" required="true" />
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>
					<div class="mb-3">
						<label for="userName" class="form-label">Username:</label> <sf:input
							type="text" class="form-control" id="userName"
							placeholder="Enter username" name="userName" path="userName" required="true" />
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email:</label> <sf:input
							type="email" class="form-control"
							placeholder="Enter username" name="email" path="email" required="true" />
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Password:</label> <sf:input
							type="password" class="form-control" id="password"
							placeholder="Enter password" name="password" path="password" required="true" />
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill out this field.</div>
					</div>

					<input type="submit" value="Register"
						   class="btn btn-primary" />
				</sf:form>
			</div>
		</section>
	</main>





</body>
</html>
