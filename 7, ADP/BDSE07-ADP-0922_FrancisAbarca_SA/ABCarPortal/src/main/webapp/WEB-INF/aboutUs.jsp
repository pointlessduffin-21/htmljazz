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
            <h2><br><span style="color: rgb(237, 235, 233); background-color: rgba(255, 255, 255, 0.1);">About ABC Cars</span></h2>
            <p>Established with a passion for excellence, ABC Cars has been delivering Always Better Choices to our valued customers since 2021.</p><a  href="register_user"><button class="btn btn-outline-light btn-lg" type="button">Join Us!</button></a>
        </div>
    </section>
    <section class="clean-block features">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Perks of ABC Cars</h2>
                <p>At ABC Cars, we understand that purchasing a vehicle is an important decision, and we're here to make the process as smooth and enjoyable as possible.</p>
            </div>
            <div class="row justify-content-center">
                <div class="col-md-5 feature-box"><i class="icon-grid icon"></i>
                    <h4>Diverse Vehicle Inventory</h4>
                    <p>Extensive selection of top-quality vehicles, catering to all lifestyles and budgets.</p>
                </div>
                <div class="col-md-5 feature-box"><i class="icon-pencil icon"></i>
                    <h4>Personalized Guidance</h4>
                    <p>Expert team dedicated to guiding customers in finding the perfect vehicle.</p>
                </div>
                <div class="col-md-5 feature-box"><i class="icon-check icon"></i>
                    <h4>Quality Assurance</h4>
                    <p>Rigorous inspection process ensuring vehicle quality and reliability.</p>
                </div>
                <div class="col-md-5 feature-box"><i class="icon-phone icon"></i>
                    <h4>After-Sales Support</h4>
                    <p>Comprehensive after-sales services, including financing, warranty, and maintenance solutions.</p>
                </div>
            </div>
        </div>
    </section>
    <section class="clean-block about-us">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Meet the Team!</h2>
                <p>Get to know the faces behind the ABC Cars family and discover why our people make all the difference!</p>
            </div>
            <div class="row justify-content-center">
                <div class="col-sm-6 col-lg-4">
                    <div class="card text-center clean-card"><img class="card-img-top w-100 d-block" src="assets2/img/avatars/avatar1.jpg">
                        <div class="card-body info">
                            <h4 class="card-title">Paul Kevin</h4>
                            <p class="card-text">Lead Marketing</p>
                            <div class="icons"><a href="#"><i class="icon-social-facebook"></i></a><a href="#"><i class="icon-social-instagram"></i></a><a href="#"><i class="icon-social-twitter"></i></a></div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-lg-4">
                    <div class="card text-center clean-card"><img class="card-img-top w-100 d-block" src="assets2/img/avatars/avatar2.jpg">
                        <div class="card-body info">
                            <h4 class="card-title">Robert Adam</h4>
                            <p class="card-text">Lead Automobile Specialist</p>
                            <div class="icons"><a href="#"><i class="icon-social-facebook"></i></a><a href="#"><i class="icon-social-instagram"></i></a><a href="#"><i class="icon-social-twitter"></i></a></div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-lg-4">
                    <div class="card text-center clean-card"><img class="card-img-top w-100 d-block" src="assets2/img/avatars/avatar3.jpg">
                        <div class="card-body info">
                            <h4 class="card-title">Amanda Cassidy</h4>
                            <p class="card-text">Assistant Manager</p>
                            <div class="icons"><a href="#"><i class="icon-social-facebook"></i></a><a href="#"><i class="icon-social-instagram"></i></a><a href="#"><i class="icon-social-twitter"></i></a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>

<%@ include file="footer.jsp"%>

</body>
</html>
