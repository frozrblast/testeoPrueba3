<%@page import="TallerSeguimientoAuto.DTO.MantencionDTO"%>
<%@page import="java.util.ArrayList"%>
<form action="MantencionBuscarServlet" method="POST" >
            <table>
                <tr>Ingrese Codigo de Mantencion a Buscar<tr>
                <tr>
                    <td><input type="text" name="idMantencion" id="idMantencion" required> </td>
                </tr>
            </table>
            <input type="submit" value="Buscar Mantencion">
</form>
