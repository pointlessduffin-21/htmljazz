<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp">
    <jsp:param value="Search" name="HTMLtitle" />
</jsp:include>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet"/>

 <!-- Search Form-->
    <section class="bg-light py-5">
      <div class="container px-5 my-5 px-5">
          <div class="text-center mb-5">
              <div class="feature bg-danger bg-gradient text-white rounded-3 mb-3"><i class="bi bi-search"></i></div>
              <h2 class="fw-bolder">Search</h2>
              <p class="lead mb-0">Press enter to search.</p>
          </div>
          <div class="row gx-5 justify-content-center">
              <div class="col-lg-6">
                  <form action="" method="get" class="ms-auto">
                      <!-- First Name input-->
                      <div class="form-floating mb-3">
                          <input type="text" class="form-control" name="q" placeholder="Search Other" value="<%= request.getParameter("q") != null ? request.getParameter("q") : "" %>" id="search-query" placeholder="Search" data-sb-validations="required" />
                          <label for="search">Search</label>
                      </div>
                      </form>
                      </div>
                      </div>
                      </div>
                      <div>
    	<h1>${notFound == true ? "Not Found" : ""}</h1>
	   	<c:forEach var="s" items="${selected}">
	       <div class="d-flex align-items-center border mb-3 rounded p-5 shadow-sm container py-5">
	           <div>
	           	<h2>${s.split("-")[0]}</h2>
	           	<p>${s.split("-")[1]}</p>
	           </div>
	           <form action="result" method="post" class="ms-auto">
	           		<input type="hidden" name="name" value="${s.split("-")[0]}">
		           	<button type="submit" class="btn btn-outline-danger ms-auto">View Profile</button>
			   </form>
	       </div>
     	</c:forEach>
    </div>
  </section>