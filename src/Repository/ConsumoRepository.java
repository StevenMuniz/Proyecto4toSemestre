/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Conexion.Conexion_1;
import Dominio.Consumo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ConsumoRepository {
    Connection conn;
    List<Consumo> consumo= new ArrayList<>();
      
    //METODO CONSULTAR.- RETORNA EL TIPO DE CONSUMO QUE EXISTE EN LA DB
    public List<Consumo> Cargar(){
        String sql= "select * from consumo";
        try{
            conn= Conexion.Conexion_1.open();
            PreparedStatement ps= conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Consumo c= new Consumo();
                c.setDescripcion(rs.getString(2));
                consumo.add(c);
            }
        } catch(SQLException e){
            System.out.println("Error al Cargar Consumo.."+ e.getMessage());
        }     
        return consumo;
    }
    
  
}
