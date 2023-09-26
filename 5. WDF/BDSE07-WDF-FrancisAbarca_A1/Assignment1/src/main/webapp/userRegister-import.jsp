<%@page import="com.yeems214.dao.UserRegisterDao"%>
<jsp:useBean id="u" class="com.yeems214.bean.UserRegister"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
int i=UserRegisterDao.save(u);
if(i>0){
response.sendRedirect("userRegister-success.jsp");
}else{
response.sendRedirect("userRegister-error.jsp");
}
%>