<%@page import="TallerSeguimientoAuto.DTO.OperarioDTO"%>
<%@page import="java.util.ArrayList"%>
</br>
<h2>Lista de talleres ingresados</h2>
<table>
    <link rel="stylesheet" href="/TallerSeguimientoAuto/styles/style.css"/>
    <tr>
        <th>idTaller</th>
        <th>Nombre</th>
        <th>Direccion</th>
    </tr>
        <%
            ArrayList<OperarioDTO> ope = null;
            ope = (ArrayList<OperarioDTO>)request.getAttribute("opes");
            try
            {
                for( int i = 0; i < ope.size(); i++)

             {
        %>
            <tr>
                <td><%= ope.get(i).getIdOperario()%></td>
                <td><%= ope.get(i).getNombre()%></td>
                <td><%= ope.get(i).getRut() %></td>
            </tr>
        <% }   }catch(Exception ex)
{
System.out.println("esta vacio");
}%>   
        
</table>