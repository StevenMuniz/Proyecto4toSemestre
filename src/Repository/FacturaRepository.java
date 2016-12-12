/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Conexion.Conexion_1;
import Dominio.Factura;
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
public class FacturaRepository {
    Connection conn;
    List<Factura> factura= new ArrayList<>();
    public void Ingresar(Factura fac){
        try{
           conn= Conexion_1.open();
           String sql= "insert into factura(cajero,cliente,valor_cancelado,fecha) values(?,?,?,?)";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1,fac.getCajero());
            ps.setString(2, fac.getCliente());
            ps.setDouble(3,fac.getValor_cancelado());
            ps.setDate(4, fac.getFecha());
            ps.execute();
            
        } catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}
    }
    
    public int CodigoFactura(){
        String sql="select id_factura from factura order by id_factura desc";
        int c=0;
        try{
            conn= Conexion_1.open();
            PreparedStatement ps= conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                c= rs.getInt(1);
            }
        }catch(Exception ex){
            
        } 
        return c;
    }
    
}
