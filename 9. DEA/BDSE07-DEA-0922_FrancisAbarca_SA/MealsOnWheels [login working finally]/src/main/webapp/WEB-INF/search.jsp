
<%@ page import="com.merrymeals.mealsonwheels.Entity.Meal" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html data-bs-theme="light" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/style.css">
    <title>Member Dashboard</title>
    <link href="https://cdn-icons-png.flaticon.com/512/7541/7541900.png" rel="icon">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
</head>
<body>

<%@ include file="header.jsp"%>
<!-- Main Dashboard -->
<div class="dashboard">
    <div class="dashboard-banner">
        <img src="https://i.pinimg.com/564x/25/e6/a1/25e6a1365e9a35071db3c7d2d8ea6eab.jpg">
        <div class="row">

            <div class="row" style="position:absolute;top:25%;left:10%">
                <div class="col-1">
                    <div style="height: 150px; width: 150px;" class="rounded-circle bg-primary">
                        <div class="h-100 fs-1 text-white d-flex justify-content-center" style="width: 150px;">
                            <span style="font-size: 2em;" class="my-auto">J</span>
                            <span style="font-size: 2em;" class="my-auto">D</span>
                        </div>
                    </div>
                </div>
                <div class="col-8 ms-5 ps-5">
                    <h1 style="color: var(--yellow);font-weight: 800;">WELCOME!</h1>
                    <h1 class="text-white">John Doe</h1>
                    <h4 class="text-white">Donator</h4>
                </div>
            </div>

            <div class="banner-promo text-end">
                <h1><span>FREE</span><br>
                    Tasty Food<br> On Your Hand
                </h1>
            </div>
        </div>

    </div>

    <div class="row d-flex justify-content-between my-3">

        <div class="col-6">
            <h3 class="dashboard-title">Recommended Food For You</h3>
        </div>

        <div class="col-6 d-flex justify-content-end px-5">
            <div class="row">
                <div class="ps-0 col-10">
                    <form action="/search" method="get" class="my-auto ms-3">
                        <input style="width: 500px;" type="text" class="form-control" placeholder="Search meals..." name="searchKey" autocomplete="off" data-bs-toggle="popover" data-bs-trigger="focus" data-bs-title="Tips" data-bs-content="Press enter to continue">
                    </form>
                </div>
            </div>
        </div>

    </div>



    <div class="dashboard-content mx-5">
        <% String noMealResult = (String) request.getAttribute("noMealResult"); %>

        <% if (noMealResult != null) { %>
        <div class="border rounded text-center py-3">
            <h6 class="fw-bold"><%= noMealResult %></h6>
        </div>
        <% } %>

        <% List<Meal> mealResults = (List<Meal>) request.getAttribute("mealResults"); %>

        <% if (mealResults != null && !mealResults.isEmpty()) { %>
        <% for (Meal meals : mealResults) { %>
        <div class="dashboard-card">
            <img class="card-image" src="https://hips.hearstapps.com/hmg-prod/images/classic-cheese-pizza-recipe-2-64429a0cb408b.jpg?crop=0.6666666666666667xw:1xh;center,top&resize=1200:*">
            <div class="card-detail">
                <h4><%= meals.getMeal_name() %><span>$30</span></h4>
                <p>Nutrition: <%= meals.getNutrition() %></p>
                <p class="card-time"><span class="fas fa-carrot"></span><%= meals.getIngredients() %></p>
            </div>
        </div>
        <% } %>
        <% } %>
    </div>





    <!-- Order Dashboard -->
    <div class="dashboard-order" style="padding-top:90px;">
        <h3>Order Menu</h3>
        <div class="order-address">
            <p>Address Delivery</p>
            <h4>221 B Baker Street, Philippines</h4>
        </div>
        <div class="order-time">
            <span class="fas fa-clock"></span>30 minutes <span class="fas fa-map-marker-alt">2km</span>
        </div>

        <div class="order-wrapper">
            <div class="order-card">
                <img class="order-image" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLY5j-0GxBdLWv53oNAH6KKQszBRTDWstPXg&usqp=CAU">
                <div class="order-detail">
                    <p>Lorem ipsum dolor sit amet.</p>
                    <i class="fas fa-times"></i> <input type="text" value="1">
                </div>
                <h4 class="order-price">$35</h4>
            </div>
            <div class="order-card">
                <img class="order-image" src="https://images.immediate.co.uk/production/volatile/sites/30/2014/05/Epic-summer-salad-hub-2646e6e.jpg">
                <div class="order-detail">
                    <p>Lorem ipsum dolor sit amet.</p>
                    <i class="fas fa-times"></i> <input type="text" value="2">
                </div>
                <h4 class="order-price">$35</h4>
            </div>
            <div class="order-card">
                <img class="order-image" src="https://assets.epicurious.com/photos/5c745a108918ee7ab68daf79/1:1/w_2560%2Cc_limit/Smashburger-recipe-120219.jpg">
                <div class="order-detail">
                    <p>Lorem ipsum dolor sit amet.</p>
                    <i class="fas fa-times"></i> <input type="text" value="3">
                </div>
                <h4 class="order-price">$23</h4>
            </div>
        </div>
        <hr class="divider">
        <button class="checkout">
            Checkout
        </button>

    </div>

    <%@ include file="footer.jsp"%>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <script src="https://cdn.reflowhq.com/v2/toolkit.min.js"></script>
    <script src="assets/js/bs-init.js"></script>
    <script src="assets/js/theme.js"></script>

</body>
</html>