<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 22/12/2017
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <c:if test="${empty sessionScope.nickname}">
        <c:redirect url="index.html"></c:redirect>
    </c:if>
    <head>
        <title>Longueurs</title>
        <link rel="icon" type="image/png" href="../img/ico.ico" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/accueil.css" />
        <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css"/>
        <script type="text/javascript" src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready(function(){
                $('#table_id').DataTable();
            });
        </script>
    </head>
    <body>
    <%@include file="include/menu.jsp"%>
        <div class="maindiv">
            <div class="container">
                <h2>Ici vous trouverez la liste des longueurs de la voie sélectionnée</h2>
                <table id="table_id" class="display" class="table table-striped">
                    <thead>
                    <tr>
                        <th>Nom de la longueur</th>
                        <th>Description</th>
                        <th>Détails</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="infoLongueur" items="${ infoLongueurs }">
                            <tr>
                                <td><c:out value="${ infoLongueur.name }" /></td>
                                <td><c:out value="${ infoLongueur.description }" /></td>
                                <td><a href="points?ID=<c:out value="${ infoLongueur.length_id }"/>"><button type="button" class="btn btn-info">Plus d'informations</button></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="container">
                <h3>Vous souhaitez ajouter une nouvelle longueur à cette voie ? Merci de compléter ces champs :</h3>
                <table class="table table-bordered">
                    <form method="post" action="longueurs">
                        <thead>
                            <tr>
                                <th><label for="name">Nom : </label></th>
                                <th><label for="description">Descritption : </label></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><input type="text" name="name" id="name" required/></td>
                                <td><input type="text" name="description" id="description" required/></td>
                                <input type="hidden" name="way_id" id="way_id" value="${ID}"/>
                                <td><input type="submit" value="Ajouter" /></td>
                            </tr>
                        </tbody>
                    </form>
                </table>
            </div>
        </div>
    </body>
</html>