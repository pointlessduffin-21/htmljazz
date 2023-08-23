<head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title><%= request.getParameter("HTMLtitle") !=null ? request.getParameter("HTMLtitle")
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
                  : "text-white" %>" href="/abcjobs/home" style="margin-right: -4px;">Home</a>
            </li>
            <li class="nav-item">
               <a class="nav-link <%= request.getServletPath().equals("/WEB-INF/views/search/search.jsp") ? "text-danger"
                  : "text-white" %>" href="/abcjobs/search">Search</a>
              </li>
            <% if((Boolean) session.getAttribute("isLogin") != null) { %>
                <li class="nav-item">
                  <a class="nav-link <%= request.getServletPath().equals("/WEB-INF/views/dashboard/index.jsp")
                    ? "text-danger" : "text-white" %>" href="/abcjobs/dashboard" style="margin-left: 2px;">Dashboard</a>
                </li>
                <% } %>
            </ul>
            <% if((Boolean) session.getAttribute("isLogin") != null) { %>
                <li class="nav-item">
                  <a class="nav-link <%= request.getServletPath().equals("/WEB-INF/views/jobs/job.jsp")
                    ? "text-danger" : "text-white" %>" href="/abcjobs/job" style="margin-top:-21px;">Jobs</a>
                </li>
                <% } %>
            </ul>
            <% if((Boolean) session.getAttribute("isLogin") != null) { %>
                <li class="nav-item">
                  <a class="nav-link <%= request.getServletPath().equals("/WEB-INF/views/threads/threads.jsp")
                    ? "text-danger" : "text-white" %>" href="/abcjobs/thread" style="margin-left: -12px; margin-top:-21px;">Threads</a>
                </li>
                <% } %>
            </ul>
            <% if((Boolean) session.getAttribute("isLogin") != null) { %>
            	<li class="nav-item">
            		<a class="nav-link <%= request.getServletPath().equals("/WEB-INF/views/dashboard/profile.jsp")
                    ? "text-danger" : "text-white" %>" href="/abcjobs/profile" style="margin-left: -21px; margin-top:-21px;">Profile</a>
                </li>
                <% } %>
            <% if((Boolean) session.getAttribute("isLogin") != null) { %>
              <li class="nav-item">
                <a class="nav-link fw-semibold <%= request.getServletPath().equals("/WEB-INF/views/administrator/index.jsp") 
                ? "text-primary border-bottom border-3 border-primary" : request.getServletPath().equals("/WEB-INF/views/index.jsp") ? "text-white" : "text-dark border-bottom border-3  border-white" %>" href="<%= request.getContextPath() %>/admin">Admin</a>
              </li>
              <% } %>    
                    
            <% if((Boolean) session.getAttribute("isLogin") != null) { %>
              <a href="logout" class="btn btn-danger">Logout</a>
              <% } else { %>
                <a href="<%= request.getContextPath() %>/login" class="btn btn-danger" style="margin-right: 10px;" <%= request.getServletPath().equals("/WEB-INF/views/index.jsp") ? "d-none" : "" %>>Login</a>
                <% } %>
          </ul>
        </div>
      </div>
    </nav>



