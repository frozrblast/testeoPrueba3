<%-- 
    Document   : login
    Created on : 28-11-2018, 15:55:36
    Author     : Gonzalo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../partials/head.jsp" %>
    </head>
    <body class="container">
        <%
            session.invalidate();
            %>
        <header>
            
        </header>
        <nav>
            
        </nav>
        <main>
            <h1>Inicio de Sesión</h1>
            <%@include file="../contents/loginForm.jsp" %>
        </main>
        <footer>
            <%@include file="../partials/footer.jsp" %>
        </footer>      
    </body>
</html>