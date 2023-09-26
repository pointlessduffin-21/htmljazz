<%@ page import="com.Assignment2.bean.User" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>
    
    <!--  New Navbar -->
    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>ABC Jobs | <%= request.getParameter("HTMLtitle") !=null ? request.getParameter("HTMLtitle")
          : "Home" %>
      </title>
      <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
      <link href="css/zephyr.css" rel="stylesheet">
      <link href="css/styles.css" rel="stylesheet">
    </head>
    
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container px-5">
        <a href="home"><img
          src="https://media.discordapp.net/attachments/751840315614167104/1077804817059168307/abcjobslogolight.png?width=881&height=250"
          width="100"
          height="30"
          class="d-inline-block align-top"
          alt=""
        /></a>
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
              <a class="nav-link <%= request.getServletPath().equals("/WEB-INF/views/index.jsp") ? "text-danger"
                  : "text-white" %>" href="home">Home</a>
            </li>
            <li class="nav-item">
               <a class="nav-link <%= request.getServletPath().equals("/WEB-INF/views/search.jsp") ? "text-danger"
                  : "text-white" %>" href="search">Search</a>
              </li>
            <% if(User.isLogin()) { %>
                <li class="nav-item">
                  <a class="nav-link <%= request.getServletPath().equals("/WEB-INF/views/dashboard.jsp")
                    ? "text-danger" : "text-white" %>" href="dashboard">Dashboard</a>
                </li>
                <% } %>
            </ul>
            <% if(User.isLogin()) { %>
              <a href="logout" class="btn btn-danger">Logout</a>
              <% } else { %>
                <a href="login" class="btn btn-outline-danger">Login</a>
                <% } %>
          </ul>
        </div>
      </div>
    </nav>