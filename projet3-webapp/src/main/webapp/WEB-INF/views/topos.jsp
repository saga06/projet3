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
    <title>Topos</title>
    <link rel="icon" type="image/png" href="../img/ico.ico" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"/>


<script type="text/javascript" src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script>
    $(document).ready(function(){
        $('#table_id').DataTable();
    });
</script>

<c:if test="${ !empty erreur }">
    <p style="color:red;"><c:out value="${ erreur }" /></p>
</c:if>

<%@include file="include/menu.jsp"%>

<c:if test="${ !empty pseudo}">
    <p><c:out value="Merci ${pseudo}, votre commentaire a été posté !"/></p>
</c:if>

<c:if test="${ !empty name}">
    <p>Bonjour ${ empty name ? '' : name }</p>
</c:if>

<div class="container">
    <h2>Ici vous trouverez la liste des topos</h2>
    <table id="table_id" class="display" class="table table-striped">
        <thead>
        <tr>
            <th>Nom du topo</th>
            <th>Nom du site concerné</th>
            <th>Description</th>
            <th>Disponibilité</th>
            <th>Pseudo du propriétaire</th>

        </tr>
        </thead>
        <tbody>

        <c:forEach var="infoTopo" items="${ infoTopos }">
            <tr>
                <td><c:out value="${ infoTopo.topo_name }" /></td>
                <td><c:out value="${ infoTopo.site_name }" /></td>
                <td><c:out value="${ infoTopo.description }" /></td>
                <td>
                    <c:set var="free"><c:out value="${ infoTopo.free }" /></c:set>
                    <c:if test="${free == true}">Disponible</c:if>
                    <c:if test="${free == false}">Non Disponible</c:if>
                </td>
                <td><c:out value="${ infoTopo.owner_nickname }" /></td>
                <td><a href="topos-share?ID=<c:out value="${ infoTopo.topo_id }"/>"><button type="button" class="btn btn-info">Réserver</button></a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>


<div class="container">
    <h3>Vous souhaitez ajouter un nouveau topo ? Merci de compléter ces champs :</h3>
    <table class="table table-bordered">
        <form method="post" action="topos">
            <thead>
            <tr>
                <th><label for="topo_name">Nom : </label></th>
                <th><label for="description">Description: </label></th>
                <th><label for="site_id">Site concerné: </label></th>

                <th>test</th>
            </tr>
            </thead>
            <tbody>


            <tr>
                <td><input type="text" name="topo_name" id="topo_name" /></td>
                <td><input type="text" name="description" id="description" /></td>
                <td>
                    <select name="site_id" id="site_id">
                        <c:forEach var="infoSite" items="${ infoSites }">
                            <option value="<c:out value="${ infoSite.site_id }" />"><c:out value="${ infoSite.name }" /></option>
                        </c:forEach>
                    </select>
                </td>
                <input type="hidden" name="owner_nickname" id="owner_nickname" value="${sessionScope.nickname}">
                <td><input type="submit" value="Ajouter" /></td>
            </tr>

            </tbody>
        </form>
    </table>
</div>


</body>
</html>
