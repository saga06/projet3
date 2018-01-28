<%--
    Document   : index
    Created on : Nov 1, 2017, 4:58:44 PM
    Author     : saga
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
    <c:if test="${empty sessionScope.nickname}">
        <c:redirect url="index.html"></c:redirect>
    </c:if>
    <head>
        <title>Réservation topos</title>
        <link rel="icon" type="image/png" href="../img/ico.ico" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/accueil.css" />
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker({ dateFormat: "dd/mm/yy" }).val()
            });
        </script>
    </head>
    <body>
        <%@include file="include/menu.jsp"%>
        <div class="maindiv">
            <div class="container" id="info-booking" style="font-size: 1.2vw;">
                <p></br> <u>Ce topo est déjà réservé pour les dates suivantes :</u> </br></br>
                    <c:forEach var="infoBooking" items="${ infoBookings }">
                        <c:set var="user"><c:out value="${ infoBooking.borrower_nickname }" /></c:set>
                            <c:if test="${user == sessionScope.nickname}">Vous avez réservé ce topo pour la date du <c:out value="${ infoBooking.date }" /> </c:if>
                            <c:if test="${user != sessionScope.nickname}">Ce topo est réservé par le membre <b><c:out value="${ infoBooking.borrower_nickname }" /></b> pour la journée du <c:out value="${ infoBooking.date }" /></c:if>
                            </br>
                    </c:forEach>
                </p>
                <p style="color: green;">Vous souhaitez aussi réserver ce topo ? Sélectionnez la date de réservation souhaitée:</p>
                <p style="color: red"></br><b>(Merci de vérifier que le topo est bien libre à la date désirée !)</b>
                </p>
                <form method="post" action="topos-share">
                    <label for="datepicker">Date désirée :</label>
                        <input type="text" name="date" id="datepicker" required>
                    <input type="hidden" name="topo_id" id="topo_id" value="${ID}"/>
                    <input type="hidden" name="nickname" id="nickname" value="${sessionScope.nickname}"/>
                    <input type="submit" value="Réserver">
                </form>
            </div>
        </div>
    </body>
</html>