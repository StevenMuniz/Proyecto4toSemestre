/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Dominio.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexion.Conexion_1;
import java.util.ArrayList;
import java.util.List;


public class CargoRepository {
    Connection conn;
    List<Cargo> cargo= new ArrayList<>();
    
    
    
    //METODO GUARDAR EN LA BD
    public void Guardar(Cargo cargo){
        try{
            conn = Conexion_1.open();
            String sql = "INSERT INTO cargo(cargo,sueldo) VALUES(?,?)";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cargo.getCargo());
            ps.setDouble(2, cargo.getSueldo() );
           
            ps.execute();
            ps.close();
	} catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}
        
    }
    //METODO MODIFICAR EL CARGO 
    public void Modificar(Cargo cargo){
         try{
            conn = Conexion_1.open();
            String sql="Update cargo SET cargo=?, sueldo=? Where id_cargo=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cargo.getCargo());
            ps.setDouble(2, cargo.getSueldo() );
            ps.setInt(3, cargo.getCargoid());
            ps.execute();
            ps.close();
	} catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}  
    }
     //METODO ELIMINAR EL CARGO 
    public void Eliminar(Cargo cargo){
        try{
            conn = Conexion_1.open();
            String sql="delete from cargo where id_cargo="+ cargo.getCargoid();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ps.close();
	} catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}  
    }
         
    
    //METODO CARGAR LA TABLA 
    public List<Cargo> CargarTabla(){
       cargo.removeAll(cargo);
        String sql= "select * from cargo order by cargo";
        try{
            conn=Conexion_1.open();
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
               Cargo cargo = new Cargo(rs.getInt(1), rs.getString(2), rs.getDouble(3));
               this.cargo.add(cargo);
            }
        }catch(SQLException e){
            System.out.println("Error.." + e.getMessage());
        }
       return cargo; 
    }
    
    
    // ***********     METODOS AUN NO APLICABLES :V
    
    //METODO CONSULTAR.- RETORNA EL TIPO DE CARGO QUE EXISTE EN LA DB
    public List<Cargo> Cargar(){
        String sql= "select * from cargo";
        try{
            conn= Conexion.Conexion_1.open();
            PreparedStatement ps= conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Cargo c= new Cargo(rs.getString(2));
                cargo.add(c );
            }
        
        } catch(SQLException e){
            System.out.println("Error al Cargar Cargo.."+ e.getMessage());
        }     
        return cargo;
    }
    
    //METODO
     public List<Cargo> Consultar(String val){
        List<Cargo> nombre = new ArrayList<>();
       
        try{ 
            conn=Conexion_1.open();
            String sql="select * from cargo where cargo like ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, val+"%");
            ResultSet rs = ps.executeQuery();
	    while(rs.next()){
		Cargo cargo= new Cargo(rs.getInt(1),rs.getString(2), rs.getDouble(3));
                nombre.add(cargo);
	    }
        }catch(SQLException e){
            System.out.println("Error.." + e.getMessage());
        }
        
        return nombre;
    }
    
    
    
    
 
    
    
}
