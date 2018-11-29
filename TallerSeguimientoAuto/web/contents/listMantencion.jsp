<%@page import="TallerSeguimientoAuto.DTO.MantencionDTO"%>
<%@page import="java.util.ArrayList"%>
</br>
<h2>Listar mantencione ingresadas</h2>
<table>
    <link rel="stylesheet" href="/TallerSeguimientoAuto/styles/style.css"/>
    <tr>
        <th>idMantencion</th>
        <th>Auto</th>
        <th>Taller</th>
        <th>fecha</th>
        <th>Kilometraje</th>
    </tr>
        <%
            ArrayList<MantencionDTO> man = null;
            man = (ArrayList<MantencionDTO>)request.getAttribute("mans");
            try
            {
                for( int i = 0; i < man.size(); i++)

             {
        %>
            <tr>
                <td><%= man.get(i).getIdMantencion() %></td>
                <td><%= man.get(i).getAuto() %></td>
                <td><%= man.get(i).getTaller() %></td>
                <td><%= man.get(i).getFecha() %></td>
                <td><%= man.get(i).getKilometraje() %></td>
            </tr>
        <% }   }catch(Exception ex)
{
System.out.println("esta vacio");
}%>   
        
</table>