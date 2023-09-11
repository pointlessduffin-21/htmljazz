<head>
    <meta charset="UTF-8">
    <title>Know Your Neighborhood</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" href="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets/img/kynlogo.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i&amp;display=swap">
    <link rel="stylesheet" href="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets/css/baguetteBox.min.css">
    <link rel="stylesheet" href="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets/css/vanilla-zoom.min.css">

</head>

<!-- Footer -->
<footer class="text-center text-lg-start bg-light text-muted mt-5">
    <!-- Section: Social media -->
    <section
            class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
    </section>
    <!-- Section: Social media -->

    <!-- Section: Links  -->
    <section class="">
        <div class="container text-center text-md-start mt-5">
            <!-- Grid row -->
            <div class="row mt-3">
                <!-- Grid column -->
                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                    <!-- Content -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        <i class="fas fa-gem me-3"></i>ABC Cars
                    </h6>
                    <p>Always Beyond Comfort, Driven to Exceed Expectations
                    </p>
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">Cars</h6>
                    <p>
                        <a href="cars" class="text-reset">Post Car</a>
                    </p>
                    <p>
                        <a href="cars" class="text-reset">View all Car</a>
                    </p>
                    <!-- <p>
                        <a href="#!" class="text-reset">Vue</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Laravel</a>
                    </p> -->
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">ABC Car</h6>
                    <p>
                        <a href="about_us" class="text-reset">About Us</a>
                    </p>
                    <p>
                        <a href="contact_us" class="text-reset">Contact Us</a>
                    </p>
                    <!-- <p>
                        <a href="#!" class="text-reset">Orders</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Help</a>
                    </p> -->
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
                    <p>
                        <i class="fas fa-home me-3"></i> Springfield, IL
                    </p>
                    <p>
                        <i class="fas fa-envelope me-3"></i> support@abccars.com
                    </p>
                    <p>
                        <i class="fas fa-phone me-3"></i> +1 (555) 321-6789
                    </p>
                </div>
                <!-- Grid column -->
            </div>
            <!-- Grid row -->
        </div>
    </section>
    <!-- Section: Links  -->

    <!-- Copyright -->
    <div class="text-center p-4"
         style="background-color: rgba(0, 0, 0, 0.05);">
        &copy; 2023 Copyright: <a class="text-reset fw-bold"
                                  href="https://home.yeems214.xyz/">yeems214</a>
    </div>

    <script>
        function adjustFooter() {
            const main = document.querySelector("main");
            const windowHeight = window.innerHeight;
            const headerHeight = document.querySelector("header").offsetHeight;
            const footerHeight = document.querySelector("footer").offsetHeight;
            const contentHeight = headerHeight + footerHeight;

            if (contentHeight < windowHeight) {
                main.style.minHeight = `${windowHeight - contentHeight}px`;
            } else {
                main.style.minHeight = "0";
            }
        }

        // Call the function on page load and when the window is resized
        window.addEventListener("load", adjustFooter);
        window.addEventListener("resize", adjustFooter);

    </script>
    <!-- Copyright -->
</footer>
<!-- Footer -->