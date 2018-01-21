<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 04/12/2017
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:if test="${empty sessionScope.nickname}">
    <c:redirect url="index.html"></c:redirect>
</c:if>
<head>
    <title>Accueil</title>
    <link rel="icon" type="image/png" href="../img/ico.ico" />
</head>
<body>
<%@ include file="include/menu.jsp"%>
<c:if test="${ !empty sessionScope.nickname}">
    <p>Bienvenue ${sessionScope.nickname} !! </p>
</c:if>
Choisissez dans le menu ci-dessus la rubrique qui vous intéresse.
</body>
</html>
