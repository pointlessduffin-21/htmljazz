<!DOCTYPE html>
<html xmlns:c="http://java.sun.com/xml/ns/javaee">

<head>
    <!--  Enable Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!--  Access the Static Resources without using spring URL -->
    <link href="/css/style.css" rel="stylesheet" />
    <script src="/js/script.js"></script>
</head>

<body>

<div class="container my-3">
    <h3>Sign In with Facebook</h3>
    <c:url var="post_url" value="/login" />
    <form action="${post_url}" method="post" class="was-validated">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <div class="alert alert-success">
            Logged in as: <span id="user"></span>
            ! Click here to navigate to <a href="http://localhost:3000">Home</a>
        </div>

    </form>
</div>

<script type="text/javascript">
    $.get("/user", function(data) {
        $("#user").html(data.userAuthentication.details.name);
        $(".unauthenticated").hide()
        $(".authenticated").show()
    });

</script>
</body>

</html>
