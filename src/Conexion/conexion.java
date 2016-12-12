package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class conexion {
  
    Connection conex= null;
    public Connection Conectar(){
        String cadena= "jdbc:postgresql://localhost:5432/Calificaciones";
        String user="postgres";
        String pass="1993";
        try {
            Class.forName("org.postgresql.Driver");
            conex=DriverManager.getConnection(cadena,user,pass);
            if(conex !=null){
                System.out.print("Conectando a base de datos...");  
            }
 
        }catch(Exception exc){
            System.out.print("Error.."+ exc.getMessage());
        }
        return conex;
    }

   
    

}
