/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TallerSeguimientoAuto.DTO;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian
 */
public class ConnectionDB {

    public ConnectionDB() {
     
    }
    
    public static Connection getConnection(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db_tallerautos?zeroDateTimeBehavior=convertToNull";
        String user = "root";
        String pass = "";
        Connection con = null;
        try {
            Class.forName(driver);
            con  = (Connection)DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }  
    
}
