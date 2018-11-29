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
public class TallerDTO {
    private int idTaller;
    private String nombre;
    private String direccion;
    private String comuna;
    private String responsable;

    private final Connection con = (Connection) ConnectionDB.getConnection();
    public TallerDTO() {
    }

    public TallerDTO(int idTaller, String nombre, String direccion, String comuna, String responsable) {
        this.idTaller = idTaller;
        this.nombre = nombre;
        this.direccion = direccion;
        this.comuna = comuna;
        this.responsable = responsable;
    }

    public int getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(int idTaller) {
        this.idTaller = idTaller;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
    

    public void insertTaller(TallerDTO tall) throws Exception{
        String query = "INSERT INTO Taller (idTaller,nombre,direccion,comuna,responsable) VALUES (null,?, ?, ?, ?);";
        try (PreparedStatement ps = con.prepareStatement(query)){
            //ps.setInt(1, tall.getIdTaller());
            ps.setString(1, tall.getNombre());
            ps.setString(2, tall.getDireccion());
            ps.setString(3, tall.getComuna());
            ps.setString(4, tall.getResponsable());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al insertar el taller  " + e.getMessage());
        }
    }

    
    public ArrayList<TallerDTO> allTaller() throws Exception{
        ArrayList<TallerDTO> output = new ArrayList<TallerDTO>();
        String query = "select * from Taller";
        try (PreparedStatement ps = con.prepareStatement(query)){
            try( ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    TallerDTO tall = new TallerDTO();
                    tall.setIdTaller(rs.getInt("idTaller"));
                    tall.setNombre(rs.getString("nombre"));
                    tall.setDireccion(rs.getString("direccion"));
                    tall.setComuna(rs.getString("comuna"));
                    tall.setResponsable(rs.getString("responsable"));
                    output.add(tall);
                }
            }           
        } catch (Exception e) {
            throw new Exception("Error al listar talleres: " + e.getMessage());
        }
        return output;
    }
    
    
}
