<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h1>Message : ${message}</h1>
    <br/>
    <a href="<c:url value="/list/item"/>">List</a>
    <a href="<c:url value="/dirviewer/"/>">Dirviewer</a>
</body>
</html>