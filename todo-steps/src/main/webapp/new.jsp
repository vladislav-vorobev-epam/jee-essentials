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
      Here should be a form
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
