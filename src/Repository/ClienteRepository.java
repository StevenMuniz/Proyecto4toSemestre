/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Conexion.Conexion_1;
import Dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class ClienteRepository {
    Connection conn;
    List<Cliente> cliente= new ArrayList<>();
    
    //METODO GUARDAR CLIENTE
    public void Guardar(Cliente cliente) {
     try{
            conn = Conexion_1.open();
            String sql = "INSERT INTO clientes(cedula,nombres,apellidos,fecha_nac,sexo,direccion,telefono) VALUES(?,?,?,?,?,?,?)";
        
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getCedula());
            ps.setString(2, cliente.getNombre().toUpperCase());
            ps.setString(3, cliente.getApellido().toUpperCase());
            ps.setDate(4, cliente.getFecha_nac());
            ps.setString(5, cliente.getSexo().toUpperCase());
            ps.setString(6, cliente.getDireccion().toUpperCase());
            ps.setString(7, cliente.getTelefono().toUpperCase());
            ps.execute();
            ps.close();
	} catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}
    } 
    
    //METODO MODIFICAR EL CLIENTE
    public void Modificar(Cliente cliente){
         try{
            conn = Conexion_1.open();
            String sql="Update clientes SET cedula=?, nombres=?, apellidos=?, fecha_nac=?, sexo=?, direccion=?, telefono=? Where id_cliente=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, cliente.getCedula());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setDate(4, cliente.getFecha_nac());
            ps.setString(5, cliente.getSexo());
            ps.setString(6, cliente.getDireccion());
            ps.setString(7, cliente.getTelefono());
            ps.setInt(8, cliente.getClienteid());
            
            ps.execute();
            ps.close();
	} catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}  
    }
    
     //METODO ELIMINAR EL CLIENTE
    public void Eliminar(Cliente cliente){
        try{
            conn = Conexion_1.open();
            String sql="delete from clientes where id_cliente="+ cliente.getClienteid();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ps.close();
	} catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}  
    }
    
    
    //METODO CONSULTAR.- PERMITE EXTRAER LOS REGISTRO DE LA BD PARA GUARDAR EN EL ARRAY 
    public List<Cliente> Consultar(String val){
        
        String sql = " select e.id_cliente, e.cedula, e.nombres, e.apellidos, e.fecha_nac, e.sexo, e.direccion,"
                + " e.telefono from clientes e "
                + "where e.cedula='"+val+"'";
        try{
            conn= Conexion_1.open();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Cliente cli= new Cliente(rs.getInt(1), rs.getString(2),  rs.getString(3),  rs.getString(4), rs.getDate(5),  rs.getString(6),
                         rs.getString(7),  rs.getString(8));
                cliente.add(cli);
            }
	} catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}
        
        
        return cliente;
    }
    
}
