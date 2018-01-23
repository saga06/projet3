<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 06/01/2018
  Time: 17:53
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

        <p>Vous pouvez contacter l'administrateur de ce site à l'adresse email suivante : test@gmail.com</p></br>
        <p>Vous pouvez aussi envoyer un courrier à l'adresse postale : 3 rue de la paix, 75016 PARIS</p></br>
        <p>Enfin vous pouvez nous joindre par téléphone au 01 01 01 01 01</p></br>
    </div>
</div>
</body>
</html>
