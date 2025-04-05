<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Add Store</title>

    <link rel="icon" href="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets/img/kynlogo.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i&amp;display=swap">
    <link rel="stylesheet" href="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets/css/baguetteBox.min.css">
    <link rel="stylesheet" href="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets/css/vanilla-zoom.min.css">
</head>

<body>
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
                <li class="nav-item"><a class="nav-link " href="/">Home</a></li>
                <li class="nav-item"><a class="nav-link active" href="addStore">Add</a></li>
                <li class="nav-item"><a class="nav-link" href="viewStore">Manage</a></li>
            </ul>
        </div>
    </div>
</nav>
<main class="page contact-us-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Add Store</h2>
                <p>Expand Your Circle: Connect, Engage, and Thrive Together!</p>
            </div>
            <%--@elvariable id="store" type=""--%>
            <sf:form class="p-5" d="storeForm" modelAttribute="store" action="saveStore" method="post">
                <div class="mb-3">
                    <sf:label class="form-label" for="name" path="name">Store Name</sf:label>
                    <sf:input class="form-control" type="text" aria-describedby="storeHelp" name="name"
                              placeholder="Enter store name" path="name" value="${name}"></sf:input>
                </div>
                <div class="mb-3">
                    <sf:label class="form-label" for="phone_number" path="phone_number">Phone Number</sf:label>
                    <sf:input class="form-control" type="text" name="phone_number"
                              path="phone_number" placeholder="Enter phone number" value="${phone_number}"></sf:input>
                </div>
                <div class="mb-3">
                    <sf:label class="form-label" for="localities" path="localities">Store Location</sf:label>
                    <sf:input class="form-control" type="text" name="localities" path="localities" placeholder="Enter store location" value="${localities}" />
                </div>
                <div class="mb-3">
                    <sf:hidden path="id" value="${id}"/>
                    <sf:button class="btn btn-primary" type="submit">Send</sf:button>
                </div>
            </sf:form>
        </div>
    </section>
</main>
<script src="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets/js/baguetteBox.min.js"></script>
<script src="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets/js/vanilla-zoom.js"></script>
<script src="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets/js/theme.js"></script>

<!-- Required for Reference -->
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