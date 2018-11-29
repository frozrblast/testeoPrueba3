<%@page import="TallerSeguimientoAuto.DTO.TallerDTO"%>
<%@page import="java.util.ArrayList"%>
</br>
<h2>Lista de talleres ingresados</h2>
<table>
    <link rel="stylesheet" href="/TallerSeguimientoAuto/styles/style.css"/>
    <tr>
        <th>idTaller</th>
        <th>Nombre</th>
        <th>Direccion</th>
        <th>Comuna</th>
        <th>Responsable</th>
    </tr>
        <%
            ArrayList<TallerDTO> taller = null;
            taller = (ArrayList<TallerDTO>)request.getAttribute("talls");
            try
            {
                for( int i = 0; i < taller.size(); i++)

             {
        %>
            <tr>
                <td><%= taller.get(i).getIdTaller()%></td>
                <td><%= taller.get(i).getNombre()%></td>
                <td><%= taller.get(i).getDireccion() %></td>
                <td><%= taller.get(i).getComuna() %></td>
                <td><%= taller.get(i).getResponsable() %></td>
            </tr>
        <% }   }catch(Exception ex)
{
System.out.println("esta vacio");
}%>   
        
</table>