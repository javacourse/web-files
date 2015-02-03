<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Home</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/screen.css" />" type="text/css" />
</head>
<body>
<h1>Content of directory:</h1>
<h2>
<c:forEach items="${headDirectories}" var="item">
	<c:if test="${item.value != '0'}">
		<a href="<c:url value="/list/${item.value}"/>">
	</c:if>
	${item.key}
	<c:if test="${item.value != '0'}">
		</a>/
	</c:if>
</c:forEach>
</h2>
<table>
	<tr class="panel">
		<td></td>
		<td align="center">Name</td>
		<td align="center">File size</td>
	</tr>
<c:forEach items="${list}" var="item">
	<tr>
		<td>
			<c:if test="${item.isDirectory == 'true'}">
				<c:if test="${item.name != '..'}">
					<img src="<c:url value="/resources/ico/Folder.ico"/>">
				</c:if>
			</c:if>
			<c:if test="${item.isDirectory == 'false'}">
				<img src="<c:url value="/resources/ico/Text.ico"/>">
			</c:if>
		</td>
	    <td>
			<c:if test="${item.isDirectory == 'true'}"><a href="<c:url value="/list/${item.path.hashCode()}"/>"></c:if>
			    ${item.name}
			<c:if test="${item.isDirectory == 'true'}"></a></c:if>
		</td>
		<td align="right">
		    <c:if test="${item.isDirectory == 'false'}">
		        ${item.size}
			</c:if>
		</td>
		<td>
			<c:if test="${item.isDirectory == 'true'}">
				<a href="<c:url value="/rest/${item.path}"/>">json</a>
			</c:if>
		</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
