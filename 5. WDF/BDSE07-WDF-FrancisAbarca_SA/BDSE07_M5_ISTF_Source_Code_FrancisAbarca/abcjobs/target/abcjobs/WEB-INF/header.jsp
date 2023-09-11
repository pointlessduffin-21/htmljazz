<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>ABC Jobs | <%= request.getParameter("HTMLtitle") !=null ? request.getParameter("HTMLtitle")
          : "Welcome" %>
      </title>
      <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
      <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
      <link href="<%= request.getParameter("isNested") == null ? "css/zephyr.css" : request.getParameter("isNested") %>" rel="stylesheet">
      <link href="css/styles.css" rel="stylesheet">
      <link rel="icon" href="https://media.discordapp.net/attachments/751840315614167104/1084694096729358366/abcjobslogo.png">
    </head>

    <body class="d-flex flex-column" style="min-height: 100vh; font-family: 'Poppins', sans-serif;">
    <jsp:include page="navbar.jsp"></jsp:include>
