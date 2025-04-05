<%@ page contentType="text/html; charset=US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<!--  This file has been downloaded from bootdey.com @bootdey on twitter -->
<!--  All snippets are MIT license http://bootdey.com/license -->
<title>Know Your Neigborhood</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
<c:forEach items="${user}" var="u" >
<c:set var="name" value="${u.name}"></c:set>
</c:forEach>

	<%@ include file="header.jsp"%>

<main class="page landing-page">
	<section class="clean-block clean-hero" style="color: rgba(31,28,140,0.35);background: url(https://gpupv.yeems214.xyz/R%20e%20p%20o%20s%20i%20t%20o%20r%20y/assets/img/OIG.jpg) center / cover space;">
		<div class="text">
			<h2><br><span style="color: rgb(237, 235, 233); background-color: rgba(255, 255, 255, 0.1);">Discover the hidden gems in your community here!</span></h2>
			<p>With Know Your Neighborhood, we help you find the utmost special businesses and infrastructures available in your community!</p><a  href="addStore"><button class="btn btn-outline-light btn-lg" type="button">Add your business</button></a>
		</div>
	</section>
</main>


</body>
</html>
