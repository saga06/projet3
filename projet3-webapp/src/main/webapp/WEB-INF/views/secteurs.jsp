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
        <title>Secteurs</title>
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
                <h2>Ici vous trouverez la liste des secteurs du site selectionne</h2>
                <table id="table_id" class="display" class="table table-striped">
                    <thead>
                        <tr>
                            <th>Nom du site</th>
                            <th>Description</th>
                            <th>Details</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="infoSecteur" items="${ infoSecteurs }">
                        <tr>
                            <td><c:out value="${ infoSecteur.name }" /></td>
                            <td><c:out value="${ infoSecteur.description }" /></td>
                            <td><a href="voies?ID=<c:out value="${ infoSecteur.sector_id }"/>"><button type="button" class="btn btn-info">Plus d'informations</button></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="container">
                <h3>Vous souhaitez ajouter un nouveau secteur a ce site ? Merci de completer ces champs :</h3>
                <table class="table table-bordered">
                    <form method="post" action="secteurs">
                        <input type="hidden" name="Parameter-Name" value="value1">
                        <thead>
                            <tr>
                                <th><label for="name">Nom : </label></th>
                                <th><label for="description">Descritption : </label></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><input type="text" name="name" id="name" required /></td>
                                <td><input type="text" name="description" id="description" required/></td>
                                <input type="hidden" name="site_id" id="site_id" value="${ID}"/>
                                <td><input type="submit" value="Ajouter" /></td>
                            </tr>
                        </tbody>
                    </form>
                </table>
                <h3>Liste des commentaires precedents: </h3>
                <c:forEach var="infoComment" items="${ infoComments }">
                    <p>L'utilisateur : <b><c:out value="${ infoComment.user_nickname }" /></b> a laisse le commentaire suivant :</p>
                    <p>"<c:out value="${ infoComment.content }" />"</p>
                    <hr>
                </c:forEach>
                <h3>Vous souhaitez ajouter un commentaire concernant ce site ?</br> Exprimez vous ici :</h3>

                <form method="post" action="secteurs">
                    <input type="hidden" name="Parameter-Name" value="value2">
                    <textarea name="content" id="content" rows="4" cols="100" placeholder="Vous pouvez ecrire quelque chose ici"></textarea>
                    <input type="hidden" name="user_nickname" id="user_nickname" value="${sessionScope.nickname}">
                    <input type="hidden" name="site_id" id="site_id" value="${ID}">
                    <input type="submit" value="Ajouter" style="margin-bottom: 20px;margin-left: 50px">
                </form>
            </div>
        </div>
    </body>
</html>