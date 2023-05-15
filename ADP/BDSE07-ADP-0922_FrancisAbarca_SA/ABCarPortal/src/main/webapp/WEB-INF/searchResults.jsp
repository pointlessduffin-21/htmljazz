<%@ page contentType="text/html; charset=US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

    <link rel="icon" href="https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/abc-cars.png">
    <title>Search</title>

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


<div class="container">
    <section class="clean-block features">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Search</h2>
            </div>


    <c:if test="${empty searchCar}">

        <div class="alert alert-danger">No search results found for
                ${keyword}</div>

    </c:if>
    <!-- list of all cars posted -->
    <div class="row" style="gap: 60px;">

        <c:forEach items="${searchCar}" var="c">

            <div class="card" style="width: 400px">
                <img class="card-img-top" src="${c.photoImagePath}"
                     alt="${c.photos}" style="width: 100%">
                <div class="card-body">
                    <h4 class="card-title">${c.name}</h4>
                    <p class="card-text">
                        <i class="fas fa-tags"></i>&nbsp;RM ${c.price}
                    </p>

                    <!--<a href="#" class="btn"
                        style="background-color: red; margin-right: 40px;">Book a
                        Test Drive</a>-->
                    <a href="/car_detail?cid=${c.id}" class="btn btn-primary">View
                        Car Details</a>
                </div>
            </div>
        </c:forEach>

    </div>
    <!-- list of all cars posted -->
</div>
    </section>




<%@ include file="footer.jsp"%>
</body>
</html>