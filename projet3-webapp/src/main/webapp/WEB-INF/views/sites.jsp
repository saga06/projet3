<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 22/12/2017
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<c:if test="${empty sessionScope.nickname}">
    <c:redirect url="index.html"></c:redirect>
</c:if>
<head>
    <title>Sites</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="include/menu.jsp"%>

<c:if test="${ !empty pseudo}">
    <p><c:out value="Merci ${pseudo}, votre commentaire a été posté !"/></p>
</c:if>

<c:if test="${ !empty name}">
<p>Bonjour ${ empty name ? '' : name }</p>
</c:if>

<div class="container">
    <h2>Ici vous trouverez la liste des sites</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Nom du site</th>
            <th>Localisation</th>
            <th>Code postal</th>
            <th>Description</th>
            <th>ID du site</th>
            <th>Latitude</th>
            <th>Longitude</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="infoSite" items="${ infoSites }">
        <tr>
            <td><c:out value="${ infoSite.name }" /></td>
            <td><c:out value="${ infoSite.location }" /></td>
            <td><c:out value="${ infoSite.zipcode }" /></td>
            <td><c:out value="${ infoSite.description }" /></td>
            <td><a href="sites?ID=<c:out value="${ infoSite.site_id }"/>">${ infoSite.site_id }</a></td>
            <td><c:out value="${ infoSite.latitude }" /></td>
            <td><c:out value="${ infoSite.longitude }" /></td>
        </tr>
        </c:forEach>

        </tbody>
    </table>
</div>


<div class="container">
    <h3>Vous souhaitez ajouter un nouveau site ? Merci de compléter ces champs :</h3>
    <table class="table table-bordered">
        <form method="post" action="sites">
        <thead>
        <tr>
            <th><label for="name">Nom : </label></th>
            <th><label for="location">Localisation: </label></th>
            <th><label for="zipcode">Code postal: </label></th>
            <th><label for="description">Description: </label></th>
            <th><label for="latitude">Latitude: </label></th>
            <th><label for="longitude">Longitude: </label></th>

            <th>test</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td><input type="text" name="name" id="name" /></td>
                <td><input type="text" name="location" id="location" /></td>
                <td><input type="text" name="zipcode" id="zipcode" /></td>
                <td><input type="text" name="description" id="description" /></td>
                <td><input type="text" name="latitude" id="latitude" /></td>
                <td><input type="text" name="longitude" id="longitude" /></td>
                <td><input type="submit" value="Ajouter" /></td>
            </tr>
        </tbody>
        </form>
    </table>
</div>


</body>
</html>
