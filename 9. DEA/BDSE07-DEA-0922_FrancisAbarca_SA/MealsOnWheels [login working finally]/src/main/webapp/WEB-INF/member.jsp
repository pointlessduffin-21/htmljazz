<%@ page import="com.Group1.MealsOnWheels.Entity.Meal_Order" %>
<%@ page import="com.Group1.MealsOnWheels.Entity.Meal" %>
<%@ page import="com.Group1.MealsOnWheels.Entity.User" %>
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

<!-- header -->

<!-- Main Dashboard -->
<div class="dashboard">
    <div class="dashboard-banner">
        <img src="https://i.pinimg.com/564x/25/e6/a1/25e6a1365e9a35071db3c7d2d8ea6eab.jpg">
        <div class="row">

            <div class="row" style="position:absolute;top:25%;left:10%">
                <<% User user = (User) request.getAttribute("loggedUser"); %>>
                <div class="col-1">
                    <div style="height: 150px; width: 150px;" class="rounded-circle bg-primary">
                        <div class="h-100 fs-1 text-white d-flex justify-content-center" style="width: 150px;">
                            <span style="font-size: 2em;" class="my-auto"> <%= user.getName().charAt(0) %></span>
                        </div>
                    </div>
                </div>
                
                <div class="col-8 ms-5 ps-5">
                    <h1 style="color: var(--yellow);font-weight: 800;">WELCOME!</h1>
                    <h1 class="text-white"><%= user.getName() %> </h1>
                    <h4 class="text-white">Member</h4>
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

            <form action="/search" method="get" class="my-auto ms-3">
                <input style="width: 500px;" type="text" class="form-control" placeholder="Search meals..." name="searchKey" autocomplete="off" data-bs-toggle="popover" data-bs-trigger="focus" data-bs-title="Tips" data-bs-content="Press enter to continue">
            </form>
        </div>

    </div>

    <% String noMealResult = (String) request.getAttribute("noMealResult"); %>
    <% if (noMealResult != null) { %>
    <div class="border rounded text-center py-3 mx-5">
        <h6 class="fw-bold mb-0"><%= noMealResult %></h6>
    </div>
    <% } %>


    <div class=" mx-5">

        <% List<Meal> mealResult = (List<Meal>) request.getAttribute("mealResults"); %>
        <div style="margin: 16px;">
            <% if (mealResult != null && !mealResult.isEmpty()) { %>
            <% int count = 0; %>
            <% for (Meal meal : mealResult) { %>
            <% if (count % 4 == 0) { %>
            <div class="row mb-3">
                <% } %>
                <div class="col-sm-3 pe-1">
                    <div class="dashboard-card">
                        <img class="card-image" src="<%= meal.getPhotoPath() %><%= meal.getPhoto() %>">
                        <div class="card-detail">
                            <h4><%= meal.getMeal_name() %>
                            	<span>  
                            		<form action="/addToCart" method="post" class="ms-0 col-2" style="position:relative;left:0%;">
									    <input type="hidden" name="mealId" value="<%= meal.getM_id() %>">
									    <!-- Insert the CSRF token input field here -->
									    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
									    <button type="submit" class="btn btn-outline-danger" style="width:100px;font-size:0.5em;">Add to Cart</button>
									</form>


								</span>
								<p><%= meal.getDescription() %></p>
                            	<p class="card-time"><span class="fas fa-clock"></span> <%= meal.getDuration() %></p>
							</h4>
							
                            <%-- <p>Nutrition: <%= meal.getNutrition() %></p>
                            <p class="card-time"><span class="fas fa-carrot"></span><%= meal.getIngredients() %></p> --%>
                        </div>
                    </div>
                </div>
                <% if (count % 4 == 3 || count == mealResult.size() - 1) { %>
            </div>
            <% } %>
            <% count++; %>
            <% } %>
            <% } %>
        </div>

    </div>

</div>




<!-- Order Dashboard -->
<div class="dashboard-order" style="padding-top:90px;">
    <h3>Order Menu</h3>
    <div class="order-address">
        <p>Address Delivery</p>
        <h4>221 B Baker Street, Philippines</h4>
    </div>
    <% String orderNumber =(String) request.getAttribute("orderNumber"); %>
    <div class="order-time gap-2">
        <span class="fas fa-hashtag"></span><%= orderNumber %>
    </div>
	    <div class="order-wrapper" style="height:80px;">
	     <% List<Meal> cartContent = (List<Meal>) request.getAttribute("cartContent"); %>
	    <% if (cartContent != null && !cartContent.isEmpty()) { %>
	            <% for (Meal meal : cartContent) { %>
	        <div class="order-card">
	        	<form action="/deleteFromCart" method="post">
	        		<div class="d-flex justify-content-between">
							<div class="d-flex justify-content-start mb-3">
					            <img class="order-image" src="<%= meal.getPhotoPath() %><%= meal.getPhoto() %>">
					            <div class="order-detail ms-3">
					            	<p class="fw-bold mb-0" style="font-size:1em;"><%= meal.getMeal_name() %></p>
					                <span>x</span> <span>1</span>
					            </div>
					        </div>
				        <div>
				           <input type="hidden" name="mealId" id="mealId" value="<%= meal.getM_id() %>">
				            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				            <button type='submit' class="order-price text-danger d-flex justify-content-end me-3 btn"><i class="fas fa-times"></i></button>
						</div>
					</div>
		        </form>
	        </div>
	        
	     <% } %>
	     <% } else %>
	     <div class="order-card">
	     	<% String successMsg =(String) request.getAttribute("successMsg"); %>
	     	
    		<% if (successMsg != null && !successMsg.isEmpty()) { %>
	     	<div class="bg-success-subtle text-center rounded py-3">
	     	<%= successMsg %>
	     	</div>
	     	<% } %>
	     </div>
	    </div>
	     <% Long meal_id = (Long) request.getAttribute("meal_id"); %>
		    <hr class="divider">
				<form action="/checkout" method="post">
				 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				    <input type="hidden" name="mealId" id="mealId" value="<%= meal_id %>">
				    <button type="submit" class="checkout">Checkout</button>
				</form>
	     <h3 class="mt-3"
	     >Order History</h3>
	     <div class="order-wrapper" style="height:300px;">
	     <% List<Meal_Order> myOrders = (List<Meal_Order>) request.getAttribute("myOrders"); %>
	    <% if (myOrders != null && !myOrders.isEmpty()) { %>
	            <% for (Meal_Order meal : myOrders) { %>
	        <div class="order-card">
	        		<div class="d-flex justify-content-between">
	        		        <% mealResult = (List<Meal>) request.getAttribute("mealResults"); %>
	        				<% for (Meal mealOrdered : mealResult) { %>
	        				<% if (meal.getM_id() == mealOrdered.getM_id()) { %>
							<div class="d-flex justify-content-start mb-3">
					            <img class="order-image" src="<%= mealOrdered.getPhotoPath() %><%= mealOrdered.getPhoto() %>">
					            <div class="order-detail ms-3">
					            	<p class="fw-bold mb-0" style="font-size:1em;"> <%= mealOrdered.getMeal_name() %> </p>
					                <span style="font-size:0.8em;"><%= meal.getOrder_date() %> </span> 
					            </div>
					        </div>
					        <% } %>
					        <% } %>
				        <div>
				           <input type="hidden" name="mealId" id="mealId" value="<%= meal.getM_id() %>">
				            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				            <button type='submit' class="order-price text-danger d-flex justify-content-end btn" style="width:113px;">
				            	<p style="font-size:0.8em;" class="mb-0">Status: <%= meal.getStatus() %>
				            </button>
						</div>
					</div>
	        </div>
	     <% } %>
	     <% }  %>
	  
	     </div>
</div>

<%-- 
<%@ include file="footer.jsp"%>
 --%>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="https://cdn.reflowhq.com/v2/toolkit.min.js"></script>
<script src="assets/js/bs-init.js"></script>
<script src="assets/js/theme.js"></script>

</body>
</html>