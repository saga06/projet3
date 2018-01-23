<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 04/12/2017
  Time: 03:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <c:if test="${empty sessionScope.nickname}">
        <c:redirect url="index.html"></c:redirect>
    </c:if>
    <head>
        <title>Accueil</title>
        <link rel="icon" type="image/png" href="../img/ico.ico" />
        <link rel="stylesheet" href="css/accueil.css" />
    </head>
    <body>
        <%@ include file="include/menu.jsp"%>
            <div class="maindiv">
                <div class="hello container">
                    <c:if test="${ !empty sessionScope.nickname}">
                        <p>Bienvenue ${sessionScope.nickname} !! </p></br>
                    </c:if>
                    <p>Sur ce site, tu pourras trouver des informations sur les différents sites d'escalade repertoriés par nos membres, mais aussi sur les secteurs, voies, longueurs, et points.</p></br>
                    <p>Tu peux aussi participer en ajoutant tes propres sites et leurs descriptions.</p>
                    <p>Tu peux ajouter des commentaires concernant les sites présentés grâce à ton expérience personnelle.</p></br>
                    <p>Enfin tu peux chercher les topos disponibles mis à disposition par d'autres membres, les réserver, et proposer les tiens</p></br>
                    <p>Choisis dans le menu ci-dessus la rubrique qui t'intéresses.</p>
                </div>
            </div>
    </body>
</html>
