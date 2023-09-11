<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../header.jsp">
    <jsp:param value="Profile" name="HTMLtitle" />
</jsp:include>

<div class="container">
            <div class="alert alert-success alert-dismissible fade show ${message == null ? " d-none" : "d-flex" }"
                role="alert">
                ${message}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            
          <div class="bg-element container py-5" style="margin-left: -12px; margin-bottom: -5px;">
        	<div class="row gx-5 justify-content-center">
            <div class="my-5" style="padding: 5%;">
              </div>
            </div>
          </div>
        </div>
            

		<div class="container">
            <div class="row border rounded-3 p-3 mb-4 foreground">
                <div
                    class="col-2 border-none rounded-circle align-self-stretch text-center fs-1 d-flex align-items-center justify-content-center bg-danger bg-gradient text-white">
                    <span>${f}</span>
                    <span>${l}</span>
                </div>
                <div class="col-8 p-5">
                    <h2>${fullName}</h2>
                    <p>${title} at ${company}</p>
                </div>
                <div class="col-2 align-self-center">
                    <a href="update-profile" class="btn btn-danger">Edit Profile</a>
                </div>
            </div>

            <div class="row">
                <div class="col-9">
                    <div class="mb-3">
                        <h3>About Me</h3>
                        <hr>
                        <p>${about}</p>
                    </div>
                    <div class="mb-3">
                        <h3>Experience</h3>
                        <hr>
                        <c:forEach var="e" items="${ex}">
                            <div class="d-flex align-items-center">
                                <i class='bx bx-map-pin fs-2'></i>
                                <div class="p-3">
                                    <h4>${e.getPosition()} (${e.getStartDate().split("-")[0]} - ${e.getEndDate().split("-")[0]})</h4>
                            		<small>${e.getCompanyName()}</small>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div>
                        <h3>Education</h3>
                        <hr>
                        <c:forEach var="e" items="${ed}">
                            <div class="d-flex align-items-center">
                                <i class='bx bx-book fs-2'></i>
                                <div class="p-3">
                                     <h4>${e.getEducationName()} (${e.getStartDate().split("-")[0]} - ${e.getEndDate().split("-")[0]})</h4>
                            		<small>${e.getIntitutionName()}</small>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-3">
                    <div>
                        <div class="d-flex align-items-center">
                            <i class='bx bx-envelope fs-2'></i>
                            <div class="p-2">
                                <h4>Email</h4>
                                <small>${email}</small>
                            </div>
                        </div>
                        <div class="d-flex align-items-center">
                            <i class='bx bx-globe fs-2'></i>
                            <div class="p-2">
                                <h4>Website</h4>
                                <small>${website}</small>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        </div>

<jsp:include page="../../footer.jsp"></jsp:include>