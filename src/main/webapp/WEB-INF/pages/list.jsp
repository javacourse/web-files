<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
<h1>Listing</h1>
<c:forEach items="${list}" var="item">
	<a href="<c:url value="/list/item"/>">${item}</a>
	<br />
</c:forEach>

</body>
</html>
