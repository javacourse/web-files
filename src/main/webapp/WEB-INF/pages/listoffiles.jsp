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
<a href="<c:url value="/listoffiles/${rootFolder}"/>">${rootFolder}</a>
<br>
<table cellspacing="1" border="1">
  <c:forEach items="${fileList}" var="item">

  <c:if test="${item.getIsDir()}">
    <tr>
      <td>
        <img src="<c:url value="/resources/folder.png"/>" class="icon"/>
      </td>
      <td>
        <a href="<c:url value="/listoffiles/${item.getName()}"/>">${item.getName()}</a>
      </td>
      <td>
          ${item.getSize()} bytes
      </td>
    </tr>
  </c:if>

  <c:if test="${!item.getIsDir()}">
    <tr>
      <td>
        <img src="<c:url value="/resources/copy_edit_co.png"/>" class="icon"/>
      </td>
      <td>
        ${item.getName()}
      </td>
      <td>
          ${item.getSize()} bytes
      </td>
    </tr>
  </c:if>
</c:forEach>
</table>
</body>
</html>

