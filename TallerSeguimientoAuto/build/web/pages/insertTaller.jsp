<%-- 
    Document   : insertTaller
    Created on : 27-11-2018, 15:25:15
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
            <h1>Ingreso de Taller</h1>
            <%@include file="../contents/formTaller.jsp" %>
            <%@include file="../contents/listTaller.jsp" %>
        </main>
        <footer>
            <%@include file="../partials/footer.jsp" %>
        </footer>
    </body>
