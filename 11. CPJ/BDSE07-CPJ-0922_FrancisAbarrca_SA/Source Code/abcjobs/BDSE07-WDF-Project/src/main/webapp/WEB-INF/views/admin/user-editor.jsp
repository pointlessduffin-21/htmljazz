<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../header.jsp">
    <jsp:param value="User Editor" name="HTMLtitle" />
    <jsp:param value="../../css/zephyr.css" name="isNested" />
</jsp:include>
<head>
    <title>Edit Profile</title>
</head>
<body>

    <section class="bg-light py-5">
        <div class="container px-5 my-5 px-5">
            <div class="text-center mb-5">
                <div class="feature bg-danger bg-gradient text-white rounded-3 mb-3"><i class="bi bi-pen"></i></div>
                <h2 class="fw-bolder">Edit Profile</h2>
                <p class="lead mb-0">Update your profile information</p>
            </div>
            <div class="row gx-5 justify-content-center">
                <div class="col-lg-6">
                    <form action="<c:url value='/admin/profile/update'/>" method="POST">
                        <input type="hidden" name="userDetailsId" value="${id}"/>
                        <!-- First Name input-->
                        <div class="form-floating mb-3">
                            <input type="text" id="firstName" name="firstName" value="${firstName}" class="form-control"/>
                            <label for="firstName">First Name:</label>
                        </div>
                        <!-- Last Name input-->
                        <div class="form-floating mb-3">
                            <input type="text" id="lastName" name="lastName" value="${lastName}" class="form-control"/>
                            <label for="lastName">Last Name:</label>
                        </div>
                        <!-- Title input-->
                        <div class="form-floating mb-3">
                            <input type="text" id="title" name="title" value="${title}" class="form-control"/>
                            <label for="title">Title:</label>
                        </div>
                        <!-- About input-->
                        <div class="form-floating mb-3">
                            <textarea id="about" name="about" class="form-control">${about}</textarea>
                            <label for="about">About:</label>
                        </div>
                        <!-- Company input-->
                        <div class="form-floating mb-3">
                            <input type="text" id="company" name="companyName" value="${company}" class="form-control"/>
                            <label for="company">Company:</label>
                        </div>
                        <!-- Email input-->
                        <div class="form-floating mb-3">
                            <input type="email" id="email" name="email" value="${email}" class="form-control"/>
                            <label for="email">Email:</label>
                        </div>
                        <!-- Website input-->
                        <div class="form-floating mb-3">
                            <input type="url" id="website" name="website" value="${website}" class="form-control"/>
                            <label for="website">Website:</label>
                        </div>
                        <!-- Submit Button-->
                        <div class="d-grid"><button class="btn btn-danger btn-lg" type="submit">Save Changes</button></div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</body>
<jsp:include page="../../footer.jsp"></jsp:include>
