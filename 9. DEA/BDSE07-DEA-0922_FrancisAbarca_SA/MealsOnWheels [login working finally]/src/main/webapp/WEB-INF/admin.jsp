<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport"
		  content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
	<title>Admin Dashboard</title>
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
											<span>Harry Potter</span>
										</div>
										<span>Admin</span>
										<div class="text-dark fw-bold h5 mb-0"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-6 col-xl-6 col-xxl-6 mb-4">
						<div class="card shadow border-start-primary py-2">
							<div class="card-body">
								<div class="row align-items-center no-gutters ps-3">
									<div class="col me-2 ps-3 d-flex justify-content-between" style="padding-top:13px; padding-bottom:13px;">
										<span>Total Donations:</span>
										<span class="text-uppercase text-secondary fw-bold text-xs mb-1 fs-5 pe-3">$</span>
										<span class="text-uppercase text-secondary fw-bold text-xs mb-1 fs-5 pe-3" id="totalAmount"></span>
									</div>
								</div>
								<script type="text/javascript">
									$(document).ready(function() {
										$.ajax({
											url: '/api/allfunds/',
											type: 'GET',
											success: function(data) {
												let tableBody = $('#fundsTable tbody');
												let totalAmount = 0;
												data.forEach(function(fund) {
													let row = $('<tr></tr>');
													row.append($('<td></td>').text(fund.f_id));
													row.append($('<td></td>').text(fund.name));
													row.append($('<td></td>').text(fund.amount));
													row.append($('<td></td>').text(fund.dateTime));
													tableBody.append(row);
													totalAmount += parseInt(fund.amount); // Parse amount as an integer
												});
												$('#totalAmount').text(totalAmount);
											}
										});
										function updateDonations() {
											$.ajax({
												url: '/api/allfunds',
												type: 'GET',
												success: function(data) {
													let tableBody = $('#fundsTable tbody');
													let totalAmount = 0;
													tableBody.empty(); // Clear the table body

													data.forEach(function(donation) {
														let row = $('<tr></tr>');
														row.append($('<td></td>').text(donation.f_id));
														row.append($('<td></td>').text(donation.name));
														row.append($('<td></td>').text(donation.amount));
														row.append($('<td></td>').text(donation.dateTime));
														tableBody.append(row);
														totalAmount += parseInt(donation.amount);
													});

													$('#totalAmount').text(totalAmount);
												}
											});
										}
										updateDonations();
										setInterval(updateDonations, 10000);
									});
								</script>
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




						<!-- Orders -->
						<div class="col-lg-6 col-xxl-4 mb-4">
							<div class="card shadow mb-4"></div>
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="text-secondary fw-bold m-0">Orders</h6>
								</div>
								<ul class="list-group list-group-flush" id="ordersContainer">
									<!-- Orders will be dynamically added here -->
								</ul>
							</div>
						</div>

						<!-- Orders (JSON) -->
						<script>
							$(document).ready(function() {
								$.ajax({
									url: '/orders/all',
									type: 'GET',
									dataType: 'json',
									success: function(data) {
										let container = $('#allOrdersList');
										let totalAmount = 0;

										data.sort(function(b, a) {
											return new Date(a.order_date) - new Date(b.order_date);
										});

										data.forEach(function(order) {
											let orderContainer = $('<div class="card"></div>');
											let cardBody = $('<div class="card-body"></div>');

											cardBody.append($('<p class="card-text"></p>').text('Meal Id: ' + order.mo_id));
											cardBody.append($('<p class="card-text"></p>').text('Order Number: ' + order.order_number));
											cardBody.append($('<p class="card-text"></p>').text('Member Id: ' + order.m_id));
											cardBody.append($('<p class="card-text"></p>').text('Date: ' + order.order_date));
											cardBody.append($('<p class="card-text"></p>').html('Status: <strong>' + order.status + '</strong>'));

											orderContainer.append(cardBody);
											container.append(orderContainer);
										});

									},
									error: function(xhr, status, error) {
										console.error('Error:', error);
									}
								});
							});

						</script>

						<!-- All Orders -->
						<div class="col-lg-6 col-xxl-4 offset-xxl-0 mb-4">
							<div class="card shadow mb-4"></div>
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="text-secondary fw-bold m-0">All Orders</h6>
								</div>
								<ul class="list-group list-group-flush" id="allOrdersList">
									<!-- Donations will be dynamically added here -->
								</ul>
							</div>
						</div>


						<!-- Donations (JSON) -->
						<script type="text/javascript">
							$(document).ready(function() {
								$.ajax({
									url: '/api/allfunds',
									type: 'GET',
									success: function(data) {
										let container = $('#donationContainer');
										let donationsList = $('#donationsList');
										let totalAmount = 0;

										data.sort(function(b, a) {
											return new Date(a.dateTime) - new Date(b.dateTime);
										});

										data.forEach(function(donation) {
											let donationItem = $('<div class="alert alert-info"></div>');
											let date = new Date(donation.dateTime);
											let formattedDate = date.toLocaleDateString('en-US');
											donationItem.text(donation.name + ' donated $' + donation.amount + ' on ' + formattedDate);
											donationsList.append(donationItem);
											totalAmount += parseInt(donation.amount);
										});



										$('#totalAmount').text(totalAmount);
									}
								});
							});
						</script>

						<!-- Donations (Notification)  -->
						<div class="col-lg-6 col-xxl-4 mb-4">
							<div class="card shadow mb-4"></div>
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="text-secondary fw-bold m-0"
										style="color: rgb(45, 237, 42);">Notification</h6>
								</div>
								<div class="alert alert-info" style="background-color: white;" id="donationsList"></div>
								<!-- Add more notifications here -->
							</div>
						</div>
					</div>

					<!-- Orders (JSON) -->
					<script>
						$(document).ready(function() {
							$.ajax({
								url: '/orders/pendingOrders',
								type: 'GET',
								dataType: 'json',
								success: function(data) {
									let container = $('#ordersContainer');
									let totalAmount = 0;

									data.sort(function(b, a) {
										return new Date(a.order_date) - new Date(b.order_date);
									});

									data.forEach(function(order) {
										let orderContainer = $('<div class="card"></div>');
										let cardBody = $('<div class="card-body"></div>');

										cardBody.append($('<p class="card-text"></p>').text('Meal Id: ' + order.mo_id));
										cardBody.append($('<p class="card-text"></p>').text('Order Number: ' + order.order_number));
										cardBody.append($('<p class="card-text"></p>').text('Member Id: ' + order.m_id));
										cardBody.append($('<p class="card-text"></p>').text('Date: ' + order.order_date));
										cardBody.append($('<p class="card-text"></p>').html('Status: <strong>' + order.status + '</strong>'));

										// Create the button
										let acceptButton = $('<button class="btn btn-success float-end" type="button">Accept</button>');

										acceptButton.on('click', function() {
											// Create the modal
											let modal = $('<div class="modal fade" tabindex="-1"></div>');
											let modalDialog = $('<div class="modal-dialog"></div>');
											let modalContent = $('<div class="modal-content"></div>');
											let modalHeader = $('<div class="modal-header"></div>');
											let modalBody = $('<div class="modal-body"></div>');
											let modalFooter = $('<div class="modal-footer"></div>');

											// Add content to the modal
											modalHeader.append($('<h5 class="modal-title">Order Manager</h5>'));
											modalFooter.append($('<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>'));

											// Append the modal elements
											modalContent.append(modalHeader);
											modalContent.append(modalBody);
											modalContent.append(modalFooter);
											modalDialog.append(modalContent);
											modal.append(modalDialog);

											// Show the modal
											$('body').append(modal);
											modal.modal('show');


											// Retrieve the list of partners from the server
											$.ajax({
												url: '/orders/partners',
												type: 'GET',
												success: function(data) {
													let partnerText = $('<p></p>').text('Select a kitchen to accept the order:');
													modalBody.append(partnerText);
													let partnersDropdown = $('<select></select>');
													data.forEach(function(partner) {
														partnersDropdown.append($('<option></option>').val(partner.p_id).text(partner.name + ', ' + partner.address));
													});
													modalBody.append(partnersDropdown);

													// Create the "Send to Kitchen" button
													let sendToKitchenButton = $('<button class="btn btn-primary mt-3">Send to Kitchen</button>');
													sendToKitchenButton.on('click', function() {
														let selectedPartnerId = partnersDropdown.val();
														$.ajax({
															url: '/orders/acceptOrder',
															type: 'POST',
															data: {
																orderNumber: order.order_number,
																partnerId: selectedPartnerId
															},
															success: function(data) {
																alert('Order accepted!');
																location.reload();
															}
														});
													});
													modalFooter.append(sendToKitchenButton);
												}
											});
										});

										cardBody.append(acceptButton);

										orderContainer.append(cardBody);
										container.append(orderContainer);
									});

								},
								error: function(xhr, status, error) {
									console.error('Error:', error);
								}
							});
						});

					</script>



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