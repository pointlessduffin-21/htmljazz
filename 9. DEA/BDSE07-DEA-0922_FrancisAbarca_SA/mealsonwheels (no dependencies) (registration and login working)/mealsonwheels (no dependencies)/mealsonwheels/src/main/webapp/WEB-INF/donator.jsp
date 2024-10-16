<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meals on Wheels</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Bacasime+Antique&display=swap">

</head>

<body>

<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark fixed-top mb-5" id="mainNav" style="background-color: black;">
    <div class="container">
        <h1 class="text-white fs-2">MOW</h1>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars ms-1"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                <li class="nav-item"><a class="nav-link text-white" href="kitchen.html">Home</a></li>
                <li class="nav-item"><a class="nav-link text-white" href="#">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>
<section>
    <div class='container pt-0 rounded'
         style="width: 100%; height: 80%; position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); background-color: rgba(255, 255, 255, 0.8)">

        <div class="row p-3 d-flex justify-content-evenly">

            <div class="col-3 border p-5 rounded">
                <div class="row">
                    <div class="col-4">
                        <div style="height: 70px; width: 70px;" class="border border-white rounded-circle bg-primary">
                            <div class="h-100 fs-1 text-white d-flex justify-content-center" style="width: 70px;">
                                <span style="font-size: 1em;" class="">J</span>
                                <span style="font-size: 1em;" class="">D</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-8">
                        <h4>John Doe</h4>
                        <h6>Donator</h6>
                    </div>
                </div>
                <hr>
                <h6>Notifications</h6>
                <!-- For each -->
                <div class="row border rounded py-3">
                    <div class="col-3">
                        <div style="height: 40px; width: 40px;" class="border border-white rounded-circle bg-primary">
                            <div class="h-100 fs-1 text-white d-flex justify-content-center" style="width: 40px;">
                                <span style="font-size: 0.55em;" class="">A</span>
                                <span style="font-size: 0.55em;" class="">B</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-9">
                        <h6>John Doe</h6>
                        <p style="font-size: 0.7em;" class="mb-0">Donated: 7,000<br /> Date: June 23, 2023</p>
                    </div>
                </div>
            </div>

            <div class="col-9">
                <div class="border p-5 rounded text-center">
                    <h4 style="font-family: 'Bacasime Antique', cursive;">All donations will proceed to MerryMeals
                        charitable organization to fund the organization's operations</h4>
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-light" data-bs-toggle="modal" data-bs-target="#donationForm">
                        Donate Now
                    </button>
                </div>

                <div class="border p-5 rounded mt-3">
                    <h3> Your Donations </h3>
                    <hr>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Date</th>
                            <th scope="col">Amount (PHP)</th>
                            <th scope="col">Status</th>
                        </tr>
                        </thead>
                        <tbody class="table-group-divider">
                        <tr>
                            <th scope="row">1</th>
                            <td>June 28, 2023 12:45:23</td>
                            <td>13,000</td>
                            <td>Confirmed</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="donationForm" tabindex="-1" aria-labelledby="donationFormLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="donationFormLabel">Donation</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form class="d-grid">
                                <div class='form-group mb-3 col-12'>
                                    <label htmlFor='amount'>Amount (PHP)</label>
                                    <input type='text' class='form-control' id='amount' />
                                </div>

                                <button type='submit' class='btn btn-outline-dark px-5 mt-3'>Donate</button>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<footer class="text-center text-lg-start text-muted" style="background-color: black;">

    <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
        <div class="me-5 d-none d-lg-block">
            <span class="text-white">Contact us through our social networking sites:</span>
        </div>
        <div>
            <a href="" class="me-4 text-reset"> <i class="fab fa-facebook-f text-white"></i>
            </a> <a href="" class="me-4 text-reset"> <i class="fab fa-twitter text-white"></i>
        </a> <a href="" class="me-4 text-reset"> <i class="fab fa-google text-white"></i>
        </a> <a href="" class="me-4 text-reset"> <i class="fab fa-instagram text-white"></i>
        </a> <a href="" class="me-4 text-reset"> <i class="fab fa-linkedin text-white"></i>
        </a> <a href="" class="me-4 text-reset"> <i class="fab fa-github text-white"></i>
        </a>
        </div>

    </section>

    <section class="">
        <div class="container text-center text-md-start mt-5">

            <div class="row mt-3">

                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                    <h6 class="text-uppercase fw-bold mb-4 text-white">
                        <i class="fas fa-gem me-3 text-white"></i>Meals On Wheels
                    </h6>
                    <p class="text-white">Nourishing Lives: Meals on Wheels Delivers Care and Support</p>
                </div>

                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4" id="links">
                    <h6 class="text-uppercase fw-bold mb-4 text-white">Meals</h6>
                    <p>
                        <a href="cars" class="text-white text-decoration-none">Menu</a>
                    </p>
                    <p>
                        <a href="cars" class="text-white text-decoration-none">Partners</a>
                    </p>
                </div>

                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4" id="links">
                    <h6 class="text-uppercase fw-bold mb-4 text-white">Meals On Wheels</h6>
                    <p>
                        <a href="about_us" class="text-white text-decoration-none">About Us</a>
                    </p>
                    <p>
                        <a href="contact_us" class="text-white text-decoration-none">Contact Us</a>
                    </p>

                </div>

                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                    <h6 class="text-uppercase fw-bold mb-4 text-white">Contact</h6>
                    <p class="text-white">
                        <i class="fas fa-home me-3 text-white"></i> Philippines, CEBU 10286, PH
                    </p>
                    <p class="text-white">
                        <i class="fas fa-envelope me-3 text-white"></i> mealsonwheels.com
                    </p>
                    <p class="text-white">
                        <i class="fas fa-phone me-3 text-white"></i> + 09 186 562 54
                    </p>
                    <p class="text-white">
                        <i class="fas fa-print me-3 text-white"></i> + 09 825 660 09
                    </p>
                </div>
            </div>
        </div>
    </section>
    <div class="text-center p-4 text-white" style="background-color: rgba(0, 0, 0, 0.05);">
        &copy; 2023 Copyright: <a class="text-reset fw-bold text-white" href="#">mealsonwheels.com</a>
    </div>
</footer>


</body>

</html>