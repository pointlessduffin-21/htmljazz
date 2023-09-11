<%--   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   --%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%@ page import="com.merrymeals.mealsonwheels.Entity.Meal" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html data-bs-theme="light" lang="en">


<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Dashboard - Brand</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.reflowhq.com/v2/toolkit.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    
    <!-- JSTL -->
    <%-- <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  --%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jstl/1.2/jstl.min.js"></script>
    
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
    
</head>

<body>

<div class="col-4 d-flex justify-content-start ps-5" style="position: relative; top: 150px">
	<form action="/search" method="get" class="w-75 my-auto ms-3">
		<input type="text" class="form-control" placeholder="Search someone..." name="searchKey" autocomplete="off" data-bs-toggle="popover" data-bs-trigger="focus" data-bs-title="Tips" data-bs-content="Press enter to continue">
	</form>
</div>

<div class="col-12 text-center mt-4" style="position: relative; top: 150px">
    <h4>Search Key: <%= request.getParameter("searchKey") %></h4>
</div>

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
                <li class="nav-item"><a class="nav-link" href="kitchen.html">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container" style="padding-top: 170px;">
    <div id="wrapper">
        <div class="d-flex flex-column" id="content-wrapper">
            <div id="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-2 col-lg-2 col-xl-2 col-xxl-2 mb-4" style="--bs-body-bg: #ffffff;">
                            <div class="card shadow border-start-primary py-2">
                                <div class="card-body" style="--bs-body-bg: var(--bs-body-bg);">
                                    <div class="row align-items-center no-gutters">
                                        <div class="col-lg-2">
                                            <div class="text-uppercase text-primary fw-bold text-xs mb-1" style="background: var(--bs-emphasis-color);"></div><img class="rounded-circle img-fluid" width="60" height="60" src="assets/img/avatar2.jpg">
                                        </div>
                                        <div class="col-lg-8" style="background: var(--bs-card-cap-bg);">
                                            <h6>Member</h6>
                                            <h1 style="color: var(--bs-emphasis-color);font-size: 20px;">Janet Donut</h1>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- History (Takes from meal_order, add stuff) -->
                            <div style="margin: 6px 0px;border-color: var(--bs-body-bg);background: var(--bs-card-cap-bg);">
                                <h1 style="color: var(--bs-emphasis-color);width: 50px;">History</h1>
                                <div class="card"><img class="card-img d-block img-thumbnail" style="max-width: 200px; max-height: 200px;" src="assets/img/air-fryer-crispy-chicken-sandwhich.jpg">
                                    <div class="card-body">
                                        <h4 class="card-title">Air Fryer Crispy Chicken Sandwhich</h4>
                                        <p class="card-text">Ordered on 6/28/23</p>
                                    </div>
                                </div>
                                <div class="card"><img class="card-img-top d-block" style="max-width: 200px; max-height: 200px;" src="assets/img/vegan-pizza.jpg">
                                    <div class="card-body">
                                        <h4 class="card-title">Vegan Pizza</h4>
                                        <p class="card-text">Ordered on 6/29/23</p>
                                    </div>
                                </div>
                            </div>
                            <!-- Make it -->
                        </div>
                        <div class="col-md-9 col-lg-8 col-xl-8 col-xxl-8 mb-4">
                           
                            <% List<Meal> mealResult = (List<Meal>) request.getAttribute("mealResult"); %>
                            <div style="margin: 16px;">
						    <% if (mealResult != null && !mealResult.isEmpty()) { %>
						        <% int count = 0; %>
						        <% for (Meal meal : mealResult) { %>
						            <% if (count % 3 == 0) { %>
						                <div class="row">
						            <% } %>
						            <div class="col-sm-4 px-0">
						                <div class="card"><img class="card-img-top w-100 d-block" style="max-width: 400px; max-height: 400px;" src="assets/img/healthy-chicken-caserole.jpg">
						                    <div class="card-body">
						                        <h4 class="card-title"><%= meal.getMeal_name() %></h4>
						                        <p class="card-text">Nutrition: <%= meal.getNutrition() %></p>
						                        <p class="card-text">Ingredients: <%= meal.getIngredients() %></p>
						                        <button class="btn btn-primary" type="button">Add to cart</button>
						                    </div>
						                </div>
						            </div>
						            <% if (count % 3 == 2 || count == mealResult.size() - 1) { %>
						                </div>
						            <% } %>
						            <% count++; %>
						        <% } %>
						    <% } %>
						</div>             
                            
                     </div>
                        <div class="col-md-2 col-lg-2 col-xl-2 col-xxl-2 mb-4">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h1 style="color: var(--bs-emphasis-color);width: 50px;">Cart</h1>
                            </div>
                            <div class="card">
                                <img class="card-img-top w-100 d-block" style="max-width: 200px; max-height: 200px;" src="assets/img/healthy-chicken-caserole.jpg">
                                <div class="card-body">
                                    <h4 class="card-title">Healthy Chicken Caserole</h4>
                                    <p class="card-text">It's chicken, but healthy</p>
                                    <a href="#" class="btn btn-danger float-right"><i class="fas fa-trash-alt"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div><a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
    </div>
</div>

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
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="https://cdn.reflowhq.com/v2/toolkit.min.js"></script>
<script src="assets/js/bs-init.js"></script>
<script src="assets/js/theme.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>