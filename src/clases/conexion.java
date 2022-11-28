
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Giuliana Carnevalle, Bautista Venier y Alan Sebastian Schimpf
 */
public class conexion {
    
    public static Connection conectar(){
    
        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "";
            String usuario = "system";
            String pass = "admin";
            
            Connection cn = DriverManager.getConnection(url, usuario, pass);
            return cn;
                    
        } catch (ClassNotFoundException | SQLException e) {
            
            System.out.println("Error en la conexion al servidor" + e);
            
        } 
        return (null);
    }
}
