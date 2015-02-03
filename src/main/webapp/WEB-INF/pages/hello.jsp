<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="<c:url value="/resources/css/screen.css" />" type="text/css" />
</head>
<body>
	<h1>${message}</h1>
    <br/>
    <h2><a href="<c:url value="/list/${pathToBrowse.hashCode()}"/>">${pathToBrowse}</a></h2>
</body>
</html>