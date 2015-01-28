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
    <title>Folder navigator</title>
  <!--<link rel="stylesheet" href="<c:url value="resources/css/folderbrowsingstyles.css"/>" type="text/css">-->
  <style>
    body {
      margin: 0 auto;
    }

    .container {
      width: 900px;
      border: #204080 solid 3px;
      margin: 0 auto;
      margin-top: 10px;
      margin-bottom: 10px;
      padding: 2px;
    }

    .header {
      border: #204080 solid 2px;
      text-align: center;
      font-family: Serif;
      font-size: 40px;
      color:cornsilk;
      background-color: #204080;
    }

    .content {
      border: #204080 solid 2px;
      font-family: Serif;
      color:#204080;
      margin-top: 2px;
      padding: 2px
    }

    .content a{
      text-decoration: none;
      color:#204080;
    }

    .content a:visited {
      color:#204080;
    }

    .content a:active {
      color:#204080;
    }

    .content a:hover {
      color: #204080;
      text-decoration: underline;
    }

    .cellwidth {
      width: 300px;
    }

    .icon {
      width: 20px;
      height: 20px;
    }
  </style>
</head>
<body>
<div class="container">
  <div class="header">
    File browser
  </div>
  <div class="content">

    <table>
    <c:if test="${!''.equals(prevFolder)}">
      <tr>
        <td>
          <img src="<c:url value="/resources/images/Card_file.png"/>" class="icon"/>
        </td>
        <td class="cellwidth">
          <a href="<c:url value="/list/${prevFolder}"/>">..</a>
        </td>
        <td>

        </td>
      </tr>
    </c:if>

      <c:forEach items="${fileList}" var="fileName">
        <c:if test="${!fileName.isDir()}">
            <tr>
              <td>
                <img src="<c:url value="/resources/images/file.png"/>" class="icon"/>
              </td>
            <td class="cellwidth">
            ${fileName.getFileName()}
            </td>
            <td>
            ${fileName.getSize()} bytes
            </td>
            </tr>
        </c:if>
        <c:if test="${fileName.isDir()}">
         <tr>
           <td>
             <img src="<c:url value="/resources/images/Card_file.png"/>" class="icon"/>
           </td>
           <td class="cellwidth">
             <a href="<c:url value="/list/${fileName.getPath()}"/>">${fileName.getFileName()}</a>
           </td>
           <td>

           </td>
         </tr>
        </c:if>
      </c:forEach>
    </table>

  </div>
</div>
</body>
</html>