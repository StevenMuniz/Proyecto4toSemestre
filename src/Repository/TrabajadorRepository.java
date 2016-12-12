/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;




import Conexion.Conexion_1;
import Dominio.Cargo;
import Dominio.Trabajador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steven
 */
public class TrabajadorRepository {
    
    List<Trabajador> trabajadores= new ArrayList<>();
    Connection conn;
    
    
    public void Guardar(Trabajador trabajador) {
        try{
            conn = Conexion_1.open();
            String sql= "INSERT INTO trabajador(cedula,nombres,apellidos,fecha_nac,sexo,direccion,telefono,contraseña,id_carg)"+
               "VALUES(?,?,?,?,?,?,?,?,(select id_cargo from cargo where cargo='"+trabajador.getCargo()+"'))";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, trabajador.getCedula());
            ps.setString(2, trabajador.getNombres());
            ps.setString(3, trabajador.getApellidos());
            ps.setDate(4, trabajador.getFecha_nac());
            ps.setString(5, trabajador.getSexo());
            ps.setString(6, trabajador.getDireccion());
            ps.setString(7, trabajador.getTelefono());
            ps.setString(8, trabajador.getContraseña());
            ps.execute();
            ps.close();
	} catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}
    } 
    
    //METODO CONSULTAR.- PERMITE EXTRAER LOS REGISTRO DE LA BD PARA GUARDAR EN EL ARRAY 
    public List<Trabajador> Consultar(String val){
        
        String sql = " select e.id_trabajador, e.cedula, e.nombres, e.apellidos, e.fecha_nac, e.sexo, e.direccion,"
                + " e.telefono, e.contraseña, c.cargo from trabajador e "
                + " inner join cargo c on c.id_cargo=e.id_carg "
                + "where e.cedula='"+val+"'";
        try{
            conn= Conexion_1.open();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Cargo cargo = new  Cargo();
                cargo.setCargo(rs.getString(10));
                
                Trabajador trab= new Trabajador(rs.getInt(1), rs.getString(2),  rs.getString(3),  rs.getString(4), 
                        rs.getDate(5),  rs.getString(6),rs.getString(7),  rs.getString(8),  rs.getString(9), cargo);
                trabajadores.add(trab);
            }
	} catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}
        
        
        return trabajadores;
    }
    //METODO MODIFICAR EL CARGO 
    public void Modificar(Trabajador t){
         try{
            conn = Conexion_1.open();
            String sql="UPDATE trabajador SET cedula=?,nombres=?,apellidos=?,fecha_nac=?,sexo=?,direccion=?,telefono=?,contraseña=?,"
                    + "id_carg=(select id_cargo from cargo where cargo='"+t.getCargo()+"')"
                    + "  WHERE id_trabajador="+   t.getTrabajadorid();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getCedula());
            ps.setString(2, t.getNombres());
            ps.setString(3, t.getApellidos());
            ps.setDate(4, t.getFecha_nac());
            ps.setString(5, t.getSexo());
            ps.setString(6, t.getDireccion());
            ps.setString(7, t.getTelefono());
            ps.setString(8, t.getContraseña()); 
            
            
            ps.execute();
            ps.close();
	} catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}  
    }
    
    //METODO ELIMINAR
    public void Eliminar( Trabajador t){
        try{
            conn = Conexion_1.open();
            String sql="delete from trabajador where id_trabajador= " +t.getTrabajadorid();
            PreparedStatement ps = conn.prepareStatement(sql); 
            ps.execute();
	} catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}  
    }
    
    
}
    
    
    
    
