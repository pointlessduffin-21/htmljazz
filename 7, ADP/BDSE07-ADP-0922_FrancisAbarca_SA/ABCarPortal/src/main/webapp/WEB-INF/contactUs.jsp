<%@ page contentType="text/html; charset=US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Contact Us</title>
        <link rel="stylesheet" href="assets2/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i&amp;display=swap">
        <link rel="stylesheet" href="assets2/fonts/simple-line-icons.min.css">
        <link rel="stylesheet" href="assets2/css/baguetteBox.min.css">
        <link rel="stylesheet" href="assets2/css/vanilla-zoom.min.css">

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

<%@ include file="header.jsp"%>

<body>



<main class="page landing-page">
    <section class="clean-block clean-hero" style="color: rgba(31,28,140,0.35);background: url(https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/cars.jpg) center / cover space;">
        <div class="text">
            <h2><br><span style="color: rgb(237, 235, 233); background-color: rgba(255, 255, 255, 0.1);">Contact Us</span></h2>
            <p>Established with a passion for excellence, ABC Cars has been delivering Always Better Choices to our valued customers since 2021.</p><a  href="register_user"><button class="btn btn-outline-light btn-lg" type="button">Join Us!</button></a>
        </div>
    </section>
    <section class="clean-block features">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Contact Information</h2>
                <p>You may contact us through the following:</p>
            </div>
            <div class="row justify-content-center">
                <div class="col-md-5 feature-box"><i class="icon-calendar icon"></i>
                    <h4>Business Hours</h4>
                    <p>Monday - Friday: 9:00 AM - 6:00 PM</p>
                    <p>Saturday: 10:00 AM - 4:00 PM</p>
                    <p>Sunday: Closed</p>
                </div>
                <div class="col-md-5 feature-box"><i class="icon-phone icon"></i>
                    <h4>Phone Number</h4>
                    <p>+1 (555) 321-6789</p>
                </div>
                <div class="col-md-5 feature-box"><i class="icon-direction icon"></i>
                    <h4>Address</h4>
                    <p>ABC Cars</p>
                    <p>1234 Driveway Lane</p>
                    <p>Springfield, IL 62704</p>
                </div>
                <div class="col-md-5 feature-box"><i class="icon-envelope icon"></i>
                    <h4>Email Address</h4>
                    <p>support@abccars.com</p>
                </div>
            </div>
        </div>
    </section>
    <section class="clean-block features">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Map</h2>
            </div>
            <div class="row justify-content-center">
                <iframe src="https://www.google.com/maps/embed?pb=!1m17!1m12!1m3!1d3066.07491761963!2d-89.65594692374043!3d39.78287407154852!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m2!1m1!2zMznCsDQ2JzU4LjQiTiA4OcKwMzknMTIuMSJX!5e0!3m2!1sen!2sph!4v1683094309059!5m2!1sen!2sph" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>
    </section>
</main>
<%@ include file="footer.jsp"%>
</body>
</html>
