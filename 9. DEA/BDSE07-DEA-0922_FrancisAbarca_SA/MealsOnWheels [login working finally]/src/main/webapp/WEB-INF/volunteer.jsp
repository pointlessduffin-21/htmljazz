<%@ page import="com.Group1.MealsOnWheels.Entity.Meal_Order" %>
<%@ page import="com.Group1.MealsOnWheels.Entity.Meal" %>
<%@ page import="com.Group1.MealsOnWheels.Entity.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Volunteer Dashboard</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
<link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<!-- Favicon-->
<link href="https://cdn-icons-png.flaticon.com/512/7541/7541900.png"
	rel="icon">
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
</head>

<body id="page-top" class="dark-mode">

	<%@ include file="header.jsp"%>

	<div id="wrapper" class="container">
		<div class="d-flex flex-column" id="content-wrapper">
			<div id="content">
				<div class="container-fluid">
					<div
						class="d-sm-flex justify-content-between align-items-center mb-4"
						style="margin-bottom: 0px; margin-top: 16px;">
						<h3 class="text-dark mb-0">Dashboard</h3>
					</div>
					<div class="row">
						<div class="col-md-6 col-xl-6 col-xxl-6 mb-4">
							<div class="card shadow border-start-primary py-2">
								<div class="card-body">
									<div class="row align-items-center no-gutters ps-3">
										<div class="col-auto">
											<img src="assets/img/avatars/avatar3.jpeg">
										</div>
										<div class="col me-2 ps-3">
											<div class="text-uppercase text-secondary fw-bold text-xs mb-1 fs-5">
												<% String uName = (String) request.getAttribute("uName"); %>

												<span><%= uName %></span>
											</div>
											<span>Volunteer</span>
											<div class="text-dark fw-bold h5 mb-0"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6 col-xl-6 col-xxl-6 offset-xxl-0 mb-4">
							<div class="card shadow border-start-success py-2">
								<div class="card-body">
									<div class="row align-items-center no-gutters ps-3">
										<div class="col-auto">
											<i class="fas fa-user-check fa-2x text-gray-300"></i>
										</div>
										<div class="col me-2">
											<div class="text-uppercase text-success fw-bold text-xs mb-1">
												<span>STATUS</span>
											</div>
											<div class="text-dark fw-bold h5 mb-0">
												<div class="dropdown">
													<button id="status-btn"
														class="btn text-white dropdown-toggle"
														aria-expanded="false" data-bs-toggle="dropdown"
														type="button"
														style="height: 41px; background: #5ec58f; font-size: 18px;">Available</button>
													<div class="dropdown-menu">
														<a class="dropdown-item" href="#"
															onclick="changeStatus('Available')" style="color: green;">Available</a>
														<a class="dropdown-item" href="#"
															onclick="changeStatus('Busy')" style="color: orange;">Busy</a>
														<a class="dropdown-item" href="#"
															onclick="changeStatus('Offline')" style="color: grey;">Offline</a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<script>
							function changeStatus(status) {
								document.getElementById("status-btn").innerHTML = status;
								if (status === "Available") {
									document.getElementById("status-btn").style.backgroundColor = "#5ec58f";
								} else if (status === "Busy") {
									document.getElementById("status-btn").style.backgroundColor = "orange";
								} else if (status === "Offline") {
									document.getElementById("status-btn").style.backgroundColor = "grey";
								}
							}
						</script>
						<div class="row">
							<div class="col-lg-6 col-xxl-4 mb-4">
								<div class="card shadow mb-4"></div>
								<div class="card shadow mb-4">
									<div class="card-header py-3">
										<h6 class="text-secondary fw-bold m-0"
											style="color: rgb(45, 237, 42);">Incoming</h6>
									</div>
									<ul class="list-group list-group-flush ps-3">
									
									<% List<Meal_Order> ookOrders = (List<Meal_Order>) request.getAttribute("ookOrders"); %>
										<!-- Order 1 -->
										<li class="list-group-item">
										<% if (ookOrders != null && !ookOrders.isEmpty()) { %>
							           
							            <% for (Meal_Order order : ookOrders) { %>
											<div class="row align-items-center no-gutters border-bottom">
												<div class="col-xxl-7 me-2">
													<p class="mb-0 fw-bold">Order Number # <%= order.getOrder_number() %></p>
													<% List<Meal> meals = (List<Meal>) request.getAttribute("meals"); %>
														<% for (Meal meal : meals) { %>
	        											<% if (order.getM_id() == meal.getM_id()) { %>
													<p class=""><%= meal.getMeal_name() %></p>
													<% } %>
										            <% } %>
													<% List<User> users = (List<User>) request.getAttribute("users"); %>
														<% for (User user : users) { %>
	        											<% if (order.getU_id() == user.getId()) { %>
													
													<h6 class="mb-0">
														<strong><%= user.getName() %></strong>
													</h6>
													<p><%= user.getAddress() %></p>
													<% } %>
										            <% } %>
												</div>
												<form action="/volunteerReceives" method="post">
													<div class="col-xxl-4 offset-xxl-0">
														<input type="hidden" name="mo_id" id="mo_id" value="<%= order.getMo_id() %>">
														<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
														<button class="btn btn-success" type="submit"
															style="width: 126.037px; padding: 6px 12px; margin: 10px;">Receive
															</button>
													</div>
												</form>
											</div>
											<% } %>
            								<% } %>
										</li>
									
									</ul>
								</div>

								<!-- Decline Order Modal 1 -->
								<div class="modal fade" id="colOneModal" tabindex="-1"
									aria-labelledby="colOneModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="colOneModalLabel">Are you
													sure you want to decline this order?</h5>
												<button type="button" class="btn-close"
													data-bs-dismiss="modal" aria-label="Close"></button>
											</div>
											<div class="modal-body">
												<!-- Add additional information or warning message here if needed -->
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-bs-dismiss="modal">Cancel</button>
												<button type="button" class="btn btn-danger">Decline</button>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-6 col-xxl-4 mb-4">
								<div class="card shadow mb-4"></div>
								<div class="card shadow mb-4">
									<div class="card-header py-3">
										<h6 class="text-secondary fw-bold m-0">Ongoing</h6>
									</div>
									<ul class="list-group list-group-flush ps-3">
										<% List<Meal_Order> vrOrders = (List<Meal_Order>) request.getAttribute("vrOrders"); %>
										<!-- Order 1 -->
										<li class="list-group-item">
										<% if (vrOrders != null && !vrOrders.isEmpty()) { %>
							           
							            <% for (Meal_Order order : vrOrders) { %>
											<div class="row align-items-center no-gutters border-bottom">
												<div class="col-xxl-7 me-2">
													<p class="mb-0 fw-bold">Order Number # <%= order.getOrder_number() %></p>
													<% List<Meal> meals = (List<Meal>) request.getAttribute("meals"); %>
														<% for (Meal meal : meals) { %>
	        											<% if (order.getM_id() == meal.getM_id()) { %>
													<p class=""><%= meal.getMeal_name() %></p>
													<% } %>
										            <% } %>
													<% List<User> users = (List<User>) request.getAttribute("users"); %>
														<% for (User user : users) { %>
	        											<% if (order.getU_id() == user.getId()) { %>
													
													<h6 class="mb-0">
														<strong><%= user.getName() %></strong>
													</h6>
													<p><%= user.getAddress() %></p>
													<% } %>
										            <% } %>
										            
										            
												</div>
												<form action="/deliverOrder" method="post">
													<div class="col-xxl-4 offset-xxl-0">
														<input type="hidden" name="mlo_id" id="mlo_id" value="<%= order.getMo_id() %>">
														<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
														<button class="btn btn-success" type="submit"
																style="width: 126.037px; padding: 6px 12px; margin: 10px;">Deliver
														</button>
													</div>
												</form>
											</div>
										
											<% } %>
            								<% } %>
										</li>
									</ul>
								</div>

								<!-- Decline Order Modal 1 -->
								<div class="modal fade" id="declineModal1" tabindex="-1"
									aria-labelledby="declineModal1Label" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="declineModal1Label">Are you
													sure you want to cancel this order?</h5>
												<button type="button" class="btn-close"
													data-bs-dismiss="modal" aria-label="Close"></button>
											</div>
											<div class="modal-body">
												<!-- Add additional information or warning message here if needed -->
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-bs-dismiss="modal">Cancel</button>
												<button type="button" class="btn btn-danger">Decline</button>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-6 col-xxl-4 offset-xxl-0 mb-4">
								<div class="card shadow mb-4"></div>
								<div class="card shadow mb-4">
									<div class="card-header py-3">
										<h6 class="text-secondary fw-bold m-0">History</h6>
									</div>
									<div>
									<% List<Meal_Order> dOrders = (List<Meal_Order>) request.getAttribute("dOrders"); %>
										<!-- Order 1 -->
										<li class="list-group-item">
										<% if (dOrders != null && !dOrders.isEmpty()) { %>
							           
							            <% for (Meal_Order order : dOrders) { %>
									<div class="alert alert-info">
										<% List<User> users = (List<User>) request.getAttribute("users"); %>
														<% for (User user : users) { %>
	        											<% if (order.getU_id() == user.getId()) { %>
	        							<span class="fw-bold"><%= user.getName() %>'s</span>
													<% } %>
										            <% } %> 
										            order of
										<% List<Meal> meals = (List<Meal>) request.getAttribute("meals"); %>
														<% for (Meal meal : meals) { %>
	        											<% if (order.getM_id() == meal.getM_id()) { %>
										<span class="fw-bold"><%= meal.getMeal_name() %></span>
													<% } %>
										            <% } %> 
										            is delivered successfully.
										
													
									</div>
									<% } %>
            						<% } %>
								</div>
								</div>
							</div>

							<!-- Order Modal 1 -->
							<div class="modal fade" id="orderModal1" tabindex="-1"
								aria-labelledby="orderModal1Label" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="orderModal1Label">Order
												Details</h5>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">
											<h6>Order</h6>
											<h3>#2142</h3>
											<h6>Name</h6>
											<h3>
												<strong>Jane Doe</strong>
											</h3>
											<h6>Address</h6>
											<h3>Cupertino, California</h3>
											<h6>Order</h6>
											<h3>1pc. 12" Pizza</h3>
											<h6>Date of Order</h6>
											<h3>October 5, 2022</h3>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-bs-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		
	<%@ include file="footer.jsp"%>

		<script src="assets/bootstrap/js/bootstrap.min.js"></script>
		<script src="assets/js/theme.js"></script>
</body>

</html>