<%--
  Created by IntelliJ IDEA.
  User: Odour
  Date: 28.01.2015
  Time: 0:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<H1>Main Page</H1>
<c:if test="${!''.equals(prevFolder)}">
<a href="<c:url value="/list/${prevFolder}"/>">..</a> <br/>
</c:if>
<c:forEach items="${fileList}" var="fileName">
  <c:if test="${!fileName.isDir()}">
  ${fileName.getFileName()} ${fileName.getSize()}<br/>
  </c:if>
  <c:if test="${fileName.isDir()}">
    <a href="<c:url value="/list/${fileName.getPath()}"/>">${fileName.getFileName()}</a> <br>
  </c:if>
</c:forEach>
</body>
</html>
