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

<c:if test="${ !empty pseudo}">
    <p><c:out value="Merci ${pseudo}, votre commentaire a été posté !"/></p>
</c:if>
<p>Bonjour ${ empty name ? '' : name }</p>
<p>ici vous trouverez la liste des sites</p>
<p> Information sur le site ${ infoSite.name } </p>
<p>sa latitude est de ${ infoSite.latitude}</p>

<form method="post" action="sites">
    <p>
        <label for="name">Nom : </label>
        <input type="text" name="name" id="name" />
    </p>
    <p>
        <label for="location">Lieu: : </label>
        <input type="text" name="location" id="location" />
    </p>

    <input type="submit" />
</form>
<ul>
    <c:forEach var="infoSite" items="${ infoSites }">
        <li><c:out value="${ infoSite.name }" /> <c:out value="${ infoSite.location }" /></li>
    </c:forEach>
</ul>

</body>
</html>
