   <form action="TallerServlet" method="POST" >
            <table>
                <link rel="stylesheet" href="/TallerSeguimientoAuto/styles/list.css"/>
                <tr>
                    <td> Nombre: </td>
                    <td><input type="text" name="nombre" id="nombre" required> </td>
                </tr>
                <tr>
                    <td> Direccion: </td>
                    <td><input type="text" name="direccion" id="direccion" required> </td>
                </tr>
                <tr>
                    <td> Comuna: </td>
                    <td><input type="text" name="comuna" id="comuna" required> </td>
                </tr>
                <tr>
                    <td> Responsable </td>
                    <td><input type="text" name="responsable" id="responsable" required> </td>
                </tr>
            </table>
            <input type="submit" value="Ingresar Taller">
  </form>