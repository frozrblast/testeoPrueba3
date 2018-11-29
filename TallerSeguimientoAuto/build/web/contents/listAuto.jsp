<%@page import="java.util.ArrayList"%>
<%@page import="TallerSeguimientoAuto.DTO.AutoDTO"%>
</br>
<h2>Lista de autos ingresados</h2>
<table>
    <link rel="stylesheet" href="/TallerSeguimientoAuto/styles/list.css"/>
    <tr>
        <th>idAuto</th>
        <th>Patente</th>
        <th>Marca</th>
        <th>Modelo</th>
        <th>Año de Fabricacion</th>
    </tr>
        <%
            ArrayList<AutoDTO> auto = null;
            auto = (ArrayList<AutoDTO>)request.getAttribute("cars");
            try
            {
                for( int i = 0; i < auto.size(); i++)

             {
        %>
            <tr>
                <td><%= auto.get(i).getIdAuto() %></td>
                <td><%= auto.get(i).getPatente() %></td>
                <td><%= auto.get(i).getMarca() %></td>
                <td><%= auto.get(i).getModelo() %></td>
                <td><%= auto.get(i).getAñoFabricacion() %></td>
            </tr>
        <% }   }catch(Exception ex)
{
System.out.println("esta vacio");
}%>   
        
</table>
