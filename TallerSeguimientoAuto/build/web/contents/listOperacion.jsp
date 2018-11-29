<%@page import="TallerSeguimientoAuto.DTO.OperacionDTO"%>
<%@page import="java.util.ArrayList"%>
</br>
<h2>Listar mantencione ingresadas</h2>
<table>
    <link rel="stylesheet" href="/TallerSeguimientoAuto/styles/style.css"/>
    <tr>
        <th>idOperacion</th>
        <th>Mantencion</th>
        <th>Operario</th>
        <th>Descripcion</th>
    </tr>
        <%
            ArrayList<OperacionDTO> opera = null;
            opera = (ArrayList<OperacionDTO>)request.getAttribute("operas");
            try
            {
                for( int i = 0; i < opera.size(); i++)

             {
        %>
            <tr>
                <td><%= opera.get(i).getIdOperacion() %></td>
                <td><%= opera.get(i).getMantencion() %></td>
                <td><%= opera.get(i).getOperario() %></td>
                <td><%= opera.get(i).getDescripcion() %></td>
            </tr>
        <% }   }catch(Exception ex)
{
System.out.println("esta vacio");
}%>   
        
</table>
