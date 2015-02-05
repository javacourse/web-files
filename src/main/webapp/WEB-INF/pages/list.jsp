<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/css/screen.css" />" >
</head>
<body>
<h1>Listing</h1>
<div id="page">
    <p>
        Hello
    </p>
</div>
<c:forEach items="${list}" var="item">
	<a href="<c:url value="/list/item"/>">${item}</a>
	<br />

</c:forEach>

</body>
</html>
