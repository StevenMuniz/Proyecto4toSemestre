package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion_1{
    
    public static Connection open() throws SQLException{
        String url="jdbc:postgresql://localhost:5432/Restaurante";
	String user="postgres";
	String password="1234";
		
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

}
