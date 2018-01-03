<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 22/12/2017
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accueil</title>
</head>
<body>
<%@include file="WEB-INF/menu.jsp"%>
<p><c:out value="Bonjour!!!!!!!!" /></p>

<form name="f1" action="success.jsp" method="get">

        Identifiants : <input type="text" name="login"><br>
        Mot de passe : <input type="password" name="pass"><br>
        <input type="submit" value="Entrer">

</form>
</body>
</html>
