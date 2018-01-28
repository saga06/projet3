<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 22/12/2017
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<header class="clearfix">
    <div class="container">
        <div class="header-left">
            <h1>Bonjour ${sessionScope.nickname }</h1>
        </div>
        <div class="header-right">
            <label for="open">
                <span class="hidden-desktop"></span>
            </label>
            <input type="checkbox" name="" id="open">
            <nav>
                <a href="accueil">Accueil</a>
                <a href="sites">Les Sites</a>
                <a href="topos">Espace de prêts de topo</a>
                <a href="contact">Contact</a>
            </nav>
        </div>
    </div>
</header>
<section class="clearfix">
    <div class="container">
        <div class="section-left">
            <h1 class="section-title">Si tu veux atteindre le sommet, n'observe pas la montagne, escalade-là !</h1>
        </div>
        <div class="section-right">
            <form action="logout" method="post">
                <input type="submit" class="learn-more" value="Déconnexion">
            </form>
        </div>
    </div>
</section>