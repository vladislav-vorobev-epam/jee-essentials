<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <jsp:include page="parts/header.jsp"/>
<head>
<body>
<div class="container">
  <jsp:include page="parts/navigation.jsp"/>
  <div class="panel panel-default">
    <div class="panel-heading">New ToDo item</div>
    <div class="panel-body">
      <form action="/todo/task/add.do" method="POST" class="form-new-task" role="form">
        <input type="hidden" name="username" value="<%= session.getAttribute("username")%>">

        <div class="input-group">
          <input name="name" type="text" class="form-control" placeholder="Name" required autofocus>
        </div>
        <br/>
        <div class="input-group">
          <input name="dueDateTime" id="dueDateTime" type="text" class="form-control" placeholder="Due Time" required>
        </div>
        <br/>
        <div class="input-group">
          <input name="tags" id="tags" type="text" class="form-control" placeholder="Tags" required>
        </div>
        <br/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Create</button>

      </form>
    </div>
  </div>
</div>
<script>
  $(document).ready(function() {
    $("#dueDateTime").datetimepicker({
      format: 'd-m-Y H:i'
    });
  });
</script>
</body>
</html>
