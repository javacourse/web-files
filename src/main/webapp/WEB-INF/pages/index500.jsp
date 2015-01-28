<%--
  Created by IntelliJ IDEA.
  User: Odour
  Date: 28.01.2015
  Time: 0:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<H1>Sorry, but you do not have permissions for such directory, or requested directory does not exist :(</H1>
<a href="<c:url value="/list/${prevFolder}"/>">Return to the previous folder</a>
</body>
</html>
