/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Conexion.Conexion_1;
import Dominio.Contraseña;
import Dominio.Trabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus Alaña
 */
public class ContraseñaRepository {
    Connection conn;
    List<Contraseña> contraseña= new ArrayList<>();
    public static int cargo=0;
    public static String usuario;
    public  boolean Consultar(Contraseña con){
        
        String contrasena="";
        boolean login=false;
        String sql = "SELECT apellidos,contraseña,id_carg FROM trabajador";
        try{
            conn= Conexion_1.open();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                usuario= rs.getString(1);   contrasena= rs.getString(2);cargo=rs.getInt(3);
                if(con.getUsuario().equals(usuario) && con.getPassword().equals(contrasena)){
                    login= true;
                    
                    break;
                }
            }
	} catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}
        return login;
    }
    
 
}
