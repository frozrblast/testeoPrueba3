/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TallerSeguimientoAuto.DTO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class MantencionDTO {
    
    
    private int idMantencion;
    private String auto;
    private String taller;
    private Date fecha;
    private int kilometraje;
    
    private final Connection con = (Connection) ConnectionDB.getConnection();

    public MantencionDTO() {
    }

    
    public MantencionDTO(int idMantencion, String auto, String taller, Date fecha, int kilometraje) {
        this.idMantencion = idMantencion;
        this.auto = auto;
        this.taller = taller;
        this.fecha = fecha;
        this.kilometraje = kilometraje;
    }

    public int getIdMantencion() {
        return idMantencion;
    }

    public void setIdMantencion(int idMantencion) {
        this.idMantencion = idMantencion;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getTaller() {
        return taller;
    }

    public void setTaller(String taller) {
        this.taller = taller;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }
     
    public void insertMantencion(MantencionDTO man) throws Exception{
        String query = "INSERT INTO Mantencion (idMantencion,auto,taller,fecha,kilometraje) VALUES (null,?, ?, NOW(), ?);";
        try (PreparedStatement ps = con.prepareStatement(query)){
            //ps.setInt(1, man.getIdMantencion());
            ps.setString(1, man.getAuto());
            ps.setString(2, man.getTaller());
            //ps.setDate(3, man.getFecha());
            ps.setInt(3, man.getKilometraje());
            
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al insertar la mantencion  " + e.getMessage());
        }
    }
     
    public ArrayList<MantencionDTO> allMantencion() throws Exception{
        ArrayList<MantencionDTO> output = new ArrayList<MantencionDTO>();
        String query = "select * from Mantencion";
        try (PreparedStatement ps = con.prepareStatement(query)){
            try( ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    MantencionDTO man = new MantencionDTO();
                    man.setIdMantencion(rs.getInt("idMantencion"));
                    man.setAuto(rs.getString("auto"));
                    man.setTaller(rs.getString("taller"));
                    man.setFecha(rs.getDate("fecha"));
                    man.setKilometraje(rs.getInt("kilometraje"));
                    output.add(man);
                }
            }           
        } catch (Exception e) {
            throw new Exception("Error al listar las mantenciones: " + e.getMessage());
        }
        return output;
    }
    
    public MantencionDTO readMantencion(int idMantencion) throws Exception{
        MantencionDTO output = null;
        String query = "select * from Mantencion where idMantencion = ?";
        try (PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, idMantencion);
            try( ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    output = new MantencionDTO();
                    output.setIdMantencion(rs.getInt("idMantencion"));
                    output.setAuto(rs.getString("auto"));
                    output.setTaller(rs.getString("taller"));
                    output.setFecha(rs.getDate("fecha"));
                    output.setKilometraje(rs.getInt("kilometraje"));
                }
            }           
        } catch (Exception e) {
            throw new Exception("Error al buscar la mantencion: " + e.getMessage());
        }
        return output;
    }
    
    
    public void deleteMantencion(int idMantencion) throws Exception{
        String query = "DELETE FROM Mantencion WHERE idMantencion=?";
        try (PreparedStatement ps = con.prepareStatement(query)){           
            ps.setInt(1, idMantencion);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al eliminar la Mantencion: " + e.getMessage());
        }
    }
}
