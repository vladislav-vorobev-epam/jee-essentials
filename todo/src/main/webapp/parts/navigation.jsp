<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<ul class="nav nav-tabs">
  <li <c:if test="${pageContext.request.requestURL.toString().contains('app.jsp')}" >class="active"</c:if>> <a href="<%= request.getContextPath()%>/app.jsp">In Progress</a></li>
  <li <c:if test="${pageContext.request.requestURL.toString().contains('new.jsp')}" >class="active"</c:if>><a href="<%= request.getContextPath()%>/new.jsp">New</a></li>
  <li <c:if test="${pageContext.request.requestURL.toString().contains('done.jsp')}" >class="active"</c:if>><a href="<%= request.getContextPath()%>/done.jsp">Done</a></li>
  <li><a href="#">Help</a></li>
</ul>