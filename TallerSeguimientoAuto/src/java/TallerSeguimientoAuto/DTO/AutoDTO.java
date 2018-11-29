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
public class AutoDTO {

    private int idAuto;
    private String patente;
    private String marca;
    private String modelo;
    private Date añoFabricacion;
    
    private final Connection con = (Connection) ConnectionDB.getConnection();

    public AutoDTO() {
    }

    public AutoDTO(int idAuto, String patente, String marca, String modelo, Date añoFabricacion) {
        this.idAuto = idAuto;
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.añoFabricacion = añoFabricacion;
    }

    public int getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(Date añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

 

    

    public void insertAuto(AutoDTO car) throws Exception{
        String query = "INSERT INTO Auto (idAuto,patente,marca,modelo,añoFabricacion) VALUES (null,?, ?, ?, NOW());";
        try (PreparedStatement ps = con.prepareStatement(query)){
            //ps.setInt(1, car.getIdAuto());
            ps.setString(1, car.getPatente());
            ps.setString(2, car.getMarca());
            ps.setString(3, car.getModelo());
           // ps.setDate(5, car.getAñoFabricacion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al insertar el auto  " + e.getMessage());
        }
    }

    
    public ArrayList<AutoDTO> allAutos() throws Exception{
        ArrayList<AutoDTO> output = new ArrayList<AutoDTO>();
        String query = "select * from Auto";
        try (PreparedStatement ps = con.prepareStatement(query)){
            try( ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    AutoDTO car = new AutoDTO();
                    car.setIdAuto(rs.getInt("idAuto"));
                    car.setPatente(rs.getString("patente"));
                    car.setMarca(rs.getString("marca"));
                    car.setModelo(rs.getString("modelo"));
                    car.setAñoFabricacion(rs.getDate("añoFabricacion"));
                    output.add(car);
                }
            }           
        } catch (Exception e) {
            throw new Exception("Error al listar Autos: " + e.getMessage());
        }
        return output;
    }
    
    
}
