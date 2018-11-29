   <form action="OperarioServlet" method="POST" >
            <table>
                <link rel="stylesheet" href="/TallerSeguimientoAuto/styles/list.css"/>
                <tr>
                    <td> Nombre Operario: </td>
                    <td><input type="text" name="nombre" id="nombre" required> </td>
                </tr>
                <tr>
                    <td> Rut: </td>
                    <td><input type="text" name="rut" id="rut" placeholder="Ej:19566879k" required> </td>
                </tr>
            </table>
            <input type="submit" value="Ingresar Operario">
  </form>