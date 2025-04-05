<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../header.jsp">
    <jsp:param value="Index" name="HTMLtitle" />
    <jsp:param value="../css/zephyr.css" name="isNested" />
</jsp:include>

<section class="bg-light py-5">
      <div class="container px-5 my-5 px-5">
          <div class="text-center mb-5">
              <div class="feature bg-danger bg-gradient text-white rounded-3 mb-3"><i class="bi bi-search"></i></div>
              <h2 class="fw-bolder">Admin Manager</h2>
              <p class="lead mb-0">Monitor the page here!</p>
          </div>
<div class="container">
<!-- Button to open the User Manager page -->
<button type="button" class="btn btn-primary" onclick="window.location.href='/abcjobs/admin/all-users'">
  User Manager
</button>
<!-- Button to open the Job Manager page -->
<button type="button" class="btn btn-primary" onclick="window.location.href='/abcjobs/admin/job-manager'">
  Job Manager
</button>

</div>
</div>
</section>

<jsp:include page="../../footer.jsp"></jsp:include>