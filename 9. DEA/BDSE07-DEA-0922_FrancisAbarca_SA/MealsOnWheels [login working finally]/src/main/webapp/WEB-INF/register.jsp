<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registration</title>
    <link href="https://cdn-icons-png.flaticon.com/512/7541/7541900.png"
          rel="icon">
</head>
<body>
<%@ include file="header.jsp"%>
<div class="align-items-center position-relative" style="height: 100vh; overflow: hidden">
    <img class="position-absolute" style="width:100%" src="https://images.unsplash.com/photo-1522072075489-6c14756ea254?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80"/>
    <h1 class="text-white text-center ps-5 pt-5 pb-0 mb-0" style="font-size: 3em; font-weight: 700; position: relative; top: 0px" >REGISTRATION</h1>

    <div class='container mt-5 border p-5 pt-0 rounded' style="width: 50%; position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); background-color: rgba(255, 255, 255, 0.5)">


        <div class='row justify-content-evenly mt-5'>
            <hr class="col-3 py-2 mb-0"></hr>
            <p type="button" class="col-6 py-2 mb-0 text-center" style="position: relative; top: -20px">Don't have an account? Register!</p>
            <hr class="col-3 py-2 mb-0"></hr>
        </div>

        <form class='m-2' action="/register_user" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		
			<div class="dropdown-center col-3 mx-auto d-grid text-center mb-3">
			    <label htmlFor='userRole'>Choose a Role:</label>
			    <select name="userRole" class="form-control" id="userRole">
			        <option value="Member">Member</option>
			        <option value="Donator">Donator</option>
			        <option value="Volunteer">Volunteer</option>
			        <option value="Partner">Partner</option>
			    </select>
			</div>


            <div class='row'>
                <div class='form-group mb-3 col-6'>
                    <label htmlFor='name'>Name</label>
                    <input
                            type='text'
                            class='form-control'
                            id='name'
                            name='name'
                    />
                </div>

                <div class='form-group mb-3 col-6'>
                    <label htmlFor='userName'>Username</label>
                    <input
                            type='text'
                            class='form-control'
                            id='userName'
                            name='userName'
                    />
                </div>
            </div>

            <div class="row">
                <div class='form-group mb-3 col-6'>
                    <label htmlFor='email'>Email Address</label>
                    <input
                            type='email'
                            class='form-control'
                            id='email'
                            name='email'
                    />
                </div>

                <div class='form-group mb-3 col-6'>
                    <label htmlFor='password'>Password</label>
                    <input
                            type='password'
                            class='form-control'
                            id='password'
                            name='password'
                    />
                </div>
            </div>

            <div class='row'>
                <div class='form-group mb-3 col-6'>
                    <label htmlFor='age'>Age</label>
                    <input
                            type='text'
                            class='form-control'
                            id='age'
                            name='age'
                    />
                </div>

                <div class='form-group mb-3 col-6'>
                    <label htmlFor='mobile'>Contact</label>
                    <input
                            type='text'
                            class='form-control'
                            id='mobile'
                            name='mobile'
                    />
                </div>
            </div>

            <div class='form-group mb-3'>
                <label htmlFor='address'>Address</label>
                <input
                        type='text'
                        class='form-control'
                        id='address'
                        name='address'
                />
            </div>

            <button type='submit' class='btn btn-outline-dark px-5 mt-3 col-12'>Register</button>

        </form>
    </div>
</div>

<%@ include file="footer.jsp"%>

</body>
</html>