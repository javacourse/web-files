<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet" href="<c:url value="/resources/css/screen.css" />" type="text/css" />
<body>
	<h1>${message}</h1>
    <br/>
    <a href="<c:url value="/list/${pathToBrowse.hashCode()}"/>">${pathToBrowse}</a>
</body>
</html>