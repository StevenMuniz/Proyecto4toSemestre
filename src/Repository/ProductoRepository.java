/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Conexion.Conexion_1;
import Dominio.Consumo;
import Dominio.Producto;
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
public class ProductoRepository {
    List<Producto> productos= new ArrayList<>();
    Connection conn;
    
    //GUARDAR
    public void Guardar(Producto producto) {
        try{
            conn = Conexion_1.open();
            String sql= "INSERT INTO productos(descripcion,cantidad,precio,id_consumo1)"+
               "VALUES(?,?,?,(select id_consumo from consumo where descripcion='"+producto.getConsumo()+"'))";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, producto.getDescripcion());
            ps.setInt(2, producto.getCantidad());
            ps.setDouble(3, producto.getPrecio());
            ps.execute();
            ps.close();
	} catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}
    } 
        
    //METODO MODIFICAR EL PRODUCTO 
    public void Modificar(Producto p){
         try{
            conn = Conexion_1.open();
            String sql="UPDATE productos SET descripcion=?,cantidad=?,precio=?,"
                    + "id_consumo1=(select id_consumo from consumo where descripcion='"+p.getConsumo()+"')"
                    + "  WHERE id_producto="+   p.getId_producto();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getDescripcion());
            ps.setInt(2, p.getCantidad());
            ps.setDouble(3, p.getPrecio());   
            ps.execute();
            ps.close();
	} catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}  
    }
    //METODO ELIMINAR
    public void Eliminar( Producto p){
        try{
            conn = Conexion_1.open();
            String sql="delete from productos where id_producto= " +p.getId_producto();
            PreparedStatement ps = conn.prepareStatement(sql); 
            ps.execute();
	} catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}  
    }
    
    //LLENAR TABLA 
    public List<Producto> LLenarTabla(){
        productos.removeAll(productos);
        String sql="select a.id_producto,e.descripcion,a.descripcion,a.cantidad,a.precio from productos a inner join "
                + "consumo e on id_consumo1=id_consumo order by a.id_producto";
        try{
            conn = Conexion_1.open();
            PreparedStatement ps= conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Consumo consumo= new Consumo();
                consumo.setDescripcion(rs.getString(2));
                Producto pro= new Producto(rs.getInt(1), rs.getString(3), rs.getInt(4), rs.getDouble(5), consumo);
                productos.add(pro);
            }
        } catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}
        return productos;
    }
    
    
    //METODO CONSULTAR POR DESCPCION.- PERMITE EXTRAER LOS REGISTRO DE LA BD PARA GUARDAR EN EL ARRAY 
    public List<Producto> Consultar(String val){
        List<Producto> filtro= new ArrayList<>();
        String sql="select a.id_producto,e.descripcion,a.descripcion,a.cantidad,a.precio from productos a inner join " +
               " consumo e on id_consumo1=id_consumo where e.descripcion like '" +val+"%' order by a.id_producto";
        
        try{
            conn = Conexion_1.open();
            PreparedStatement ps= conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
           
            while(rs.next()){
                Consumo consumo= new Consumo();
                consumo.setDescripcion(rs.getString(2));
                Producto pro= new Producto(rs.getInt(1), rs.getString(3), rs.getInt(4), rs.getDouble(5), consumo);
                filtro.add(pro);
            }
	} catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}
        
        
        return filtro;
    }
    //METODO CONSULTAR DESCRPCION
    public List<Producto> DescripcionProducto(String val){
        List<Producto> filtro= new ArrayList<>();
        String sql="select a.descripcion from productos a join consumo e on id_consumo1=id_consumo"
                + " where e.descripcion='"+val+"'";
        
        try{
            conn = Conexion_1.open();
            PreparedStatement ps= conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Producto p= new Producto();
                p.setDescripcion(rs.getString(1));
                filtro.add(p);
            }
	} catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}
        
        return filtro;
    }
    
    //
    public List<Producto> Precio(String val){
        List<Producto> filtro= new ArrayList<>();
        String sql="select cantidad,precio from productos where descripcion='"+val+"'";
        try{
            conn = Conexion_1.open();
            PreparedStatement ps= conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Producto p= new Producto();
                p.setCantidad(rs.getInt(1));
                p.setPrecio(rs.getDouble(2));
                filtro.add(p);
            }
	} catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}
        
        return filtro;
    }
    public void Stock(Producto producto){
        String sql= "update productos set cantidad=cantidad-? where descripcion='"+producto.getDescripcion()+"'";
        try{
            conn = Conexion_1.open();
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setInt(1, producto.getCantidad());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}
    }
    
     



}
