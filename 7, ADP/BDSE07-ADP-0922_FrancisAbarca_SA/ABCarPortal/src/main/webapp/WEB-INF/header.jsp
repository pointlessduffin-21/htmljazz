<head>
    <link rel="icon" href="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/abc-cars.png">
    <meta charset="UTF-8">
    <title>ABC Cars</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets2/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i&amp;display=swap">
    <link rel="stylesheet" href="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets2/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets2/css/baguetteBox.min.css">
    <link rel="stylesheet" href="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets2/css/vanilla-zoom.min.css">
    <link rel="stylesheet" href="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets2/fonts/simple-line-icons.min.css">

    <head>
        <!-- Add your existing meta tags, link tags, etc. -->
        <style>
            .navbar {
                z-index: 1030;
            }

            .navbar-collapse {
                background-color: #ffffff;
            }

            @media (max-width: 991px) {
                .navbar-nav {
                    margin-left: 0;
                }
                .navbar-nav .nav-item {
                    float: none;
                }
                .navbar-nav .nav-link {
                    padding-left: 15px;
                    padding-right: 15px;
                }
            }
        </style>
    </head>

</head>



<!-- Navbar -->
<nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
    <div class="container">
        <a class="navbar-brand logo" href="/">
            <img src="/images/abc-cars.png" alt="ABC Cars" style="width: 60px; height: auto;">
        </a>
        <button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1">
            <span class="visually-hidden">Toggle navigation</span>
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="navbar-nav ms-auto">


                <sec:authorize access="!isAuthenticated()">
                <div class="navbar-nav ms-auto">
                    <a href="/" class="nav-item nav-link">Home</a>
                  <a href="about_us" class="nav-item nav-link">About Us</a> <a
                        href="contact_us" class="nav-item nav-link">Contact Us</a>
                </div>
                <div class="navbar-nav ms-auto">
                    <a href="login" class="btn btn-primary">Login</a>
                </div>
                </sec:authorize>

                    <sec:authorize access="hasAnyRole('Administrator')">

                    <div class="navbar-nav px-5 ms-auto" style="width: 40%;">
                        <sf:form action="search" method="get" style="width: 100%;">
                            <div class="input-group">
                                <input type="search" class="form-control rounded p-3"
                                       placeholder="Search" aria-label="Search" name="keyword"
                                       aria-describedby="search-addon" />
                                <button type="submit" class="btn btn-outline-primary p-3">search</button>
                            </div>
                        </sf:form>
                    </div>

                    </sec:authorize>

                    <sec:authorize access="hasAnyRole('Users')">

                    <div class="navbar-nav px-5 ms-auto" style="width: 70%;">
                        <sf:form action="search" method="get" style="width: 100%;">
                            <div class="input-group">
                                <input type="search" class="form-control rounded p-3"
                                       placeholder="Search" aria-label="Search" name="keyword"
                                       aria-describedby="search-addon" />
                                <button type="submit" class="btn btn-outline-primary p-3">search</button>
                            </div>
                        </sf:form>
                    </div>

                    </sec:authorize>




                <sec:authorize access="isAuthenticated()">

                <sec:authorize access="hasRole('Users')">
                <div class="navbar-nav ms-auto">
                    <a class="nav-item nav-link p-3" href="cars">Home</a>
                </div>

                </sec:authorize>

                <sec:authorize access="hasRole('Administrator')">
                <div class="navbar-nav ms-auto">
                    <a class="nav-item nav-link p-3" href="cars">Home</a> <a
                        class="nav-item nav-link p-3" href="all_cars">Car Manager</a>
                    <a class="nav-item nav-link p-3" href="users">User Manager</a>
                </div>

                </sec:authorize>

                    <sec:authorize access="hasAnyRole('Administrator','Users')">

                    <!-- /logout must be a POST request, as csrf is enabled.
                    This ensures that log out requires a CSRF token and that a malicious user cannot forcibly log out your users.-->
                    <div class="navbar-nav ms-auto">

                        <a class="nav-item nav-link p-3" href="profile">Profile</a>

                        <form action="logout" method="post" style="padding: 7px;">
                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}" /> <input type="submit" name="Logout"
                                                                    value="Logout" class="btn btn-primary"></input>
                        </form>
                    </div>


                    </sec:authorize>




                </sec:authorize>




        </div>
    </div>
</nav>
</div>
</nav>

<br />
<br />
<br />
<br />