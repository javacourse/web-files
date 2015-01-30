<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
<h1>Listing</h1>
<a> ${root} </a>
<br />
<a> ${current} </a>
<br />
<a href="<c:url value="/list/${item}"/>">${item}</a>
<c:if test = "${canWalkUp}">
	<a href="..."> ... </a>
	<br />
</c:if>
<c:forEach items="${list}" var="item">
	<a href="<c:url value="/list/${item}"/>">${item}</a>
	<br />
</c:forEach>

</body>
</html>
