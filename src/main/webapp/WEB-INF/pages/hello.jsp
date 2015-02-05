<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h1>Message : ${message}</h1>
    <br/>
    <a href="<c:url value="/list/item"/>">List</a><br/>
    <a href="<c:url value="/files"/>">File browser</a><br/>
    <a href="<c:url value="/rest/files"/>">File REST</a><br/>
</body>
</html>