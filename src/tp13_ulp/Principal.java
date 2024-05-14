
package tp13_ulp;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.internal.util.dao.PrepareResult;


public class Principal {

  
    public static void main(String[] args) {
        Connection con=Conexion.getConexion();
        
                    try {
           insertarAlumnos(con);

            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar alumnos");
        }
        try{
        insertarMaterias(con);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar materias");
            
        }
        try {
            incribirAlumnos(con);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar inscripciones");
        }
        try {
            listarDatos(con);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar alumnos");
        }
try{
eliminarInscripcion(con);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al eliminar inscripcion");
        }
        
    }
    public static void insertarAlumnos(Connection con) throws SQLException{
    String alum1="INSERT INTO `alumno`( `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado`) "
            + "VALUES (547456,'Correa','Angel','2000-04-12',1)";
    PreparedStatement ps= con.prepareStatement(alum1);
    ps.executeUpdate();
    String alum2="INSERT INTO `alumno`( `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado`) "
            + "VALUES (43563463,'Luna','Santino','2004-07-25',1)";
    PreparedStatement ps1= con.prepareStatement(alum2);
    ps1.executeUpdate();
    
      String alum3="INSERT INTO `alumno`( `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado`) "
            + "VALUES (8357683,'fernandez','equis','2001-12-07',1)";
      PreparedStatement ps2= con.prepareStatement(alum3);
      int verificar=ps2.executeUpdate();
      if(verificar>0){
          System.out.println("Alumnos cargados");
      }
    }
    public static void insertarMaterias(Connection con) throws SQLException{
       // Agregar materia 1
        String mat1="INSERT INTO materia( `nombre`, `año`, `estado`) "
                + "VALUES ('Laboratorio 1',2024,1)";
       PreparedStatement ps1=con.prepareStatement(mat1);
        ps1.executeUpdate();
        //Agregar materia2
        String mat2="INSERT INTO `materia`( `nombre`, `año`, `estado`) "
                + "VALUES ('Matemática',2024,1)";
        PreparedStatement ps2=con.prepareStatement(mat2);
        ps2.executeUpdate();
        //Agregar materia 3
        String mat3="INSERT INTO materia( `nombre`, `año`, `estado`) "
                + "VALUES ('web 1',2024,1)";
        PreparedStatement ps3=con.prepareStatement(mat3);
        ps3.executeUpdate();
    //Agregar materia 4
    String mat4="INSERT INTO materia( `nombre`, `año`, `estado`) "
            + "VALUES ('Comprensión de texto',2024,2)";
    PreparedStatement ps4=con.prepareStatement(mat4);
    
//Agregar materia 5
    String mat5="INSERT INTO materia( `nombre`, `año`, `estado`)"
             +"VALUES ('Acceso a base a datos',2024,3)";
    
       PreparedStatement ps5=con.prepareStatement(mat5);
       ps5.executeUpdate();
       //Agregar materia 6
        String mat6="INSERT INTO materia( `nombre`, `año`, `estado`)"
             +"VALUES ('Laboratorio 2',2024,3)";
    
       PreparedStatement ps6=con.prepareStatement(mat6);
    int verificar=ps6.executeUpdate();
    if(verificar>0){
        System.out.println("Materias cargadas");
    }
   }
     
    public static void incribirAlumnos(Connection con) throws SQLException{
        //Inscripcion 1
        String inc1="INSERT INTO inscripcion( `nota`, `idAlumno`, `idMateria`) "
                + "VALUES (8,1,1)";
        PreparedStatement ps1=con.prepareStatement(inc1);
        ps1.executeUpdate();
        
        //Inscripcion 2
        String inc2="INSERT INTO inscripcion( `nota`, `idAlumno`, `idMateria`) "
                + "VALUES (10,1,6)";
        PreparedStatement ps2=con.prepareStatement(inc2);
        ps2.executeUpdate();
        
        //Inscripcion 3
        String inc3="INSERT INTO inscripcion( `nota`, `idAlumno`, `idMateria`) "
                + "VALUES (9,2,3)";
        PreparedStatement ps3=con.prepareStatement(inc3);
        ps3.executeUpdate();
    
    //Inscripcion 4
    String inc4="INSERT INTO inscripcion( `nota`, `idAlumno`, `idMateria`) "
                + "VALUES (8,2,1)";
        PreparedStatement ps4=con.prepareStatement(inc4);
        ps4.executeUpdate();
        //Inscripcion 5
        String inc5="INSERT INTO inscripcion( `nota`, `idAlumno`, `idMateria`) "
                + "VALUES (7,3,3)";
        PreparedStatement ps5=con.prepareStatement(inc5);
        ps5.executeUpdate();
        //Inscripcion 6
        String inc6="INSERT INTO inscripcion( `nota`, `idAlumno`, `idMateria`) "
                + "VALUES (8,3,4)";
        PreparedStatement ps6=con.prepareStatement(inc6);
        int verificar=ps6.executeUpdate();
        if(verificar>0){
            System.out.println("Inscripciones cargadas");
        }
        
    }
    public static void listarDatos(Connection con)throws SQLException{
    String listar="SELECT `idInscripcion`, `nota`, `idAlumno`, `idMateria` FROM `inscripcion` WHERE nota>8";
    PreparedStatement ps=con.prepareStatement(listar);
   ResultSet lista= ps.executeQuery();
   while(lista.next()){
   int idInscripcion=lista.getInt("idInscripcion");
     int nota=lista.getInt("nota");
     int idAlumno=lista.getInt("idAlumno");
     int idMateria=lista.getInt("idMateria");
     
       System.out.println("idInscripcion: "+idInscripcion);
       System.out.println("Nota: "+nota);
       System.out.println("idAlumno: "+idAlumno);
       System.out.println("idMateria: "+idMateria);
       System.out.println("---------------------------------------");
   }
   
 
    }
    public static void eliminarInscripcion(Connection con)throws SQLException{
    String borrar="DELETE FROM `inscripcion` WHERE idAlumno=1 AND idMateria=1";
    PreparedStatement ps=con.prepareStatement(borrar);
    int verificar=ps.executeUpdate();
 if(verificar>0){
     System.out.println("Alumno desinscripto");}   
    
    }
            
}
