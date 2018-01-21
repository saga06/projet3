
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
            <title>Secteurs</title>
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
    <h2>Ici vous trouverez la liste des secteurs du site sélectionné</h2>
    <table id="table_id" class="display" class="table table-striped">
        <thead>
        <tr>
            <th>Nom du site</th>
            <th>Description</th>
            <th>Détails</th>

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

    <h3>Vous souhaitez ajouter un nouveau secteur à ce site ? Merci de compléter ces champs :</h3>
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
                <td><input type="text" name="name" id="name" /></td>
                <td><input type="text" name="description" id="description" /></td>
                <input type="hidden" name="site_id" id="site_id" value="${ID}"/>
                <td><input type="submit" value="Ajouter" /></td>
            </tr>
            </tbody>
        </form>
    </table>
    <h3>Liste des commentaires précédents: </h3>
    <c:forEach var="infoComment" items="${ infoComments }">
        <p>L'utilisateur : <c:out value="${ infoComment.user_nickname }" /> a laissé le commentaire suivant :</p>
        <p><c:out value="${ infoComment.content }" /></p>
    </c:forEach>
    <h3>Vous souhaitez ajouter un commentaire concernant ce site ?</br> Exprimez vous ici :</h3>

    <form method="post" action="secteurs">
        <input type="hidden" name="Parameter-Name" value="value2">
        <textarea name="content" id="content" rows="4" cols="100" placeholder="Vous pouvez écrire quelque chose ici"></textarea>
        <input type="hidden" name="user_nickname" id="user_nickname" value="${sessionScope.nickname}">
        <input type="hidden" name="site_id" id="site_id" value="${ID}">
        <input type="submit" value="Ajouter">
    </form>

</div>


</body>
</html>