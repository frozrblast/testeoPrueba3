<%-- 
    Document   : insertOperacion
    Created on : 27-11-2018, 22:36:21
    Author     : Sebastian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <%@include file="../partials/head.jsp" %>
    </head>
    <body>
        <header>
            <%@include file="../partials/header.jsp" %>
        </header>
        <nav>
            <%@include file="../partials/menu.jsp" %>
        </nav>
        <main>
            <h1>Ingreso de Operacion</h1>
            <%@include file="../contents/formOperacion.jsp" %>
            <%@include file="../contents/listOperacion.jsp" %>
        </main>
        <footer>
            <%@include file="../partials/footer.jsp" %>
        </footer>
    </body>
</html>
