<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <jsp:include page="../parts/header.jsp"/>
</head>
<body>
<div class="container">
  <div class="alert alert-danger">
    Login failure! <a href="<%= request.getContextPath()%>/login.jsp" class="alert-link">Try again.</a>
  </div>
</div>
</body>
</html>
