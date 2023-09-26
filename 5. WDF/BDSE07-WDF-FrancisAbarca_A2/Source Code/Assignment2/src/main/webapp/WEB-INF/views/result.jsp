<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.Assignment2.bean.User"%>
<jsp:include page="../header.jsp">
    <jsp:param value="Result" name="HTMLtitle" />
</jsp:include>

<div class="container">
	<div class="alert alert-success alert-dismissible fade show ${message == null ? "d-none" : "d-flex"}" role="alert">
	  ${message}
	  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>
    <div class="row border rounded-3 p-3 mb-4">
        <div
            class="col-2 border-none rounded-circle align-self-stretch text-center fs-1 d-flex align-items-center justify-content-center bg-success bg-gradient text-white">
            <span>${f}</span>
            <span>${l}</span>
        </div>
        <div class="col-8 p-5">
            <h2>${fullName}</h2>
            <p>${title}</p>
        </div>
        <div class="col-2 align-self-center">
            <button class="btn btn-success" id="follow">Follow</button>
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
	                        <h4>${e[0]} (${e[1].split("-")[0]} - ${e[2].split("-")[0]})</h4>
	                        <small>${e[3]}</small>
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
	                        <h4>${e[0]} (${e[1].split("-")[0]} - ${e[2].split("-")[0]})</h4>
	                        <small>${e[3]}</small>
	                    </div>
	                </div>
                </c:forEach>
            </div>
        </div>
        <div class="col-3">
            <div>
                <div class="d-flex align-items-center">
                    <i class='bx bx-building fs-2'></i>
                    <div class="p-2">
                        <h4>Company</h4>
                        <small>${company}</small>
                    </div>
                </div>
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
<script>
	const followBtn = document.querySelector("#follow");
	followBtn.addEventListener("click", () => {
		if(followBtn.innerHTML == "Follow") {
			followBtn.classList.remove("btn-success");
			followBtn.classList.add("btn-outline-success");
			followBtn.innerHTML = "Unfollow";
		} else {
			followBtn.classList.add("btn-success");
			followBtn.classList.remove("btn-outline-success");
			followBtn.innerHTML = "Follow";
		}
	});
</script>
<jsp:include page="../footer.jsp"></jsp:include>