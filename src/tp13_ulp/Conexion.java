
package tp13_ulp;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Conexion {
    
   private static Conexion conexion;

    private Conexion() {
       try {
           Class.forName("org.mariadb.jdbc.Driver");
                   } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null, "Error al cargar el driver");
       }
    }

    public static Connection getConexion() {
        Connection con=null;
        if(conexion==null){
        conexion= new Conexion();
        }
        try{
            String url="jdbc:mariadb://localhost:3308/ulp";
            String usuario= "root";
            String contraseña="";
        con=DriverManager.getConnection(url,usuario,contraseña);
         
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos");
        }
       return con;
    }
   
}
