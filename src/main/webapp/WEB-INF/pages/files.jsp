<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>File Browser</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/files.css" />"/>
</head>
<body>
<c:set var="rootUrl" value="/files" />

<table>
    <tr>
        <td>
            <a href="${currentUrl}/.." >
        <c:choose>
            <c:when test="${currentUrl == rootUrl}">
                <img  src="<c:url value="/resources/img/rew.png" />" alt=""/> Back To Main
            </c:when>
            <c:when test="${currentUrl != rootUrl}">
                <img  src="<c:url value="/resources/img/back.png" />" alt=""/>Parent Directory
            </c:when>
        </c:choose>
                <br/>
                <br/>
            </a>
        </td>
    </tr>
<c:forEach items="${files}" var="file">
    <c:if test="${file.isDir()}">
    <tr>
        <td>
            <a href="${currentUrl}/${file.name}" >
                <img  src="<c:url value="/resources/img/dir.gif" />" alt=""/>${file.name}
            </a>
        </td>
        <td></td>
    </tr>
    </c:if>
    <c:if test="${!file.isDir()}">
    <tr>
        <td><img  src="<c:url value="/resources/img/generic.png" />" alt=""/>${file.name}</td>
        <td>${file.size} bytes</td>
    </tr>
    </c:if>
</c:forEach>
</table>
</body>
</html>
