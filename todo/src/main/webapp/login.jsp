<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <jsp:include page="parts/header.jsp" />
<head>
<body>
<div class="container">
  <form action="/todo/login.do" method="POST" class="form-signin" role="form">
    <h2 class="form-signin-heading">Please sign in</h2>
    <input name="login" type="text" class="form-control" placeholder="Login" required autofocus>
    <input name="password" type="password" class="form-control" placeholder="Password" required>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
  </form>
</div>
</body>
</html>
