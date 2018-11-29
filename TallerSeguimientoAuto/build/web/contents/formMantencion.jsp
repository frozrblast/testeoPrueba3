<%@page import="TallerSeguimientoAuto.DTO.AutoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="TallerSeguimientoAuto.DTO.TallerDTO"%>

<form action="MantencionServlet" method="POST" >
            <table>
                <link rel="stylesheet" href="/TallerSeguimientoAuto/styles/list.css"/>
                <tr>
                    <td> Auto:
                    <%
                            AutoDTO au = new AutoDTO();
                            ArrayList<AutoDTO> lista = au.allAutos();
                            out.println("<select name='auto'>");
                            for (int i=0;i<lista.size();i++)
                            {
                               out.println("<option value='"+lista.get(i).getIdAuto()+"'>"+lista.get(i).getPatente()+"</option>");
                            }
                            out.println("</select>");
                    %> 
                    </td>
                </tr>
                <tr>
                    <td> Taller: 
                    <%
                            TallerDTO ta = new TallerDTO();
                            ArrayList<TallerDTO> listaT = ta.allTaller();
                            out.println("<select name='taller'>");
                            for (int i=0;i<listaT.size();i++)
                            {
                               out.println("<option value='"+listaT.get(i).getIdTaller()+"'>"+listaT.get(i).getNombre()+"</option>");
                            }
                            out.println("</select>");
                    %>
                    </td>
                </tr>
                <tr>
                    <td> Kilometraje: </td>
                    <td><input type="text" name="kilometraje" id="kilometraje" required> </td>
                </tr>
            </table>
            <input type="submit" value="Ingresar Mantencion">
</form>