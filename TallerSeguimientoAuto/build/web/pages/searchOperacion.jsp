<%-- 
    Document   : searchOperacion
    Created on : 29-11-2018, 0:31:34
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
            <h1>Buscar Mantencion</h1>
            <%@include file="../contents/formSearchOperacion.jsp" %>
            <%@include file="../contents/listSearchOperacion.jsp" %>
        </main>
        <footer>
            <%@include file="../partials/footer.jsp" %>
        </footer>
    </body>
</html>