<%@ page contentType="text/html; charset=US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

    <link rel="icon" href="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/abc-cars.png">
    <title>ABC Cars</title>

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
    <section class="clean-block clean-hero" style="color: rgba(31,28,140,0.35);background: url(https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/dealership.jpg) center / cover space;">
        <div class="text">
            <h2><br><span style="color: rgb(237, 235, 233); background-color: rgba(255, 255, 255, 0.1);">ABC Cars</span></h2>
            <p>Established with a passion for excellence, ABC Cars has been delivering Always Better Choices to our valued customers since 2021.</p><a  href="register_user"><button class="btn btn-outline-light btn-lg" type="button">Join Us!</button></a>
        </div>
    </section>
    <section class="clean-block features">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Make yourself at home.</h2>
                <p>Here at ABC Cars, we care about your customer service.</p>
            </div>
            <div class="row justify-content-center">
                <div class="col-md-5 feature-box"><i class="icon-grid icon"></i>
                    <h4>Have an account? Log-in</h4>
                    <a href="login" class="btn btn-primary">Login</a>
                </div>
                <div class="col-md-5 feature-box"><i class="icon-pencil icon"></i>
                    <h4>Don't have an account? Create one here</h4>
                    <a href="register_user" class="btn btn-primary">Register</a>
                </div>
            </div>
        </div>
    </section>
</main>

<%@ include file="footer.jsp"%>

</body>
</html>
