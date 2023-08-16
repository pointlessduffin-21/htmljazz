<%@ page import="com.Group1.MealsOnWheels.Entity.Meal_Order" %>
<%@ page import="com.Group1.MealsOnWheels.Entity.Meal" %>
<%@ page import="com.Group1.MealsOnWheels.Entity.User" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html data-bs-theme="light" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/bootstrap/css/style.css">
    <title>Kitchen Dashboard</title>
    <link href="https://cdn-icons-png.flaticon.com/512/7541/7541900.png" rel="icon">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>

	<%@ include file="header.jsp"%>

    <!-- Main Dashboard -->
    <div class="dashboard">
        <div class="dashboard-banner">
            <img src="https://i.pinimg.com/564x/25/e6/a1/25e6a1365e9a35071db3c7d2d8ea6eab.jpg">
            <div class="banner-promo">
                <h1><span>50% OFF</span><br>
                Tasty Food<br> On Your Hand
                </h1>
            </div>
        </div>


        <div class="dashboard-menu">

            <a class="button btn-primary" href="/addmeal">Add Meal</a>
        </div>

        <div class="dashboard-content">
        
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
      


								</span>
								<p>Meal no.  <%= meal.getM_id() %></p>
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
		<div class="card-header py-3">
			<h6 class="text-secondary fw-bold m-0"
				style="color: rgb(45, 237, 42);">Incoming</h6>
		</div>
        <div class="order-wrapper">
        <% List<Meal_Order> approvedMeals = (List<Meal_Order>) request.getAttribute("approvedMeals"); %>
       		<% if (approvedMeals != null && !approvedMeals.isEmpty()) { %>
       		<% for (Meal_Order order : approvedMeals) { %>
        <div class="order-card">
                <% mealResult = (List<Meal>) request.getAttribute("mealResults"); %>
		       	<% for (Meal approvedMeal : mealResult) { %>
		       	<% if (order.getM_id() == approvedMeal.getM_id()) { %>
                <img class="order-image" src="<%= approvedMeal.getPhotoPath() %><%= approvedMeal.getPhoto() %>">
                <div class="order-detail">
                    <p><%= approvedMeal.getMeal_name() %></p>
                    <p>Order Number: <%= order.getOrder_number() %></p>
                    <p>Member ID: <%= order.getU_id() %></p>
					<div style="display: flex;">
					  <span style="margin-right: 10px;">
						  <form action="/acceptOrder" method="post" class="ms-0 col-2" style="position:relative;left:0%;">	
					    	<input type="hidden" name="orderId" value="<%= order.getMo_id() %>">
					    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
					    	<button class="btn btn-success" type="submit" style="width: 80px; padding: 6px 12px;">Accept</button>
					    </form>
					    
					    
					    
					  </span>
					</div>
                </div>
	            <% } %>
				<% } %>
            </div>
            <% } %>
			<% } %>
        </div><br><br><br>
        <hr class="divider">
        
        
        
		<div class="card-header py-3">
			<h6 class="text-secondary fw-bold m-0"
				style="color: rgb(45, 237, 42);">Delivery</h6>
		</div>
		<div class="order-wrapper">
		  <% List<Meal_Order> acceptedMeals = (List<Meal_Order>) request.getAttribute("acceptedMeals"); %>
       		<% if (acceptedMeals != null && !acceptedMeals.isEmpty()) { %>
       		<% for (Meal_Order cooking : acceptedMeals) { %>
		
            <div class="order-card">
                <div class="order-detail">
                <% mealResult = (List<Meal>) request.getAttribute("mealResults"); %>
		       	<% for (Meal approvedMeal : mealResult) { %>
		       	<% if (cooking.getM_id() == approvedMeal.getM_id()) { %>    
                    <img class="order-image" src="<%= approvedMeal.getPhotoPath() %><%= approvedMeal.getPhoto() %>">
                    <p>Order Number: <%= cooking.getOrder_number() %></p>
                    <p>Member ID: <%= cooking.getU_id() %></p>
                    <p>Name: <%= approvedMeal.getMeal_name() %></p>
                    <% } %>
					<% } %>
                    
					<div style="display: flex;" class="pt-2">
					  <span style="margin-right: 10px;">
					    <form action="/assignRider" method="post" class="ms-0 col-2" style="position:relative;left:0%;">	
					    	<input type="hidden" name="orderId" value="<%= cooking.getMo_id() %>">
					    	 <select class="form-select rider-dropdown mb-3" name="riderId" id="riderId">
			          		<option selected disabled>Select a rider</option>
			            	<% List<User> rider = (List<User>) request.getAttribute("riders"); %>
		       				  <% if (rider != null && !rider.isEmpty()) { %>
		       				  <% for (User volunteers : rider) { %>
                    <option value="<%= volunteers.getId() %>"><%= volunteers.getName() %></option>
                    <% } %>
                    <% } %>
			        </select>
					    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
					    	<button class="btn btn-success" type="submit" style="width: 80px; padding: 6px 12px;">Assign</button>
					    </form>
					  </span>
					</div>
                </div>
            </div>
            <hr class="divider">
            <% } %>
			<% } %>
           <!--  <hr class="divider">
            <div class="order-card">
                <div class="order-detail">
                    <p>Order Number: #122</p>
                    <select class="form-select rider-dropdown">
			          <option selected disabled>Select a rider</option>
			          <option>Rider 1</option>
			          <option>Rider 2</option>
			          <option>Rider 3</option>
			        </select>
					<div style="display: flex;" class="pt-2">
					  <span style="margin-right: 10px;">
					    <button class="btn text-white" type="button" style="width: 220px; padding: 6px 12px; background: rgb(86, 114, 216);">Deliver</button>
					  </span>
					</div>
                </div>
            </div>
            <hr class="divider">
            <div class="order-card">
                <div class="order-detail">
                    <p>Order Number: #123</p>
                    <select class="form-select rider-dropdown">
			          <option selected disabled>Select a rider</option>
			          <option>Rider 1</option>
			          <option>Rider 2</option>
			          <option>Rider 3</option>
			        </select>
					<div style="display: flex;" class="pt-2">
					  <span style="margin-right: 10px;">
					    <button class="btn text-white" type="button" style="width: 220px; padding: 6px 12px; background: rgb(86, 114, 216);">Deliver</button>
					  </span>
					</div>
                </div>
            </div> -->

        </div>
    </div>

<div class="modal fade" id="addMenuModal" tabindex="-1" role="dialog" aria-labelledby="addMenuModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="addMenuModalLabel">Add Menu</h5>
        <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group pb-3">
            <label for="menuName">Menu Name</label>
            <input type="text" class="form-control" id="menuName" placeholder="Enter the menu name">
          </div>
          <div class="form-group pb-3">
            <label for="menuIngredients">Menu Description</label>
            <textarea class="form-control" id="menuIngredients" rows="3" placeholder="Enter the menu ingredients"></textarea>
          </div>
          <div class="form-group">
            <label for="menuPicture">Menu Picture</label><br>
            <input type="file" class="form-control-file" id="menuPicture">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
        <button type="button" class="btn btn-success">Save</button>
      </div>
    </div>
  </div>
</div>

        <script>
            $(document).ready(function() {
                $.ajax({
                    url: '/orders/readyOrders',
                    type: 'GET',
                    dataType: 'json',
                    success: function(data) {
                        let container = $('#ordersContainer');
                        let totalAmount = 0;
    
                        data.forEach(function(order) {
                            let orderContainer = $('<div class="card mb-3"></div>');
                            let cardBody = $('<div class="card-body"></div>');

                            cardBody.append($('<p class="card-text"></p>').text('Meal Id: ' + order.mo_id));
                            cardBody.append($('<p class="card-text"></p>').text('Order Number: ' + order.order_number));
                            cardBody.append($('<p class="card-text"></p>').text('Member Id: ' + order.m_id));
                            cardBody.append($('<p class="card-text"></p>').text('Date: ' + order.order_date));
                            cardBody.append($('<p class="card-text"></p>').html('Status: <strong>' + order.status + '</strong>'));



                            // Create the button
                            let acceptButton = $('<button class="btn btn-success float-end" type="button">Accept</button>');

                            cardBody.append(acceptButton);

                            orderContainer.append(cardBody);
                            container.append(orderContainer);
                        });
                    },
                    error: function(xhr, status, error) {
                        console.error('Error:', error);
                    }
                });
            });

        </script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="https://cdn.reflowhq.com/v2/toolkit.min.js"></script>
<script src="assets/js/bs-init.js"></script>
<script src="assets/js/theme.js"></script>

</body>
</html>