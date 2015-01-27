<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <h3></h3>
    <table border="1" width="25%">
        <thead>
            <tr>
                <th>${currentFolder}</th>
            </tr>
        </thead>
        <tbody>
        <c:if test="${null != parentFolder}">
            <tr>
                <td>
                    <a href="<c:url value="/dirviewer/${parentFolder}"/>">..</a>
                </td>
            </tr>
        </c:if>
        <c:forEach var="item" items="${folderContent}">
            <tr>
                <td>
                    <c:if test="${item.isDirectory()}">
                        <a href='<c:url value="/dirviewer"/>${"/" == currentFolder ? "" : currentFolder}/${item.getName()}'>${item.getName()}</a>
                    </c:if>
                    <c:if test="${!item.isDirectory()}">
                        ${item.getName()}
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>