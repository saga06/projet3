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
        <title>Voies</title>
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

        <c:if test="${ !empty erreur }">
            <p style="color:red;"><c:out value="${ erreur }" /></p>
        </c:if>
        <div class="maindiv">
            <div class="container">
                <h2>Ici vous trouverez la liste des voies du secteur sélectionné</h2>
                <table id="table_id" class="display" class="table table-striped">
                    <thead>
                        <tr>
                            <th>Nom de la voie</th>
                            <th>Hauteur (en mètres)</th>
                            <th>Cotation</th>
                            <th>Nombre de points</th>
                            <th>Détails</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="infoVoie" items="${ infoVoies }">
                            <tr>
                                <td><c:out value="${ infoVoie.name }" /></td>
                                <td><c:out value="${ infoVoie.height }" /></td>
                                <td><c:out value="${ infoVoie.quotation }" /></td>
                                <td><c:out value="${ infoVoie.nb_point }" /></td>
                                <td><a href="longueurs?ID=<c:out value="${ infoVoie.way_id }"/>"><button type="button" class="btn btn-info">Plus d'informations</button></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="container">
                <h3>Vous souhaitez ajouter une nouvelle voie à ce secteur ? Merci de compléter ces champs :</h3>
                <table class="table table-bordered">
                    <form method="post" action="voies">
                        <thead>
                            <tr>
                                <th><label for="name">Nom : </label></th>
                                <th><label for="height">Hauteur (en mètres) : </label></th>
                                <th><label for="quotation">Cotation : </label></th>
                                <th><label for="nb_point">Nombre de point : </label></th>
                            </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><input type="text" name="name" id="name" required/></td>
                            <td><input type="text" name="height" id="height" onkeypress='return event.charCode >= 48 && event.charCode <= 57' required/></td>
                            <td><input type="text" name="quotation" id="quotation" required/></td>
                            <td><input type="text" name="nb_point" id="nb_point" onkeypress='return event.charCode >= 48 && event.charCode <= 57' required/></td>
                            <input type="hidden" name="sector_id" id="sector_id" value="${ID}"/>
                            <td><input type="submit" value="Ajouter" /></td>
                        </tr>
                        </tbody>
                    </form>
                </table>
            </div>
        </div>
    </body>
</html>