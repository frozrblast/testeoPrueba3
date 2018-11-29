<%@page import="TallerSeguimientoAuto.DTO.OperacionDTO"%>
</br>
<h2>Lista la busqueda de la Operacion</h2>
<table>
    <tr>
        <th>idOperacion</th>
        <th>mantencion</th>
        <th>operario</th>
        <th>descripcion</th>
        <th>Acciones</th>
        
    </tr>
        <%
            OperacionDTO ope = null;
            ope = (OperacionDTO)request.getAttribute("opet");
            try
            {

                int a = ope.getIdOperacion();
        %>
        
            <tr>
                <td><%= ope.getIdOperacion() %></td>
                <td><%= ope.getMantencion() %></td>
                <td><%= ope.getOperario() %></td>
                <td><%= ope.getDescripcion() %></td>
                <td><%= "<form action='DeleteOperacionServlet' method='POST' ><input type='hidden' value='"+ope.getIdOperacion()+"' name='idElimnar' > <input type='submit' value='Eliminar' ></form>" %></td>

            </tr>
            
        <%  }catch(Exception ex)
{
String mensajeError = (String)request.getAttribute("mensajeError");
if(mensajeError != null){

 %>

 <strong><%= mensajeError %></strong>

 <%
  }
System.out.println("esta vacio");
}%>

    
</table>
