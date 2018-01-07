<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 22/12/2017
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>S'identifier</title>
</head>
<body>
<p>Bienvenue sur le site d'échange de bons plans sur l'escalade</p>
<p>Ici vous trouverez toutes les informations que vous souhaitez sur différents sites</p>
<p>Et vous pourrez en ajouter d'autres !!</p>
<p>Mais d'abord, merci de vous identifiez : </p>

<form method="post" action="login">
    Email:<input type="text" name="email" /><br/>
    Mot de passe:<input type="password" name="pass" /><br/>
    <input type="submit" value="Valider" />
</form>

<p>Pas encore inscrit ? Merci de remplir ces informations pour rejoindre notre communauté</p>

<form method="post" action="register">
    Nom:<input type="text" name="surname" /><br/>
    Prénom:<input type="text" name="firstname"/><br/>
    Email:<input type="text" name="email" /><br/>
    Mot de passe:<input type="password" name="pass" /><br/>
    <input type="submit" value="S'enregistrer" />
</form>

</body>
</html>

