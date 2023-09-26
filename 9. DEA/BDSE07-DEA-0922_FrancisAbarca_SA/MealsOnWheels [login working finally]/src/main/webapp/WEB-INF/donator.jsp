<%@ page import="com.Group1.MealsOnWheels.Entity.User" %>

<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Donator Dashboard</title>
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
											<div style="height: 65px; width: 65px;" class="rounded bg-primary">
						                        <div class="h-100 fs-1 text-white d-flex justify-content-center" style="width: 65px;">
													<span style="font-size: 0.8em;" class="my-auto">H</span>
													<span style="font-size: 0.8em;" class="my-auto">G</span>
						                        </div>
						                    </div>
										</div>
										<div class="col me-2 ps-3">
											<div class="text-uppercase text-secondary fw-bold text-xs mb-1 fs-5">
												<span>Hermione Granger</span>
											</div>
											<span>Donator</span>
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
											<div>
												<span>Total Donated:</span>
												<span class="text-uppercase text-secondary fw-bold text-xs mb-1 fs-5 pe-3">$</span>
												<span class="text-uppercase text-secondary fw-bold text-xs mb-1 fs-5 pe-3" id="totalAmount"></span>
											</div>
											<div>
												<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#donateModal">
												  DONATE
												</button>
												
												<!-- Modal -->
												<div class="modal fade" id="donateModal" tabindex="-1" aria-labelledby="donateModalLabel" aria-hidden="true">
												  <div class="modal-dialog">
												    <div class="modal-content">
												      <div class="modal-header">
												        <h1 class="modal-title fs-5" id="donateModalLabel">Donate</h1>
												        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
												      </div>
												      <div class="modal-body">
    <form class="m-2" method="post" onsubmit="event.preventDefault(); createDonation();">
        <div class="form-group mb-3 text-center">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name">
            <label for="amount">Amount:</label>
            <input type="text" class="form-control" id="amount" name="amount" required>
        </div>
		<div id="paypal-button-container"></div>
        <!-- <button type="submit" class="btn btn-primary col-12" data-bs-dismiss="modal" value="Submit">Save changes</button> -->
        
    </form>
</div>
<script src="https://www.paypal.com/sdk/js?client-id=AbPgKt26jKqlmXNV_LZkwyKbtdml0LR3e2YIVoOnoHbY0seQ4tZTMdP1L4wy4Tf4PM3kbX1i_B-MYRVy"></script>
<script>
	function createDonation() {
		// Get the name and amount from the input fields
		let name = document.getElementById("name").value;
		let amount = document.getElementById("amount").value;

		// Create a new XMLHttpRequest object
		let xhr = new XMLHttpRequest();

		// Open a new POST request to the /create endpoint
		xhr.open("POST", "/api/createfunds/");

		// Set the request headers
		xhr.setRequestHeader("Content-Type", "application/json");

		// Send the request with the JSON data
		xhr.send(JSON.stringify({name: name, amount: amount}));

		// Handle the response
		xhr.onload = function() {
			if (xhr.status === 201) {
				// Parse the JSON response
				let response = JSON.parse(xhr.response);

				// Display the response on the page
				document.getElementById("response").innerHTML = JSON.stringify(response, null, 2);
			} else {
				alert("Error: " + xhr.statusText);
			}
		};
	}

	paypal.Buttons({
		createOrder: function(data, actions) {
			let amount = document.getElementById("amount").value;

			return actions.order.create({
				purchase_units: [{
					amount: {
						value: amount
					}
				}]
			});
		},
		onApprove: function(data, actions) {
			return actions.order.capture().then(function(details) {
				// Extract the necessary information from the details object
				let name = document.getElementById("name").value;
				let amount = details.purchase_units[0].amount.value;
				let date = details.update_time;

				// Create a new XMLHttpRequest object
				let xhr = new XMLHttpRequest();

				// Open a new POST request to the /funds/create endpoint
				xhr.open("POST", "/api/createfunds/");

				// Set the request headers
				xhr.setRequestHeader("Content-Type", "application/json");

				// Send the request with the JSON data
				xhr.send(JSON.stringify({ name: name, amount: amount, dateTime: date }));

				// Handle the response
				xhr.onload = function() {
					if (xhr.status === 201) {
						// Parse the JSON response
						let response = JSON.parse(xhr.response);

						// Display the response on the page
						document.getElementById("response").innerHTML = JSON.stringify(response, null, 2);
					} else {
						alert("Error: " + xhr.statusText);
					}
				};

				// Handle the payment success
				alert('Payment completed successfully!');
				// Add your own code to handle further actions (e.g., redirecting to a success page)
			});
		}
	}).render('#paypal-button-container');
</script>
												      <div class="modal-footer">
												        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
												        
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
						<script type="text/javascript">
							$(document).ready(function() {
								$.ajax({
									url: '/api/allfunds/',
									type: 'GET',
									success: function(data) {
										let tableBody = $('#fundsTable tbody');
										let totalAmount = 0;
										data.sort(function(b, a) {
											return new Date(a.dateTime) - new Date(b.dateTime);
										});
										data.forEach(function(fund) {
											let row = $('<tr></tr>');
											row.append($('<td></td>').text(fund.f_id));
											row.append($('<td></td>').text(fund.name));
											row.append($('<td></td>').text(fund.amount));
											row.append($('<td></td>').text(fund.dateTime)); // Display dateTime as is
											tableBody.append(row);
											totalAmount += parseInt(fund.amount); // Parse amount as an integer
										});
										$('#totalAmount').text(totalAmount);
									}
								});

								function updateDonations() {
									$.ajax({
										url: '/api/allfunds/',
										type: 'GET',
										success: function(data) {
											let tableBody = $('#fundsTable tbody');
											let totalAmount = 0;
											tableBody.empty(); // Clear the table body

											data.sort(function(b, a) {
												return new Date(a.dateTime) - new Date(b.dateTime);
											});

											data.forEach(function(donation) {
												let row = $('<tr></tr>');
												row.append($('<td></td>').text(donation.f_id));
												row.append($('<td></td>').text(donation.name));
												row.append($('<td></td>').text(donation.amount));
												row.append($('<td></td>').text(donation.dateTime)); // Display dateTime as is
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

						<div class="row">
							<div class="col-lg-4 col-xxl-4 mb-4">
								<div class="card shadow mb-4"></div>
								<div class="card shadow mb-4">
								    <div class="card-header py-3">
										<h6 class="text-secondary fw-bold m-0"
											style="color: rgb(45, 237, 42);">Notification</h6>
									</div>
								     <div>
					                    <div class="alert alert-info"><span class="fw-bold">Jhon Doe</span> donated <span class="fw-bold">1,000,000</span> on <span class="fw-bold">June 18, 2023</span></div>
					                    <!-- Add more notifications here -->
					                </div>
								</div>
							</div>
							<div class="col-lg-8 col-xxl-8 mb-4">
								<div class="card shadow mb-4"></div>
								<div class="card shadow mb-4">
									<div class="card-header py-3">
										<h6 class="text-secondary fw-bold m-0"
											style="color: rgb(45, 237, 42);">Your Donations</h6>
									</div>
									<div class="card-body">
								      <div class="table-responsive">
								        <table class="table table-bordered" id="fundsTable">
								          <thead>
								            <tr>
								              <th>#</th>
								              <th>Name</th>
								              <th>Amount</th>
								              <th>Date</th>
								            </tr>
								          </thead>
								          <tbody>
								          </tbody>
								        </table>
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