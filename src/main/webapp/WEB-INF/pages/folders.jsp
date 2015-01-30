<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
  <head>
    <title>Home</title>
  </head>
<body>
  <a href="root">${fw.getRootFolder()}</a>
  <br />
  <c:if test = "${fw.canWalkUp()}">
    <c:set var="index" value="${0}" />
    <c:forEach  items = "${fw.getCurrentFolders()}" var = "item">
      <c:choose>
        <c:when test = "${index < fw.getCurrentFolders().size() - 1}">
          <a href="curr?idx=${index}"> ${item} </a>
        </c:when>
        <c:otherwise>
          <a> ${item} </a>
        </c:otherwise>
      </c:choose>

      <a> / </a>
      <c:set var="index" value="${index + 1}" />
    </c:forEach>
    <br />
      <a href="back"> ... </a>
    <br />
  </c:if>


  <a> Files list </a>
  <br />
  <c:forEach items="${fw.getFolderContent()}" var="item">
    <c:choose>
      <c:when test = "${item.isDir()}">
        <a href="item?folder=${item.getName()}"> ${item.getName()} </a>
      </c:when>
      <c:otherwise>
        <a>${item.toString()} </a>
      </c:otherwise>
    </c:choose>
  <br />
  </c:forEach>

</body>

</html>
