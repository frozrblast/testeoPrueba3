<%-- 
    Document   : searchMantencion
    Created on : 28-11-2018, 23:51:12
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
            <%@include file="../contents/formSearchMantencion.jsp" %>
            <%@include file="../contents/listSearchMantencion.jsp" %>
        </main>
        <footer>
            <%@include file="../partials/footer.jsp" %>
        </footer>
    </body>
</html>