<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<jsp:include page="layout/header.jsp" />
<h3>File System</h3>
<h4>${homePath}/${h}</h4>
<c:choose>
    <c:when test="${parent != null}">
        <p>
            <a href="<c:url value="/path${parent}"/>">
                <b>
                    <i class="glyphicon glyphicon-folder-open"></i>
                </b>
            </a>
        </p>
    </c:when>
</c:choose>

<c:forEach items="${files}" var="file">
    <p>
        <c:choose>
            <c:when test="${file.getIsDirectory()}">
                <i class="glyphicon glyphicon-folder-close" style="color:#337ab7;"></i>
                <a href="<c:url value="/path${file.getFilePath()}"/>"><b>${file.getFileName()}</b></a>
            </c:when>
            <c:otherwise>
                <i class="glyphicon glyphicon-file"></i> ${file.getFileName()}
            </c:otherwise>
        </c:choose>
    </p>
</c:forEach>

<jsp:include page="layout/footer.jsp" />
