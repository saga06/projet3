<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 27/12/2017
  Time: 03:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<c:if test="${empty sessionScope.nickname}">
    <c:redirect url="index.html"></c:redirect>
</c:if>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="include/menu.jsp"%>

<p>hello les topos</p>
</body>
</html>
