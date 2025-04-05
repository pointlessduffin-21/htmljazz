<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Donation</title>
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
</head>
<body>
<h1>Create Donation</h1>
<form onsubmit="event.preventDefault(); createDonation();">
    <label for="name">Name:</label><br>
    <input type="text" id="name" name="name"><br><br>
    <label for="amount">Amount:</label><br>
    <input type="text" id="amount" name="amount" required><br><br>
    <input type="submit" value="Submit">
    <div id="paypal-button-container"></div>
</form>
<h2>Response:</h2>
<pre id="response"></pre>
</body>
</html>
