<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 22/12/2017
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="menu.jsp"%>

<p>Bonjour ${ empty name ? '' : name }</p>
<p>ici vous trouverez la liste des sites</p>
<p> Information sur le site ${ site.name } </p>
<p>sa latitude est de ${ site.latitude}</p>

</body>
</html>
