/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    //NOMBREDELSERVIDOR.COM;PUERTO/
    private String url = "jdbc:postgresql://mahmud.db.elephantsql.com:5432/neahhlzt";
    private Properties properties = new Properties(); // OBJETOS DE LAS INTERFACES
    private static Connection conn = null; // OBJETOS DE LA  INTERFACE 

    private Conexion() {
        properties.setProperty("user", "neahhlzt"); // PERMITE ALMACENAR DATOS DE LA BASE DE DATOS 
        properties.setProperty("password", "P-A6gShPeAmmaNdgWXauyXlG7UCCa5K5");

        try {
            conn = DriverManager.getConnection(url, properties);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        if (conn == null) {
            Conexion c = new Conexion();
            return c.conn;
        } else {
            return conn;
        }
    }

}
