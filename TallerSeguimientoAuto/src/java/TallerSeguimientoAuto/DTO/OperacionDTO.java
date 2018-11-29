/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TallerSeguimientoAuto.DTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class OperacionDTO {
    private int idOperacion;
    private String mantencion;
    private String operario;
    private String descripcion;

    private final Connection con = (Connection) ConnectionDB.getConnection();
    public OperacionDTO() {
    }

    public OperacionDTO(int idOperacion, String mantencion, String operario, String descripcion) {
        this.idOperacion = idOperacion;
        this.mantencion = mantencion;
        this.operario = operario;
        this.descripcion = descripcion;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public String getMantencion() {
        return mantencion;
    }

    public void setMantencion(String mantencion) {
        this.mantencion = mantencion;
    }

    public String getOperario() {
        return operario;
    }

    public void setOperario(String operario) {
        this.operario = operario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
 
      public void insertOperacion(OperacionDTO opera) throws Exception{
        String query = "INSERT INTO Operacion (idOperacion,mantencion,operario,descripcion) VALUES (null,?, ?, ?);";
        try (PreparedStatement ps = con.prepareStatement(query)){

            ps.setString(1, opera.getMantencion());
            ps.setString(2, opera.getOperario());
            ps.setString(3, opera.getDescripcion());
            
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al insertar la operacion " + e.getMessage());
        }
    }
     
    public ArrayList<OperacionDTO> allOperacion() throws Exception{
        ArrayList<OperacionDTO> output = new ArrayList<OperacionDTO>();
        String query = "select * from Operacion";
        try (PreparedStatement ps = con.prepareStatement(query)){
            try( ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    OperacionDTO opera = new OperacionDTO();
                    opera.setIdOperacion(rs.getInt("idOperacion"));
                    opera.setMantencion(rs.getString("mantencion"));
                    opera.setOperario(rs.getString("operario"));
                    opera.setDescripcion(rs.getString("descripcion"));
                    output.add(opera);
                }
            }           
        } catch (Exception e) {
            throw new Exception("Error al listar las operaciones: " + e.getMessage());
        }
        return output;
    }
    
        public OperacionDTO readOperacion(int idOperacion) throws Exception{
        OperacionDTO output = null;
        String query = "select * from Operacion where idOperacion = ?";
        try (PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, idOperacion);
            try( ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    output = new OperacionDTO();
                    output.setIdOperacion(rs.getInt("idOperacion"));
                    output.setMantencion(rs.getString("mantencion"));
                    output.setOperario(rs.getString("operario"));
                    output.setDescripcion(rs.getString("descripcion"));
                }
            }           
        } catch (Exception e) {
            throw new Exception("Error al buscar la operacion: " + e.getMessage());
        }
        return output;
    }
    
    
    public void deleteOperacion(int idMantencion) throws Exception{
        String query = "DELETE FROM Operacion WHERE idOperacion=?";
        try (PreparedStatement ps = con.prepareStatement(query)){           
            ps.setInt(1, idOperacion);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al eliminar la Operacion: " + e.getMessage());
        }
    }

}
