<%--
  Created by IntelliJ IDEA.
  User: ragham
  Date: 29.01.2015
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File Browser</title>
</head>
<body>
Test
<a href="<c:url value="/listoffiles/${rootFolder}"/>">${rootFolder}</a>
<c:forEach items="${fileList}" var="item">
  <a href="<c:url value="/listoffiles/${item.getName()}"/>">${item.getName()}</a>
  <br>
</c:forEach>
</body>
</html>

