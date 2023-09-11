<html>
<head>
    <title>Distance Matrix</title>
</head>
<body>

<form id="distance-form">
    <input type="text" id="origin" name="origin" placeholder="Distance From">
    <input type="text" id="destination" name="destination" placeholder="Distance To">
    <input type="submit" value="Submit">
</form>

<div id="loading-icon" style="display: none;">Loading...</div>

<div id="distance-results"></div>

<div id="map"></div>

<script>
    function initMap() {
        var mapOptions = {
            center: { lat: 0, lng: 0 }, // Default center at (0, 0)
            zoom: 12 // Adjust the zoom level as needed
        };
        var map = new google.maps.Map(document.getElementById('map'), mapOptions);

        var marker;

        map.addListener('click', function(event) {
            placeMarker(event.latLng);
        });

        function placeMarker(location) {
            if (marker) {
                marker.setMap(null); // Remove the existing marker
            }
            marker = new google.maps.Marker({
                position: location,
                map: map
            });
            updateAddress(location);
        }

        function updateAddress(location) {
            var geocoder = new google.maps.Geocoder();
            geocoder.geocode({ 'latLng': location }, function(results, status) {
                if (status === 'OK') {
                    if (results[0]) {
                        var address = results[0].formatted_address;
                        document.getElementById("origin").value = address;
                        map.setCenter(location); // Set the map center to the clicked location
                    } else {
                        alert('No results found');
                    }
                } else {
                    alert('Geocoder failed due to: ' + status);
                }
            });
        }
    }

    document.getElementById("distance-form").addEventListener("submit", function(event) {
        event.preventDefault();

        // Show the loading icon
        document.getElementById("loading-icon").style.display = "block";

        var origin = encodeURIComponent(document.getElementById("origin").value);
        var destination = encodeURIComponent(document.getElementById("destination").value);

        var xhr = new XMLHttpRequest();
        xhr.open("POST", "/api/" + origin + "/" + destination, true);
        xhr.onreadystatechange = function() {
            if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                // Hide the loading icon
                document.getElementById("loading-icon").style.display = "none";

                var response = JSON.parse(xhr.responseText);
                displayDistance(response);
            } else if (xhr.readyState === XMLHttpRequest.DONE) {
                // Hide the loading icon
                document.getElementById("loading-icon").style.display = "none";

                alert("Error retrieving distance.");
            }
        };
        xhr.send();
    });

    function displayDistance(response) {
        var distanceResults = document.getElementById("distance-results");
        distanceResults.innerHTML = "";

        var distanceFrom = document.createElement("div");
        distanceFrom.textContent = "Distance From: " + response.From;
        distanceResults.appendChild(distanceFrom);

        var distanceTo = document.createElement("div");
        distanceTo.textContent = "Distance To: " + response.To;
        distanceResults.appendChild(distanceTo);

        var kilometerDistance = document.createElement("div");
        kilometerDistance.textContent = "Distance in Kilometers: " + response.Distance;
        distanceResults.appendChild(kilometerDistance);

        var timeOfArrival = document.createElement("div");
        timeOfArrival.textContent = "Time of Arrival: " + response.Duration;
        distanceResults.appendChild(timeOfArrival);

        var foodStatus = document.createElement("div");
        foodStatus.textContent = "Food Status: " + response.Status;
        distanceResults.appendChild(foodStatus);
    }
</script>

<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&callback=initMap" async defer></script>

</body>
</html>
