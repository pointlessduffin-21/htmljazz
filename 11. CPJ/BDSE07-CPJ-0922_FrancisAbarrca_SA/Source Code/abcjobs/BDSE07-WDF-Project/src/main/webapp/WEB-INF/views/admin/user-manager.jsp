<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../header.jsp">
    <jsp:param value="All users" name="HTMLtitle" />
    <jsp:param value="../css/zephyr.css" name="isNested" />
</jsp:include>

<section class="bg-light py-5">
      <div class="container px-5 my-5 px-5">
          <div class="text-center mb-5">
              <div class="feature bg-danger bg-gradient text-white rounded-3 mb-3"><i class="bi bi-search"></i></div>
              <h2 class="fw-bolder">User Manager</h2>
              <p class="lead mb-0">Monitor users here!</p>
          </div>
<div class="container">
    <table class="table table-hover my-3">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Full Name</th>
                <th scope="col">Email</th>
                <th scope="col">Title</th>
                <th scope="col">Action</th>
            </tr>
        </thead>
        <tbody>
            <% int i = 1; %>
            <c:forEach var="user" items="${users}">
                <tr>
                    <th scope="row"><%= i++ %></th>
                    <td>${user.firstName} ${user.lastName}</td>
                    <td>${user.user.email}</td>
                    <td>${user.title == null ? "-" : user.title}</td>
                    <td>
                        <a href="<c:url value='/admin/profile/${user.userDetailsId}'/>">Update Profile</a> |
                        <a href="<c:url value='/admin/delete/${user.userDetailsId}'/>">Delete Profile</a>
                    </td>
                </tr>

                <!-- delete confirmation -->
                <div class="modal fade" id="deleteModal" style="z-index: 2000;">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="exampleModalLabel">Delete ${user.firstName}</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                You want to really delete this user?
                            </div>
                            <div class="modal-footer">
                                <a href="<c:url value='/admin/delete/${user.userDetailsId}'/>" class="btn btn-outline-danger">Delete</a>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- detail -->
                <div class="modal fade" id="detailModal${user.userDetailsId}" style="z-index: 2000;">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="exampleModalLabel">Detail</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">
                                        <h4>First Name</h4>
                                        <p>${user.firstName}</p>
                                    </li>
                                    <li class="list-group-item">
                                        <h4>Last Name</h4>
                                        <p>${user.lastName}</p>
                                    </li>
                                    <li class="list-group-item">
                                        <h4>Title</h4>
                                        <p>${user.title}</p>
                                    </li>
                                    <li class="list-group-item">
                                        <h4>About</h4>
                                        <p>${user.about}</p>
                                    </li>
                                    <li class="list-group-item">
                                        <h4>Company Name</h4>
                                        <p>${user.companyName}</p>
                                    </li>
                                    <li class="list-group-item">
                                        <h4>Website</h4>
                                        <a href="${user.website}">${user.website}</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </tbody>
    </table>
</div>
</div>
</section>

<jsp:include page="../../footer.jsp"></jsp:include>
