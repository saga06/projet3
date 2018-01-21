<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 06/01/2018
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:if test="${empty sessionScope.nickname}">
    <c:redirect url="index.html"></c:redirect>
</c:if>
<head>
    <title>Contacts</title>
    <link rel="icon" type="image/png" href="../img/ico.ico" />
</head>
<body>
<%@include file="include/menu.jsp"%>
<p>
    Vous pouvez nous contacter par email ou tel etc etc ...
</p>
</body>
</html>
