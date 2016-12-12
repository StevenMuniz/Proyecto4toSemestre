/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Conexion.Conexion_1;
import Dominio.DetalleFactura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Jesus Alaña
 */
public class DetalleFacturaRepository {
    Connection conn;
    
    public void IngresarDetalleF(DetalleFactura fac){
        try{
           conn= Conexion_1.open();
            String sql="insert into detallefactura(descripcion,precio,cantidad,total,factura) values(?,?,?,?,?)";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1,fac.getDescripcion());
            ps.setDouble(2, fac.getPrecio());
            ps.setInt(3,fac.getCantidad());
            ps.setDouble(4, fac.getTotal());
            ps.setInt(5,  fac.getFactura().getFacturaid()  );
            ps.execute();
            
        } catch (SQLException e) {
            System.out.println("Error.." + e.getMessage());
	}
        
    }
    
}
