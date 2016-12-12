/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.sql.Date;


/**
 *
 * @author Jesus Alaña
 */
public class Factura {
    private int facturaid;
    private String cajero;
    private String cliente;
    private double valor_cancelado;
    private Date fecha;

    public Factura(int facturaid, String cajero, String cliente, double valor_cancelado, Date fecha) {
        this.facturaid = facturaid;
        this.cajero = cajero;
        this.cliente = cliente;
        this.valor_cancelado = valor_cancelado;
        this.fecha = fecha;
    }

    public Factura() {
    }

    public int getFacturaid() {
        return facturaid;
    }

    public void setFacturaid(int facturaid) {
        this.facturaid = facturaid;
    }

    public String getCajero() {
        return cajero;
    }

    public void setCajero(String cajero) {
        this.cajero = cajero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getValor_cancelado() {
        return valor_cancelado;
    }

    public void setValor_cancelado(double valor_cancelado) {
        this.valor_cancelado = valor_cancelado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

   
   
    
    
    
    
}
