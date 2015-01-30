<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<%--	<h1>Message : ${message}</h1>--%>
    <br/>
    <c:forEach items="${fileList}" var="item">
        <img src="/resources/images/folder1.jpg" height="50" width="50"/>
        <a href="<c:url value="/folder/${item}"/>">${item}</a>
        <br />
    </c:forEach>
<%--/WEB-INF/pages\images\folder1.jpg--%>

    <%--<a href="<c:url value="/list/item"/>">List</a>--%>
</body>
</html>