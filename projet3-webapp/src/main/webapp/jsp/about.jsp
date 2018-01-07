<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 07/12/2017
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${application.name} - A propos</title>
</head>
<body>

<%@include file="_include/header.jsp"%>

<div class="container">
    <ul>
        <li>Application : ${application.name}</li>
        <li>Version : ${project.version}</li>
        <li>Date du build : ${maven.build.timestamp}</li>
    </ul>
</div>

<%@include file="_include/footer.jsp"%>
</body>
</html>
