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

	<div class="p-5">

		<c:if test="${empty search_result}">
			<h3>Store not found for ${searchKey}</h3>
		</c:if>
		<c:if test="${not empty search_result}">
			<main class="page contact-us-page">
				<section class="clean-block clean-form dark">
					<div class="container">
						<div class="block-heading">
							<h2 class="text-info">Search Results</h2>
							<p>Search stores created by a user.</p>
						</div>
						<section class="clean-block features">
							<div class="container"> <!-- Reference -->
								<table class="table table-striped">
									<thead class="thead-dark">
									<tr>
										<th>Store Name</th>
										<th>Phone Number</th>
										<th>Localities</th>
										<sec:authorize access="hasRole('Administrator')">
											<th>Action</th>
										</sec:authorize>
									</tr>
									</thead>

									<tbody>
									<c:forEach items="${search_result}" var="u">
										<tr>
											<td>${u.getName()}</td>
											<td>${u.getPhone_number()}</td>
											<td>${u.getLocalities()}</td>
											<sec:authorize access="hasRole('Administrator')">
												<td><a class="pr-5" href="addStore">Add</a> <a class="pr-5"
																							   href="/update?sid=${u.id}">Update</a> <a class="pr-5"
																																		href="/delete?sid=${u.id}">Delete</a></td>
											</sec:authorize>
										</tr>
									</c:forEach>


									</tbody>
								</table>
							</div>
						</section>
					</div>
				</section>
			</main>

		</c:if>

	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>

</body>
</html>