<%-- <%@ page contentType="text/html; charset=US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">

<title>Upload Meal</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

		<div class="container text-start text-info mt-5 py-2 rounded-4">
	<h3 class="text-center">Upload a Meal</h3>
		
		<form action="createMeal" method="post" class="was-validated" modelAttribute="meal"
          enctype="multipart/form-data">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	        <div class="mb-3">
	            <label for="meal_name" class="form-label">Name:</label>
	            <input type="text" class="form-control" placeholder="Enter name" name="meal_name" id="meal_name"
	                   value="" />
	        </div>
	        <div class="mb-3">
	            <label for="description" class="form-label">Description:</label>
	            <input type="text" class="form-control" placeholder="Enter description" name="description"
	                   id="description" value="" />
	        </div>
	        <div class="mb-3">
	            <label for="duration" class="form-label">Duration:</label>
	            <input type="text" class="form-control" placeholder="Enter duration" name="duration" id="duration"
	                   value="" />
	        </div>
	        <div class="mb-3">
	            <label class="form-label">Photo:</label>
	            <input type="file" class="form-control" name="picture" id="photo" accept="image/png, image/jpeg" />
	        </div>
	        <div class="holder border border-info" style="height: 300px; width: 300px; margin: auto;">
	            <img id="imgPreview" src="#" alt="image preview" style="width: inherit;" />
	        </div>
	        <input type="hidden" name="id" value="${id}" />
	        <button type="submit" class="btn btn-primary d-flex">Post</button>
    </form>
    <script>
        $(document).ready(function() {
            $("#photo").on("change", function() {
                const file = this.files[0];
                if (file) {
                    let reader = new FileReader();
                    reader.onload = function(event) {
                        $("#imgPreview").attr("src", event.target.result);
                    };
                    reader.readAsDataURL(file);
                }
            });
        });
    </script>

</div>

</body>
</html>
