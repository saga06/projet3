<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 07/12/2017
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<footer class="footer">
    <div class="container">
        <p>
            ${application.name} - version ${project.version}
            <a href="${organisation.url}">${organisation.name}</a>
        </p>
    </div>
</footer>

<!-- Bootstrap -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
        crossorigin="anonymous"></script>