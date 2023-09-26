<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Register</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
      rel="stylesheet"
    />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
  </head>
  <body>
  
    <!-- Responsive navbar-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container px-5">
        <img
          src="https://media.discordapp.net/attachments/751840315614167104/1077804817059168307/abcjobslogolight.png?width=881&height=250"
          width="100"
          height="30"
          class="d-inline-block align-top"
          alt=""
        />
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
            </li>
            <li class="nav-item"><a class="nav-link" href="userRegister.jsp">Register</a></li>
          </ul>
        </div>
      </div>
    </nav>
    
		<div align="center">
        <h1>User Register Form</h1>
        <form id="myForm" action="userRegister-import.jsp" onsubmit="return validateForm()" method="post">
            <table style="width: 80%">
                <tr>
                    <td>First Name*</td>
                    <td><input type="text" name="firstName" required /></td>
                </tr>
                <tr>
                    <td>Last Name*</td>
                    <td><input type="text" name="lastName" required /></td>
                </tr>
                <tr>
                    <td>User Name*</td>
                    <td><input type="text" name="userName" required /></td>
                </tr>
                <tr>
                    <td>Pronouns*</td>
                    <td><select name="pronouns" required>
                        <option value="He/Him">He/Him</option>
                        <option value="She/Her">She/Her</option>
                        <option value="They/Them">They/Them</option>
                        <option value="Rather Not Say">Rather Not Say</option>
                    </select></td>
                </tr>
                <tr>
                    <td>Country*</td>
                    <td><input type="text" name="country" required></td>
                </tr>
                <tr>
                    <td>Email Address*</td>
                    <td><input type="text" name="email" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"></td>
                </tr>
                <tr>
                    <td>Password*</td>
                    <td><input type="password" name="password" required></td>
                </tr>
                <tr>
                    <td>Confirm Password*</td>
                    <td><input type="password" name="confirmPassword" required></td> 
                </tr>
            </table>
            <input type="submit" value="Submit" />
        </form> 
    </div>
    
    <!-- Footer-->
    <footer class="py-5 bg-dark">
      <div class="container px-5">
        <p class="m-0 text-center text-white">
          Copyright &copy; ABC Jobs 2023
        </p>
      </div>
    </footer>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
     <script>
      function validateForm() {
        var password = document.forms['myForm']['password'].value;
        var confirmPassword = document.forms['myForm']['confirmPassword'].value;
        if (password != confirmPassword) {
          alert('Passwords do not match.');
          return false;
        }
      }
    </script>
  </body>
</body>
</html>