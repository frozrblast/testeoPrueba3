<%@page import="TallerSeguimientoAuto.DTO.OperarioDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="TallerSeguimientoAuto.DTO.MantencionDTO"%>
<form action="OperacionServlet" method="POST" >
            <table>
                <link rel="stylesheet" href="/TallerSeguimientoAuto/styles/list.css"/>
                <tr>
                    <td> Mantencion:
                    <%
                            MantencionDTO man = new MantencionDTO();
                            ArrayList<MantencionDTO> lista = man.allMantencion();
                            out.println("<select name='mantencion'>");
                            for (int i=0;i<lista.size();i++)
                            {
                               out.println("<option value='"+lista.get(i).getIdMantencion()+"'>"+lista.get(i).getIdMantencion()+"</option>");
                            }
                            out.println("</select>");
                    %> 
                    </td>
                </tr>
                <tr>
                    <td> Operario: 
                    <%
                            OperarioDTO op = new OperarioDTO();
                            ArrayList<OperarioDTO> listaO = op.allOperario();
                            out.println("<select name='operario'>");
                            for (int i=0;i<listaO.size();i++)
                            {
                               out.println("<option value='"+listaO.get(i).getIdOperario()+"'>"+listaO.get(i).getNombre()+"</option>");
                            }
                            out.println("</select>");
                    %>
                    </td>
                </tr>
                <tr>
                    <td> Descripcion </td>
                    <td><input type="text" name="descripcion" id="descripcion" required> </td>
                </tr>
            </table>
            <input type="submit" value="Ingresar Operacion">
</form>