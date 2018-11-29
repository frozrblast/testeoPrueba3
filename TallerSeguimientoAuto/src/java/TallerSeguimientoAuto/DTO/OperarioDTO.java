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
 * @author Informatica
 */
public class OperarioDTO {
    private int idOperario;
    private String nombre;
    private String rut;

    private final Connection con = (Connection) ConnectionDB.getConnection();
    public OperarioDTO() {
    }

    public OperarioDTO(int idOperario, String nombre, String rut) {
        this.idOperario = idOperario;
        this.nombre = nombre;
        this.rut = rut;
    }

    public int getIdOperario() {
        return idOperario;
    }

    public void setIdOperario(int idOperario) {
        this.idOperario = idOperario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
    
    public void insertOperario(OperarioDTO ope) throws Exception{
        String query = "INSERT INTO Operario (idOperario,nombre,rut) VALUES (null,?, ?);";
        try (PreparedStatement ps = con.prepareStatement(query)){
            //ps.setInt(1, ope.getIdOperario());
            ps.setString(1, ope.getNombre());
            ps.setString(2, ope.getRut());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al insertar el operario  " + e.getMessage());
        }
    }
        public ArrayList<OperarioDTO> allOperario() throws Exception{
        ArrayList<OperarioDTO> output = new ArrayList<OperarioDTO>();
        String query = "select * from Operario";
        try (PreparedStatement ps = con.prepareStatement(query)){
            try( ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    OperarioDTO ope = new OperarioDTO();
                    ope.setIdOperario(rs.getInt("idOperario"));
                    ope.setNombre(rs.getString("nombre"));
                    ope.setRut(rs.getString("rut"));
                    output.add(ope);
                }
            }           
        } catch (Exception e) {
            throw new Exception("Error al listar operarios: " + e.getMessage());
        }
        return output;
    }
   
}
