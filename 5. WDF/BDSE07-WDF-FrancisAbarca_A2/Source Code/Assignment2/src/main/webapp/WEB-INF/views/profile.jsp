<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="../header.jsp">
        <jsp:param value="Profile" name="HTMLtitle" />
    </jsp:include>
        
        <div class="bg-element container py-5">
        	<div class="row gx-5 justify-content-center" style="margin-left: -12px; margin-bottom: -5px;">
            <div class="my-5" style="padding: 5%;">
              </div>
            </div>
          </div>

    <div class="container">
        <form action="profile" method="post">
            <div class="row border rounded-3 p-3 mb-4">
                <div
                    class="col-2 border-none rounded-circle align-self-stretch text-center fs-1 d-flex align-items-center justify-content-center bg-danger bg-gradient text-white">
                    <span>${f}</span>
                    <span>${l}</span>
                </div>
                <div class="col-8">
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="firstName" name="firstName" value="${firstName}"
                            required>
                        <label for="firstName">First Name</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="lastName" name="lastName" value="${lastName}"
                            required>
                        <label for="lastName">Last Name</label>
                    </div>

                    <input type="text" class="form-control" value="${title}" name="title" placeholder="Your title"> <br />
                    <input type="text" class="form-control" value="${company}" name="company" placeholder="Your Company">
                </div>
                <div class="col-2 align-self-center">
                    <button type="submit" class="btn btn-danger">Save Changes</button>
                </div>
            </div>

            <div class="row">
                <div class="col-9">
                    <div class="mb-3">
                        <h3>About Me</h3>
                        <hr>
                        <textarea class="form-control" name="about" id="about" cols="10">${about}</textarea>
                    </div>
                    <div class="mb-3">
                        <div class="d-flex">
                            <h3>Experience</h3>
                            <button type="button" class="btn btn-danger ms-auto" data-bs-toggle="modal"
                                data-bs-target="#experiences">
                                Add Experience
                            </button>

                            <div class="modal fade" id="experiences" tabindex="-1" aria-labelledby="experiencesLabel"
                                aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="experiencesLabel">Add Experience</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-floating mb-3">
                                                <input type="text" class="form-control" id="position" name="position">
                                                <label for="position">Position</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input type="date" class="form-control" id="startDateEX"
                                                    name="startDateEX">
                                                <label for="startDateEX">Start Date</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input type="date" class="form-control" id="endDateEX" name="endDateEX">
                                                <label for="endDateEX">End Date</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input type="text" class="form-control" id="companyName"
                                                    name="companyName">
                                                <label for="companyName">Company Name</label>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal"
                                                id="exBtn">Add</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr>
                        <div id="experiencesMD"></div>
                        <c:forEach var="e" items="${ex}">
                            <div class="d-flex align-items-center">
                                <i class='bx bx-map-pin fs-2'></i>
                                <div class="p-3">
                                    <h4>${e[0]} (${e[1].split("-")[0]} - ${e[2].split("-")[0]})</h4>
                                    <small>${e[3]}</small>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div>
                        <div class="d-flex">
                            <h3>Education</h3>
                            <button type="button" class="btn btn-danger ms-auto" data-bs-toggle="modal"
                                data-bs-target="#educations">
                                Add Education
                            </button>
                            <div class="modal fade" id="educations" tabindex="-1" aria-labelledby="educationsLabel"
                                aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="educationsLabel">Add Education</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-floating mb-3">
                                                <input type="text" class="form-control" id="intitutionName"
                                                    name="intitutionName">
                                                <label for="intitutionName">Intitution Name</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input type="date" class="form-control" id="startDateED"
                                                    name="startDateED">
                                                <label for="startDateED">Start Date</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input type="date" class="form-control" id="endDateED" name="endDateED">
                                                <label for="endDateED">End Date</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input type="text" class="form-control" id="educationName"
                                                    name="educationName">
                                                <label for="educationName">Education Name</label>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal"
                                                id="edBtn">Add</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <hr>
                        <div id="educationsMD"></div>
                        <c:forEach var="e" items="${ed}">
                            <div class="d-flex align-items-center">
                                <i class='bx bx-map-pin fs-2'></i>
                                <div class="p-3">
                                    <h4>${e[0]} (${e[1].split("-")[0]} - ${e[2].split("-")[0]})</h4>
                                    <small>${e[3]}</small>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-3">
                    <div>
                        <div class="d-flex align-items-center mb-3">
                            <i class='bx bx-envelope fs-2'></i>
                            <div class="form-floating ml-3">
                                <input type="text" class="form-control" id="email" name="email" value="${email}"
                                    disabled>
                                <label for="email">Email</label>
                            </div>
                        </div>
                        <div class="d-flex align-items-center mb-3">
                            <i class='bx bx-globe fs-2'></i>
                            <div class="form-floating ml-3">
                                <input type="text" class="form-control" id="website" name="website" value="${website}">
                                <label for="website">Website</label>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <script src="js/profile.js"></script>
    <jsp:include page="../footer.jsp"></jsp:include>