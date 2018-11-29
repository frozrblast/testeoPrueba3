<%@page import="java.util.ArrayList"%>
<%@page import="TallerSeguimientoAuto.DTO.MantencionDTO"%>
</br>
<h2>Lista la busqueda de la Mantencion</h2>
<table>
    <tr>
        <th>idMantencion</th>
        <th>Auto</th>
        <th>Taller</th>
        <th>fecha</th>
        <th>Kilometraje</th>
        <th>Acciones</th>
        
    </tr>
        <%
            MantencionDTO man = null;
            man = (MantencionDTO)request.getAttribute("mant");
            try
            {
                //for( int i = 0; i < man.size(); i++)
//<a href='DeleteMantencionServlet' id='idMantencion' value='"+man.getIdMantencion()+"' name='btnDelete'>Delete</a>
           int a = man.getIdMantencion();
        %>
        
            <tr>
                <td><%= man.getIdMantencion() %></td>
                <td><%= man.getAuto() %></td>
                <td><%= man.getTaller() %></td>
                <td><%= man.getFecha() %></td>
                <td><%= man.getKilometraje() %></td>
                <td><%= "<form action='DeleteMantencionServlet' method='POST' ><input type='hidden' value='"+man.getIdMantencion()+"' name='idElimnar' > <input type='submit' value='Eliminar' ></form>" %></td>

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
