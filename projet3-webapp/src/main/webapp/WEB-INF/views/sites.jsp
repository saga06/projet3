<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 22/12/2017
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<html>
    <c:if test="${empty sessionScope.nickname}">
        <c:redirect url="index.html"></c:redirect>
    </c:if>
    <head>
        <title>Sites</title>
        <link rel="icon" type="image/png" href="../img/ico.ico" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script type="text/javascript" src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready(function(){
                $('#table_id').DataTable();
            });
        </script>
        <link rel="stylesheet" href="css/accueil.css" />
    </head>
    <body>
        <%@include file="include/menu.jsp"%>
        <div class="maindiv">
            <div class="container">
                <h2>Ici tu trouveras la liste des sites</h2>
                <table id="table_id" class="display" class="table table-striped">
                    <thead>
                        <tr>
                            <th>Nom du site</th>
                            <th>Localisation</th>
                            <th>Code postal</th>
                            <th>Description</th>
                            <th>Latitude</th>
                            <th>Longitude</th>
                            <th>Details</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="infoSite" items="${ infoSites }">
                            <tr>
                                <td><c:out value="${ infoSite.name }" /></td>
                                <td><c:out value="${ infoSite.location }" /></td>
                                <td><c:out value="${ infoSite.zipcode }" /></td>
                                <td><c:out value="${ infoSite.description }" /></td>
                                <td><c:out value="${ infoSite.latitude }" /></td>
                                <td><c:out value="${ infoSite.longitude }" /></td>
                                <td><a href="secteurs?ID=<c:out value="${ infoSite.site_id }"/>"><button type="button" class="btn btn-info">Plus d'informations</button></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="container">
                <h3>Vous souhaitez ajouter un nouveau site ? Merci de completer ces champs :</h3>
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
                                <th>Ajouter</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><input type="text" name="name" id="name" required/></td>
                                <td><input type="text" name="location" id="location" required/></td>
                                <td><input type="text" name="zipcode" id="zipcode" onkeypress='return event.charCode >= 48 && event.charCode <= 57'required/></td>
                                <td><input type="text" name="description" id="description" required/></td>
                                <td><input type="text" name="latitude" id="latitude" required/></td>
                                <td><input type="text" name="longitude" id="longitude" required/></td>
                                <td><input type="submit" value="Ajouter" /></td>
                            </tr>
                        </tbody>
                    </form>
                </table>
            </div>
        </div>
    </body>
</html>
