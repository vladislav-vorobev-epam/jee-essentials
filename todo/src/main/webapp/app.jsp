<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <jsp:include page="parts/heade.jsp"/>
<head>
<body>
<div class="container">
  <ul class="nav nav-tabs">
    <li class="active"><a href="<%= request.getContextPath()%>/app.jsp">In Progress</a></li>
    <li><a href="<%= request.getContextPath()%>/new">New</a></li>
    <li><a href="<%= request.getContextPath()%>/done.jsp">Done</a></li>
    <li><a href="#">Help</a></li>
  </ul>
</div>
</body>
</html>
